package productApplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import productApplication.dto.request.ClientRequestDto;
import productApplication.dto.request.ProductRequestDto;
import productApplication.dto.response.ProductStocksResponseDto;
import productApplication.manager.ProductManagerClient;
import productApplication.mapper.ProductMapper;
import productApplication.repository.entity.Product;
import productApplication.repository.entity.ProductStock;
import productApplication.repository.entity.Stock;
import productApplication.repository.repo.ProductRepository;
import productApplication.repository.repo.ProductStockRepository;
import productApplication.repository.repo.StockRepository;
import productApplication.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductStockRepository productStockRepository;

    @Autowired
    StockRepository stockRepository;

    @Autowired
    ProductMapper productMapper;
    @Autowired
    ProductManagerClient productManagerClient;


    @Override
    public ProductRequestDto addProductRequestDto(ProductRequestDto productRequestDto) {


        Product product=productMapper.toProduct(productRequestDto);
        product=productRepository.save(product);
        productRequestDto.setId(product.getId());
        return productRequestDto;
    }

    @Override
    public void addProductStok(List<Long> stocklist, long productid) {

        Product product=productRepository.findById(productid).get();

        for (Long item:stocklist)
        {
          productStockRepository.save(ProductStock.builder().productid(productid).stockid(item).build());

        }

    }

    @Override
    public void deleteProduct(long id) {

        Product product=productRepository.findById(id).orElseThrow(()->new IllegalArgumentException());

        productRepository.delete(product);


    }

    @Override
    public ProductRequestDto updateProduct(ProductRequestDto productRequestDto, long id) {

        Product product=productRepository.findById(id).orElseThrow(()->new IllegalArgumentException());
        product=productMapper.toProduct(productRequestDto);
        return productRequestDto=productMapper.toProductRequestDto(productRepository.save(product));



    }

    @Override
    public ProductRequestDto getProduct(long id) {

        Product product=productRepository.findById(id).get();

        return productMapper.toProductRequestDto(product);

    }

    public ProductStocksResponseDto getProductStocks(long productid){

        List<Stock> stockList=new ArrayList<>();

        for (ProductStock item:productStockRepository.findByProductid(productid))
        {
           stockList.add(stockRepository.findById(item.getId()).get());

        }
        return ProductStocksResponseDto.builder().stockList(stockList).product(productRepository.findById(productid).get()).build();

    }

    public ResponseEntity<ClientRequestDto> getClient(long clientid) {

        ResponseEntity<ClientRequestDto> clientRequestDtoResponseEntity=productManagerClient.getClient(clientid);

        clientRequestDtoResponseEntity.getBody();

       return clientRequestDtoResponseEntity;

    }



}



