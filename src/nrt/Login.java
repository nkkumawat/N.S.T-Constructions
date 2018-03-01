package nrt;

import java.io.*;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer; 
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import nrt.SqlConnections;
/**
 *
 * @author sonu
 */
public class Login extends javax.swing.JFrame {
    public Login() {
        initComponents();
        initMy();       
    }
    public void initMy() {
        File database = new File("database");
        if (!database.exists()) {
            try{
                database.mkdir();
            } 
            catch(SecurityException e){
                JPane.showMessageDialog(null, e.getMessage(), "InfoBox: " , JPane.INFORMATION_MESSAGE);
            }
        }
        File print = new File("print");
        if (!print.exists()) {
            try{
                print.mkdir();
            } 
            catch(SecurityException e){
                JPane.showMessageDialog(null, e.getMessage(), "InfoBox: " , JPane.INFORMATION_MESSAGE);
            }
        }
        new SqlConnections();
        try{
            File file = new File("login.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            if ((st = br.readLine()) != null){
                System.out.println(st);
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
                Date startDate =  dateFormat.parse(st);
                Date endDate  = new Date();
                endDate = dateFormat.parse(dateFormat.format(endDate));

                long duration  = endDate.getTime() - startDate.getTime();
                long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);
                System.out.println(diffInHours + "");
//                if(diffInHours < 24) {
//                    st = br.readLine();
//                    SharedData.setLoginName(st);
//                    this.setVisible(false);
//                    new Home().setVisible(true);
//                    
//                }
            }
        }catch (Exception e) {
            System.out.print("No File");
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UserName = new javax.swing.JTextField();
        Submit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        UserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserNameActionPerformed(evt);
            }
        });

        Submit.setText("Login");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel1.setText("LOGIN");

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Submit, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Password))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(Submit)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void UserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserNameActionPerformed
    }//GEN-LAST:event_UserNameActionPerformed
    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
        try {
            String username = UserName.getText();
            String password = Password.getText();
//            String sql = "insert into user(username , password) values('nk' , 'nk');";
            Statement stmt = SqlConnections.getStat();
//            stmt.execute(sql);
            String sql = "select * from user where username = '"+username+"';";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next() && rs.getString("password").equals(password)) {
                SharedData.setLoginName(username);
                try {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
                    java.util.Date date = new java.util.Date();
                    Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("login.txt" , true), "utf-8") );
                    writer.write(dateFormat.format(date)+"      ");
                    writer.write(username +"\n \n \n");
                    writer.close();
                    this.setVisible(false);
                    new Home().setVisible(true);
                }catch(Exception e) {
                    JPane.showMessageDialog(null, e.getMessage(), "InfoBox: " , JPane.INFORMATION_MESSAGE);
                }
                
            }else {
                System.out.print("NOT Found");
                JPane.showMessageDialog(null, "USER NOT FOUND", "InfoBox: " , JPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            JPane.showMessageDialog(null, ex.getMessage() , "InfoBox: " , JPane.INFORMATION_MESSAGE);
        } 
    }//GEN-LAST:event_SubmitActionPerformed
    public static void main(String args[]) throws ClassNotFoundException {
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
        // SQL statement for creating a new table   
//        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Password;
    private javax.swing.JButton Submit;
    private javax.swing.JTextField UserName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JOptionPane JPane;
}
