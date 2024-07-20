package UI;

import DAO.ClienteDAO;
import java.awt.Font;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import javax.swing.table.JTableHeader;

public class ElimClientePNL extends javax.swing.JPanel {

    public ElimClientePNL() {
        initComponents();

        // Agrega listener para seleccionar filas de la tabla
        Tools.mouseListenerTable(tabla_clientes, idTF, nombreTF, correoTF, telTF);

        // Muestra la lista de clientes al entrar al panel
        Tools.listarClientes(tabla_clientes);
        
        // Fuente header tabla
        JTableHeader header = tabla_clientes.getTableHeader();
        Font headerFont = new Font("Segoe UI", Font.BOLD, 14);
        header.setFont(headerFont);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ElimClienteForm = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
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
        tabla_clientes = new javax.swing.JTable();

        ElimClienteForm.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ELIMINAR CLIENTES");

        eliminarForm.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        id_label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        id_label.setText("ID:");

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
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(eliminarFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eliminarFormLayout.createSequentialGroup()
                        .addGroup(eliminarFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(direccLabel)
                            .addComponent(id_label)
                            .addComponent(nombreLabel)
                            .addComponent(nombreTF)
                            .addComponent(idTF)
                            .addComponent(correoTF)
                            .addComponent(telTF, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eliminarFormLayout.createSequentialGroup()
                        .addComponent(eliminarBtn)
                        .addGap(142, 142, 142))))
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
                .addContainerGap(40, Short.MAX_VALUE))
        );

        tabla_clientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabla_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Correo electronico", "Telefono"
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
        tabla_clientes.setShowHorizontalLines(true);
        tabla_clientes.setShowVerticalLines(true);
        tabla_clientes.setSurrendersFocusOnKeystroke(true);
        tabla_clientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabla_clientes);

        javax.swing.GroupLayout ElimClienteFormLayout = new javax.swing.GroupLayout(ElimClienteForm);
        ElimClienteForm.setLayout(ElimClienteFormLayout);
        ElimClienteFormLayout.setHorizontalGroup(
            ElimClienteFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ElimClienteFormLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(eliminarForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ElimClienteFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        ElimClienteFormLayout.setVerticalGroup(
            ElimClienteFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ElimClienteFormLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addGroup(ElimClienteFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminarForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
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
                Tools.listarClientes(tabla_clientes);
            }
            Tools.limpiarFormulario(tabla_clientes, idTF, nombreTF, correoTF, telTF);
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreTF;
    private javax.swing.JTable tabla_clientes;
    private javax.swing.JTextField telTF;
    // End of variables declaration//GEN-END:variables
}