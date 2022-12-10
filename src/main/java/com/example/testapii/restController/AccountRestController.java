package com.example.testapii.restController;

import com.example.testapii.model.Account;
import com.example.testapii.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
public class AccountRestController {

    @Autowired
    private AccountService service;

    @PostMapping("/saveAccount")
    public ResponseEntity<?> saveAccount(@RequestBody Account account){
        Account checkAcc = service.findAccount(account.getUsername());
        if(checkAcc==null){
            Account acc = service.save(account);
            if(acc!=null){
                return ResponseEntity.status(HttpStatus.CREATED).body(acc);
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot insert !");
            }
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(account.getUsername() +" is exists !");
        }

    }

    @PostMapping("/checkLogin")
    public ResponseEntity<?> checkLogin(String username,String password){
        Account account = service.login(username,password);
        if(account!=null){
            return ResponseEntity.status(HttpStatus.OK).body(account);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Login failed");
        }
    }

    @GetMapping("/getAccount/{username}")
    public ResponseEntity<?> getAccount(@PathVariable("username") String username){
        Account account = service.findAccount(username);
        if(account!=null){
            return ResponseEntity.status(HttpStatus.OK).body(account);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found account !!!");
        }
    }
}
