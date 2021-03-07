package wiki;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ReferServlet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException,IOException{
	  
	//リクエストスコープからnameのパラメータを取得
    String name = request.getParameter("name");
    
    
    try{
// nameのパラメータがnullだったら、
      if(name != null){
//    	  WikiPage型の変数に、
        WikiPage wikiPage = WikiPageDAO.getInstance().findByName(name);
        HttpSession session = request.getSession();
        session.setAttribute("wikiPage", wikiPage);
      }
//  /refer.jspに画面遷移
      request.getRequestDispatcher("/refer.jsp").forward(request, response);
    } catch (SQLException e) {
      throw new ServletException(e);
    }
  }

}
