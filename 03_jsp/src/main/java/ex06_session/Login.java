package ex06_session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  // 요청 인코딩
	  request.setCharacterEncoding("UTF-8");
	  
	  // 요청 파라미터
	  String id = request.getParameter("id");
	  String pw = request.getParameter("pw");
	  
	  // 로그인 성공 규칙 : id 와 pw가 동일하면 로그인 성공으로 가정하고 풀이
	  if(id.equals(pw)) {
	    // 로그인 처리 : session에 id를 저장해 두기
	    HttpSession session = request.getSession();          // 세션 생성 및 얻기
	    session.setAttribute("id", id);                      // 세션에 id라는 이름의 세션 값 저장
	    session.setMaxInactiveInterval(60 * 10);             // 초 기준(10분간 세션 유지)
	    
	    
	  }
	
	  // main 화면으로 되돌아가기
	  response.sendRedirect(request.getContextPath() + "/ex06_session/main.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
