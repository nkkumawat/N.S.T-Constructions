package nrt;

import java.sql.Statement;
import javax.swing.JFrame;

/**
 *
 * @author sonu
 */
public class Home extends javax.swing.JFrame {
    public Home() {
        initComponents();
        initMy();
    }
    public void initMy() {
        new SqlConnections();   
        UserName.setText("Welcome : " + SharedData.getLoginName());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        Attendance = new javax.swing.JButton();
        AddWorker = new javax.swing.JButton();
        Summery = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        UserName = new javax.swing.JLabel();
        CreateNewUser = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(779, 560));

        jButton1.setText("Bills");
        jButton1.setPreferredSize(new java.awt.Dimension(92, 27));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Attendance.setText("Attendance");
        Attendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttendanceActionPerformed(evt);
            }
        });

        AddWorker.setText("Add Worker");
        AddWorker.setPreferredSize(new java.awt.Dimension(92, 27));
        AddWorker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddWorkerActionPerformed(evt);
            }
        });

        Summery.setText("Summery");
        Summery.setPreferredSize(new java.awt.Dimension(92, 27));
        Summery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SummeryActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 48)); // NOI18N
        jLabel1.setText("N. S. T  CONSTRUCTIONS");

        UserName.setText("Welcome");

        CreateNewUser.setText("Create User");
        CreateNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateNewUserActionPerformed(evt);
            }
        });
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel1)
                        .addGap(0, 124, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(UserName)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Summery, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Attendance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CreateNewUser, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addComponent(AddWorker, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UserName)
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Attendance, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AddWorker, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Summery, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateNewUser, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(224, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Pay pay = new Pay();
        pay.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pay.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
      
    private void AttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttendanceActionPerformed
        AllWorkers allWorker = new AllWorkers();
        allWorker.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        allWorker.setVisible(true);
    }//GEN-LAST:event_AttendanceActionPerformed

    private void AddWorkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddWorkerActionPerformed
       
        AddWorker addWorker = new AddWorker();
        addWorker.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWorker.setVisible(true);
    }//GEN-LAST:event_AddWorkerActionPerformed

    private void SummeryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SummeryActionPerformed
        Summery summery = new Summery();
        summery.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        summery.setVisible(true);
    }//GEN-LAST:event_SummeryActionPerformed

    private void CreateNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateNewUserActionPerformed
        SignUp signup = new SignUp();
        signup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        signup.setVisible(true);
    }//GEN-LAST:event_CreateNewUserActionPerformed
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddWorker;
    private javax.swing.JButton Attendance;
    private javax.swing.JButton CreateNewUser;
    private javax.swing.JButton Summery;
    private javax.swing.JLabel UserName;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
