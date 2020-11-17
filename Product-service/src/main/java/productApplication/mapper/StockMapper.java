package productApplication.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import productApplication.dto.request.StockRequestDto;
import productApplication.repository.entity.Stock;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StockMapper {

    Stock toStock(StockRequestDto stockRequestDto);

    StockRequestDto toStockRequestDto(Stock stock);
}
