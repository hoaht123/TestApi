package com.example.testapii.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedStoredProcedureQuery(name = "getAccountByAccountName",
        procedureName = "getAccountByAccountName", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "username",type = String.class)
})
public class Account {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "username", nullable = true, length = 45)
    private String username;
    @Basic
    @Column(name = "password", nullable = true, length = 45)
    private String password;
    @Basic
    @Column(name = "email", nullable = true, length = 100)
    private String email;
    @Basic
    @Column(name = "fullname", nullable = true, length = 45)
    private String fullname;
    @Basic
    @Column(name = "phone", nullable = true, length = 20)
    private String phone;


}
