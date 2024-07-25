package br.edu.vianna.finance.model.users;

import br.edu.vianna.finance.utils.CryptoUtils;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

public abstract class User {
    private String cpf;
    private String name;
    private String login;
    private String email;
    private String password;
    private LocalDateTime dateOfRegister;

    public User() {
    }

    public User(String cpf, String name, String login, String email, String password) {
        setCpf(cpf);
        setName(name);
        setLogin(login);
        setEmail(email);
        setPassword(password);
        setDateOfRegister(LocalDateTime.now());
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(cpf != null && !cpf.isEmpty() && !cpf.isBlank()){
            this.cpf = cpf;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null && !name.isEmpty() && !name.isBlank()){
            this.name = name;
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if(login != null && !login.isEmpty() && !login.isBlank()){
            this.login = login;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email != null && !email.isEmpty() && !email.isBlank()){
            this.email = email;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        if(password != null && !password.isEmpty() && !password.isBlank()){
            this.password = password;
        }
    }

    public LocalDateTime getDateOfRegister() {
        return dateOfRegister;
    }

    public void setDateOfRegister(LocalDateTime dateOfRegister) {
        this.dateOfRegister = dateOfRegister;
    }
}
