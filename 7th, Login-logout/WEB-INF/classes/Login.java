import javax.servlet.*;
import javax.servlet.http.*;
import java.io.* ;
import java.sql.*;
public class Login extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res){
		PrintWriter out = null;
		try{
			res.setContentType("text/html");
			out=res.getWriter();
			String email = req.getParameter("email");
			String pass = req.getParameter("pass");

				out.print("<html><body>");
			Class.forName("com.mysql.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/akash","root","vishal");
				Statement st = c.createStatement();
				ResultSet rs=st.executeQuery("select * from login_logout where email='"+email+"' and pass='"+pass+"'");
				if(rs.next()){
					
				RequestDispatcher rd=req.getRequestDispatcher("Profile");
			     rd.forward(req,res);
			     out.close();}				}
				else
				{
					
					res.sendRedirect("wrongentry.html");
					out.close();				}
					out.print("</body></html>");
				}catch(Exception e){
					out.print(e);
		}
	}

