package wiki;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fw.DBManager;
import fw.ResultSetBeanMapping;

public class WikiPageDAO {



  // ResultSetの１行をWikiPageのインスタンスに変換するクラス
  // ここでしか利用されないので、無名クラスとして、この場所でインスタンス化する
//ジェネリクスによりデータ型をWikiPageに制限したResultSetBeanMappingインターフェース
  private ResultSetBeanMapping<WikiPage> allMapping =
//		  無名クラスとして定義、実装していく
  new ResultSetBeanMapping<WikiPage>(){

    public WikiPage createFromResultSet(ResultSet rs) throws SQLException {
//無名クラスの実装内容 rsで取得した内容をpageにセットしてpegeを返す
      WikiPage page = new WikiPage();
      page.setName(rs.getString("name"));
      page.setContent(rs.getString("content"));
      page.setUpdateTime(rs.getTimestamp("update_time"));
      return page;
    }
  };



  // このクラスのインスタンスを取得します
  public static WikiPageDAO getInstance(){
    return new WikiPageDAO();
  }



  // 全件検索を行います
  // 戻り値はWikiPageオブジェクトのListです
  public List<WikiPage> findAll() throws SQLException {
    String sql = "SELECT * FROM wiki_page" + " ORDER BY update_time DESC";
    return DBManager.simpleFind(sql,allMapping);
  }



  //指定した名前に一致するレコードを検索する
  public WikiPage findByName(String name) throws SQLException {
    String sql = "SELECT * FROM wiki_page" + " WHERE name='" + name + "'";

    List<WikiPage> list = DBManager.simpleFind(sql, allMapping);
    if(list.size() == 0){
      return null;
    }else if(list.size() > 1){
      throw new IllegalArgumentException("record > 1");
    }
    return list.get(0);
  }




  // 指定したWikiPageを元にINSERTを実行する
  public void insert(WikiPage page) throws SQLException {
    String sql = "INSERT INTO wiki_page (name, content)"
                + " VALUES("
                + "'" + page.getName() + "'"
                + ",'" + page.getContent() + "'"
                + ")";
    DBManager.simpleUpdate(sql);
  }




  // 指定したWikiPageを元にUPDATEを実行する
  public void update(WikiPage page) throws SQLException {
    String sql = "UPDATE wiki_page "
    +" SET "
    +" content='" + page.getContent() + "'"
    +" WHERE name='" + page.getName() + "'";
    DBManager.simpleUpdate(sql);
  }



  //指定したWikiPageを元にDELETEを実行する
  public void delete(WikiPage page) throws SQLException {
    String sql = "DELETE FROM wiki_page WHERE name='"
    + page.getName() + "'";
    DBManager.simpleUpdate(sql);
  }




}
