package view;

import business.BookControl;
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
import view.utils.LibrosImgTable;
import view.utils.Validates;

public class FrmLibros extends javax.swing.JFrame {
    
    private final BookControl CONTROL;
    private File archivoImagenLibro;
    private String nombreLibroAnt;
    private Categories categoriaSeleccionada;
    private String imgAnt;
    private Path imgTemp;
    private String imgChange = null;
    private String imgActual;

    public FrmLibros() {
        initComponents();
        
        //Inicializar el CONTROL
        CONTROL = new BookControl();
        listar("");
        
        this.setTitle("Listado de libros | Biblioteca System");
        this.setSize(1003,500);
        this.setResizable(false);
        setLocationRelativeTo(null);
        
        //Ocultar variables
        txtId.setVisible(false);
        txtImg.setVisible(false);
        cargarCategorias();
    }
    
    private void listar(String texto) {
        //Llenar el modelo del JTable de nombre tabla Listado
        tablaLibros.setModel(CONTROL.listar(texto));
        tablaLibros.setRowHeight(60);
        tablaLibros.getColumnModel().getColumn(6).setCellRenderer(new LibrosImgTable());
        
        //Asignar tamaño a columnas
        tablaLibros.getColumnModel().getColumn(0).setPreferredWidth(30);
        tablaLibros.getColumnModel().getColumn(4).setPreferredWidth(30);
        tablaLibros.getColumnModel().getColumn(5).setPreferredWidth(30);
        tablaLibros.getColumnModel().getColumn(6).setPreferredWidth(60);
        tablaLibros.getColumnModel().getColumn(7).setPreferredWidth(55);
        
        tablaLibros.getColumnModel().getColumn(9).setMaxWidth(0);
        tablaLibros.getColumnModel().getColumn(9).setMinWidth(0);
        tablaLibros.getColumnModel().getColumn(9).setPreferredWidth(0);
        
        dibujarPortadaLibro("src/view/img/libros/libro-default.jpg");
        
        //Total de registros
        String total = Integer.toString(CONTROL.total());
        lblRegistros.setText("Registros mostrados: " + CONTROL.totalMostrados() + " de un total de " + total);
    }
    
    private void limpiar() {
        txtLibro.setText("Ingrese libro a buscar");
        txtLibro.setFont(new Font("Roboto", Font.PLAIN,14));
        txtNombreLibro.setText("Nombre del Libro");
        txtNombreLibro.setFont(new Font("Roboto", Font.PLAIN,14));
        txtAutorLibro.setText("Autor del Libro");
        txtAutorLibro.setFont(new Font("Roboto", Font.PLAIN,14));
        txtEditorialLibro.setText("Editorial del Libro");
        txtEditorialLibro.setFont(new Font("Roboto", Font.PLAIN,14));
        txtAnioLibro.setText("Año");
        txtAnioLibro.setFont(new Font("Roboto", Font.PLAIN,14));
        txtPaginasLibro.setText("Paginas");
        txtPaginasLibro.setFont(new Font("Roboto", Font.PLAIN,14));
        disponibleBox.setSelectedIndex(0);
        cmbCategoria.setSelectedIndex(0);
        dibujarPortadaLibro("src/view/img/libros/libro-default.jpg");
        btnGuardar.setText("Guardar"); 
        listar("");
    }
    
