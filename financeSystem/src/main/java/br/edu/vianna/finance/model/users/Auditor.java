package br.edu.vianna.finance.model.users;

public class Auditor extends User {
    private String department;
    private String position;

    public Auditor() {
    }

    public Auditor(String cpf, String name, String login, String email, String password, String department, String position) {
        super(cpf, name, login, email, password);
        setDepartment(department);
        setPosition(position);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if(department != null && !department.isBlank() && !department.isEmpty()){
            this.department = department;
        }
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        if(position != null && !position.isBlank() && !position.isEmpty()){
            this.position = position;
        }
    }
}
