package customerApplication.service;

import customerApplication.dto.request.ClientRequestDto;
import customerApplication.repository.entity.Account;
import customerApplication.repository.entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ClientService {

    ClientRequestDto getClient(long clientid);

    ClientRequestDto saveClient(ClientRequestDto clientRequestDto);

    void deleteClient(long clientid);

    ClientRequestDto updateClient(long clientid,ClientRequestDto clientRequestDto);

    void addClientAccount(List<Long> accountList,long clientid);


}
