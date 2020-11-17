package productApplication.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_product")
public class Product implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_product",allocationSize = 1)
    @GeneratedValue(generator = "seq_product", strategy = GenerationType.SEQUENCE)
    long id;

    String name;

    String brand;

    double unitPrice;

}
