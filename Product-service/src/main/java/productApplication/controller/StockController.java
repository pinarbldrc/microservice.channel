package productApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import productApplication.dto.request.StockRequestDto;
import productApplication.repository.entity.Stock;
import productApplication.service.impl.StockServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    StockServiceImpl stockService;

    @GetMapping("/stock/{id}")
    ResponseEntity<StockRequestDto> getStock(@PathVariable long id){
     return    ResponseEntity.ok(stockService.getStock(id));
    }

    @GetMapping("/getAll")
    ResponseEntity<List<Stock>> getAllStock(@RequestBody @Valid List<Stock>stockList){
        return ResponseEntity.ok(stockService.getAllStock());
    }

    @PostMapping("/addstock")
    ResponseEntity<StockRequestDto> addStock(@RequestBody @Valid StockRequestDto stockRequestDto){
        return ResponseEntity.ok(stockService.saveStock(stockRequestDto));
    }
    @PutMapping("/updatestock/{id}")
    ResponseEntity<StockRequestDto> updateStock(@PathVariable Long id,@RequestBody @Valid StockRequestDto stockRequestDto){

        return ResponseEntity.ok(stockService.updateStock(id,stockRequestDto));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteStock(@PathVariable long id){

        stockService.deleteStock(id);
       return ResponseEntity.ok().build();
    }
}
