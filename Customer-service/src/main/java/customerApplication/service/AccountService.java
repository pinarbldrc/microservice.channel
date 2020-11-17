package customerApplication.service;

import customerApplication.dto.request.AccountRequestDto;
import customerApplication.dto.request.ClientRequestDto;
import customerApplication.repository.entity.Account;

import java.util.List;

public interface AccountService {


    List<Account> accountList();
    AccountRequestDto saveAccount(AccountRequestDto clientRequestDto);
    AccountRequestDto getAccount(long accountid);
    AccountRequestDto updateAccount(long accountid,AccountRequestDto accountRequestDto);
    void  deleteAccount(long accountid);

}
