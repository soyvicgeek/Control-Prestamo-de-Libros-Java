package view;

import javax.swing.JOptionPane;

public class FrmPrincipal extends javax.swing.JFrame {

    public FrmPrincipal() {
        initComponents();
        
        this.setTitle("Bienvenido | Biblioteca System");
        this.setSize(700,400);
        this.setResizable(false);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblLibros = new javax.swing.JLabel();
        lblUsuarios = new javax.swing.JLabel();
        lblPrestamos = new javax.swing.JLabel();
        lblPerfil = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        btnCategorias = new javax.swing.JButton();
        btnBooks = new javax.swing.JButton();
        btnUsers = new javax.swing.JButton();
        btnPrestamos = new javax.swing.JButton();
        btnX = new javax.swing.JButton();
        lblTriangle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(255, 255, 255));
        escritorio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/login/Logo.png"))); // NOI18N
        escritorio.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 240, 90));

        lblLibros.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblLibros.setForeground(new java.awt.Color(120, 94, 47));
        lblLibros.setText("Libros");
        escritorio.add(lblLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, -1, -1));

        lblUsuarios.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblUsuarios.setForeground(new java.awt.Color(120, 94, 47));
        lblUsuarios.setText("Categorías");
        escritorio.add(lblUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, -1, -1));

        lblPrestamos.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblPrestamos.setForeground(new java.awt.Color(120, 94, 47));
        lblPrestamos.setText("Préstamos");
        escritorio.add(lblPrestamos, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, -1, -1));

        lblPerfil.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblPerfil.setForeground(new java.awt.Color(120, 94, 47));
        lblPerfil.setText("Usuarios");
        escritorio.add(lblPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, -1, -1));

        lblCerrar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblCerrar.setForeground(new java.awt.Color(120, 94, 47));
        lblCerrar.setText("Cerrar Sesión");
        escritorio.add(lblCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, -1, -1));

        btnCategorias.setBackground(new java.awt.Color(247, 169, 22));
        btnCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/categories.png"))); // NOI18N
        btnCategorias.setBorder(null);
        btnCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriasActionPerformed(evt);
            }
        });
        escritorio.add(btnCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 100, 100));

        btnBooks.setBackground(new java.awt.Color(247, 169, 22));
        btnBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/book.png"))); // NOI18N
        btnBooks.setBorder(null);
        btnBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBooksActionPerformed(evt);
            }
        });
        escritorio.add(btnBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 100, 100));

        btnUsers.setBackground(new java.awt.Color(247, 169, 22));
        btnUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/grupo.png"))); // NOI18N
        btnUsers.setBorder(null);
        btnUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsersActionPerformed(evt);
            }
        });
        escritorio.add(btnUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 100, 100));

        btnPrestamos.setBackground(new java.awt.Color(247, 169, 22));
        btnPrestamos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/prestamo.png"))); // NOI18N
        btnPrestamos.setBorder(null);
        btnPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestamosActionPerformed(evt);
            }
        });
        escritorio.add(btnPrestamos, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 100, 100));

        btnX.setBackground(new java.awt.Color(255, 255, 255));
        btnX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/btnX.png"))); // NOI18N
        btnX.setBorder(null);
        btnX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXActionPerformed(evt);
            }
        });
        escritorio.add(btnX, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 80, 60));

        lblTriangle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/triangle02.png"))); // NOI18N
        escritorio.add(lblTriangle, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 70, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, 389, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXActionPerformed
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnXActionPerformed

    private void btnBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBooksActionPerformed
        
        dispose();
        FrmLibros frmBooks = new FrmLibros();
        frmBooks.setVisible(true);
        
        /*FrmPrincipal frmPrinc = new FrmPrincipal();
        frmPrinc.setVisible(false);*/
    }//GEN-LAST:event_btnBooksActionPerformed

    private void btnCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriasActionPerformed
        mensajeError("Esta sección aún no está habilitada.");
    }//GEN-LAST:event_btnCategoriasActionPerformed

    private void btnPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestamosActionPerformed
        
        dispose();
        FrmPrestamos frmPrestamos = new FrmPrestamos();
        frmPrestamos.setVisible(true);
    }//GEN-LAST:event_btnPrestamosActionPerformed

    private void btnUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsersActionPerformed
        mensajeError("Esta sección aún no está habilitada.");
    }//GEN-LAST:event_btnUsersActionPerformed

    // Método para mostrar Mensajes de error
    private void mensajeError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Bilbioteca System", JOptionPane.ERROR_MESSAGE);
    }
    
    // Método para mostrar Mensajes de OK
    private void mensajeOK(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Bilbioteca System", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBooks;
    private javax.swing.JButton btnCategorias;
    private javax.swing.JButton btnPrestamos;
    private javax.swing.JButton btnUsers;
    private javax.swing.JButton btnX;
    private javax.swing.JPanel escritorio;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblLibros;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JLabel lblPrestamos;
    private javax.swing.JLabel lblTriangle;
    private javax.swing.JLabel lblUsuarios;
    // End of variables declaration//GEN-END:variables
}
