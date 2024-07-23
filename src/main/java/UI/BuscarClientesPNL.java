package UI;

import DAO.ClienteDAO;
import Entidades.Cliente;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class BuscarClientesPNL extends javax.swing.JPanel {

    public BuscarClientesPNL() {
        initComponents();

        // Agrega listener para seleccionar filas de la tabla
        Tools.mouseListenerTable(tabla_clientes, idTF, nombreTF, correoTF, telTF);

        // Muestra la lista de clientes al entrar al panel
        Tools.entablarClientes(tabla_clientes);

        // Fuente header tabla
        JTableHeader header = tabla_clientes.getTableHeader();
        Font headerFont = new Font("Segoe UI", Font.BOLD, 14);
        header.setFont(headerFont);

        // Crear un renderizador para centrar el texto del encabezado
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buscarEditForm = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        actualizarBtn = new javax.swing.JButton();
        nombreLabel = new javax.swing.JLabel();
        nombreTF = new javax.swing.JTextField();
        idTF = new javax.swing.JTextField();
        correoLabel = new javax.swing.JLabel();
        correoTF = new javax.swing.JTextField();
        telefonoLabel = new javax.swing.JLabel();
        telTF = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_clientes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        buscarEditForm.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        idLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idLabel.setText("ID:");

        actualizarBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        actualizarBtn.setText("Actualizar");
        actualizarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarBtnActionPerformed(evt);
            }
        });

        nombreLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nombreLabel.setText("Nombre:");

        nombreTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        idTF.setEditable(false);
        idTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        correoLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        correoLabel.setText("Correo electronico:");

        correoTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        telefonoLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        telefonoLabel.setText("Telefono:");

        telTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout buscarEditFormLayout = new javax.swing.GroupLayout(buscarEditForm);
        buscarEditForm.setLayout(buscarEditFormLayout);
        buscarEditFormLayout.setHorizontalGroup(
            buscarEditFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buscarEditFormLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(buscarEditFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(telefonoLabel)
                    .addComponent(correoLabel)
                    .addComponent(nombreLabel)
                    .addComponent(idLabel)
                    .addComponent(idTF, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                    .addComponent(nombreTF)
                    .addComponent(correoTF)
                    .addComponent(telTF))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buscarEditFormLayout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addComponent(actualizarBtn)
                .addGap(121, 121, 121))
        );
        buscarEditFormLayout.setVerticalGroup(
            buscarEditFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buscarEditFormLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(idLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nombreLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(correoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(correoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(telefonoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(actualizarBtn)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        tabla_clientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabla_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "CORREO ELECTRONICO", "TELEFONO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_clientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabla_clientes.setShowHorizontalLines(true);
        tabla_clientes.setShowVerticalLines(true);
        tabla_clientes.setSurrendersFocusOnKeystroke(true);
        tabla_clientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabla_clientes);
        if (tabla_clientes.getColumnModel().getColumnCount() > 0) {
            tabla_clientes.getColumnModel().getColumn(0).setMinWidth(70);
            tabla_clientes.getColumnModel().getColumn(0).setPreferredWidth(70);
            tabla_clientes.getColumnModel().getColumn(0).setMaxWidth(70);
            tabla_clientes.getColumnModel().getColumn(3).setMinWidth(120);
            tabla_clientes.getColumnModel().getColumn(3).setPreferredWidth(120);
            tabla_clientes.getColumnModel().getColumn(3).setMaxWidth(120);
        }

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BUSCAR Y MODIFICAR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(348, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(330, 330, 330))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(buscarEditForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscarEditForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    private void actualizarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarBtnActionPerformed
        String id = idTF.getText();
        String nombre = nombreTF.getText();
        String correo = correoTF.getText();
        String telefono = telTF.getText();

        if (id.isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un elemento de la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!Tools.validarCamposVacios(new String[]{nombre, correo, telefono})) {
            JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!Tools.correoTelefonoValidos(correo, telefono)) {
            return;
        }

        // Lee respuesta del usuario
        int res = JOptionPane.showConfirmDialog(null, "¿Seguro que desea modificar?", "Confirmacion requerida", JOptionPane.YES_NO_OPTION, QUESTION_MESSAGE);

        if (res == JOptionPane.YES_OPTION) {

            // Crea un objeto de cliente con los nuevos datos y lo sobreescribe en la db
            Cliente cliente = new Cliente(nombreTF.getText(), correoTF.getText(), telTF.getText());
            cliente.setID(Integer.parseInt(id));
            ClienteDAO db = new ClienteDAO();

            if (db.actualizarCliente(cliente, Integer.parseInt(id))) {
                JOptionPane.showMessageDialog(null, "Se ha actualizado el cliente con ID " + id, "Operacion exitosa", JOptionPane.INFORMATION_MESSAGE);
                Tools.entablarClientes(tabla_clientes);
            }
            Tools.limpiarFormulario(new JTextField[]{idTF, nombreTF, correoTF, telTF});
        }
    }//GEN-LAST:event_actualizarBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarBtn;
    private javax.swing.JPanel buscarEditForm;
    private javax.swing.JLabel correoLabel;
    private javax.swing.JTextField correoTF;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreTF;
    private javax.swing.JTable tabla_clientes;
    private javax.swing.JTextField telTF;
    private javax.swing.JLabel telefonoLabel;
    // End of variables declaration//GEN-END:variables
}
