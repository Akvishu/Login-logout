import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class Profile extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		String e=req.getParameter("email");
		PrintWriter out=res.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<center><h1>My Login-Logout Application</h1>");
		out.print("<hr>");
		try{
			Class.forName("com.mysql.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/akash","root","vishal");
				Statement st = c.createStatement();
			 ResultSet rs=st.executeQuery("select * from login_logout where email='"+e+"'");
			if(rs.next()){
				out.print("Welcome  "+rs.getString("name")+"  Sir <br>");
				out.print(" <a href='index.html'>Logout</a> <hr>");
				out.print("Email: "+rs.getString("email")+"<br><br>");
				out.print("Phone: "+rs.getString("phone")+"<br><br>");
				out.print("Age: "+rs.getInt("age")+"<hr>");
			}else{
				out.print("Email does not exist !<br><br>");
			}
			c.close();
		}catch(Exception ex){
			out.print(ex);
		}
		out.print("</center></body>");
		out.print("</html>");
	}
}