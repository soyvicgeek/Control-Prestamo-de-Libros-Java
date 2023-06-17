package view;

import business.CategoriesControl;
import entities.Categories;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.UUID;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import view.utils.CategoriasImgTable;
import view.utils.Validates;

public class FrmCategorias extends javax.swing.JFrame {
    
    private final CategoriesControl CONTROL;
    private File archivoImagenLibro;
    private String nombreLibroAnt;
    private Categories categoriaSeleccionada;
    private String imgAnt;
    private Path imgTemp;
    private String imgChange = null;
    private String imgActual;

    public FrmCategorias() {
        initComponents();
        
        //Inicializar el CONTROL
        CONTROL = new CategoriesControl();
        listar("");
        
        this.setTitle("Categorías Libros | Biblioteca System");
        this.setSize(1003,500);
        this.setResizable(false);
        setLocationRelativeTo(null);
        
        //Ocultar variables
        txtId.setVisible(false);
        txtImg.setVisible(false);
    }
    
    private void listar(String texto) {
        //Llenar el modelo del JTable de nombre tabla Listado
        tablaCategorias.setModel(CONTROL.listar(texto));
        tablaCategorias.setRowHeight(60);
        tablaCategorias.getColumnModel().getColumn(3).setCellRenderer(new CategoriasImgTable());
        
        dibujarPortadaCategoria("src/view/img/libros/categoria-default.jpg");
        
        //Total de registros
        String total = Integer.toString(CONTROL.total());
        lblRegistros.setText("Registros mostrados: " + CONTROL.totalMostrados() + " de un total de " + total);
    }
    
    private void limpiar() {
        txtCategoria.setText("Buscar Categoría");
        txtCategoria.setFont(new Font("Roboto", Font.PLAIN,14));
        txtNombreCategoria.setText("Nombre del Libro");
        txtNombreCategoria.setFont(new Font("Roboto", Font.PLAIN,14));
        txtDescripCategoria.setText("Autor del Libro");
        txtDescripCategoria.setFont(new Font("Roboto", Font.PLAIN,14));
        dibujarPortadaCategoria("src/view/img/libros/categoria-default.jpg");
        btnGuardar.setText("Guardar"); 
        listar("");
    }
    
