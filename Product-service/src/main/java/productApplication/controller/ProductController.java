package productApplication.controller;

import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import productApplication.dto.request.ClientRequestDto;
import productApplication.dto.request.ProductRequestDto;
import productApplication.dto.response.ProductStocksResponseDto;
import productApplication.manager.ProductManagerClient;
import productApplication.service.impl.ProductServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;



    @GetMapping("/product/{id}")
    ResponseEntity<ProductRequestDto> getProduct(@PathVariable long id){

        return ResponseEntity.ok(productService.getProduct(id));
    }


    @GetMapping("/productsStock/{id}")
    ResponseEntity<ProductStocksResponseDto> getProductsStock(@PathVariable long id){

        return ResponseEntity.ok(productService.getProductStocks(id));
    }

    @PostMapping ("/addproductsOfCount/{id}")
    ResponseEntity<Void> addProductsStock(@PathVariable long id, @RequestBody @Valid List<Long> stocklist){

        productService.addProductStok(stocklist,id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addProduct")
    ResponseEntity<ProductRequestDto> addProduct(@RequestBody @Valid ProductRequestDto productRequestDto){

        return ResponseEntity.ok(productService.addProductRequestDto(productRequestDto));
    }

    @PutMapping("/updateProduct/{id}")
    ResponseEntity<ProductRequestDto> updateProduct(@PathVariable long id,@RequestBody @Valid ProductRequestDto productRequestDto){

        return ResponseEntity.ok(productService.updateProduct(productRequestDto,id));
    }

    @GetMapping("/client/{id}")
    ResponseEntity<ClientRequestDto> getClient(@PathVariable long id){

       return ResponseEntity.ok(productService.getClient(id).getBody());
    }


}
