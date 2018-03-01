package nrt;

import java.sql.*;
/**
 *
 * @author sonu
 */
public class SqlConnections {
    private static Connection con;
    private static Statement stmt;
    public SqlConnections(){
        try {
            String sqlBills = "CREATE TABLE IF NOT EXISTS bills (\n"
               + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
               + "	dealername text NOT NULL,\n"
               + "	material text NOT NULL,\n"
               + "	billno text NOT NULL,\n"
               + "	totalamount double ,\n"
               + "	paidamount double ,\n"
               + "	billdate text NOT NULL,\n"
               + "	addeddate text NOT NULL,\n"
               + "	addedby text NOT NULL\n"
               + ");";
            String sqlWorkers = "CREATE TABLE IF NOT EXISTS workers (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	name text NOT NULL,\n"
                + "	designation text NOT NULL,\n"
                + "	payrate text NOT NULL,\n"
                + "	addeddate text NOT NULL,\n"
                + "	addedby text NOT NULL\n"
                + ");";
            String sqlAttendance = "CREATE TABLE IF NOT EXISTS attendance (\n"
              + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
              + "	workerid integer NOT NULL,\n"
              + "	status text NOT NULL,\n"
              + "	statusdate text NOT NULL,\n"
              + "	addeddate text NOT NULL,\n"
              + "	addedby text NOT NULL\n"
              + ");";
            String sqlPayWorker = "CREATE TABLE IF NOT EXISTS payworker (\n"
              + "id integer PRIMARY KEY AUTOINCREMENT,\n"
              + "workerid integer NOT NULL,\n"
              + "paidamount text NOT NULL,\n"
              + "fromdate text,\n"
              + "todate text ,\n"
              + "ondate text ,\n"
              + "addeddate text NOT NULL,\n"
              + "addedby text NOT NULL\n"
              + ");";
            String SqlLogin = "CREATE TABLE IF NOT EXISTS user (\n"
              + "	id integer NOT NULL  PRIMARY KEY, AUTO_INCREMENT,\n"
              + "	username text NOT NULL,\n"
              + "	password text NOT NULL\n"
              + ");";
            
            String sqlAdminLogin = "insert or ignore into user (username , password) values ('admin' , 'admin');\n";
            Statement stmt = getStat();
            stmt.execute(SqlLogin);
            String check = "select * from user where username = 'admin'";
            ResultSet rs = stmt.executeQuery(check);
            if(!rs.next()){
               stmt.execute(sqlAdminLogin);
            }           
            stmt.execute(sqlBills);
            stmt.execute(sqlWorkers);
            stmt.execute(sqlAttendance);
            stmt.execute(sqlPayWorker);
        } catch (Exception e) {
            System.out.println(e.getMessage() );
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "InfoBox: " , javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }    
    public static Statement getStat() throws ClassNotFoundException, SQLException{
        if(con == null){
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:./database/database.db";
            con = DriverManager.getConnection(url);
            stmt = con.createStatement();
        }
        return stmt;
    }   
}
