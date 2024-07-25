package br.edu.vianna.finance.utils.cpfForm;

public class CpfFormat {
    public static String cpfFormat(String cpf){
       return cpf.replace(".", "").replace("-", "");
    }
    public static Boolean validateCpf(String cpf){
        return (cpf.matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}") || cpf.matches("\\d{11}")) && !cpf.matches(".*[^0-9.-].*");
    }
}
