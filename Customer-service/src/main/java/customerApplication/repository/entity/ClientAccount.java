package customerApplication.repository.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="tbl_clientAccount")
public class ClientAccount implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_clientAccount",allocationSize = 1)
    @GeneratedValue(generator = "seq_clientAccount",strategy = GenerationType.SEQUENCE)
    long id;

    long clientid;

    long accountid;


}
