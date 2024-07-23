package UI;

import DAO.ClienteDAO;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

public class ElimClientePNL extends javax.swing.JPanel {

    public ElimClientePNL() {
        initComponents();

        // Agrega listener para seleccionar filas de la tabla
        Tools.mouseListenerTable(tablaClientes, idTF, nombreTF, correoTF, telTF);

        // Muestra la lista de clientes al entrar al panel
        Tools.entablarClientes(tablaClientes);

        // Fuente header tabla
        JTableHeader header = tablaClientes.getTableHeader();
        Font headerFont = new Font("Segoe UI", Font.BOLD, 14);
        header.setFont(headerFont);

        // Crear un renderizador para centrar el texto del encabezado
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        
        // Crear el sorter y aplicarlo a la tabla
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tablaClientes.getModel());
        tablaClientes.setRowSorter(sorter);

        // Deshabilitar ordenamiento en columnas correo y telefono
        sorter.setSortable(2, false);
        sorter.setSortable(3, false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ElimClienteForm = new javax.swing.JPanel();
        eliminarForm = new javax.swing.JPanel();
        id_label = new javax.swing.JLabel();
        eliminarBtn = new javax.swing.JButton();
        nombreLabel = new javax.swing.JLabel();
        idTF = new javax.swing.JTextField();
        nombreTF = new javax.swing.JTextField();
        direccLabel = new javax.swing.JLabel();
        correoTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        telTF = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        ElimClienteForm.setEnabled(false);

        eliminarForm.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        id_label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        id_label.setText("ID:");

        eliminarBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        eliminarBtn.setText("Eliminar");
        eliminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBtnActionPerformed(evt);
            }
        });

        nombreLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nombreLabel.setText("Nombre:");

        idTF.setEditable(false);
        idTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        nombreTF.setEditable(false);
        nombreTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        direccLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        direccLabel.setText("Correo electronico:");

        correoTF.setEditable(false);
        correoTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Telefono:");

        telTF.setEditable(false);
        telTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout eliminarFormLayout = new javax.swing.GroupLayout(eliminarForm);
        eliminarForm.setLayout(eliminarFormLayout);
        eliminarFormLayout.setHorizontalGroup(
            eliminarFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarFormLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(eliminarFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eliminarFormLayout.createSequentialGroup()
                        .addGroup(eliminarFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(direccLabel)
                            .addComponent(id_label)
                            .addComponent(nombreLabel))
                        .addGap(196, 196, 196))
                    .addGroup(eliminarFormLayout.createSequentialGroup()
                        .addGroup(eliminarFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nombreTF, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addComponent(correoTF)
                            .addComponent(telTF)
                            .addComponent(idTF))
                        .addContainerGap())))
            .addGroup(eliminarFormLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(eliminarBtn)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        eliminarFormLayout.setVerticalGroup(
            eliminarFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarFormLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(id_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(nombreLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(direccLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(correoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(eliminarBtn)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        tablaClientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaClientes.setShowHorizontalLines(true);
        tablaClientes.setShowVerticalLines(true);
        tablaClientes.setSurrendersFocusOnKeystroke(true);
        tablaClientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaClientes);
        if (tablaClientes.getColumnModel().getColumnCount() > 0) {
            tablaClientes.getColumnModel().getColumn(0).setMinWidth(70);
            tablaClientes.getColumnModel().getColumn(0).setPreferredWidth(70);
            tablaClientes.getColumnModel().getColumn(0).setMaxWidth(70);
            tablaClientes.getColumnModel().getColumn(3).setMinWidth(120);
            tablaClientes.getColumnModel().getColumn(3).setPreferredWidth(120);
            tablaClientes.getColumnModel().getColumn(3).setMaxWidth(120);
        }

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ELIMINAR CLIENTES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(350, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(329, 329, 329))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout ElimClienteFormLayout = new javax.swing.GroupLayout(ElimClienteForm);
        ElimClienteForm.setLayout(ElimClienteFormLayout);
        ElimClienteFormLayout.setHorizontalGroup(
            ElimClienteFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ElimClienteFormLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(eliminarForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        ElimClienteFormLayout.setVerticalGroup(
            ElimClienteFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ElimClienteFormLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(ElimClienteFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminarForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ElimClienteForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ElimClienteForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Acciones boton "Eliminar" en el formulario
    private void eliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBtnActionPerformed

        if (idTF.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un elemento de la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ClienteDAO db = new ClienteDAO();

        int res = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar?", "Confirmacion requerida", JOptionPane.YES_NO_OPTION, QUESTION_MESSAGE);

        if (res == JOptionPane.YES_OPTION) {
            int clienteID = Integer.parseInt(idTF.getText());
            if (db.eliminarClienteCompleto(clienteID)) {
                JOptionPane.showMessageDialog(null, "Se elimino al cliente con ID : " + clienteID, "Operacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
                Tools.entablarClientes(tablaClientes);
            }
            Tools.limpiarFormulario(new JTextField[]{idTF, nombreTF, correoTF, telTF});
        }

    }//GEN-LAST:event_eliminarBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ElimClienteForm;
    private javax.swing.JTextField correoTF;
    private javax.swing.JLabel direccLabel;
    private javax.swing.JButton eliminarBtn;
    private javax.swing.JPanel eliminarForm;
    private javax.swing.JTextField idTF;
    private javax.swing.JLabel id_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreTF;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField telTF;
    // End of variables declaration//GEN-END:variables
}
