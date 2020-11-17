package productApplication.repository.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import productApplication.repository.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
