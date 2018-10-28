package wecc.examples.springboot.rest.server.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wecc.examples.springboot.rest.server.model.Product;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@Api(tags="Product")
public class ProductController {

    private Map<String, Product> products = new HashMap<>();

    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "getting all products")
    @ApiResponses({
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK", response = Product[].class),
            @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Unhandled exception")
    })
    public List<Product> products(){
        return products.values().stream().collect(Collectors.toList());
    }

    @GetMapping("/product/{code}")
    @ApiOperation(value = "getting a product")
    @ApiResponses({
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK", response = Product.class),
            @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "Not Found"),
            @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Unhandled exception")
    })
    public ResponseEntity<Product> products(@PathVariable String code){
        Product product = products.get(code);
        if (Objects.isNull(product)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
    }

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "creating a product")
    @ApiResponses({
            @ApiResponse(code = HttpServletResponse.SC_CREATED, message = "Created"),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Bad Request"),
            @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Unhandled exception")
    })
    public void product(@RequestBody Product product){
        products.put(product.getCode(), product);
    }

}

