package productApplication.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import productApplication.dto.request.ProductRequestDto;
import productApplication.repository.entity.Product;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    Product toProduct(ProductRequestDto productRequestDto);
    ProductRequestDto toProductRequestDto(Product product);
}
