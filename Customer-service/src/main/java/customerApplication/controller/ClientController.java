package customerApplication.controller;


import customerApplication.dto.request.ClientRequestDto;
import customerApplication.dto.response.ClientAccountResponseDto;
import customerApplication.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {


    @Autowired
    ClientServiceImpl clientService;

    @GetMapping("/client/{id}")
    ResponseEntity<ClientRequestDto> getClient(@PathVariable long id){

        return ResponseEntity.ok(clientService.getClient(id));
    }

    @GetMapping("/clientofAccount/{id}")
    ResponseEntity<ClientAccountResponseDto> getClientOfAccount(@PathVariable long id){

        return ResponseEntity.ok(clientService.getAccountOfClient(id));
    }

    @PostMapping("/addclientAccount/{id}")
    ResponseEntity<Void> addClientAccount(@PathVariable long id, @RequestBody @Valid List<Long> accountList){

        clientService.addClientAccount(accountList,id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addclient")
    ResponseEntity<ClientRequestDto> addClient(@RequestBody @Valid ClientRequestDto clientRequestDto){

        return ResponseEntity.ok(clientService.saveClient(clientRequestDto));

    }
    @PutMapping("/updateClient/{id}")
    ResponseEntity<ClientRequestDto> updateClient(@PathVariable long id,@RequestBody @Valid ClientRequestDto clientRequestDto){
        return ResponseEntity.ok(clientService.updateClient(id,clientRequestDto));
    }
    @DeleteMapping("/deleteclient/{id}")
    ResponseEntity<Void>deleteClient(@PathVariable long id){

        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }
}
