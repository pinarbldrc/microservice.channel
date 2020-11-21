package customerApplication.security.models;

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
@Table(name = "tbl_user")
public class User implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_user",allocationSize = 1)
    @GeneratedValue(generator = "seq_user",strategy = GenerationType.SEQUENCE)
    long id;

    String name;


}
