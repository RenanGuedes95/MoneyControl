package br.edu.vianna.finance;

import br.edu.vianna.finance.dao.imp.*;
import br.edu.vianna.finance.model.finances.Expense;
import br.edu.vianna.finance.model.finances.Income;
import br.edu.vianna.finance.model.users.Client;
import br.edu.vianna.finance.view.viewPrincipal;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String [] args){
        viewPrincipal vp = new viewPrincipal();
        vp.setVisible(true);
    }
}
