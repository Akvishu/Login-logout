import javax.servlet.*;
import javax.servlet.http.*;
import java.io.* ;
import java.sql.*;
public class Add extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		PrintWriter out = null;
		try{
			res.setContentType("text/html");
			out=res.getWriter();
			String email = req.getParameter("email");
			String name = req.getParameter("name");
			String phone = req.getParameter("phone");
			int age = Integer.parseInt (req.getParameter("age"));
			String pass = req.getParameter("pass");
			Class.forName("com.mysql.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/akash","root","vishal");
				Statement st = c.createStatement();
				st.executeUpdate( "insert into login_logout values ('"+email+"','"+name+"','"+phone+"',"+age+",'"+pass+"')");
				out.print("<html><body>");
				RequestDispatcher rd=req.getRequestDispatcher("Profile");
			     rd.forward(req,res);
				
				out.print("</body></html>");
				out.close();
		}catch(SQLIntegrityConstraintViolationException ex)
			{
			res.sendRedirect("alreadyexist.html");
			}
		catch(Exception e){
			out.print(e);
		}
	}
}
