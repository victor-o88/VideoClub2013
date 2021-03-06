/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IG_Alquiler;

import cevisy.CeViSy;
import cevisy.Principal;
import datosPeliculas.Alquileres;
import datosPeliculas.Peliculas;
import datosPersona.Cliente;
import excepciones.DateAccessException;
import gestionar.GestorAlquileres;
import gestionar.GestorClientes;
import gestionar.GestorPeliculas;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;

/**
 *
 * @author Alejandrux
 */
public class RealizarAlquiler extends javax.swing.JFrame {

    /**
     * Creates new form RealizarAlquiler
     */
    public RealizarAlquiler(){
        
        
    }
    DefaultTableModel modelo = new DefaultTableModel();
    
    public RealizarAlquiler(Integer idcli) {
        try{
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(0);
        
        jTextField10.setText(idcli.toString());
        //Id Alquiler
        int i=0;
        do{
        Random rn = new Random();
        Integer id = rn.nextInt(9000)+1000;
        GestorAlquileres ga = new GestorAlquileres();
        Alquileres nuevo = ga.buscaralquiler(id);

        if(nuevo!=null){
            i++;
        }jTextField1.setText(id.toString());
            i=0;
        }while(i!=0);
        
        //Fecha de Alquiler y Devolucion
        CeViSy f = new CeViSy();
        jTextField4.setText(f.calcfecha().toString());
        jTextField11.setText(devolucion().toString());
        
        //Lista de peliculas
        String [] columnas = {"Cod_Pelicula", "Titulo", "Genero", "Formato", "Director", "Stock", "Monto"};
            modelo.setColumnIdentifiers(columnas);
            
            GestorPeliculas gp = new GestorPeliculas();
            Collection listado = gp.listarPeliculas();
            
            ArrayList peliculas = (ArrayList)listado;
            
            Iterator<Peliculas> it = peliculas.iterator();
            
            while(it.hasNext()){
                
                Peliculas pel = it.next();
                
                String cod_pelicula = pel.getCod_pelicula();
                String titulo = pel.getTitulo();
                String genero = pel.getGenero();
                String formato = pel.getFormato();
                String director = pel.getDirector();
                Integer stock = pel.getStock();
                Integer mnt = pel.getMonto();
                
                Object [] fila = {cod_pelicula, titulo, genero, formato, director, stock, mnt};
                modelo.addRow(fila);
            }
            this.jTable1.setModel(modelo);
            this.jScrollPane1.setRowHeader(null);
            
            }catch(DateAccessException e){
            System.out.println(e);
                }   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jToggleButton3 = new javax.swing.JToggleButton();
        jTextField10 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Id Cliente");

        jLabel2.setText("Id Pelicula 1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jToggleButton1.setText("Aceptar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Cancelar");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("ALQUILER");

        jLabel6.setText("Id Alquiler");

        jLabel3.setText("Id pelicula 2");

        jLabel4.setText("Id Pelicula 3");

        jLabel7.setText("Monto");

        jToggleButton3.setText("Calcular Total");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jLabel8.setText("Fecha Alquiler");

        jLabel9.setText("Fecha Devolucion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2)
                                    .addComponent(jTextField3)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 39, Short.MAX_VALUE)
                                .addComponent(jToggleButton3)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField9, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                            .addComponent(jTextField8)
                            .addComponent(jTextField7)
                            .addComponent(jLabel7)
                            .addComponent(jTextField6))
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField4)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(52, 52, 52))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton2)
                        .addGap(64, 64, 64))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(120, 120, 120)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jToggleButton3)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)))
                        .addContainerGap(22, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //aceptar
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if(!jTextField5.getText().equals("")){
        try{
            String ids = jTextField10.getText();
            Integer id = Integer.parseInt(ids);

            GestorClientes gc = new GestorClientes();
            Cliente cliente = gc.buscarCliente(id);
            String cuil = cliente.getCuil();

            String id_alq = jTextField1.getText();
            Integer idalq = Integer.parseInt(id_alq);
            
            String cod_pel1 = jTextField5.getText();
            String cod_pel2 = jTextField2.getText();
            String cod_pel3 = jTextField3.getText();
            
            CeViSy f = new CeViSy();
            java.sql.Date fa = f.calcfecha();
            java.sql.Date fe = (java.sql.Date) devolucion();
            
            String mon = jTextField9.getText();
            Integer mnt = Integer.parseInt(mon);
            Integer estado = 1;
            

            GestorAlquileres ga = new GestorAlquileres();
            Peliculas pel1 = new Peliculas(cod_pel1);
            Peliculas pel2 = new Peliculas(cod_pel2);
            Peliculas pel3 = new Peliculas(cod_pel3);
            Cliente cli = new Cliente(cuil);
            Alquileres alq = new Alquileres(idalq,fa,mnt,fe,estado,id);
            
            ga.agregarAlquiler(alq, pel1, pel2, pel3, cli);
            
            Principal principal = new Principal();
            principal.setVisible(true);
            dispose();        
                    
        }catch(Exception ex){
            System.out.println(ex);
        }

        }else
                if(jTextField5.getText().equals("")||jTextField2.getText().equals("")||jTextField3.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Hay Campos sin llenar");
                }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    //cancelar
    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        JOptionPane.showMessageDialog(null,"Los datos de un nuevo alquiler se perderan");
                
        Principal principal = new Principal();
        principal.setVisible(true);
        dispose();
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    
    //calculaMonto
    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        if(!jTextField6.getText().equals("") && !jTextField7.getText().equals("") && !jTextField8.getText().equals("")){
        String monto1 = jTextField6.getText();
        Integer mnt1 = Integer.parseInt(monto1);
        String monto2 = jTextField7.getText();
        Integer mnt2 = Integer.parseInt(monto2);
        String monto3 = jTextField8.getText();
        Integer mnt3 = Integer.parseInt(monto3);
        
        Integer resultado = mnt1 + mnt2 + mnt3;
        jTextField9.setText(resultado.toString());
        }else
                if(jTextField1.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Llenar todos los Campos");
                }
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        // TODO add your handling code here:
            try{
            String idpel1 = jTextField5.getText();
            GestorPeliculas gp = new GestorPeliculas();
            Peliculas ex_pel1 = gp.buscarPelicula(idpel1);
            String cant = ex_pel1.getStock().toString();
            Integer stk = Integer.parseInt(cant);
            
            if(ex_pel1!=null && stk!=0){
                jTextField6.setText(ex_pel1.getMonto().toString());
                Integer nuevo = stk-1;
                
                String tit = ex_pel1.getTitulo();
                String gen = ex_pel1.getGenero();
                String dir = ex_pel1.getDirector();
                String form = ex_pel1.getFormato();
                Integer monto = ex_pel1.getMonto();
                
                Peliculas pelicula = new Peliculas(idpel1,gen,tit,form,dir,nuevo,monto);
                gp.modificarPelicula(pelicula); 
                }
            else{
                JOptionPane.showMessageDialog(null,"Pelicula inexistente o Stock insuficiente");
            }
                
                 
            }catch(DateAccessException e){
                System.out.println(e);
                }
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // TODO add your handling code here:
            try{
            String idpel2 = jTextField2.getText();
            GestorPeliculas gp = new GestorPeliculas();
            Peliculas ex_pel2 = gp.buscarPelicula(idpel2);
            String cant = ex_pel2.getStock().toString();
            Integer stk = Integer.parseInt(cant);
        
            if(ex_pel2!=null && stk!=0){
                jTextField7.setText(ex_pel2.getMonto().toString());
                Integer nuevo = stk-1;
                
                String tit = ex_pel2.getTitulo();
                String gen = ex_pel2.getGenero();
                String dir = ex_pel2.getDirector();
                String form = ex_pel2.getFormato();
                Integer monto = ex_pel2.getMonto();
                
                Peliculas pelicula = new Peliculas(idpel2,gen,tit,form,dir,nuevo,monto);
                gp.modificarPelicula(pelicula);
                 }
                else{
                JOptionPane.showMessageDialog(null,"Pelicula inexistente o Stock insuficiente");
            }
                
            }catch(DateAccessException e){
                System.out.println(e);
                }
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        // TODO add your handling code here:
            try{
            String idpel3 = jTextField3.getText();
            GestorPeliculas gp = new GestorPeliculas();
            Peliculas ex_pel3 = gp.buscarPelicula(idpel3);
            String cant = ex_pel3.getStock().toString();
            Integer stk = Integer.parseInt(cant);
        
            if(ex_pel3!=null && stk!=0){
                jTextField8.setText(ex_pel3.getMonto().toString());
                Integer nuevo = stk-1;
                
                String tit = ex_pel3.getTitulo();
                String gen = ex_pel3.getGenero();
                String dir = ex_pel3.getDirector();
                String form = ex_pel3.getFormato();
                Integer monto = ex_pel3.getMonto();
                
                Peliculas pelicula = new Peliculas(idpel3,gen,tit,form,dir,nuevo,monto);
                gp.modificarPelicula(pelicula);
                 }
                else{
                JOptionPane.showMessageDialog(null,"Pelicula inexistente o Stock insuficiente");
            }
            
            }catch(DateAccessException e){
                System.out.println(e);
                }
    }//GEN-LAST:event_jTextField3KeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RealizarAlquiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RealizarAlquiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RealizarAlquiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RealizarAlquiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RealizarAlquiler().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    // End of variables declaration//GEN-END:variables

    public Date devolucion(){
            Calendar hoy = Calendar.getInstance();
            hoy.add(Calendar.DATE,7);
            java.sql.Date f;
                    f = new java.sql.Date(hoy.getTimeInMillis());
            return f;
        }

}
