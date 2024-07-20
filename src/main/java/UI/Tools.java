package UI;

import DAO.ClienteDAO;
import DAO.CuentaBancariaDAO;
import DAO.UsuarioDAO;
import Modelos.Cliente;
import Modelos.CuentaBancaria;
import java.awt.BorderLayout;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Tools {

    public static void mouseListenerTable(JTable tabla, JTextField idTF, JTextField nombreTF,
            JTextField correoTF, JTextField telTF) {
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tabla.getSelectedRow();
                if (row != -1) {
                    // Obtener el modelo de la tabla
                    javax.swing.table.TableModel model = tabla.getModel();

                    // Obtener los valores de la fila seleccionada
                    String id = model.getValueAt(row, 0).toString();
                    String nombre = model.getValueAt(row, 1).toString();
                    String correo = model.getValueAt(row, 2).toString();
                    String telefono = model.getValueAt(row, 3).toString();

                    // Mostrar los valores de la fila en el formulario
                    idTF.setText(id);
                    nombreTF.setText(nombre);
                    correoTF.setText(correo);
                    telTF.setText(telefono);
                }
            }
        });
    }

    public static void limpiarFormulario(JTable tabla, JTextField idTF, JTextField nombreTF,
            JTextField correoTF, JTextField telTF) {

        idTF.setText("");
        nombreTF.setText("");
        correoTF.setText("");
        telTF.setText("");

    }

    // Recibe una Tabla y la rellena con datos
    public static void listarClientes(JTable tabla) {

        // Obtener el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();

        // Limpiar la tabla antes de agregar los nuevos datos
        model.setRowCount(0);

        List<Cliente> clientes = new ClienteDAO().obtenerTodosLosClientes();

        if (clientes.isEmpty()) {
            Object[] row = {"No hay clientes", "No hay clientes", "No hay clientes", "No hay clientes"};
            model.addRow(row);
            return;
        }

        for (Cliente cliente : clientes) {
            Object[] row = {cliente.getID(), cliente.getNombre(), cliente.getCorreo(), cliente.getTelefono()};
            model.addRow(row);
        }
    }

    // Recibe una Tabla y la rellena con datos
    public static void listarCuentasB(JTable tabla, int idCliente) {

        // Obtener el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();

        // Limpiar la tabla antes de agregar los nuevos datos
        model.setRowCount(0);

        List<CuentaBancaria> cuentasBancarias = new CuentaBancariaDAO().obtenerCuentasCliente(idCliente);

        if (cuentasBancarias.isEmpty()) {
            Object[] row = {"No hay cuentas", "No hay cuentas"};
            model.addRow(row);
            return;
        }

        for (CuentaBancaria cuenta : cuentasBancarias) {
            Object[] row = {cuenta.getNumeroCuenta(), cuenta.getSaldo()};
            model.addRow(row);
        }
    }

    // Validar que no se dejen campos vacios
    public static boolean existenCamposVacios(String nombre, String contrasenia, String nombreComp, String correo, String telefono) {
        return nombre.isBlank() || correo.isBlank() || telefono.isBlank() || contrasenia.isBlank();
    }

    // Verifica si un correo es valido
    public static boolean validarCorreo(String correo) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern patron = Pattern.compile(emailRegex);
        Matcher matcher = patron.matcher(correo);
        return matcher.matches();
    }

    // Verifica si un telefono es valido
    public static boolean validarTelefono(String telefono) {
        String phoneRegex = "^[0-9]{10}$";
        Pattern patron = Pattern.compile(phoneRegex);
        Matcher matcher = patron.matcher(telefono);
        return matcher.matches();
    }

    // Validar todos los campos del formulario
    public static boolean validarFormulario(String nombre, String contrasenia, String nombreComp, String correo, String telefono) {

        if (Tools.existenCamposVacios(nombre, contrasenia, nombreComp, correo, telefono)) {
            JOptionPane.showMessageDialog(null, "Por favor rellena todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!Tools.validarCorreo(correo)) {
            JOptionPane.showMessageDialog(null, "Por favor ingresa un correo valido", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!Tools.validarTelefono(telefono)) {
            JOptionPane.showMessageDialog(null, "Por favor ingresa un telefono valido", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    // Cambia entre paneles
    public static void showPanel(JPanel p, JPanel mainPanel) {
        p.setSize(1060, 670);
        p.setLocation(0, 0);

        mainPanel.removeAll();
        mainPanel.add(p, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    // Método para verificar si un String es numérico
    public static boolean esNumerico(String str) {
        return str != null && str.matches("\\d*\\.?\\d+");
    }
}
