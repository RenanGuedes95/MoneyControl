package br.edu.vianna.finance.utils.dateForm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormat {
    public static String formatDateToString(LocalDate date){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(dtf);
    }

    public static LocalDate formatStringToDate(String date){
        String dateFormated = getDateFormated(date);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateFormated, dtf);
    }

    private static String getDateFormated(String date) {
        String year = date.substring(6,10) + "-";
        String month = date.substring(3,5) + "-";
        String day = date.substring(0,2);
        return year + month + day;
    }

    public static Boolean validateDate(String date){
        return date.matches("\\d{2}/\\d{2}/\\d{4}") && !date.matches(".*[^0-9/].*");
    }

    public static Boolean validateMonth(String month){
        return month.matches("\\d{2}") && !month.matches(".*[^0-9].*");
    }

    public static Boolean validadeYear(String year){
        return year.matches("\\d{4}") && !year.matches(".*[^0-9].*");
    }
}
