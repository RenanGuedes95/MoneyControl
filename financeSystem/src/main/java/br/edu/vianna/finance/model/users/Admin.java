package br.edu.vianna.finance.model.users;

import java.security.NoSuchAlgorithmException;

public class Admin extends User {
    private String department;
    private String position;

    public Admin() {
    }

    public Admin(String cpf, String name, String login, String email, String password, String department, String position){
        super(cpf, name, login, email, password);
        setDepartment(department);
        setPosition(position);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if(department != null && !department.isEmpty() && !department.isBlank()){
            this.department = department;
        }
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        if(position != null && !position.isEmpty() && !position.isBlank()){
            this.position = position;
        }
    }
}
