package count;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		String password=request.getParameter("password");
		
		if("123".equals(password)){
			String nums = (String) this.getServletContext().getAttribute("nums");
			if(nums==null){
				this.getServletContext().setAttribute("nums", "1");
			}else{
				this.getServletContext().setAttribute("nums", (Integer.parseInt(nums)+1)+"");
			}
			//request.getRequestDispatcher("/Manager").forward(request, response);
			response.sendRedirect("/count/Manager");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
