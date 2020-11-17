package customerApplication.repository.repo;

import customerApplication.repository.entity.Account;
import customerApplication.repository.entity.ClientAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientAccountRepository extends JpaRepository<ClientAccount,Long> {


    List<ClientAccount> findAllByClientid(Long clientid);

}
