package fw;

import java.sql.ResultSet;
import java.sql.SQLException;

//インターフェース
public interface ResultSetBeanMapping<T> {
  //reateFromResultSet()メソッド ResultSetを引数にオブジェクトを返す
  // オブジェクトを生成し、ResultSetから取得したデータをセットして返す
	//返り値が T
	//引数が ResultSet型のrs変数
  public T createFromResultSet(ResultSet rs) throws SQLException;
  
}

