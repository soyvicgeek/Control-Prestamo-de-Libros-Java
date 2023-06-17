package view;

import java.awt.Color;
import javax.swing.JOptionPane;
import business.UserControl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import libreriabasica.Usuario;

public class Login extends javax.swing.JFrame {
    
    //Crear instancia del controlador
    private final UserControl CONTROL;
    
    public Login() {
        initComponents();
        
        //Inicializar CONTROL
        CONTROL = new UserControl();
        
        this.setTitle("Iniciar Sesión | Biblioteca System");
        this.setSize(450,550);
        this.setResizable(false);
        setLocationRelativeTo(null);
        
        lblOcultar.setVisible(false);
        
        comprobarPass(); 
    }
    
    // Método para mostrar Mensajes de error
    private void messageError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Ups | Biblioteca System", JOptionPane.ERROR_MESSAGE);
    }
    
    // Método para mostrar Mensajes de OK
    private void messageOK(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Listo | Biblioteca System", JOptionPane.INFORMATION_MESSAGE);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logoLogin = new javax.swing.JLabel();
        circleAvatar1 = new view.components.CircleAvatar.CircleAvatar();
        lblVer = new javax.swing.JLabel();
        lblOcultar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        checkPass = new javax.swing.JCheckBox();
        buttonHover2 = new view.components.ButtonHover.ButtonHover();
        btnLogin = new view.components.ButtonHover.ButtonHover();
        txtUsuario = new view.components.InputIcon();
        txtPassword = new view.components.InputPasswordIcon();
        jLabel1 = new javax.swing.JLabel();
        fondoLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/login/Logo.png"))); // NOI18N
        jPanel1.add(logoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 240, 80));

        circleAvatar1.setGradientColor1(new java.awt.Color(123, 83, 11));
        circleAvatar1.setGradientColor2(new java.awt.Color(247, 169, 22));
        circleAvatar1.setImage(new javax.swing.ImageIcon(getClass().getResource("/view/img/avatar.png"))); // NOI18N
        jPanel1.add(circleAvatar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 110, 90));

        lblVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/ver_32px.png"))); // NOI18N
        lblVer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVerMouseClicked(evt);
            }
        });
        jPanel1.add(lblVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, -1, 30));

        lblOcultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/ocultar_32px.png"))); // NOI18N
        lblOcultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOcultarMouseClicked(evt);
            }
        });
        jPanel1.add(lblOcultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, -1, -1));

        jPanel2.setBackground(new java.awt.Color(249, 196, 97));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 83, 11)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, 30, 50));

        checkPass.setBackground(new java.awt.Color(247, 169, 22));
        checkPass.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        checkPass.setForeground(new java.awt.Color(255, 255, 255));
        checkPass.setText("Recordar contraseña");
        jPanel1.add(checkPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, -1, -1));

        buttonHover2.setText("Crear una cuenta");
        jPanel1.add(buttonHover2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, 140, -1));

        btnLogin.setText("Iniciar sesión");
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
        });
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, -1, 50));

        txtUsuario.setBackground(new java.awt.Color(249, 196, 97));
        txtUsuario.setForeground(new java.awt.Color(157, 128, 74));
        txtUsuario.setText("Usuario");
        txtUsuario.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        txtUsuario.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/user.png"))); // NOI18N
        txtUsuario.setSelectionColor(new java.awt.Color(120, 94, 47));
        txtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUsuarioMouseClicked(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 300, 50));

        txtPassword.setBackground(new java.awt.Color(249, 196, 97));
        txtPassword.setForeground(new java.awt.Color(157, 128, 74));
        txtPassword.setText("Contrasena");
        txtPassword.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/key.png"))); // NOI18N
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPasswordMouseClicked(evt);
            }
        });
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 270, 50));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(120, 94, 47));
        jLabel1.setText("Bienvenidos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 110, -1));

        fondoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/login/triangle01.png"))); // NOI18N
        fondoLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fondoLoginMouseClicked(evt);
            }
        });
        jPanel1.add(fondoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fondoLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fondoLoginMouseClicked
        if (txtUsuario.getText().isEmpty()) {
            txtUsuario.setText("Usuario");
            txtUsuario.setForeground(new Color(157,128,74));
        }
        
        if(String.valueOf(txtPassword.getPassword()).equals("")){
            txtPassword.setText("Contrasena");
            txtPassword.setForeground(new Color(157,128,74));
        }
    }//GEN-LAST:event_fondoLoginMouseClicked

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked

    }//GEN-LAST:event_btnLoginMouseClicked

    private void comprobarPass() {
        String ruta = "password.txt";
        File file = new File(ruta);
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            //Comprobar que el archvio exista
            if (file.exists()){
                
                checkPass.setSelected(true);              
                fr = new FileReader (ruta);
                br = new BufferedReader(fr);

                // Lectura del fichero
                String linea;
                while((linea=br.readLine())!=null){
                    txtPassword.setText(linea);
                }
                
                br.close();               
            }
            
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String resp;
        String User = txtUsuario.getText();
        String Pass = String.valueOf(txtPassword.getPassword());
        Usuario objPass = new Usuario(Pass);
        
        String validate = objPass.ValidarUsuarioString();
        
        if (User.equals("") || Pass.equals("")) {
            messageError("Uno o más campos están vacíos, por favor de llenarlos.");
        } else {
            
            if (validate.equals("Validación Correcta")){
                resp = CONTROL.login(User, Pass);
            
                if (resp.equals("OK")){
                    
                    try {
                        //Guardar contraseña si esta seleccionado
                        String ruta = "password.txt";
                        File file = new File(ruta);
                        
                        if (checkPass.isSelected()) {                                                  
                            // Si el archivo no existe es creado
                            if (!file.exists()) {
                                file.createNewFile();
                            }
                            FileWriter fw = new FileWriter(file);
                            BufferedWriter bw = new BufferedWriter(fw);
                            bw.write(Pass);
                            bw.close();                 
                        } else {                      
                            if (file.exists() && file.isFile()) {
                                file.delete();                             
                                /*if (file.delete()) {
                                    System.out.println("Archivo eliminado exitosamente.");
                                } else {
                                    System.out.println("No se pudo eliminar el archivo.");
                                }*/               
                            }  else {
                                System.out.println("El archivo no existe o no es un archivo de texto.");
                            }                     
                        }             

                        FrmPrincipal frmPrincipal = new FrmPrincipal();
                        frmPrincipal.setVisible(true);
                        dispose();
                    
                    } catch (IOException ex) {
                        System.out.println("Error: " + ex);
                    }                   

                } else {
                    messageError(resp);
                }
            
            } else {
                messageError(validate);
            }
        
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMouseClicked
        if (txtUsuario.getText().equals("Usuario")) {
            txtUsuario.setText("");
            txtUsuario.setForeground(new Color(120,94,47));
        }

        if(String.valueOf(txtPassword.getPassword()).equals("")){
            txtPassword.setText("Contrasena");
            txtPassword.setForeground(new Color(157,128,74));
        }
    }//GEN-LAST:event_txtUsuarioMouseClicked

    private void txtPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMouseClicked
        if (String.valueOf(txtPassword.getPassword()).equals("Contrasena")){
            txtPassword.setText("");
            txtPassword.setForeground(new Color(120,94,47));
        }
        
        if(txtUsuario.getText().isEmpty()){
            txtUsuario.setText("Usuario");
            txtUsuario.setForeground(new Color(157,128,74));
        }
    }//GEN-LAST:event_txtPasswordMouseClicked

    private void lblOcultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOcultarMouseClicked
        lblVer.setVisible(true);
        lblOcultar.setVisible(false);
        txtPassword.setEchoChar('●');
    }//GEN-LAST:event_lblOcultarMouseClicked

    private void lblVerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVerMouseClicked
        lblVer.setVisible(false);
        lblOcultar.setVisible(true);
        txtPassword.setEchoChar((char)0);
    }//GEN-LAST:event_lblVerMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.components.ButtonHover.ButtonHover btnLogin;
    private view.components.ButtonHover.ButtonHover buttonHover2;
    private javax.swing.JCheckBox checkPass;
    private view.components.CircleAvatar.CircleAvatar circleAvatar1;
    private javax.swing.JLabel fondoLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblOcultar;
    private javax.swing.JLabel lblVer;
    private javax.swing.JLabel logoLogin;
    private view.components.InputPasswordIcon txtPassword;
    private view.components.InputIcon txtUsuario;
    // End of variables declaration//GEN-END:variables
}
