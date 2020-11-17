package productApplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import productApplication.dto.request.StockRequestDto;
import productApplication.mapper.StockMapper;
import productApplication.repository.entity.Stock;
import productApplication.repository.repo.StockRepository;
import productApplication.service.StockService;

import java.util.List;
@Service
public class StockServiceImpl implements StockService {

    @Autowired
    StockRepository stockRepository;

    @Autowired
    StockMapper stockMapper;


    @Override
    public StockRequestDto getStock(long id) {

        Stock stock=stockRepository.findById(id).orElseThrow(()-> new IllegalArgumentException());
        StockRequestDto stockRequestDto=stockMapper.toStockRequestDto(stock);
        return stockRequestDto;

    }

    @Override
    public StockRequestDto saveStock(StockRequestDto stockRequestDto) {

        Stock stock=stockMapper.toStock(stockRequestDto);
        stock=stockRepository.save(stock);
        stockRequestDto.setId(stock.getId());
        return stockRequestDto;
    }

    @Override
    public StockRequestDto updateStock(long id, StockRequestDto stockRequestDto) {

        Stock stock=stockRepository.findById(id).orElseThrow(()->new IllegalArgumentException());

        stock=stockMapper.toStock(stockRequestDto);

       return stockRequestDto=stockMapper.toStockRequestDto(stockRepository.save(stock));


    }

    @Override
    public void deleteStock(long id) {

        Stock stock=stockRepository.findById(id).get();
        stockRepository.delete(stock);


    }

    @Override
    public List<Stock> getAllStock() {
       return stockRepository.findAll();
    }
}
