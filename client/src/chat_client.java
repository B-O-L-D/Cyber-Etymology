

import java.awt.Toolkit;
import java.awt.event.*;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


/*
 * @author Thejaswi A
 */
public class chat_client extends javax.swing.JFrame {

    /**
     * Creates new form chat_client
     */
    
    static Socket s1;
    static DataInputStream dis1;
    static DataOutputStream dout1;
    private static Timer timer;
    private static int count=16;
    static String ch1;
    static String ch2;
    static char ch;

    private static void abort() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return;
    }
   
    
    public chat_client() {
        initComponents();
        setIcon();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        msg_te = new javax.swing.JTextField();
        msg_se = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        msg_ar1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        msg_ar = new javax.swing.JTextArea();
        msg_ch = new javax.swing.JLabel();
        time_label = new javax.swing.JLabel();
        alert_label = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cyber Etymology");
        setBackground(new java.awt.Color(132, 107, 208));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1366, 780));
        getContentPane().setLayout(null);

        msg_te.setBackground(new java.awt.Color(204, 204, 255));
        msg_te.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        msg_te.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_teActionPerformed(evt);
            }
        });
        msg_te.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                msg_teKeyPressed(evt);
            }
        });
        getContentPane().add(msg_te);
        msg_te.setBounds(500, 380, 322, 50);

        msg_se.setBackground(new java.awt.Color(0, 51, 153));
        msg_se.setForeground(new java.awt.Color(255, 255, 255));
        msg_se.setText("GO");
        msg_se.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_seActionPerformed(evt);
            }
        });
        getContentPane().add(msg_se);
        msg_se.setBounds(850, 380, 111, 50);

        msg_ar1.setBackground(new java.awt.Color(204, 204, 204));
        msg_ar1.setColumns(20);
        msg_ar1.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        msg_ar1.setRows(5);
        jScrollPane2.setViewportView(msg_ar1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(1040, 430, 293, 272);

        msg_ar.setBackground(new java.awt.Color(204, 204, 204));
        msg_ar.setColumns(20);
        msg_ar.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        msg_ar.setRows(5);
        jScrollPane3.setViewportView(msg_ar);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(30, 430, 293, 272);

        msg_ch.setFont(new java.awt.Font("Sitka Small", 1, 75)); // NOI18N
        msg_ch.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(msg_ch);
        msg_ch.setBounds(650, 170, 100, 110);
        msg_ch.getAccessibleContext().setAccessibleParent(msg_ch);

        time_label.setFont(new java.awt.Font("Yu Mincho Light", 1, 70)); // NOI18N
        getContentPane().add(time_label);
        time_label.setBounds(1150, 170, 90, 90);

        alert_label.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        alert_label.setForeground(new java.awt.Color(255, 0, 51));
        getContentPane().add(alert_label);
        alert_label.setBounds(610, 430, 240, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CYBER_ETYMOLOGY.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1366, 768);

        getAccessibleContext().setAccessibleName("newframe");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void msg_seActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_seActionPerformed
        // TODO add your handling code here:
        try{
        String msgo = "";
        msgo = msg_te.getText().trim();
       
             if(msgo.isEmpty())
             {
        
                     alert_label.setText("No word is Entered !!!");
             }
       
        else if(!ch1.equalsIgnoreCase( Character.toString(msgo.charAt(0))))
        {
                    alert_label.setText("");
                    dout1.writeUTF("9999");
                    timer.stop();
                    count=16;
                    time_label.setText("");
                    msg_ch.setText("");
                    msg_se.setEnabled(false);
                    msg_te.setEditable(false);
                    JOptionPane.showMessageDialog(null,"OOPS ! You have Entered a WRONG WORD !");

        
        }
        
        else{
                   alert_label.setText("");    
                   dout1.writeUTF(msgo);
                   timer.stop();
                   count=16;
                   time_label.setText("");
                   msg_ch.setText("");
                   msg_se.setEnabled(false);
                   msg_te.setEditable(false);
                   JOptionPane.showMessageDialog(null,"Word Successfully Sent ! ");
            }
                msg_te.setText("");
        }
        catch(Exception e){}
        
    }//GEN-LAST:event_msg_seActionPerformed

    private void msg_teActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_teActionPerformed
        // TODO add your handling code here:
      
        
    }//GEN-LAST:event_msg_teActionPerformed

    private void msg_teKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_msg_teKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){        
             try{
                    
                    String msgo = "";
                    msgo = msg_te.getText().trim();
       
                    if(msgo.isEmpty())
                    {
        
                             alert_label.setText("No word is Entered !!!");
                    }
       
                  else if(!ch1.equalsIgnoreCase( Character.toString(msgo.charAt(0))))
                        {   
            
                                dout1.writeUTF("9999");
                       
                                timer.stop();
                                count=16;
                                time_label.setText("");
                                alert_label.setText("");
                                msg_ch.setText("");
                                msg_se.setEnabled(false);
                                msg_te.setEditable(false);
                                JOptionPane.showMessageDialog(null,"OOPS ! You have Entered a WRONG WORD !");

        
                        }
        
                    else{
       
                                 dout1.writeUTF(msgo);
                                 timer.stop();
                                 count=16;
                                 time_label.setText(""); 
                                 alert_label.setText("");
                                 msg_ch.setText("");
                                 msg_se.setEnabled(false);
                                 msg_te.setEditable(false);
                                 JOptionPane.showMessageDialog(null,"Word Successfully Sent ! ");
                                 
                        }
                               msg_te.setText("");  
        
               }
                    catch(Exception e){}
            
             }
        
    }//GEN-LAST:event_msg_teKeyPressed

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
            java.util.logging.Logger.getLogger(chat_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chat_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chat_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chat_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chat_client().setVisible(true);
            }
        });
        
      
        
        try{
            
             s1 = new Socket("192.168.195.87",8085);
             dis1 = new DataInputStream(s1.getInputStream());
           
             dout1 = new DataOutputStream(s1.getOutputStream());
             
              String choice = "";
              String msg = "";
         
           while(true){  
             
               if(!choice.equals("exit"))
               {    
                   choice = dis1.readUTF();
               }
               
            switch(choice)
            {
                case "charmsg" :    if(!msg.equals("exit"))
                                      {
                
                                            msg = dis1.readUTF();
                                           
                                            ch1 = msg;
                                            msg_ch.setText("");
                                            msg_ch.setText(msg_ch.getText().trim()+""+msg);
                                            msg_te.setEditable(true);
                                            msg_se.setEnabled(true);
                       timer = new Timer(1000, (ActionEvent e) -> {
                    // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                   
                                            count--;
                                            time_label.setText(count+"");
                   
                                            if(count==0)
                                             {
                                                  count=16;
                                                  time_label.setText("");
                                               
                                                  abort();
                                                  timer.stop();
                   
                                                         try {
                                                               dout1.writeUTF("7777");
                                                             } catch (IOException ex) { }
                                              // Logger.getLogger(chat_client.class.getName()).log(Level.SEVERE, null, ex);
                                                             msg_ch.setText("");
                                                             msg_se.setEnabled(false);
                                                             msg_te.setEditable(false);
                                                             msg_te.setText(""); 
                                                             JOptionPane.showMessageDialog(null,"Your time has Expired !");
                                                   
                                              }
                                            });
                                                  timer.start();
               
                                      }            
                                      break;
                
                case "acceptmsg" :      if(!msg.equals("exit"))
                                        {
                                            msg = dis1.readUTF();
                                            msg_ar.setText(msg_ar.getText().trim()+"\n "+msg);
                                        }
                                         break;
                                                
                                        
                                       
           
                                        
                  case "rejectmsg" :      if(!msg.equals("exit"))
                                            {
                                                 msg = dis1.readUTF();
                                                 msg_ar1.setText(msg_ar1.getText().trim()+"\n "+msg); 
                                                                                                        
                                            }
                                            break;
            
                   case "gameover" :     JOptionPane.showMessageDialog(null," GAME OVER !!! ");
                   
                                            break;
                                            
                       }
         
         }


        }catch(IOException e){
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alert_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private static javax.swing.JTextArea msg_ar;
    private static javax.swing.JTextArea msg_ar1;
    private static javax.swing.JLabel msg_ch;
    private static javax.swing.JButton msg_se;
    private static javax.swing.JTextField msg_te;
    private static javax.swing.JLabel time_label;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
         //To change body of generated methods, choose Tools | Templates.
         setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("celogo.png")));
    }
}