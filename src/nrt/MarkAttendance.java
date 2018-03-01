package nrt;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import net.proteanit.sql.DbUtils;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.print.PrinterException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author sonu
 */
public class MarkAttendance extends javax.swing.JFrame {
    private String name = "";
    private String designation = "";
    private String rate = "";
    private int workerid = 0;
    private int totalAttendance = 0;
    public MarkAttendance() {
        initComponents();
        initMy();
    }
    public void initMy() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String todayDate = dateFormat.format(date);
        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        SimpleDateFormat df1 = new SimpleDateFormat("MM");
        String mon = df1.format(date);
        String year = df.format(date);
        try{
            String sql = "select * from workers where name='"+SharedData.getWorkerName()+"'";
            Statement stmt = SqlConnections.getStat();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                name = rs.getString("name");
                designation = rs.getString("designation");
                rate = rs.getString("payrate");
                workerid = rs.getInt("id");
            }
            setTable(mon , year);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            javax.swing.JOptionPane.showMessageDialog(null, "Something went Wrong", "InfoBox: " , javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
        WorkerName.setText("Name : " + SharedData.getWorkerName());
        Designation.setText("Designation : " +designation);
        Rate.setText("Rate : " +rate);
        Status.removeAllItems();
        Status.addItem("A");
        Status.addItem("P");   
        Month.removeAllItems();
        for(int i = 1 ; i <= 12 ; i ++) {
            if(i < 10){
                Month.addItem("0"+i);
            }else {
                Month.addItem(""+i);
            }
        }
        Year.removeAllItems();
        for(int i = 1 ; i <= 12 ; i ++) {
            Year.addItem(i+2015 + "");
        }   
        Month.setSelectedItem(mon);
        Year.setSelectedItem(year);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        WorkerName = new javax.swing.JLabel();
        Designation = new javax.swing.JLabel();
        Rate = new javax.swing.JLabel();
        ChooseDate = new org.jdesktop.swingx.JXDatePicker();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Status = new javax.swing.JComboBox<>();
        Save = new javax.swing.JButton();
        Total = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ShowAttendness = new javax.swing.JTable();
        Month = new javax.swing.JComboBox<>();
        Year = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        Search = new javax.swing.JButton();
        TotalAmount = new javax.swing.JLabel();
        Pay = new javax.swing.JButton();
        PayHistory = new javax.swing.JButton();
        SaveToPdf = new javax.swing.JButton();
        Print = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        UpdateInfo = new javax.swing.JButton();
        DeleteWorker = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(779, 560));

        WorkerName.setText("Name");

        Designation.setText("Designation");

        Rate.setText("Rate");

        jLabel1.setText("Date");

        jLabel2.setText("Status");

        Status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        Total.setText("Total Attendance");

        ShowAttendness.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(ShowAttendness);

        Month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setText("Search");

        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        TotalAmount.setText("Total Amount");

