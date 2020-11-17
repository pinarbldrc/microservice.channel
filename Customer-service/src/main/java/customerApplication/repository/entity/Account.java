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
@Table(name = "tbl_account")
public class Account implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_account",allocationSize = 1)
    @GeneratedValue(generator = "seq_account",strategy = GenerationType.SEQUENCE)
    long id;

    long number;

    double balance;


}
