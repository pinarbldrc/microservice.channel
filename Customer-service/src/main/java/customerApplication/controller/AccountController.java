package customerApplication.controller;


import customerApplication.dto.request.AccountRequestDto;
import customerApplication.repository.entity.Account;
import customerApplication.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountServiceImpl accountService;

    @GetMapping("/account/{id}")
    ResponseEntity<AccountRequestDto> getAccount(@PathVariable long id){

        return ResponseEntity.ok(accountService.getAccount(id));
    }


    @PostMapping("/addAccount")
    ResponseEntity<AccountRequestDto> saveAccount(@RequestBody @Valid AccountRequestDto accountRequestDto){

        return ResponseEntity.ok(accountService.saveAccount(accountRequestDto));
    }

    @GetMapping("/allAccount")
    ResponseEntity<List<Account>> getAllAccount(){

       return ResponseEntity.ok(accountService.accountList());
    }

    @DeleteMapping("/deleteaccount/{id}")
    ResponseEntity<Void> deleteAccount(@PathVariable long id){

        accountService.deleteAccount(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateaccount/{id}")
    ResponseEntity<AccountRequestDto> updateAccount(@PathVariable long id,@RequestBody @Valid AccountRequestDto accountRequestDto){

        return ResponseEntity.ok(accountService.updateAccount(id,accountRequestDto));
    }





}
