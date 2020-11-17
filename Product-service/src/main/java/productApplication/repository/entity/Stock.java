package productApplication.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_stock")
public class Stock  implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_stock",allocationSize = 1)
    @GeneratedValue(generator = "seq_stock", strategy = GenerationType.SEQUENCE)
    long id;

    long quantity;


}
