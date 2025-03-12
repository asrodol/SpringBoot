package cursoSpringBoot.services;

import cursoSpringBoot.domain.Product;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductsServiceImpl {

    List<Product> listProd = new ArrayList<>(Arrays.asList(
            new Product(1, "Laptop", 799.99, 10),
            new Product(1, "SmartPhone", 899.99, 5),
            new Product(1, "Tablet", 999.99, 15),
            new Product(1, "SmartWathc", 699.99, 20)
    ));

    public List<Product> mostarProductos() {
        return listProd;
    }



}