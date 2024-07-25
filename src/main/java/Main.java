

import UI.Dashboard;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                Dashboard dashboard = new Dashboard();
                dashboard.setVisible(true);
            } catch (Exception e) {
                System.out.println("Error: " + e.toString());
            }
        });
    }
}
