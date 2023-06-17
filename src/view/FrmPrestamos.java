package view;

import business.PrestamoControl;
import entities.Books;
import entities.Users;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class FrmPrestamos extends javax.swing.JFrame {
    
    private final PrestamoControl CONTROL;
    private Books libroSeleccionado;
    private Users usuarioSeleccionado;

    public FrmPrestamos() {
        initComponents();
        
        //Inicializar el CONTROL
        CONTROL = new PrestamoControl();
        listar("");
        
        this.setTitle("Listado de Prestamos | Biblioteca System");
        this.setSize(780,500);
        this.setResizable(false);
        setLocationRelativeTo(null);
    }
    
    private void listar(String texto) {
        //Llenar el modelo del JTable de nombre tabla Listado
        tablaPrestamos.setModel(CONTROL.listar(texto));
        darFormatoTabla();
        
        //Total de registros
        String total = Integer.toString(CONTROL.total());
        lblRegistros.setText("Registros mostrados: " + CONTROL.totalMostrados() + " de un total de " + total);
    }
    
    private void limpiar() {
        txtPrestamos.setText("Buscar Usuario");
        txtPrestamos.setFont(new Font("Roboto", Font.PLAIN,14));
        listar("");
    }
    
    // Formato a tablas
    public void darFormatoTabla() {
        // Formatear encabezado
        JTableHeader th;
        th = tablaPrestamos.getTableHeader();
        Font fuente = new Font("Roboto", Font.BOLD, 13);
        th.setFont(fuente);

        // Centrar contenido
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        // Celda ID Prestamo
        tablaPrestamos.getColumnModel().getColumn(0).setCellRenderer(tcr);
        // ID Usuario
        //tablaPrestamos.getColumnModel().getColumn(1).setCellRenderer(tcr);
        // Nombre del Usuario
        //tablaPrestamos.getColumnModel().getColumn(2).setCellRenderer(tcr);
        // totalLibros
        tablaPrestamos.getColumnModel().getColumn(3).setCellRenderer(tcr);
        // fechaPrestamo
        tablaPrestamos.getColumnModel().getColumn(4).setCellRenderer(tcr);
        // fechaDevolución
        tablaPrestamos.getColumnModel().getColumn(5).setCellRenderer(tcr);
        // Estado
        tablaPrestamos.getColumnModel().getColumn(6).setCellRenderer(tcr);

        // Tamaño a columna: Id Prestamo
        tablaPrestamos.getColumnModel().getColumn(0).setMaxWidth(50);
        tablaPrestamos.getColumnModel().getColumn(0).setMinWidth(50);
        tablaPrestamos.getColumnModel().getColumn(0).setPreferredWidth(50);

        // Tamaño a columna: ID Usuario
        tablaPrestamos.getColumnModel().getColumn(1).setMaxWidth(0);
        tablaPrestamos.getColumnModel().getColumn(1).setMinWidth(0);
        tablaPrestamos.getColumnModel().getColumn(1).setPreferredWidth(0);

        // Tamaño a columna: Nombre del Usuario
        tablaPrestamos.getColumnModel().getColumn(2).setMaxWidth(200);
        tablaPrestamos.getColumnModel().getColumn(2).setMinWidth(200);
        tablaPrestamos.getColumnModel().getColumn(2).setPreferredWidth(200);

        // Tamaño a columna: Total Libros
        tablaPrestamos.getColumnModel().getColumn(3).setMaxWidth(100);
        tablaPrestamos.getColumnModel().getColumn(3).setMinWidth(100);
        tablaPrestamos.getColumnModel().getColumn(3).setPreferredWidth(100);

        // Tamaño a columna: Fecha Prestamo
        tablaPrestamos.getColumnModel().getColumn(4).setMaxWidth(150);
        tablaPrestamos.getColumnModel().getColumn(4).setMinWidth(150);
        tablaPrestamos.getColumnModel().getColumn(4).setPreferredWidth(150);

        // Tamaño a columna: Fecha Devolución
        tablaPrestamos.getColumnModel().getColumn(5).setMaxWidth(150);
        tablaPrestamos.getColumnModel().getColumn(5).setMinWidth(150);
        tablaPrestamos.getColumnModel().getColumn(5).setPreferredWidth(150);

        // Tamaño a columna: Estado
        tablaPrestamos.getColumnModel().getColumn(6).setMaxWidth(100);
        tablaPrestamos.getColumnModel().getColumn(6).setMinWidth(100);
        tablaPrestamos.getColumnModel().getColumn(6).setPreferredWidth(100);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrinc = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPrestamos = new javax.swing.JTable();
        btnDevolver = new view.components.ButtonHover.ButtonHover();
        lblHome = new javax.swing.JLabel();
        lblRegistros = new javax.swing.JLabel();
        txtPrestamos = new view.components.InputIcon();
        btnBuscar = new view.components.ButtonHover.ButtonHover();
        btnHacerPrestamo = new view.components.ButtonHover.ButtonHover();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrinc.setBackground(new java.awt.Color(255, 255, 255));
        panelPrinc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(120, 94, 47));
        jLabel1.setText("Administración de Prestamos");
        panelPrinc.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

        tablaPrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaPrestamos);

        panelPrinc.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 750, 280));

        btnDevolver.setText("Devolver Prestamo");
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });
        panelPrinc.add(btnDevolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 390, 130, 40));

        lblHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/home.png"))); // NOI18N
        lblHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeMouseClicked(evt);
            }
        });
        panelPrinc.add(lblHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblRegistros.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblRegistros.setForeground(new java.awt.Color(123, 83, 11));
        panelPrinc.add(lblRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 410, 30));

        txtPrestamos.setForeground(new java.awt.Color(120, 94, 47));
        txtPrestamos.setText("Buscar Usuario");
        txtPrestamos.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtPrestamos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPrestamosMouseClicked(evt);
            }
        });
        panelPrinc.add(txtPrestamos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 490, 30));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        panelPrinc.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 100, 30));

        btnHacerPrestamo.setText("Hacer un prestamo");
        btnHacerPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHacerPrestamoActionPerformed(evt);
            }
        });
        panelPrinc.add(btnHacerPrestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, 140, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrinc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed
        if (tablaPrestamos.getSelectedRowCount() == 1) {
            
            String id = String.valueOf(tablaPrestamos.getValueAt(tablaPrestamos.getSelectedRow(), 0));
            String nombreUsuario = String.valueOf(tablaPrestamos.getValueAt(tablaPrestamos.getSelectedRow(), 2));
            String isDevuelto = String.valueOf(tablaPrestamos.getValueAt(tablaPrestamos.getSelectedRow(), 6));
            
            System.out.println(isDevuelto);
            
            if (isDevuelto.equals("Aceptado")){
                
                if (JOptionPane.showConfirmDialog(this, "¿Desea Devolver el prestamos a nombre de "+nombreUsuario+"?", "Devolver", JOptionPane.YES_NO_OPTION) == 0){
                    String resp = CONTROL.devolver(Integer.parseInt(id));

                    if (resp.equals("OK")){
                        mensajeOK("Prestamos Devuelto");
                        listar("");
                        limpiar();
                    } else {
                        mensajeError(resp);
                    }
                }
                
            } else {      
                mensajeError("El Prestamos seleccionado ya fue devuelto.");
            }
        } else {
            mensajeError("Debes seleccionar un prestamo para devolver");
        }
    }//GEN-LAST:event_btnDevolverActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtPrestamos.getText().equals("Buscar Usuario") || txtPrestamos.getText().equals("")) {
            mensajeError("Ingresar un termino de búsqueda");
        } else {
            listar(txtPrestamos.getText());
        } 
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtPrestamosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPrestamosMouseClicked
        if (txtPrestamos.getText().equals("Buscar Usuario")) {
            txtPrestamos.setText("");
            txtPrestamos.setForeground(new Color(120,94,47));
            txtPrestamos.setFont(new Font("Roboto", Font.BOLD,14));
        }
    }//GEN-LAST:event_txtPrestamosMouseClicked

    private void btnHacerPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHacerPrestamoActionPerformed
        FrmDetallePrestamo detalle = new FrmDetallePrestamo();
        detalle.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnHacerPrestamoActionPerformed

            
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
                new FrmPrestamos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.components.ButtonHover.ButtonHover btnBuscar;
    private view.components.ButtonHover.ButtonHover btnDevolver;
    private view.components.ButtonHover.ButtonHover btnHacerPrestamo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblRegistros;
    private javax.swing.JPanel panelPrinc;
    private javax.swing.JTable tablaPrestamos;
    private view.components.InputIcon txtPrestamos;
    // End of variables declaration//GEN-END:variables
}
