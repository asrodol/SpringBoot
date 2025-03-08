package cursoSpringBoot.controllers;

import cursoSpringBoot.domain.Customer;
import org.apache.catalina.valves.rewrite.Substitution;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class CustomerController {

    List<Customer> listCust = new ArrayList<>(Arrays.asList(
            new Customer(1234, "Rodolfo", "asrodol", "0000"),
            new Customer(1235, "Alejandro", "aslex", "1111"),
            new Customer(1236, "Guillermo", "memo", "2222"),
            new Customer(1237, "Israel", "pascual", "3333")
    ));

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity <List<Customer>> showCustomers(){

        return ResponseEntity.ok(listCust);
    }



    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity <?> serarchCustomer(@PathVariable int id){
        for (Customer c:listCust){
            if (c.getId()==id){
                 return ResponseEntity.ok(c);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> saveCustomer(@RequestBody Customer cus){
        listCust.add(cus);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cus.getId())
                .toUri();

        //return  ResponseEntity.status(HttpStatus.CREATED).body("Cliente creado correctamente");
        return ResponseEntity.created(location).body(cus);
    }

    @RequestMapping( method = RequestMethod.PUT)
    public ResponseEntity<?> updateCustomer(@RequestBody Customer cus){
        for(Customer c: listCust){
            if(c.getId()== cus.getId()){
                c.setName(cus.getName());
                c.setUserName(cus.getUserName());
                c.setPassword(cus.getPassword());

                return ResponseEntity.noContent().build();
            }
        }

        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCustomer(@PathVariable int id){
        for(Customer c: listCust){
            if(id == c.getId()){
                listCust.remove(c);
                //return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
                return ResponseEntity.noContent().build();
            }
        }

        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado gracias");
        return ResponseEntity.notFound().build();
    }

}
