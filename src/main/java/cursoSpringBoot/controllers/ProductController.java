package cursoSpringBoot.controllers;

import cursoSpringBoot.domain.Product;
import cursoSpringBoot.services.ProductsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductController {

    ProductsServiceImpl productService = new ProductsServiceImpl();

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getProductsService() {

        List<Product> products = productService.mostarProductos();
        return ResponseEntity.ok(products);
    }
}

