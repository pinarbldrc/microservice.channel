package customerApplication.repository.entity;


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
@Table(name = "tbl_client")
public class Client implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_customer",allocationSize = 1)
    @GeneratedValue(generator = "seq_customer",strategy = GenerationType.SEQUENCE)
    long id;

    String name;

    String password;

    String surname;

    String email;


}