    private void dibujarPortadaCategoria(String ruta) {
        ImageIcon imagen = new ImageIcon(ruta);
        //Convertir la imagen a un icono
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblImgCategoria.getWidth(), lblImgCategoria.getHeight(), Image.SCALE_SMOOTH));
        lblImgCategoria.setIcon(icono);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrinc = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtNombreCategoria = new view.components.InputIcon();
        txtDescripCategoria = new view.components.InputIcon();
        lblImgCategoria = new javax.swing.JLabel();
        btnCargarImg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCategorias = new javax.swing.JTable();
        btnGuardar = new view.components.ButtonHover.ButtonHover();
        btnActDesc = new view.components.ButtonHover.ButtonHover();
        btnEditar = new view.components.ButtonHover.ButtonHover();
        lblHome = new javax.swing.JLabel();
        lblLimpiar = new javax.swing.JLabel();
        txtId = new javax.swing.JLabel();
        txtImg = new javax.swing.JLabel();
        lblRegistros = new javax.swing.JLabel();
        txtCategoria = new view.components.InputIcon();
        btnBuscar = new view.components.ButtonHover.ButtonHover();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrinc.setBackground(new java.awt.Color(255, 255, 255));
        panelPrinc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombreCategoria.setForeground(new java.awt.Color(120, 94, 47));
        txtNombreCategoria.setText("Nombre Categoría");
        txtNombreCategoria.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtNombreCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombreCategoriaMouseClicked(evt);
            }
        });
        jPanel1.add(txtNombreCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 202, 29));

        txtDescripCategoria.setForeground(new java.awt.Color(120, 94, 47));
        txtDescripCategoria.setText("Descripción Categoría");
        txtDescripCategoria.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtDescripCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDescripCategoriaMouseClicked(evt);
            }
        });
        jPanel1.add(txtDescripCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 202, 31));
        jPanel1.add(lblImgCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 120, 120));

        btnCargarImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/addImg.png"))); // NOI18N
        btnCargarImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCargarImgMouseClicked(evt);
            }
        });
        jPanel1.add(btnCargarImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, 40));

        panelPrinc.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 50, 220, 330));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(120, 94, 47));
        jLabel1.setText("Administración de Ccategorías");
        panelPrinc.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

        tablaCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaCategorias);

        panelPrinc.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 750, 280));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panelPrinc.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 390, 120, 40));

        btnActDesc.setText("Activar / Desactivar");
        btnActDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActDescActionPerformed(evt);
            }
        });
        panelPrinc.add(btnActDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, 160, 40));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        panelPrinc.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, 120, 40));

        lblHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/home.png"))); // NOI18N
        lblHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeMouseClicked(evt);
            }
        });
        panelPrinc.add(lblHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/limpiar.png"))); // NOI18N
        lblLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLimpiarMouseClicked(evt);
            }
        });
        panelPrinc.add(lblLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 390, 40, 40));
        panelPrinc.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 24, 30, 20));
        panelPrinc.add(txtImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 40, 20));

        lblRegistros.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblRegistros.setForeground(new java.awt.Color(123, 83, 11));
        panelPrinc.add(lblRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 410, 30));

        txtCategoria.setForeground(new java.awt.Color(120, 94, 47));
        txtCategoria.setText("Buscar Categoría");
        txtCategoria.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCategoriaMouseClicked(evt);
            }
        });
        panelPrinc.add(txtCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 640, 30));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        panelPrinc.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, 100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrinc, javax.swing.GroupLayout.DEFAULT_SIZE, 1003, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrinc, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseClicked
        FrmPrincipal home = new FrmPrincipal();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblHomeMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tablaCategorias.getSelectedRowCount() == 1) {
            
            String id = String.valueOf(tablaCategorias.getValueAt(tablaCategorias.getSelectedRow(), 0));
            String nombreLibro = String.valueOf(tablaCategorias.getValueAt(tablaCategorias.getSelectedRow(), 1));
            nombreLibroAnt = String.valueOf(tablaCategorias.getValueAt(tablaCategorias.getSelectedRow(), 1));
            String autorLibro = String.valueOf(tablaCategorias.getValueAt(tablaCategorias.getSelectedRow(), 2));
            String editorialLibro = String.valueOf(tablaCategorias.getValueAt(tablaCategorias.getSelectedRow(), 3));
            String anioLibro = String.valueOf(tablaCategorias.getValueAt(tablaCategorias.getSelectedRow(), 4));
            String pagesLibro = String.valueOf(tablaCategorias.getValueAt(tablaCategorias.getSelectedRow(), 5));
            String img = String.valueOf(tablaCategorias.getValueAt(tablaCategorias.getSelectedRow(), 6));
            imgAnt = String.valueOf(tablaCategorias.getValueAt(tablaCategorias.getSelectedRow(), 6));
            String disponible = String.valueOf(tablaCategorias.getValueAt(tablaCategorias.getSelectedRow(), 8));
            String categoriaID = String.valueOf(tablaCategorias.getValueAt(tablaCategorias.getSelectedRow(), 9));
            String nombreCategoria = String.valueOf(tablaCategorias.getValueAt(tablaCategorias.getSelectedRow(), 10));
            
            if (img.equals("")){
                imgActual = "categoria-default.jpg";
            } else {
                imgActual = img;
            }          
            
            txtId.setText(id);
            txtNombreCategoria.setText(nombreLibro);
            txtDescripCategoria.setText(autorLibro);
            dibujarPortadaCategoria("src/view/img/libros/" + imgActual);
            
            
            btnGuardar.setText("Actualizar");
            
        } else {
            mensajeError("Dedes seleccionar un libro");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void lblLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLimpiarMouseClicked
        limpiar();
        listar("");
    }//GEN-LAST:event_lblLimpiarMouseClicked

    private void txtNombreCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreCategoriaMouseClicked
        if (txtNombreCategoria.getText().equals("Nombre del Libro")) {
            txtNombreCategoria.setText("");
            txtNombreCategoria.setForeground(new Color(120,94,47));
            txtNombreCategoria.setFont(new Font("Roboto", Font.BOLD,14));
        }
        
        if (txtDescripCategoria.getText().isEmpty()) {
            txtDescripCategoria.setText("Autor del Libro");
            txtDescripCategoria.setForeground(new Color(120,94,47));
            txtDescripCategoria.setFont(new Font("Roboto", Font.PLAIN,14));
        }
    }//GEN-LAST:event_txtNombreCategoriaMouseClicked

    private void txtDescripCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDescripCategoriaMouseClicked
        if (txtDescripCategoria.getText().equals("Autor del Libro")) {
            txtDescripCategoria.setText("");
            txtDescripCategoria.setForeground(new Color(120,94,47));
            txtDescripCategoria.setFont(new Font("Roboto", Font.BOLD,14));
        }
        if (txtNombreCategoria.getText().isEmpty()) {
            txtNombreCategoria.setText("Nombre del Libro");
            txtNombreCategoria.setForeground(new Color(120,94,47));
            txtNombreCategoria.setFont(new Font("Roboto", Font.PLAIN,14));
        }
        
    }//GEN-LAST:event_txtDescripCategoriaMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        if (btnGuardar.getText().equals("Guardar")) {
            insertBook();
        } else {
            updateBook();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCargarImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCargarImgMouseClicked
        //Crear un componente JFileChoose sirve para abrir archivos o carpetas
        JFileChooser file = new JFileChooser();
        
        // Crear el filtro para las imagenes
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG and PNG images", "jpg", "jpeg", "png");
        file.setFileFilter(filter);
        
        //Abrir la ventana de dialogo
        int opcion = file.showOpenDialog(this);
        //Verificar que el usuario presiono el botón aceptar
        if (opcion == JFileChooser.APPROVE_OPTION) {
            
            // Saber extensión de la imagen
            String fileName = file.getSelectedFile().getName();
            String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
            
            // Validar que sea una imagen
            if (extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png")) {
                archivoImagenLibro = file.getSelectedFile();
            
                String orig = archivoImagenLibro.getPath();
                imgTemp = Paths.get(orig);
                imgChange = archivoImagenLibro.getName();

                //Dibujar la imagen de la categoría
                dibujarPortadaCategoria(archivoImagenLibro.getAbsolutePath());
            } else {
                mensajeError("El archivo que selecciono no es una imagen.");
                dibujarPortadaCategoria("src/view/img/libros/categoria-default.jpg");
            }  
        }
    }//GEN-LAST:event_btnCargarImgMouseClicked

    private void btnActDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActDescActionPerformed
        if (tablaCategorias.getSelectedRowCount() == 1) {
            
            String id = String.valueOf(tablaCategorias.getValueAt(tablaCategorias.getSelectedRow(), 0));
            String nombreLibro = String.valueOf(tablaCategorias.getValueAt(tablaCategorias.getSelectedRow(), 1));
            
            String estado = String.valueOf(tablaCategorias.getValueAt(tablaCategorias.getSelectedRow(), 7));
            if (estado.equals("Activo")){
                
                if (JOptionPane.showConfirmDialog(this, "Desea desactivar el libro: "+nombreLibro, "Desactivar", JOptionPane.YES_NO_OPTION) == 0){
                    String resp = CONTROL.desactivar(Integer.parseInt(id));

                    if (resp.equals("OK")){
                        mensajeOK(nombreLibro + " Desactivado");
                        listar("");
                        limpiar();
                    } else {
                        mensajeError(resp);
                    }
                }
                
            } else {
                
                if (JOptionPane.showConfirmDialog(this, "Desea Activar el libro: "+nombreLibro, "Activar", JOptionPane.YES_NO_OPTION) == 0){
                    String resp = CONTROL.activar(Integer.parseInt(id));

                    if (resp.equals("OK")){
                        mensajeOK(nombreLibro + " Activado");
                        listar("");
                        limpiar();
                    } else {
                        mensajeError(resp);
                    }
                }
            
            }    
        } else {
            mensajeError("Debes seleccionar el registro a activar o desactivar");
        }
    }//GEN-LAST:event_btnActDescActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtCategoria.getText().equals("Ingrese libro a buscar") || txtCategoria.getText().equals("")) {
            mensajeError("Ingresar un termino de búsqueda");
        } else {
            listar(txtCategoria.getText());
        } 
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCategoriaMouseClicked
        if (txtCategoria.getText().equals("Buscar Categoría")) {
            txtCategoria.setText("");
            txtCategoria.setForeground(new Color(120,94,47));
            txtCategoria.setFont(new Font("Roboto", Font.BOLD,14));
        }
    }//GEN-LAST:event_txtCategoriaMouseClicked
    
    private void insertBook() {
        String resp;
        String img = "categoria-default.jpg";
        
        Validates vNomLib = new Validates(txtNombreCategoria, "Nombre del Libro", false);
        Validates vAutorLib = new Validates(txtDescripCategoria, "Autor del Libro", false);
        
        if (vNomLib.validateInput().equals("OK") &&
            vAutorLib.validateInput().equals("OK") ) {
            
            if (imgChange != null){
                
                //Generar UUID Ramdom
                String uuid = UUID.randomUUID().toString();
                String result = uuid.replaceAll("-", "");
                String substrato = result.substring(0, 20);
                
                //Saber el formato
                int indicePunto = imgChange.lastIndexOf(".");
                String formato = imgChange.substring(indicePunto + 1);
                
                //Imagen Nueva
                img = substrato + "." + formato;
                
                try{
                    String dest = System.getProperty("user.dir") + "/src/view/img/libros/" + img;
                    Path destino = Paths.get(dest);

                    Files.copy(imgTemp, destino, REPLACE_EXISTING);
                } catch (IOException ex) {
                    System.out.println("Error" + ex);
                }
            }

            //Vamos a colocar aquí el código
            /*resp = CONTROL.insertar(
                    txtNombreLibro.getText(),
                    txtAutorLibro.getText(),
                    img
                );*/

            /*if(resp.equals("OK")){
                mensajeOK("Registro insertado correctamente");
                limpiar();
                listar("");
            } else {
                mensajeError(resp);
            } */     
        
        } else {
            
            if(vNomLib.validateInput() != "OK" ) {
                mensajeError(vNomLib.validateInput());
            }
            if(vAutorLib.validateInput() != "OK" ) {
                mensajeError(vAutorLib.validateInput());
            }
        }
    }
    
    private void updateBook() {
        String resp;
        
        Validates vNomLib = new Validates(txtNombreCategoria, "Nombre del Libro", false);
        Validates vAutorLib = new Validates(txtDescripCategoria, "Autor del Libro", false);
        
        if (vNomLib.validateInput().equals("OK") &&
            vAutorLib.validateInput().equals("OK") ){
            
            if (imgChange != null){
                
                //Generar UUID Ramdom
                String uuid = UUID.randomUUID().toString();
                String result = uuid.replaceAll("-", "");
                String substrato = result.substring(0, 20);
                
                //Saber el formato
                int indicePunto = imgChange.lastIndexOf(".");
                String formato = imgChange.substring(indicePunto + 1);             
                //Imagen Nueva
                String img = substrato + "." + formato;             
                
                // Guardar la imagen en ruta
                try{
                    String dest = System.getProperty("user.dir") + "/src/view/img/libros/" + img;
                    Path destino = Paths.get(dest);
                    Files.copy(imgTemp, destino, REPLACE_EXISTING);
                } catch (IOException ex) {
                    System.out.println("Error" + ex);
                }
                
                if (!imgAnt.equals("categoria-default.jpg")) {
                    // Ruta al archivo de imagen a eliminar
                    String imagePath = System.getProperty("user.dir") + "/src/view/img/libros/" + imgAnt;

                    // Crear un objeto File con la ruta al archivo de imagen
                    File imageFile = new File(imagePath);   
                    if (imageFile.exists()) {
                        // Eliminar el archivo
                        imageFile.delete();
                    } else {
                        mensajeError("La imagen no existe.");
                    }            
                }               
                
                /*resp = CONTROL.actualizar(
                    Integer.parseInt(txtId.getText()),
                    txtNombreLibro.getText(),
                    nombreLibroAnt,
                    txtAutorLibro.getText(),
                    img
                );*/
                
                imgChange = null;
                
                /*if(resp.equals("OK")){
                    mensajeOK("Registro actualizado correctamente");
                    limpiar();
                    listar("");
                } else {
                    mensajeError(resp);
                }*/
            
            } else {
                /*resp = CONTROL.actualizar(
                    Integer.parseInt(txtId.getText()),
                    txtNombreLibro.getText(),
                    nombreLibroAnt,
                    txtAutorLibro.getText(),
                    imgActual,
                );
                
                if(resp.equals("OK")){
                    mensajeOK("Registro actualizado correctamente");
                    limpiar();
                    listar("");
                } else {
                    mensajeError(resp);
                }*/
            
            }
            
        } else {
            if(vNomLib.validateInput() != "OK" ) {
                mensajeError(vNomLib.validateInput());
            }
            if(vAutorLib.validateInput() != "OK" ) {
                mensajeError(vAutorLib.validateInput());
            }
        }
    }
    
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
                new FrmCategorias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.components.ButtonHover.ButtonHover btnActDesc;
    private view.components.ButtonHover.ButtonHover btnBuscar;
    private javax.swing.JLabel btnCargarImg;
    private view.components.ButtonHover.ButtonHover btnEditar;
    private view.components.ButtonHover.ButtonHover btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblImgCategoria;
    private javax.swing.JLabel lblLimpiar;
    private javax.swing.JLabel lblRegistros;
    private javax.swing.JPanel panelPrinc;
    private javax.swing.JTable tablaCategorias;
    private view.components.InputIcon txtCategoria;
    private view.components.InputIcon txtDescripCategoria;
    private javax.swing.JLabel txtId;
    private javax.swing.JLabel txtImg;
    private view.components.InputIcon txtNombreCategoria;
    // End of variables declaration//GEN-END:variables
}
