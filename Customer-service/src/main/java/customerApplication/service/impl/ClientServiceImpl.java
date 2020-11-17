package customerApplication.service.impl;

import customerApplication.dto.request.ClientRequestDto;
import customerApplication.dto.response.ClientAccountResponseDto;
import customerApplication.mapper.ClientMapper;
import customerApplication.repository.entity.Account;
import customerApplication.repository.entity.Client;
import customerApplication.repository.entity.ClientAccount;
import customerApplication.repository.repo.AccountRepository;
import customerApplication.repository.repo.ClientAccountRepository;
import customerApplication.repository.repo.ClientRepository;
import customerApplication.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {


    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientMapper clientMapper;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ClientAccountRepository clientAccountRepository;




    @Override
    public ClientRequestDto getClient(long clientid) {

        Client client=clientRepository.findById(clientid).orElseThrow(()-> new IllegalArgumentException());

       ClientRequestDto clientRequestDto=clientMapper.toClientRequestDto(client);
       return clientRequestDto;

    }

    @Override
    public ClientRequestDto saveClient(ClientRequestDto clientRequestDto) {

        Client client=clientMapper.toClient(clientRequestDto);
        client=clientRepository.save(client);
        clientRequestDto.setId(client.getId());
        return clientRequestDto;

    }

    @Override
    public void deleteClient(long clientid) {

        Client client=clientRepository.findById(clientid).orElseThrow(()-> new IllegalArgumentException());
        clientRepository.delete(client);

    }

    @Override
    public ClientRequestDto updateClient(long clientid,ClientRequestDto clientRequestDto) {

        Client client=clientRepository.findById(clientid).orElseThrow(()-> new IllegalArgumentException());
        client=clientMapper.toClient(clientRequestDto);

        return clientRequestDto=clientMapper.toClientRequestDto(clientRepository.save(client));

    }

    @Override
    public void addClientAccount(List<Long> accountList, long clientid) {

        Client client=clientRepository.findById(clientid).get();

        for (Long item:accountList)
        {
            clientAccountRepository.save(ClientAccount.builder().accountid(item).clientid(clientid).build());

        }


    }

    public ClientAccountResponseDto getAccountOfClient(long clientid){

        List<Account> accountList=new ArrayList<>();

        for (ClientAccount item : clientAccountRepository.findAllByClientid(clientid))
        {


            accountList.add(accountRepository.findById(item.getId()).get());

        }

        return ClientAccountResponseDto.builder().accountList(accountList).client(clientRepository.findById(clientid).get()).build();
    }


}
