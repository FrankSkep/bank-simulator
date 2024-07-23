package UI;

import Autenticacion.SesionUsuario;
import Entidades.Usuario;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public final class Dashboard extends javax.swing.JFrame {

    enum MODO {
        ADMIN, USER, NOTHING
    }

    MODO modo;

    MenuSesionPNL inicio; // Interfaz de inicio de sesion o registro

    public Dashboard() {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }

        initComponents();
        setLocationRelativeTo(null);
        setTitle("Sistema bancario");

        modo = MODO.NOTHING; // Inicialmente, no tiene ningun rol
        ocultarBotonesDeterminados(); // Muestra solo los botones necesarios para el rol nothing

        inicio = new MenuSesionPNL(this); // Instancio interfaz, pasandole referencia a la clase actual
        Tools.showPanel(inicio, contenidoPanel); // Muestro la interfaz en el panel de contenido

//        try {
//            // Prueba conexion
//            DatabaseConnection.getInstance().getConnection();
//            JOptionPane.showMessageDialog(null, "Conexion correcta");
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al conectar");
//        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jDialog1 = new javax.swing.JDialog();
        bg = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        buscarClienteBtn = new javax.swing.JButton();
        consultaBtn = new javax.swing.JButton();
        transBtn = new javax.swing.JButton();
        retirarBtn = new javax.swing.JButton();
        depositarBtn = new javax.swing.JButton();
        abrirCuentaBtn = new javax.swing.JButton();
        elimClienteBtn = new javax.swing.JButton();
        cerrarCuentaBtn = new javax.swing.JButton();
        cerrarSesionBtn = new javax.swing.JButton();
        histTransaccionesBtn = new javax.swing.JButton();
        inicio_btn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();
        aggAdminBtn = new javax.swing.JButton();
        contenidoPanel = new javax.swing.JPanel();

        jMenu1.setText("jMenu1");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenuItem1.setText("jMenuItem1");

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(51, 153, 255));
        bg.setPreferredSize(new java.awt.Dimension(1266, 670));

        menuPanel.setBackground(new java.awt.Color(51, 153, 255));
        menuPanel.setPreferredSize(new java.awt.Dimension(206, 670));

        buscarClienteBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buscarClienteBtn.setText("Buscar cliente");
        buscarClienteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarClienteBtnActionPerformed(evt);
            }
        });

        consultaBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        consultaBtn.setText("Consultar saldos");
        consultaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaBtnActionPerformed(evt);
            }
        });

        transBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        transBtn.setText("Transferir");
        transBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transBtnActionPerformed(evt);
            }
        });

        retirarBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        retirarBtn.setText("Retirar");
        retirarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retirarBtnActionPerformed(evt);
            }
        });

        depositarBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        depositarBtn.setText("Depositar");
        depositarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositarBtnActionPerformed(evt);
            }
        });

        abrirCuentaBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        abrirCuentaBtn.setText("Abrir cuenta");
        abrirCuentaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirCuentaBtnActionPerformed(evt);
            }
        });

        elimClienteBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        elimClienteBtn.setText("Eliminar cliente");
        elimClienteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elimClienteBtnActionPerformed(evt);
            }
        });

        cerrarCuentaBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cerrarCuentaBtn.setText("Cerrar cuenta");
        cerrarCuentaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarCuentaBtnActionPerformed(evt);
            }
        });

        cerrarSesionBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cerrarSesionBtn.setText("Cerrar sesion");
        cerrarSesionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesionBtnActionPerformed(evt);
            }
        });

        histTransaccionesBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        histTransaccionesBtn.setText("Ver Transacciones");
        histTransaccionesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                histTransaccionesBtnActionPerformed(evt);
            }
        });

        inicio_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inicio_btn.setText("Volver atras");
        inicio_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicio_btnActionPerformed(evt);
            }
        });

        volverBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        volverBtn.setText("Inicio");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        aggAdminBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        aggAdminBtn.setText("Agregar administrador");
        aggAdminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aggAdminBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(aggAdminBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cerrarSesionBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(consultaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(buscarClienteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(depositarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(retirarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(histTransaccionesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(transBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(abrirCuentaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(cerrarCuentaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(inicio_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(elimClienteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(volverBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(volverBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aggAdminBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(elimClienteBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarClienteBtn)
                .addGap(6, 6, 6)
                .addComponent(depositarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(retirarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(histTransaccionesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(transBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(consultaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cerrarSesionBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(abrirCuentaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(cerrarCuentaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inicio_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        contenidoPanel.setPreferredSize(new java.awt.Dimension(1060, 670));

        javax.swing.GroupLayout contenidoPanelLayout = new javax.swing.GroupLayout(contenidoPanel);
        contenidoPanel.setLayout(contenidoPanelLayout);
        contenidoPanelLayout.setHorizontalGroup(
            contenidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1052, Short.MAX_VALUE)
        );
        contenidoPanelLayout.setVerticalGroup(
            contenidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contenidoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contenidoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Muestra los botones determinados en cada caso
    void ocultarBotonesDeterminados() {

        switch (modo) {
            case ADMIN -> {
                elimClienteBtn.setVisible(true);
                buscarClienteBtn.setVisible(true);
                inicio_btn.setVisible(true);
                cerrarSesionBtn.setVisible(true);
                volverBtn.setVisible(true);
                inicio_btn.setVisible(false);
                aggAdminBtn.setVisible(true);
            }
            case USER -> {
                abrirCuentaBtn.setVisible(true);
                cerrarCuentaBtn.setVisible(true);
                depositarBtn.setVisible(true);
                retirarBtn.setVisible(true);
                consultaBtn.setVisible(true);
                transBtn.setVisible(true);
                histTransaccionesBtn.setVisible(true);
                cerrarSesionBtn.setVisible(true);
                volverBtn.setVisible(true);
                inicio_btn.setVisible(false);
            }
            case NOTHING -> {
                elimClienteBtn.setVisible(false);
                buscarClienteBtn.setVisible(false);
                abrirCuentaBtn.setVisible(false);
                cerrarCuentaBtn.setVisible(false);
                depositarBtn.setVisible(false);
                retirarBtn.setVisible(false);
                consultaBtn.setVisible(false);
                transBtn.setVisible(false);
                histTransaccionesBtn.setVisible(false);
                cerrarSesionBtn.setVisible(false);
                inicio_btn.setVisible(false);
                volverBtn.setVisible(false);
                aggAdminBtn.setVisible(false);
            }
        }
    }

    private void histTransaccionesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_histTransaccionesBtnActionPerformed
        HistorialTransaccPNL p = new HistorialTransaccPNL();
        Tools.showPanel(p, contenidoPanel);
    }//GEN-LAST:event_histTransaccionesBtnActionPerformed

    private void cerrarSesionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionBtnActionPerformed
        int cerrar = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas cerrar la sesion?", "Confirmacion", JOptionPane.YES_NO_OPTION);

        if (cerrar == JOptionPane.YES_OPTION) {
            SesionUsuario.getInstance().cerrarSesion();
            actualizarEstado();
            Tools.showPanel(inicio, contenidoPanel);
        }
    }//GEN-LAST:event_cerrarSesionBtnActionPerformed

    private void cerrarCuentaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarCuentaBtnActionPerformed
        CerrarCuentaPNL p = new CerrarCuentaPNL();
        Tools.showPanel(p, contenidoPanel);
    }//GEN-LAST:event_cerrarCuentaBtnActionPerformed

    private void elimClienteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elimClienteBtnActionPerformed
        ElimClientePNL p = new ElimClientePNL();
        Tools.showPanel(p, contenidoPanel);
    }//GEN-LAST:event_elimClienteBtnActionPerformed

    private void abrirCuentaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirCuentaBtnActionPerformed
        AbrirCuentaPanel p = new AbrirCuentaPanel();
        Tools.showPanel(p, contenidoPanel);
    }//GEN-LAST:event_abrirCuentaBtnActionPerformed

    private void depositarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositarBtnActionPerformed
        DepositarPNL p = new DepositarPNL();
        Tools.showPanel(p, contenidoPanel);
    }//GEN-LAST:event_depositarBtnActionPerformed

    private void retirarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retirarBtnActionPerformed
        RetirarPNL p = new RetirarPNL();
        Tools.showPanel(p, contenidoPanel);
    }//GEN-LAST:event_retirarBtnActionPerformed

    private void transBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transBtnActionPerformed
        TransferirPNL p = new TransferirPNL();
        Tools.showPanel(p, contenidoPanel);
    }//GEN-LAST:event_transBtnActionPerformed

    private void consultaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaBtnActionPerformed
        ConsultarSaldosPNL p = new ConsultarSaldosPNL();
        Tools.showPanel(p, contenidoPanel);
    }//GEN-LAST:event_consultaBtnActionPerformed

    private void buscarClienteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarClienteBtnActionPerformed
        BuscarClientesPNL p = new BuscarClientesPNL();
        Tools.showPanel(p, contenidoPanel);
    }//GEN-LAST:event_buscarClienteBtnActionPerformed

    private void inicio_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicio_btnActionPerformed
        Tools.showPanel(inicio, contenidoPanel);
        inicio_btn.setVisible(false);
    }//GEN-LAST:event_inicio_btnActionPerformed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        SesionIniciadaPNL p = new SesionIniciadaPNL();
        Tools.showPanel(p, contenidoPanel);
    }//GEN-LAST:event_volverBtnActionPerformed

    private void aggAdminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aggAdminBtnActionPerformed
        AgregarAdminPNL p = new AgregarAdminPNL();
        Tools.showPanel(p, contenidoPanel);
    }//GEN-LAST:event_aggAdminBtnActionPerformed

    public void setVolverInicioBtn(boolean estado) {
        inicio_btn.setVisible(estado);
    }

    public JPanel getContenidoPanel() {
        return this.contenidoPanel;
    }

    // Método para actualizar el estado del Dashboard según el usuario autenticado
    public void actualizarEstado() {
        Usuario usuario = SesionUsuario.getInstance().getUsuario();
        if (usuario != null) {
            if (usuario.getRole().equals("ADMIN")) {
                setModo(MODO.ADMIN);
            } else {
                setModo(MODO.USER);
            }
        } else {
            setModo(MODO.NOTHING);
        }
        ocultarBotonesDeterminados();
    }

    void setModo(MODO modo) {
        this.modo = modo;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrirCuentaBtn;
    private javax.swing.JButton aggAdminBtn;
    private javax.swing.JPanel bg;
    private javax.swing.JButton buscarClienteBtn;
    private javax.swing.JButton cerrarCuentaBtn;
    private javax.swing.JButton cerrarSesionBtn;
    private javax.swing.JButton consultaBtn;
    private javax.swing.JPanel contenidoPanel;
    private javax.swing.JButton depositarBtn;
    private javax.swing.JButton elimClienteBtn;
    private javax.swing.JButton histTransaccionesBtn;
    private javax.swing.JButton inicio_btn;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JButton retirarBtn;
    private javax.swing.JButton transBtn;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables
}
