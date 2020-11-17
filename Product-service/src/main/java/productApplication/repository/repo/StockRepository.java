package productApplication.repository.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import productApplication.repository.entity.Stock;

public interface StockRepository extends JpaRepository<Stock,Long> {
}