        Pay.setText("Pay");
        Pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayActionPerformed(evt);
            }
        });

        PayHistory.setText("Pay History");
        PayHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayHistoryActionPerformed(evt);
            }
        });

        SaveToPdf.setText("Save to Pdf");
        SaveToPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveToPdfActionPerformed(evt);
            }
        });

        Print.setText("Print");
        Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setText("Mark Attendance");

        UpdateInfo.setText("Update Info");
        UpdateInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateInfoActionPerformed(evt);
            }
        });

        DeleteWorker.setText("Delete Worker");
        DeleteWorker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteWorkerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Status, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(ChooseDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Rate)
                                    .addComponent(Designation)
                                    .addComponent(WorkerName))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TotalAmount))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                        .addComponent(DeleteWorker)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(UpdateInfo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Print)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SaveToPdf)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(PayHistory)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Pay, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Total)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Search)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(WorkerName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PayHistory)
                        .addComponent(SaveToPdf)
                        .addComponent(Pay)
                        .addComponent(Print)
                        .addComponent(UpdateInfo)
                        .addComponent(DeleteWorker))
                    .addComponent(Designation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Rate)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(Search))
                    .addComponent(jLabel4))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ChooseDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Save)
                    .addComponent(TotalAmount)
                    .addComponent(Total))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        try{
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            String todayDate = dateFormat.format(date);
            String recordDate = dateFormat.format(ChooseDate.getDate());
            String status = Status.getSelectedItem().toString();
            String sql = "insert into attendance(workerid, status, statusdate,\n "
                    + "addeddate, addedby) values( \n"
                    + "'"+workerid+"',\n"
                    + "'"+status+"',\n"
                    + "'"+recordDate+"',\n"
                    + "'"+todayDate+"',\n"
                    + "'"+SharedData.getLoginName()+"');";
            Statement stmt = SqlConnections.getStat();
            String check = "select * from attendance where statusdate = '"+recordDate+"' and workerid = '"+workerid+"'";
            ResultSet rs = stmt.executeQuery(check);
            if(rs.next()){
                throw new Exception("Already Marked");
            }
            stmt.execute(sql);
//            System.out.print(stmt);
            String mon = Month.getSelectedItem().toString();
            String year = Year.getSelectedItem().toString();
            setTable(mon , year);
            javax.swing.JOptionPane.showMessageDialog(null, "Saved", "InfoBox: " , javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "InfoBox: " , javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } 
    }//GEN-LAST:event_SaveActionPerformed
    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        String mon = Month.getSelectedItem().toString();
        String year = Year.getSelectedItem().toString();
        setTable(mon , year);
    }//GEN-LAST:event_SearchActionPerformed
    private void PayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayActionPerformed
        SharedData.setWorkerId(String.valueOf(workerid));
        PayToWorker paytoworker = new PayToWorker();
        paytoworker.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        paytoworker.setVisible(true);
    }//GEN-LAST:event_PayActionPerformed
    private void PayHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayHistoryActionPerformed
        try{
            Statement stmt = SqlConnections.getStat();
            String sql = "select * from payworker where workerid = '"+workerid+"' order by id desc";
            ResultSet rs = stmt.executeQuery(sql);
            ShowAttendness.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e) {
            System.out.print(e.getMessage());
            javax.swing.JOptionPane.showMessageDialog(null, "Something went Wrong", "InfoBox: " , javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_PayHistoryActionPerformed
    private void SaveToPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveToPdfActionPerformed
        SaveToPdf();
    }//GEN-LAST:event_SaveToPdfActionPerformed
    private void PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintActionPerformed
        try {
            ShowAttendness.print();
        } catch (PrinterException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage(), "InfoBox: " , javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_PrintActionPerformed

    private void UpdateInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateInfoActionPerformed
        UpdateWorker updateworker = new UpdateWorker();
        updateworker.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updateworker.setVisible(true);
    }//GEN-LAST:event_UpdateInfoActionPerformed

    private void DeleteWorkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteWorkerActionPerformed
        // TODO add your handling code here:\
      
        String sql = "delete from workers where id = '"+workerid+"';";           
        try {
            Statement stmt = SqlConnections.getStat();
            stmt.execute(sql);
            this.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DeleteWorkerActionPerformed
    public void setTable(String mon , String year) {
        try{
            String searchLike ;
            searchLike = year+"/"+mon;
            Statement stmt = SqlConnections.getStat();
            String sql = "select * from attendance where workerid = '"+workerid+"' and statusdate like  '"+searchLike+"%'";           
            ResultSet rs = stmt.executeQuery(sql);
            ShowAttendness.setModel(DbUtils.resultSetToTableModel(rs));
//            System.out.print(sql);
            Statement stmt1 = SqlConnections.getStat();
            String sql1 = "select * from attendance where workerid = '"+workerid+"' and statusdate like  '"+searchLike+"%'";
            ResultSet rs1 = stmt1.executeQuery(sql);
            int  totPre = 0 , totAbs = 0 , totAtt = 0;
            while(rs1.next()){
                if(rs1.getString("status").equals("P")){
                    totPre ++;
                }else {
                    totAbs ++;
                }
            }
            totAtt = totAbs + totPre;
            Double rateOfWorker = Double.parseDouble(rate);
            Double Tot = totPre * rateOfWorker;
            Total.setText("Total : " + totPre + " / "+ totAtt);
            TotalAmount.setText("Total Payable : " + Tot.toString());
        }catch(Exception e) {
            System.out.print(e);
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "InfoBox: " , javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private void SaveToPdf() {
//        Document document = new Document(PageSize.A4);
//        try {
//          PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("./print/"+SharedData.getWorkerName() + new Date().toString()+".pdf"));
//          document.open();
//          PdfContentByte cb = writer.getDirectContent();
//          cb.saveState();
//          Graphics2D g2 = cb.createGraphicsShapes(500, 500);
//          Shape oldClip = g2.getClip();
//          g2.clipRect(0, 0, 500, 500);
//          ShowAttendness.print(g2);
//          g2.setClip(oldClip);
//          g2.dispose();
//          cb.restoreState();
//          javax.swing.JOptionPane.showMessageDialog(null, "Saved to print Folder", "InfoBox: " , javax.swing.JOptionPane.INFORMATION_MESSAGE);
//        } catch (Exception e) {
//          System.err.println(e.getMessage());
//          javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "InfoBox: " , javax.swing.JOptionPane.INFORMATION_MESSAGE);
//        }
//        document.close();
        
        try{
            int count=ShowAttendness.getRowCount();
            int column = ShowAttendness.getColumnCount();
            Document document=new Document();
                   PdfWriter.getInstance(document,new FileOutputStream("./print/"+SharedData.getWorkerName() +"_"+ new Date().getSeconds()+new Date().getMinutes()+".pdf"));
                   document.open();
                   PdfPTable tab = new PdfPTable(column);
                   for(int j = 0 ; j < column ; j ++){
                       tab.addCell(ShowAttendness.getColumnName(j));
                   }
            for(int i=0;i<count;i++){
                for(int j = 0 ; j < column ; j ++){
                    Object obj1 = GetData(ShowAttendness, i, j);
                     String value1=obj1.toString();
                     tab.addCell(value1);
                }
            }
            document.add(tab);
            document.close();
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "InfoBox: " , javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
public Object GetData(JTable table, int row_index, int col_index){
        return table.getModel().getValueAt(row_index, col_index);
}
     
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
            java.util.logging.Logger.getLogger(MarkAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MarkAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MarkAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MarkAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MarkAttendance().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker ChooseDate;
    private javax.swing.JButton DeleteWorker;
    private javax.swing.JLabel Designation;
    private javax.swing.JComboBox<String> Month;
    private javax.swing.JButton Pay;
    private javax.swing.JButton PayHistory;
    private javax.swing.JButton Print;
    private javax.swing.JLabel Rate;
    private javax.swing.JButton Save;
    private javax.swing.JButton SaveToPdf;
    private javax.swing.JButton Search;
    private javax.swing.JTable ShowAttendness;
    private javax.swing.JComboBox<String> Status;
    private javax.swing.JLabel Total;
    private javax.swing.JLabel TotalAmount;
    private javax.swing.JButton UpdateInfo;
    private javax.swing.JLabel WorkerName;
    private javax.swing.JComboBox<String> Year;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