    private void dibujarPortadaLibro(String ruta) {
        ImageIcon imagen = new ImageIcon(ruta);
        //Convertir la imagen a un icono
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblImgLibro.getWidth(), lblImgLibro.getHeight(), Image.SCALE_SMOOTH));
        lblImgLibro.setIcon(icono);
    }
    
    private void cargarCategorias() {
        DefaultComboBoxModel modeloCategorias = CONTROL.seleccionarCategorias();
        cmbCategoria.setModel(modeloCategorias);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrinc = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtNombreLibro = new view.components.InputIcon();
        txtAutorLibro = new view.components.InputIcon();
        txtEditorialLibro = new view.components.InputIcon();
        txtAnioLibro = new view.components.InputIcon();
        txtPaginasLibro = new view.components.InputIcon();
        cmbCategoria = new javax.swing.JComboBox();
        disponibleBox = new javax.swing.JComboBox();
        lblImgLibro = new javax.swing.JLabel();
        btnCargarImg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLibros = new javax.swing.JTable();
        btnGuardar = new view.components.ButtonHover.ButtonHover();
        btnActDesc = new view.components.ButtonHover.ButtonHover();
        btnEditar = new view.components.ButtonHover.ButtonHover();
        lblHome = new javax.swing.JLabel();
        lblLimpiar = new javax.swing.JLabel();
        txtId = new javax.swing.JLabel();
        txtImg = new javax.swing.JLabel();
        lblRegistros = new javax.swing.JLabel();
        txtLibro = new view.components.InputIcon();
        btnBuscar = new view.components.ButtonHover.ButtonHover();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrinc.setBackground(new java.awt.Color(255, 255, 255));
        panelPrinc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombreLibro.setForeground(new java.awt.Color(120, 94, 47));
        txtNombreLibro.setText("Nombre del Libro");
        txtNombreLibro.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtNombreLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombreLibroMouseClicked(evt);
            }
        });
        jPanel1.add(txtNombreLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 108, 202, 29));

        txtAutorLibro.setForeground(new java.awt.Color(120, 94, 47));
        txtAutorLibro.setText("Autor del Libro");
        txtAutorLibro.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtAutorLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAutorLibroMouseClicked(evt);
            }
        });
        jPanel1.add(txtAutorLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 143, 202, 31));

        txtEditorialLibro.setForeground(new java.awt.Color(120, 94, 47));
        txtEditorialLibro.setText("Editorial del Libro");
        txtEditorialLibro.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtEditorialLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEditorialLibroMouseClicked(evt);
            }
        });
        jPanel1.add(txtEditorialLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 202, 30));

        txtAnioLibro.setForeground(new java.awt.Color(120, 94, 47));
        txtAnioLibro.setText("Año");
        txtAnioLibro.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtAnioLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAnioLibroMouseClicked(evt);
            }
        });
        jPanel1.add(txtAnioLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 216, 98, 30));

        txtPaginasLibro.setForeground(new java.awt.Color(120, 94, 47));
        txtPaginasLibro.setText("Paginas");
        txtPaginasLibro.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtPaginasLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPaginasLibroMouseClicked(evt);
            }
        });
        jPanel1.add(txtPaginasLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 216, 100, 30));

        cmbCategoria.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jPanel1.add(cmbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 202, 34));

        disponibleBox.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        disponibleBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Disponible", "Disponible" }));
        disponibleBox.setToolTipText("");
        jPanel1.add(disponibleBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 202, 33));
        jPanel1.add(lblImgLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 11, 99, 91));

        btnCargarImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/addImg.png"))); // NOI18N
        btnCargarImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCargarImgMouseClicked(evt);
            }
        });
        jPanel1.add(btnCargarImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, 40));

        panelPrinc.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 50, 220, 330));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(120, 94, 47));
        jLabel1.setText("Administración de Libros");
        panelPrinc.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

        tablaLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaLibros);

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

        txtLibro.setForeground(new java.awt.Color(120, 94, 47));
        txtLibro.setText("Ingrese libro a buscar");
        txtLibro.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtLibroMouseClicked(evt);
            }
        });
        panelPrinc.add(txtLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 640, 30));

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
        if (tablaLibros.getSelectedRowCount() == 1) {
            
            String id = String.valueOf(tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 0));
            String nombreLibro = String.valueOf(tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 1));
            nombreLibroAnt = String.valueOf(tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 1));
            String autorLibro = String.valueOf(tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 2));
            String editorialLibro = String.valueOf(tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 3));
            String anioLibro = String.valueOf(tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 4));
            String pagesLibro = String.valueOf(tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 5));
            String img = String.valueOf(tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 6));
            imgAnt = String.valueOf(tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 6));
            String disponible = String.valueOf(tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 8));
            String categoriaID = String.valueOf(tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 9));
            String nombreCategoria = String.valueOf(tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 10));
            
            if (img.equals("")){
                imgActual = "libro-default.jpg";
            } else {
                imgActual = img;
            }          
            
            txtId.setText(id);
            txtNombreLibro.setText(nombreLibro);
            txtAutorLibro.setText(autorLibro);
            txtEditorialLibro.setText(editorialLibro);
            txtAnioLibro.setText(anioLibro);
            txtPaginasLibro.setText(pagesLibro);
            dibujarPortadaLibro("src/view/img/libros/" + imgActual);
            disponibleBox.setSelectedItem(disponible);
            
            //Mostrar las categorias y subcategorias en los combos
            categoriaSeleccionada = new Categories(Integer.parseInt(categoriaID),nombreCategoria);
            cmbCategoria.setSelectedItem(categoriaSeleccionada);
            
            btnGuardar.setText("Actualizar");
            
        } else {
            mensajeError("Dedes seleccionar un libro");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void lblLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLimpiarMouseClicked
        limpiar();
        listar("");
    }//GEN-LAST:event_lblLimpiarMouseClicked

    private void txtNombreLibroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreLibroMouseClicked
        if (txtNombreLibro.getText().equals("Nombre del Libro")) {
            txtNombreLibro.setText("");
            txtNombreLibro.setForeground(new Color(120,94,47));
            txtNombreLibro.setFont(new Font("Roboto", Font.BOLD,14));
        }
        
        if (txtAutorLibro.getText().isEmpty()) {
            txtAutorLibro.setText("Autor del Libro");
            txtAutorLibro.setForeground(new Color(120,94,47));
            txtAutorLibro.setFont(new Font("Roboto", Font.PLAIN,14));
        }
        
        if (txtEditorialLibro.getText().isEmpty()) {
            txtEditorialLibro.setText("Editorial del Libro");
            txtEditorialLibro.setForeground(new Color(120,94,47));
            txtEditorialLibro.setFont(new Font("Roboto", Font.PLAIN,14));
        }
        
        if (txtAnioLibro.getText().isEmpty()) {
            txtAnioLibro.setText("Año");
            txtAnioLibro.setForeground(new Color(120,94,47));
            txtAnioLibro.setFont(new Font("Roboto", Font.PLAIN,14));
        }
        
        if (txtPaginasLibro.getText().isEmpty()) {
            txtPaginasLibro.setText("Paginas");
            txtPaginasLibro.setForeground(new Color(120,94,47));
            txtPaginasLibro.setFont(new Font("Roboto", Font.PLAIN,14));
        }
    }//GEN-LAST:event_txtNombreLibroMouseClicked

    private void txtAutorLibroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAutorLibroMouseClicked
        if (txtAutorLibro.getText().equals("Autor del Libro")) {
            txtAutorLibro.setText("");
            txtAutorLibro.setForeground(new Color(120,94,47));
            txtAutorLibro.setFont(new Font("Roboto", Font.BOLD,14));
        }
        if (txtNombreLibro.getText().isEmpty()) {
            txtNombreLibro.setText("Nombre del Libro");
            txtNombreLibro.setForeground(new Color(120,94,47));
            txtNombreLibro.setFont(new Font("Roboto", Font.PLAIN,14));
        }
        
        if (txtEditorialLibro.getText().isEmpty()) {
            txtEditorialLibro.setText("Editorial del Libro");
            txtEditorialLibro.setForeground(new Color(120,94,47));
            txtEditorialLibro.setFont(new Font("Roboto", Font.PLAIN,14));
        }
        
        if (txtAnioLibro.getText().isEmpty()) {
            txtAnioLibro.setText("Año");
            txtAnioLibro.setForeground(new Color(120,94,47));
            txtAnioLibro.setFont(new Font("Roboto", Font.PLAIN,14));
        }
        
        if (txtPaginasLibro.getText().isEmpty()) {
            txtPaginasLibro.setText("Paginas");
            txtPaginasLibro.setForeground(new Color(120,94,47));
            txtPaginasLibro.setFont(new Font("Roboto", Font.PLAIN,14));
        }
    }//GEN-LAST:event_txtAutorLibroMouseClicked

    private void txtEditorialLibroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEditorialLibroMouseClicked
        if (txtEditorialLibro.getText().equals("Editorial del Libro")) {
            txtEditorialLibro.setText("");
            txtEditorialLibro.setForeground(new Color(120,94,47));
            txtEditorialLibro.setFont(new Font("Roboto", Font.BOLD,14));
        }
        if (txtNombreLibro.getText().isEmpty()) {
            txtNombreLibro.setText("Nombre del Libro");
            txtNombreLibro.setForeground(new Color(120,94,47));
            txtNombreLibro.setFont(new Font("Roboto", Font.PLAIN,14));
        }
        
        if (txtAutorLibro.getText().isEmpty()) {
            txtAutorLibro.setText("Autor del Libro");
            txtAutorLibro.setForeground(new Color(120,94,47));
            txtAutorLibro.setFont(new Font("Roboto", Font.PLAIN,14));
        }
        
        if (txtAnioLibro.getText().isEmpty()) {
            txtAnioLibro.setText("Año");
            txtAnioLibro.setForeground(new Color(120,94,47));
            txtAnioLibro.setFont(new Font("Roboto", Font.PLAIN,14));
        }
        
        if (txtPaginasLibro.getText().isEmpty()) {
            txtPaginasLibro.setText("Paginas");
            txtPaginasLibro.setForeground(new Color(120,94,47));
            txtPaginasLibro.setFont(new Font("Roboto", Font.PLAIN,14));
        }
    }//GEN-LAST:event_txtEditorialLibroMouseClicked

    private void txtAnioLibroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAnioLibroMouseClicked
        if (txtAnioLibro.getText().equals("Año")) {
            txtAnioLibro.setText("");
            txtAnioLibro.setForeground(new Color(120,94,47));
            txtAnioLibro.setFont(new Font("Roboto", Font.BOLD,14));
        }
        if (txtNombreLibro.getText().isEmpty()) {
            txtNombreLibro.setText("Nombre del Libro");
            txtNombreLibro.setForeground(new Color(120,94,47));
            txtNombreLibro.setFont(new Font("Roboto", Font.PLAIN,14));
        }
        
        if (txtAutorLibro.getText().isEmpty()) {
            txtAutorLibro.setText("Autor del Libro");
            txtAutorLibro.setForeground(new Color(120,94,47));
            txtAutorLibro.setFont(new Font("Roboto", Font.PLAIN,14));
        }
        
        if (txtEditorialLibro.getText().isEmpty()) {
            txtEditorialLibro.setText("Editorial del Libro");
            txtEditorialLibro.setForeground(new Color(120,94,47));
            txtEditorialLibro.setFont(new Font("Roboto", Font.PLAIN,14));
        }
        
        if (txtPaginasLibro.getText().isEmpty()) {
            txtPaginasLibro.setText("Paginas");
            txtPaginasLibro.setForeground(new Color(120,94,47));
            txtPaginasLibro.setFont(new Font("Roboto", Font.PLAIN,14));
        }
    }//GEN-LAST:event_txtAnioLibroMouseClicked

    private void txtPaginasLibroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPaginasLibroMouseClicked
        if (txtPaginasLibro.getText().equals("Paginas")) {
            txtPaginasLibro.setText("");
            txtPaginasLibro.setForeground(new Color(120,94,47));
            txtPaginasLibro.setFont(new Font("Roboto", Font.BOLD,14));
        }
        if (txtNombreLibro.getText().isEmpty()) {
            txtNombreLibro.setText("Nombre del Libro");
            txtNombreLibro.setForeground(new Color(120,94,47));
            txtNombreLibro.setFont(new Font("Roboto", Font.PLAIN,14));
        }
        
        if (txtAutorLibro.getText().isEmpty()) {
            txtAutorLibro.setText("Autor del Libro");
            txtAutorLibro.setForeground(new Color(120,94,47));
            txtAutorLibro.setFont(new Font("Roboto", Font.PLAIN,14));
        }
        
        if (txtEditorialLibro.getText().isEmpty()) {
            txtEditorialLibro.setText("Editorial del Libro");
            txtEditorialLibro.setForeground(new Color(120,94,47));
            txtEditorialLibro.setFont(new Font("Roboto", Font.PLAIN,14));
        }
        
        if (txtAnioLibro.getText().isEmpty()) {
            txtAnioLibro.setText("Año");
            txtAnioLibro.setForeground(new Color(120,94,47));
            txtAnioLibro.setFont(new Font("Roboto", Font.PLAIN,14));
        }
    }//GEN-LAST:event_txtPaginasLibroMouseClicked

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
                dibujarPortadaLibro(archivoImagenLibro.getAbsolutePath());
            } else {
                mensajeError("El archivo que selecciono no es una imagen.");
                dibujarPortadaLibro("src/view/img/libros/libro-default.jpg");
            }  
        }
    }//GEN-LAST:event_btnCargarImgMouseClicked

    private void btnActDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActDescActionPerformed
        if (tablaLibros.getSelectedRowCount() == 1) {
            
            String id = String.valueOf(tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 0));
            String nombreLibro = String.valueOf(tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 1));
            
            String estado = String.valueOf(tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 7));
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
        if (txtLibro.getText().equals("Ingrese libro a buscar") || txtLibro.getText().equals("")) {
            mensajeError("Ingresar un termino de búsqueda");
        } else {
            listar(txtLibro.getText());
        } 
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtLibroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLibroMouseClicked
        if (txtLibro.getText().equals("Ingrese libro a buscar")) {
            txtLibro.setText("");
            txtLibro.setForeground(new Color(120,94,47));
            txtLibro.setFont(new Font("Roboto", Font.BOLD,14));
        }
    }//GEN-LAST:event_txtLibroMouseClicked
    
    private void insertBook() {
        String resp;
        String img = "libro-default.jpg";
        
        Validates vNomLib = new Validates(txtNombreLibro, "Nombre del Libro", false);
        Validates vAutorLib = new Validates(txtAutorLibro, "Autor del Libro", false);
        Validates vEditLib = new Validates(txtEditorialLibro, "Editorial del Libro", false);
        Validates vAnioLib = new Validates(txtAnioLibro, "Año", true);
        Validates vPagLib = new Validates(txtPaginasLibro, "Paginas", true);
        
        if (vNomLib.validateInput().equals("OK") &&
            vAutorLib.validateInput().equals("OK") &&
            vEditLib.validateInput().equals("OK") &&
            vAnioLib.validateInput().equals("OK") &&
            vPagLib.validateInput().equals("OK") ) {
            
            categoriaSeleccionada = (Categories)cmbCategoria.getSelectedItem();
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
            resp = CONTROL.insertar(
                    txtNombreLibro.getText(),
                    txtAutorLibro.getText(),
                    txtEditorialLibro.getText(),
                    Integer.parseInt(txtAnioLibro.getText()),
                    Integer.parseInt(txtPaginasLibro.getText()),
                    img,
                    disponibleBox.getSelectedIndex(),
                    categoriaSeleccionada.getIdCategoria()
                );

            if(resp.equals("OK")){
                mensajeOK("Registro insertado correctamente");
                limpiar();
                listar("");
            } else {
                mensajeError(resp);
            }      
        
        } else {
            
            if(vNomLib.validateInput() != "OK" ) {
                mensajeError(vNomLib.validateInput());
            }
            if(vAutorLib.validateInput() != "OK" ) {
                mensajeError(vAutorLib.validateInput());
            }
            if(vEditLib.validateInput() != "OK" ) {
                mensajeError(vEditLib.validateInput());
            }
            if(vAnioLib.validateInput() != "OK" ) {
                mensajeError(vAnioLib.validateInput());
            }
            if(vPagLib.validateInput() != "OK" ) {
                mensajeError(vPagLib.validateInput());
            }
        }
    }
    
    private void updateBook() {
        String resp;
        
        Validates vNomLib = new Validates(txtNombreLibro, "Nombre del Libro", false);
        Validates vAutorLib = new Validates(txtAutorLibro, "Autor del Libro", false);
        Validates vEditLib = new Validates(txtEditorialLibro, "Editorial del Libro", false);
        Validates vAnioLib = new Validates(txtAnioLibro, "Año", true);
        Validates vPagLib = new Validates(txtPaginasLibro, "Paginas", true);
        
        if (vNomLib.validateInput().equals("OK") &&
            vAutorLib.validateInput().equals("OK") &&
            vEditLib.validateInput().equals("OK") &&
            vAnioLib.validateInput().equals("OK") &&
            vPagLib.validateInput().equals("OK") ){
            
            categoriaSeleccionada = (Categories)cmbCategoria.getSelectedItem();
            
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
                
                if (!imgAnt.equals("libro-default.jpg")) {
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
                
                resp = CONTROL.actualizar(
                    Integer.parseInt(txtId.getText()),
                    txtNombreLibro.getText(),
                    nombreLibroAnt,
                    txtAutorLibro.getText(),
                    txtEditorialLibro.getText(),
                    Integer.parseInt(txtAnioLibro.getText()),
                    Integer.parseInt(txtPaginasLibro.getText()),
                    img,
                    disponibleBox.getSelectedIndex(),
                    categoriaSeleccionada.getIdCategoria()
                );
                
                imgChange = null;
                
                if(resp.equals("OK")){
                    mensajeOK("Registro actualizado correctamente");
                    limpiar();
                    listar("");
                } else {
                    mensajeError(resp);
                }
            
            } else {
                resp = CONTROL.actualizar(
                    Integer.parseInt(txtId.getText()),
                    txtNombreLibro.getText(),
                    nombreLibroAnt,
                    txtAutorLibro.getText(),
                    txtEditorialLibro.getText(),
                    Integer.parseInt(txtAnioLibro.getText()),
                    Integer.parseInt(txtPaginasLibro.getText()),
                    imgActual,
                    disponibleBox.getSelectedIndex(),
                    categoriaSeleccionada.getIdCategoria()
                );
                
                if(resp.equals("OK")){
                    mensajeOK("Registro actualizado correctamente");
                    limpiar();
                    listar("");
                } else {
                    mensajeError(resp);
                }
            
            }
            
        } else {
            if(vNomLib.validateInput() != "OK" ) {
                mensajeError(vNomLib.validateInput());
            }
            if(vAutorLib.validateInput() != "OK" ) {
                mensajeError(vAutorLib.validateInput());
            }
            if(vEditLib.validateInput() != "OK" ) {
                mensajeError(vEditLib.validateInput());
            }
            if(vAnioLib.validateInput() != "OK" ) {
                mensajeError(vAnioLib.validateInput());
            }
            if(vPagLib.validateInput() != "OK" ) {
                mensajeError(vPagLib.validateInput());
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
                new FrmLibros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.components.ButtonHover.ButtonHover btnActDesc;
    private view.components.ButtonHover.ButtonHover btnBuscar;
    private javax.swing.JLabel btnCargarImg;
    private view.components.ButtonHover.ButtonHover btnEditar;
    private view.components.ButtonHover.ButtonHover btnGuardar;
    private javax.swing.JComboBox cmbCategoria;
    private javax.swing.JComboBox disponibleBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblImgLibro;
    private javax.swing.JLabel lblLimpiar;
    private javax.swing.JLabel lblRegistros;
    private javax.swing.JPanel panelPrinc;
    private javax.swing.JTable tablaLibros;
    private view.components.InputIcon txtAnioLibro;
    private view.components.InputIcon txtAutorLibro;
    private view.components.InputIcon txtEditorialLibro;
    private javax.swing.JLabel txtId;
    private javax.swing.JLabel txtImg;
    private view.components.InputIcon txtLibro;
    private view.components.InputIcon txtNombreLibro;
    private view.components.InputIcon txtPaginasLibro;
    // End of variables declaration//GEN-END:variables
}
