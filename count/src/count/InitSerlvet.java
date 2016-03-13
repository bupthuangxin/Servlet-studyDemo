package count;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
		String filePath=this.getServletContext().getRealPath("/record.txt");
		try {
			FileWriter fileWriter=new FileWriter(filePath);
			BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
			String nums=(String) this.getServletContext().getAttribute("nums");
			bufferedWriter.write(nums);
			bufferedWriter.close();
			fileWriter .close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
		String filePath=this.getServletContext().getRealPath("/record.txt");
		try {
			FileReader fileReader=new FileReader(filePath);
			BufferedReader bufferedReader=new BufferedReader(fileReader);
			String nums=bufferedReader.readLine();
			System.out.println(nums);
			this.getServletContext().setAttribute("nums", nums);
			bufferedReader.close();
			fileReader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
