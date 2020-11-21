package customerApplication.controller;


import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.interfaces.DecodedJWT;
import customerApplication.dto.request.AccountRequestDto;
import customerApplication.repository.entity.Account;
import customerApplication.security.auth.TokenManager;
import customerApplication.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountServiceImpl accountService;
    @Autowired
    TokenManager tokenManager;

    @GetMapping("/account/{id}")
    ResponseEntity<AccountRequestDto> getAccount(@PathVariable long id){

        return ResponseEntity.ok(accountService.getAccount(id));
    }


    @PostMapping("/addAccount")
    ResponseEntity<AccountRequestDto> saveAccount(@RequestBody @Valid AccountRequestDto accountRequestDto){

        return ResponseEntity.ok(accountService.saveAccount(accountRequestDto));
    }

    @GetMapping("/allAccount")
    ResponseEntity<List<Account>> getAllAccount( String token){

        DecodedJWT jwtVerifier=tokenManager.verifyToken(token);
        if (jwtVerifier!=null){
            String username=tokenManager.verifyToken(token).getClaim("username").asString();
            Boolean isVerify=tokenManager.verifyToken(token).getIssuedAt().before(new Date());

            if(isVerify){
                return ResponseEntity.ok(accountService.accountList());
            }
            else return ResponseEntity.ok(null);

        }
        else{
           return ResponseEntity.ok(null);
        }



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

    @GetMapping("/token")
    ResponseEntity<String> getToken(){
        return ResponseEntity.ok(tokenManager.generateToken("PINAR"));
    }





}
