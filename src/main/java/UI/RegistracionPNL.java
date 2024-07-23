package UI;

import Autenticacion.RegistroUsuario;
import Entidades.Cliente;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class RegistracionPNL extends javax.swing.JPanel {

    private Dashboard dashboard;

    public RegistracionPNL(Dashboard dashboard) {
        initComponents();

        this.dashboard = dashboard;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        containerAggCl = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        nombreLabel = new javax.swing.JLabel();
        correoLabel = new javax.swing.JLabel();
        telefonoLabel = new javax.swing.JLabel();
        usernameTF = new javax.swing.JTextField();
        correoTF = new javax.swing.JTextField();
        telefonoTF = new javax.swing.JTextField();
        registrarseBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombreComTF = new javax.swing.JTextField();
        passTF = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        labelAggCliente = new javax.swing.JLabel();

        nombreLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nombreLabel.setText("NOMBRE DE USUARIO:");

        correoLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        correoLabel.setText("CORREO ELECTRONICO:");

        telefonoLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        telefonoLabel.setText("TELEFONO:");

        usernameTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        correoTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        telefonoTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        registrarseBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        registrarseBtn.setText("REGISTRAR");
        registrarseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarseBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("CONTRASEÑA:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("NOMBRE COMPLETO:");

        nombreComTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        passTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(118, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usernameTF)
                            .addComponent(nombreComTF, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                            .addComponent(correoTF)
                            .addComponent(telefonoTF)
                            .addComponent(passTF)
                            .addComponent(nombreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(correoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefonoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(104, 104, 104))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(registrarseBtn)
                        .addGap(282, 282, 282))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(nombreLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreComTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(correoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(correoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(telefonoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telefonoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(registrarseBtn)
                .addGap(55, 55, 55))
        );

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        labelAggCliente.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelAggCliente.setForeground(new java.awt.Color(255, 255, 255));
        labelAggCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAggCliente.setText("REGISTRATE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelAggCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(354, 354, 354))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(labelAggCliente)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout containerAggClLayout = new javax.swing.GroupLayout(containerAggCl);
        containerAggCl.setLayout(containerAggClLayout);
        containerAggClLayout.setHorizontalGroup(
            containerAggClLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerAggClLayout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        containerAggClLayout.setVerticalGroup(
            containerAggClLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerAggClLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerAggCl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerAggCl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void registrarseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarseBtnActionPerformed
        String nomUsuario = usernameTF.getText();
        String contrasenia = String.valueOf(passTF.getPassword());
        String nombreCompleto = nombreComTF.getText();
        String correo = correoTF.getText();
        String telefono = telefonoTF.getText();

        if (!Tools.validarCamposVacios(new String[]{nomUsuario, contrasenia, nombreCompleto, correo, telefono})) {
            JOptionPane.showMessageDialog(null, "Por favor rellena todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!Tools.correoTelefonoValidos(correo, telefono)) {
            return;
        }

        if (!Tools.esContraseniaValida(correo)) {
            JOptionPane.showMessageDialog(null, "Ingresa una contraseña valida, debe tener mas de 6 caracteres, sin espacios", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        RegistroUsuario reg = new RegistroUsuario();

        Cliente cliente = new Cliente(nombreCompleto, correo, telefono);
        if (reg.registrarClienteYUsuario(nomUsuario, contrasenia, cliente)) {
            String mensaje = """
                             Se registro correctamente\n
                             ID de cliente : """ + cliente.getID();
            JOptionPane.showMessageDialog(null, mensaje, "Operacion exitosa", JOptionPane.INFORMATION_MESSAGE);
            Tools.showPanel(new MenuSesionPNL(this.dashboard), (JPanel) this.getParent());
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe un cliente registrado con ese nombre de usuario", "Operacion fallida", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_registrarseBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel containerAggCl;
    private javax.swing.JLabel correoLabel;
    private javax.swing.JTextField correoTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelAggCliente;
    private javax.swing.JTextField nombreComTF;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JPasswordField passTF;
    private javax.swing.JButton registrarseBtn;
    private javax.swing.JLabel telefonoLabel;
    private javax.swing.JTextField telefonoTF;
    private javax.swing.JTextField usernameTF;
    // End of variables declaration//GEN-END:variables
}
