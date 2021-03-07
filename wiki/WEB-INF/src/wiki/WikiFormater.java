package wiki;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WikiFormater {

//	WikiPageが取得する内容 
  public String formatText(String text){

    text = escapeHtmlTags(text);//HTMLのタグを正規表現に置換
    text = createHyperLink(text);//
    text = addBrToEachLines(text); //改行を正規表現に置換
    return text;
  }

  //<BR>タグの追加
  private String addBrToEachLines(String text){

    text = text.replaceAll("[\n]", "<BR>\n");
    return text;
  }

  //<,>,タブの変換
  private String escapeHtmlTags(String text){

    text = text.replaceAll("<", "&lt");
    text = text.replaceAll(">", "&gt");
    text = text.replaceAll("\t", "   ");
    return text;
  }

  //リンクの作成
  private String createHyperLink(String text){
//	  Patternクラスはcompile()で渡された文字列を正規表現として解釈する
    Pattern pattern = Pattern.compile(
      "(mailto|http|https|htp):\\/\\/([^\\s]+)");
//    Pattern.matcher(検証したい文字列)を指定してMatcherインスタンスを作成する
    Matcher matcher = pattern.matcher(text);
    StringBuffer sb = new StringBuffer();

//    public boolean find()入力シーケンスの部分がこの正規表現エンジンのパターンとマッチした場合のみtrue
    while(matcher.find()){
//    	group()    	前回のマッチで一致した入力部分シーケンスを返します。
      String group = matcher.group();
      String repText = "<A HREF=\"" + group +  "\">"
                      + group +
                      "</A>";
      matcher.appendReplacement(sb, repText);
    }
    matcher.appendTail(sb);
    return sb.toString();
  }
}
