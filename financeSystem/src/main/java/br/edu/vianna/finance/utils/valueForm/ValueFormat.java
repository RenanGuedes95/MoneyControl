package br.edu.vianna.finance.utils.valueForm;

public class ValueFormat {
    public static String formatValue(String string){
        return string.replace(".", "").replace(",", ".");
    }
    public static String displayValue(Double value){
        return String.format("%.2f", value);
    }
    public static String displayValueFormat(Double value){
        return String.format("R$ %.2f", value);
    }
    public static String displayPercentage(Double percentage){
        return String.format("%.2f%%", percentage);
    }

    public static Boolean validateValue(String value){
        return !value.matches(".*[^0-9,.].*");
    }
}
