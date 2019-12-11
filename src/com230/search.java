/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com230;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author manoj
 */
public class search extends javax.swing.JFrame {
public static int itemId;
 public static String itemName;
 public static String itemDescription;
 public static String itemDirection;
 public static ImageIcon newImage;
   
 public search() {
        initComponents();
        jLabel_itemId.setText("Item ID: " + Integer.toString(itemId));
        jLabel_itemName.setText(itemName);
        jLabel_itemDirection.setText("Direction: " + "\n" + itemDirection);
        jLabel_itemDescription.setText("<html>" + itemDescription + "</html>");
        jLabel_itemImage.setIcon(newImage);
    }
    
public void getSearchAttributes (String searchValue){
     String qry ="";
     
     try {
           Class.forName("com.mysql.jdbc.Driver");  
           String url = new String();
           String user = new String();
           String password = new String();
           url = "jdbc:mysql://localhost:3306/dataforlibrary?autoReconnect=true&useSSL=false";
            user = "root";
           password = "password";
           
           DriverManager.registerDriver(new com.mysql.jdbc.Driver());
           Connection conn = DriverManager.getConnection(url,user,password);
           Statement stment = conn.createStatement();
          if (!searchValue.equals(""))
          
          {
               qry = "SELECT * FROM library WHERE Item_Name='" + searchValue +"'"; 
          }
          
           ResultSet rs = stment.executeQuery(qry);
       
                if(rs.next())
                {
                  do{

                        itemId = rs.getInt("Item_Id");
                        itemName = rs.getString("Item_Name");
                        itemDescription = rs.getString("Item_Description");
                        itemDirection = rs.getString("Item_Direction");
                        
                        
                        byte[] img = rs.getBytes("Item_Preview");
                        ImageIcon image = new ImageIcon(img);
                        Image im = image.getImage();
                        Image myImg = im.getScaledInstance(jLabel_itemImage.getWidth(), jLabel_itemImage.getHeight(), Image.SCALE_SMOOTH);
                        newImage = new ImageIcon(myImg);
                
                        
                    }
                    while(rs.next());
                  }
                else
                {
                    showMessageDialog(null, "Sorry! The requested item was not found. Please check the item name again.", "ERROR",ERROR_MESSAGE);
                     System.exit(0);
                }
                conn.close();
        } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Database Connection Failed" +e);
        }
        
}
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel_itemId = new javax.swing.JLabel();
        jLabel_itemName = new javax.swing.JLabel();
        jLabel_itemDescription = new javax.swing.JLabel();
        jLabel_itemImage = new javax.swing.JLabel();
        jLabel_itemDirection = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 167, 38));
        jPanel1.setForeground(new java.awt.Color(102, 255, 0));

        jLabel_itemId.setBackground(new java.awt.Color(255, 167, 38));
        jLabel_itemId.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        jLabel_itemId.setText("Item ID:");
        jLabel_itemId.setOpaque(true);

        jLabel_itemName.setBackground(new java.awt.Color(255, 167, 38));
        jLabel_itemName.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel_itemName.setText("                                         ");
        jLabel_itemName.setMaximumSize(new java.awt.Dimension(300, 30));
        jLabel_itemName.setOpaque(true);

        jLabel_itemDescription.setBackground(new java.awt.Color(255, 167, 38));
        jLabel_itemDescription.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel_itemDescription.setText("itemdescription");
        jLabel_itemDescription.setOpaque(true);

        jLabel_itemImage.setBackground(new java.awt.Color(255, 167, 38));
        jLabel_itemImage.setOpaque(true);

        jLabel_itemDirection.setBackground(new java.awt.Color(255, 167, 38));
        jLabel_itemDirection.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel_itemDirection.setText("Item Direction");
        jLabel_itemDirection.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel_itemDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_itemImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel_itemId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jLabel_itemName, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel_itemDirection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel_itemId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_itemName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_itemDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_itemImage, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_itemDirection, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new search().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_itemDescription;
    private javax.swing.JLabel jLabel_itemDirection;
    private javax.swing.JLabel jLabel_itemId;
    private javax.swing.JLabel jLabel_itemImage;
    private javax.swing.JLabel jLabel_itemName;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
