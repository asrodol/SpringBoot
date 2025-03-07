package cursoSpringBoot.controllers;

import cursoSpringBoot.domain.Customer;
import org.springframework.web.bind.annotation.*;

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
    public List<Customer> showCustomers(){
        return listCust;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer serarchCustomer(@PathVariable int id){
        for (Customer c:listCust){
            if (c.getId()==id){
                 return c;
            }
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Customer saveCustomer(@RequestBody Customer cus){
        listCust.add(cus);

        return  cus;
    }

    @RequestMapping( method = RequestMethod.PUT)
    public Customer updateCustomer(@RequestBody Customer cus){
        for(Customer c: listCust){
            if(c.getId()== cus.getId()){
                c.setName(cus.getName());
                c.setUsaerName(cus.getUsaerName());
                c.setPassword(cus.getPassword());

                return c;
            }
        }
        
        return null;
    }

}
