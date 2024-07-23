package UI;

import Autenticacion.SesionUsuario;
import DAO.CuentaBancariaDAO;
import Entidades.CuentaBancaria;
import javax.swing.JOptionPane;

public class AbrirCuentaPanel extends javax.swing.JPanel {

    private int idCliente;

    public AbrirCuentaPanel() {
        initComponents();

        // Obtener ID cliente autenticado
        idCliente = SesionUsuario.getInstance().getUsuario().getClienteId();
        idClienteTF.setText(String.valueOf(idCliente));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        abrirCuenta = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        numCuentaTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        saldoTF = new javax.swing.JTextField();
        idClienteLabel = new javax.swing.JLabel();
        abrirCuentaBtn = new javax.swing.JButton();
        idClienteTF = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        labelAbrirCuenta = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("NUMERO DE CUENTA ASIGNADO:");

        numCuentaTF.setEditable(false);
        numCuentaTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("SALDO INICIAL:");

        saldoTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        idClienteLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idClienteLabel.setText("ID CLIENTE:");

        abrirCuentaBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        abrirCuentaBtn.setText("ABRIR CUENTA");
        abrirCuentaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirCuentaBtnActionPerformed(evt);
            }
        });

        idClienteTF.setEditable(false);
        idClienteTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(idClienteTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                            .addComponent(saldoTF, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numCuentaTF, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(idClienteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(abrirCuentaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(idClienteLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idClienteTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numCuentaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saldoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(abrirCuentaBtn)
                .addGap(44, 44, 44))
        );

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        labelAbrirCuenta.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelAbrirCuenta.setForeground(new java.awt.Color(255, 255, 255));
        labelAbrirCuenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAbrirCuenta.setText("ABRIR CUENTA BANCARIA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelAbrirCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(286, 286, 286))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(labelAbrirCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout abrirCuentaLayout = new javax.swing.GroupLayout(abrirCuenta);
        abrirCuenta.setLayout(abrirCuentaLayout);
        abrirCuentaLayout.setHorizontalGroup(
            abrirCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abrirCuentaLayout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(287, 287, 287))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        abrirCuentaLayout.setVerticalGroup(
            abrirCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abrirCuentaLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(174, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(abrirCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(abrirCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void abrirCuentaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirCuentaBtnActionPerformed

        String saldo = saldoTF.getText();

        if (!Tools.esNumerico(saldo)) {
            JOptionPane.showMessageDialog(null, "Ingresa solo numeros", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        CuentaBancaria cuenta = new CuentaBancaria(Double.parseDouble(saldo), idCliente);
        CuentaBancariaDAO db = new CuentaBancariaDAO();
        
        db.guardarCuenta(cuenta);
        numCuentaTF.setText(String.valueOf(cuenta.getNumeroCuenta()));
        JOptionPane.showMessageDialog(null, "Se ha creado la cuenta bancaria correctamente", "Operacion exitosa", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_abrirCuentaBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel abrirCuenta;
    private javax.swing.JButton abrirCuentaBtn;
    private javax.swing.JLabel idClienteLabel;
    private javax.swing.JTextField idClienteTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelAbrirCuenta;
    private javax.swing.JTextField numCuentaTF;
    private javax.swing.JTextField saldoTF;
    // End of variables declaration//GEN-END:variables
}
