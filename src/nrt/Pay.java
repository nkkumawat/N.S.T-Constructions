package nrt;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;

/**
 *
 * @author sonu
 */
public class Pay extends javax.swing.JFrame implements FocusListener {
    public Pay() {
        initComponents();
        initMy();
    }
    private void initMy() {
        Welcome.setText("Welcome : " + SharedData.getLoginName());
        RemainingAmount.setEditable(false);
        TotalAmount.setText("0");
        AmountPaid.setText("0");
        updateRemaining();
        TotalAmount.addFocusListener(this);
        AmountPaid.addFocusListener(this);
    }    
    public void updateRemaining(){
        String totv = TotalAmount.getText();
        String pai = AmountPaid.getText();
        if(!totv.equals("") && ! pai.equals("")){
            Double tot = Double.valueOf(totv);
            Double paid = Double.valueOf(pai);
            Double remaining = tot - paid;
            RemainingAmount.setText("" +remaining );
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        DealerName = new javax.swing.JTextField();
        MaterialName = new javax.swing.JTextField();
        BillNo = new javax.swing.JTextField();
        TotalAmount = new javax.swing.JTextField();
        AmountPaid = new javax.swing.JTextField();
        RemainingAmount = new javax.swing.JTextField();
        Welcome = new javax.swing.JLabel();
        Pay = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        BillDate = new org.jdesktop.swingx.JXDatePicker();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(779, 560));

        jLabel1.setText("Dealer Name");

        jLabel2.setText("Material Name");

        jLabel3.setText("Bill No");

        jLabel4.setText("Total Amount");

        jLabel5.setText("Amount Pay ");

        jLabel6.setText("Remaining");

        DealerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DealerNameActionPerformed(evt);
            }
        });

        TotalAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalAmountActionPerformed(evt);
            }
        });

        AmountPaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmountPaidActionPerformed(evt);
            }
        });

        Pay.setText("Pay");
        Pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayActionPerformed(evt);
            }
        });

        jLabel7.setText("Bill Date");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel8.setText("Bill History");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Welcome))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(Pay, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(RemainingAmount)
                                    .addComponent(DealerName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(MaterialName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BillNo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TotalAmount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(BillDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(AmountPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(134, 134, 134)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(Welcome)
                .addGap(12, 12, 12)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DealerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MaterialName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BillNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(BillDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(AmountPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(TotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(RemainingAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addGap(77, 77, 77)
                .addComponent(Pay, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DealerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DealerNameActionPerformed
   
    }//GEN-LAST:event_DealerNameActionPerformed
    private void PayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayActionPerformed
        try  {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            String dealerName = DealerName.getText();
            String materialName = MaterialName.getText();
            String billNo = BillNo.getText();
            String billDate = dateFormat.format(BillDate.getDate());
            String todayDate = dateFormat.format(date);
            Double totalAmount = Double.parseDouble(TotalAmount.getText());
            Double amountPaid = Double.parseDouble(AmountPaid.getText());
            Double remainingAmount = Double.parseDouble(RemainingAmount.getText());
            String sql = "insert into bills(dealername, material, billno,\n "
                    + "totalamount, paidamount, billdate, addeddate, addedby) values( \n"
                    + "'"+dealerName+"',\n"
                    + "'"+materialName+"',\n"
                    + "'"+billNo+"',\n"
                    + "'"+totalAmount+"',\n"
                    + "'"+amountPaid+"',\n"
                    + "'"+billDate+"',\n"
                    + "'"+todayDate+"',\n"
                    + "'"+SharedData.getLoginName()+"');";
            Statement stmt = SqlConnections.getStat();
            stmt.execute(sql);
            this.setVisible(false);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "InfoBox: " , javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_PayActionPerformed
    public void focusGained(FocusEvent e) {
        updateRemaining();
    }
    public void focusLost(FocusEvent e) {
        updateRemaining();
    }
    private void TotalAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalAmountActionPerformed
        updateRemaining();
    }//GEN-LAST:event_TotalAmountActionPerformed
    private void AmountPaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmountPaidActionPerformed
        updateRemaining();
    }//GEN-LAST:event_AmountPaidActionPerformed
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
            java.util.logging.Logger.getLogger(Pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pay().setVisible(true);
            }
        }); 
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AmountPaid;
    private org.jdesktop.swingx.JXDatePicker BillDate;
    private javax.swing.JTextField BillNo;
    private javax.swing.JTextField DealerName;
    private javax.swing.JTextField MaterialName;
    private javax.swing.JButton Pay;
    private javax.swing.JTextField RemainingAmount;
    private javax.swing.JTextField TotalAmount;
    private javax.swing.JLabel Welcome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
