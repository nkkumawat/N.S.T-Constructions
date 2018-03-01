package nrt;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.print.PrinterException;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author sonu
 */
public class Summery extends javax.swing.JFrame {
    public Summery() {
        initComponents();
        initMy();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        SummeryTable = new javax.swing.JTable();
        FromDate = new org.jdesktop.swingx.JXDatePicker();
        ToDate = new org.jdesktop.swingx.JXDatePicker();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Search = new javax.swing.JButton();
        Print = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(779, 560));

        SummeryTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(SummeryTable);

        jLabel1.setText("From");

        jLabel2.setText("To");

        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        Print.setText("Print");
        Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintActionPerformed(evt);
            }
        });

        jButton1.setText("Save To Pdf");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FromDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ToDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(Search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Print, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FromDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ToDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(Search)
                        .addGap(28, 28, 28)
                        .addComponent(Print)
                        .addGap(28, 28, 28)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        try{
            DateFormat dateFormatYear = new SimpleDateFormat("yyyy");
            DateFormat dateFormatMon = new SimpleDateFormat("MM");
            String fromDYear = dateFormatYear.format(FromDate.getDate());
            String fromDMon = dateFormatMon.format(FromDate.getDate());
            String toDYear = dateFormatYear.format(ToDate.getDate());
            String toDMon = dateFormatMon.format(ToDate.getDate());
            String searchLikeFrom  , searchLikeTo;
            searchLikeFrom = fromDYear+"/"+fromDMon; 
            searchLikeTo = toDYear+"/"+toDMon; 
            Statement stmt = SqlConnections.getStat();
            String sql = "select * from bills where  billdate like  '"+searchLikeFrom+"%' or  billdate like  '"+searchLikeTo+"%' order by id desc ";
            ResultSet rs = stmt.executeQuery(sql);
            SummeryTable.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e) {
            System.out.print(e.getMessage());
            javax.swing.JOptionPane.showMessageDialog(null, "Something went Wrong", "InfoBox: " , javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_SearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        SaveToPdf()();
        createPdf(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintActionPerformed
        try{
            SummeryTable.print();
        }catch(PrinterException ex){
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage(), "InfoBox: " , javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_PrintActionPerformed
    public void initMy() {
        try{
            String sql = "select * from bills order by id desc";
            Statement stmt = SqlConnections.getStat();
            ResultSet rs = stmt.executeQuery(sql);
            SummeryTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            javax.swing.JOptionPane.showMessageDialog(null, "Something went Wrong", "InfoBox: " , javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
    
    public void createPdf(boolean shapes) {
        try{
            int count=SummeryTable.getRowCount();
            int column = SummeryTable.getColumnCount();
            Document document=new Document();
                   PdfWriter.getInstance(document,new FileOutputStream("./print/"+SharedData.getLoginName() +"_"+ new Date().getSeconds()+new Date().getMinutes()+".pdf"));
                   document.open();
                   PdfPTable tab = new PdfPTable(column);
                   for(int j = 0 ; j < column ; j ++){
                       tab.addCell(SummeryTable.getColumnName(j));
                   }
            for(int i=0;i<count;i++){
                for(int j = 0 ; j < column ; j ++){
                    Object obj1 = GetData(SummeryTable, i, j);
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
            java.util.logging.Logger.getLogger(Summery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Summery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Summery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Summery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Summery().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker FromDate;
    private javax.swing.JButton Print;
    private javax.swing.JButton Search;
    private javax.swing.JTable SummeryTable;
    private org.jdesktop.swingx.JXDatePicker ToDate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
