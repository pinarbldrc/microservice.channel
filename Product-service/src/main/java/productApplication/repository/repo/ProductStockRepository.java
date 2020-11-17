package productApplication.repository.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import productApplication.repository.entity.ProductStock;


import java.util.List;

public interface ProductStockRepository extends JpaRepository<ProductStock,Long> {

    List<ProductStock> findByProductid(long productid);
}
