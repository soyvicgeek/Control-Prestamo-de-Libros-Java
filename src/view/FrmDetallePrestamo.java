package view;

import business.PrestamoControl;
import entities.Books;
import entities.Users;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmDetallePrestamo extends javax.swing.JFrame {
    
    private final PrestamoControl CONTROL;
    private Users usuarioSeleccionado;
    private DefaultTableModel modeloDetalles;

    public FrmDetallePrestamo() {
        initComponents();
        
        //Inicializar el CONTROL
        CONTROL = new PrestamoControl();
        listar("");
        
        this.setTitle("Hacer un prestamo | Biblioteca System");
        this.setSize(780,500);
        this.setResizable(false);
        setLocationRelativeTo(null);
        
        //Ocultar variables
        txtId.setVisible(false);
        cargarUsuarios();
        crearDetalles();
    }
    
    private void listar(String texto) {
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 10);
        
        //fechaPrestamo.setMinSelectableDate(new Date());
        fechaPrestamo.setDate(dt);
        finPrestamos.setDate(c.getTime());
    }
    
    private void crearDetalles() {    
        modeloDetalles = new DefaultTableModel(){
            
            @Override
            public void setValueAt(Object aValue, int row,int col)
            {
                super.setValueAt(aValue, row, col);
                calcularTotales();
                
                fireTableDataChanged();
            }      
        };
        //definir las colimnas del modelo
        modeloDetalles.setColumnIdentifiers(new Object[]{"ID Libro","Nombre Libro","Cantidad"});
        //etablecer el modelo
        tablaDetalles.setModel(modeloDetalles);
    }
    
    // Agregar el Producto que el cliente desea comprar
    public void agregarDetalles(String id, String libro) {
        String idTemp;
        boolean existe = false;
        
        //Bucar en todos los productos que tiene el modelo
        for (int i = 0; i < modeloDetalles.getRowCount(); i++) {
            //Obtener ID producto que se encunetra en modelo Detalles
            idTemp = modeloDetalles.getValueAt(i, 0).toString();
            if (idTemp.equals(id)) {
                existe = true;
            }
        }
        if(existe) {
            mensajeError("El Libro ya ha sido agregado");
        } else {
            modeloDetalles.addRow(new Object[]{id, libro, "1"});
            calcularTotales();
        }
    }
    
    //metodo calcular totales,iva, gran total 
    private void calcularTotales() {
        int total = 0;
        //Obtener el número de productos que lleva el cliente
        int items = modeloDetalles.getRowCount();
        if (items == 0) {
            total = 0;
        } else {
            //Recorrer la lista de productos para obetner el total
            for (int i = 0; i < items; i++) {
                total = total + Integer.parseInt(modeloDetalles.getValueAt(i, 2).toString());
            }           
        }
        //Llenar los controles
        txtTotal.setText(String.valueOf(total));
    }
    
    private void cargarUsuarios() {
        DefaultComboBoxModel modeloUsuarios = CONTROL.seleccionarUsuarios();
        cmbUsuario.setModel(modeloUsuarios);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrinc = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDetalles = new javax.swing.JTable();
        btnGuardar = new view.components.ButtonHover.ButtonHover();
        txtId = new javax.swing.JLabel();
        btnQuitar = new view.components.ButtonHover.ButtonHover();
        btnCancelar = new view.components.ButtonHover.ButtonHover();
        cmbUsuario = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        finPrestamos = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        fechaPrestamo = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        txtIdLibro = new view.components.InputIcon();
        jLabel3 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrinc.setBackground(new java.awt.Color(255, 255, 255));
        panelPrinc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(120, 94, 47));
        jLabel1.setText("Efectuar Prestamo");
        panelPrinc.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 160, -1));

        tablaDetalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaDetalles);

        panelPrinc.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 750, 270));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panelPrinc.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, 120, 40));
        panelPrinc.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 24, 30, 20));

        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        panelPrinc.add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 80, 30));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panelPrinc.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, 120, 40));

        cmbUsuario.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        panelPrinc.add(cmbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 170, 30));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(120, 94, 47));
        jLabel4.setText("Seleccionar un usuario");
        panelPrinc.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 150, 20));
        panelPrinc.add(finPrestamos, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 150, 30));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(120, 94, 47));
        jLabel5.setText("Fecha de Devolución");
        panelPrinc.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 150, 20));
        panelPrinc.add(fechaPrestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 150, 30));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(120, 94, 47));
        jLabel2.setText("Código del Libro");
        panelPrinc.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, 20));

        txtIdLibro.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtIdLibro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdLibroKeyReleased(evt);
            }
        });
        panelPrinc.add(txtIdLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 70, 160, 30));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(120, 94, 47));
        jLabel3.setText("Fecha de Prestamo");
        panelPrinc.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 150, 20));

        txtTotal.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        txtTotal.setText("0");
        panelPrinc.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 390, 40, 50));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(123, 83, 11));
        jLabel6.setText("Libros Prestados:");
        panelPrinc.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 410, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrinc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrinc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String resp;
        
        if(modeloDetalles.getRowCount() == 0){
            mensajeError("Debe agregar al menos un Libro");
            return;
        }
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
        Date dateP = fechaPrestamo.getDate(); 
        String inicioPrestamo = dateFormat.format(dateP);
        
        Date dateD = finPrestamos.getDate();  
        String finPrestamo = dateFormat.format(dateD);
        
        try{        
            Date fecha1 = dateFormat.parse(inicioPrestamo);
            Date fecha2 = dateFormat.parse(finPrestamo);
        
            if (fecha1.compareTo(fecha2) > 0) {
                mensajeError("La Fecha de Prestamo no puede ser Mayor a la de Devolución.");
            } else if (fecha1.compareTo(fecha2) < 0) {

                usuarioSeleccionado = (Users)cmbUsuario.getSelectedItem();       
                resp = CONTROL.insertar(
                        usuarioSeleccionado.getIdUsuario(),
                        Integer.parseInt(txtTotal.getText()),
                        inicioPrestamo,
                        finPrestamo,
                        modeloDetalles
                    );

                    if(resp.equals("OK")){
                        mensajeOK("Registro insertado correctamente");
                        listar("");
                        
                        FrmPrestamos prestamos = new FrmPrestamos();
                        prestamos.setVisible(true);
                        dispose();
                    } else {
                        mensajeError(resp);
                    }
            } else {
                mensajeError("La Fecha de Prestamo y Decolución no pueden ser iguales.");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        //Verificar que el usuario haya seleccionado un producto
        if (tablaDetalles.getSelectedRowCount() == 1) {
            modeloDetalles.removeRow(tablaDetalles.getSelectedRow());
            calcularTotales();
        } else {
            mensajeError("Debe Seleccionar un libro");
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        FrmPrestamos prestamos = new FrmPrestamos();
        prestamos.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtIdLibroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdLibroKeyReleased
        if(txtIdLibro.getText().length()>0) {
            //Verificar que se preesiono la tecla Enter
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                entities.Books lib;
                lib = CONTROL.obtenerLibro(Integer.parseInt(txtIdLibro.getText()));
                
                //Verificar si se encontro el Libro
                if(lib == null) {
                    mensajeError("No se encontro el Libro: " + txtIdLibro.getText());
                    txtIdLibro.requestFocus();
                    return;
                } else {
                    //Agregar el producto al modelo
                    agregarDetalles(String.valueOf(lib.getIdLibro()), lib.getNombreLibro());
                    //modeloDetalles.addRow(new Object[]{prod.getIdProducto(), prod.getNombreProducto(), "1", prod.getPrecioProducto(), prod.getDescuentoProducto(), prod.getPrecioProducto()});
                }     
            }
        } else {
            mensajeError("Debe escribir el código del Libro");
        }
    }//GEN-LAST:event_txtIdLibroKeyReleased
            
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
                new FrmDetallePrestamo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.components.ButtonHover.ButtonHover btnCancelar;
    private view.components.ButtonHover.ButtonHover btnGuardar;
    private view.components.ButtonHover.ButtonHover btnQuitar;
    private javax.swing.JComboBox cmbUsuario;
    private com.toedter.calendar.JDateChooser fechaPrestamo;
    private com.toedter.calendar.JDateChooser finPrestamos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelPrinc;
    private javax.swing.JTable tablaDetalles;
    private javax.swing.JLabel txtId;
    private view.components.InputIcon txtIdLibro;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
