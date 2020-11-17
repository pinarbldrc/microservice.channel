package productApplication.service;

import productApplication.dto.request.ProductRequestDto;
import productApplication.repository.entity.ProductStock;

import java.util.List;

public interface ProductService {

    ProductRequestDto addProductRequestDto(ProductRequestDto productRequestDto);
    void  addProductStok(List<Long> stocklist,long productid);
    void deleteProduct(long id);
    ProductRequestDto updateProduct(ProductRequestDto productRequestDto,long id);
    ProductRequestDto getProduct(long id);
}
