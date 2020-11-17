package productApplication.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import productApplication.repository.entity.Product;
import productApplication.repository.entity.Stock;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductStocksResponseDto {

    Product product;
    List<Stock> stockList;
}
