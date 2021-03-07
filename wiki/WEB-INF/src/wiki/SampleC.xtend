package wiki;

public class SampleC {
  public static void main(String[] args) {
      String sql = "INSERT INTO wiki_page (name, content)"
                + " VALUES("
                + "'" + "A" + "'"
                + "'" + "B" + "'"
                + ")";
      System.out.println(sql);
  }
}