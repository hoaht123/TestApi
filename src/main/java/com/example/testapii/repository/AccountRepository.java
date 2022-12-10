package com.example.testapii.repository;

import com.example.testapii.model.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Procedure(value = "getAccountByAccountNameAndPassword")
    Account getAccountByUsernameAndPassword(@Param("username") String username,@Param("password") String password);


    @Procedure(value = "getAccountByAccountName")
//    @Query(name = "CALL getAccountByAccountName(:username)")
    Account getOne(@Param("username") String username);
}