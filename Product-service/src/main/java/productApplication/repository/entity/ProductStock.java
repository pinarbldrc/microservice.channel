package productApplication.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_product_stock")
public class ProductStock implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_product_stock",allocationSize = 1)
    @GeneratedValue(generator = "seq_product_stock", strategy = GenerationType.SEQUENCE)
    long id;

    long productid;
    long stockid;


}
