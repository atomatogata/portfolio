package fw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//検索SQLを発行して、結果をオブジェクトのListに入れて返す
// ReesultSetからListへの変換は、ResultSetBeanMappingが行う

public class DBManager {

  //getConnection Statementの取得
  public static Connection getConnection() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jdbctestdb", "testuser", "testpass");
      return con;  
    } catch (Exception e) {
      throw new IllegalStateException(e);
    }
  }
  
  //更新SQLを発行する
  public static int simpleUpdate(String sql) throws SQLException {

    Connection con = null;
    Statement smt = null;
    try {
      con = DBManager.getConnection();
      smt = con.createStatement();
      //executeUpdate()メソッド　指定されたSQL文を実行するメソッド　SQL文はINSERT、UPDATE,DELETE等　返り値は変更sれた行数
      return smt.executeUpdate(sql);
    } finally {
      if(smt != null) {
        try {smt.close();} catch (SQLException ignore) {}
      }
      if (con != null) {
        try {con.close();} catch(SQLException ignore) {}
      }
    }
  }
 
    public static <T> List<T> simpleFind(String sql,ResultSetBeanMapping<T> mapping)throws SQLException {

    Connection con = null;
    Statement smt = null;
    try {
      con = DBManager.getConnection();
      smt = con.createStatement();
      ResultSet rs = smt.executeQuery(sql);
      
      List<T> list = new ArrayList<T>();
      while(rs.next()){
        T bean = mapping.createFromResultSet(rs);
        list.add(bean);
      }
      return list;

    } finally {
      if(smt != null) {
        try {smt.close();} catch (SQLException ignore) {}
      }
      if (con != null) {
        try {con.close();} catch(SQLException ignore) {}
      }
    }
  }
}