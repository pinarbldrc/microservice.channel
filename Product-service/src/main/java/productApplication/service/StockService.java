package productApplication.service;

import productApplication.dto.request.StockRequestDto;
import productApplication.repository.entity.Stock;

import java.util.List;

public interface StockService {

    StockRequestDto getStock(long id);
    StockRequestDto saveStock(StockRequestDto stockRequestDto);
    StockRequestDto updateStock(long id,StockRequestDto stockRequestDto);
    void deleteStock(long id);

    List<Stock> getAllStock();


}
