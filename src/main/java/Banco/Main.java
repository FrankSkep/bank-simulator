package Banco;
import UI.Dashboard;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        
        Dashboard gui = new Dashboard();
        
        gui.setVisible(true);
        
    }
}
