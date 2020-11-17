package customerApplication.service.impl;

import customerApplication.dto.request.AccountRequestDto;
import customerApplication.dto.request.ClientRequestDto;
import customerApplication.mapper.AccountMapper;
import customerApplication.repository.entity.Account;
import customerApplication.repository.repo.AccountRepository;
import customerApplication.service.AccountService;
import liquibase.pro.packaged.L;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AccountMapper accountMapper;

    @Override
    public List<Account> accountList() {

        return accountRepository.findAll();

    }

    @Override
    public AccountRequestDto saveAccount(AccountRequestDto accountRequestDto) {

        Account account=accountMapper.toAccount(accountRequestDto);

        account=accountRepository.save(account);
        accountRequestDto.setId(account.getId());
        return accountRequestDto;


    }

    @Override
    public AccountRequestDto getAccount(long accountid) {

        Account account=accountRepository.findById(accountid).orElseThrow(()-> new IllegalArgumentException());

        AccountRequestDto accountRequestDto=accountMapper.toAccountRequestDto(account);
        return accountRequestDto;

    }

    @Override
    public AccountRequestDto updateAccount(long accountid,AccountRequestDto accountRequestDto) {

        Account account=accountRepository.findById(accountid).orElseThrow(()-> new IllegalArgumentException());

        account=accountMapper.toAccount(accountRequestDto);

        return accountRequestDto=accountMapper.toAccountRequestDto(accountRepository.save(account));



    }

    @Override
    public void deleteAccount(long accountid) {

        Account account=accountRepository.findById(accountid).orElseThrow(()-> new IllegalArgumentException());

            accountRepository.delete(account);


    }
}
