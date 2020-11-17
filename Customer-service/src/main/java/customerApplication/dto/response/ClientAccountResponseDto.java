package customerApplication.dto.response;

import customerApplication.repository.entity.Account;
import customerApplication.repository.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientAccountResponseDto {

    Client client;

    List<Account> accountList;
}
