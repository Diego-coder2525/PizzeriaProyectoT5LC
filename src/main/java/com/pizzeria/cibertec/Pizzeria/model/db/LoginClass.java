package com.pizzeria.cibertec.Pizzeria.model.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginClass {
    private String user;
    private String password;
}
