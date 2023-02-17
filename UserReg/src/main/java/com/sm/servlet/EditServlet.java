package com.sm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sn.dao.EmpDao;
import com.sn.model.Emp;  
@WebServlet("/EditServlet")  
public class EditServlet extends HttpServlet {  
    /**
	 *           
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        out.print("<marquee>Online Employee Registration System</marquee><br><br>");
        
        out.println("<h1>Update Employee</h1>");  
         
        int id=Integer.parseInt(request.getParameter("id"));  
          
        Emp e=EmpDao.getEmployeeById(id);  
       out.print("<head><style>.sub{color:white;\r\n"
       		+ "   font-size: medium;\r\n"
       		+ "   font-style: normal;\r\n"
       		+ "   font-weight: bold;\r\n"
       		+ "   border:none;\r\n"
       		+ "   background-color: green;\r\n"
       		+ "   cursor: pointer;\r\n"
       		+ "   padding: 4px 8px;\r\n"
       		+ "}</style></head>");
       out.print("<head><style>table{\r\n"
       		+ "  border:3px;\r\n"
       		+ "  color:Blue;\r\n"
       		+ "}</style></head>");
       out.print("<head><style>h1{\r\n"
       		+ "  color:Red;\r\n"
       		+ "  text-align: center;\r\n"
       		+ "  font-size: x-large; \r\n"
       		+ "  text-decoration: underline;\r\n"
       		+ "  \r\n"
       		+ "}</style></head>");
       out.print("<head><style>body{\r\n"
       		+ "  margin:100px;\r\n"
       		+ "  font-size:large;\r\n"
       		+ "  background-color: silver;\r\n"
       		+ "  \r\n"
       		+ "  }</style></head>");
       out.print("<head><style>input{\r\n"
       		+ "  font-size:large;\r\n"
       		+ " \r\n"
       		+ "  }</style></head>");
       out.print("<head><style> a {\r\n"
       		+ "  font-size:large;\r\n"
       		+ "  }</style></head>");
       out.print("<head><style>marquee{\r\n"
       		+ " font-size: 50px;\r\n"
       		+ " overflow: hidden;\r\n"
       		+ " position: relative;\r\n"
       		+ "}</style></head>");
       out.print("<div align='center'>");
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td>Id:</td><td><input type='text'   name='id' value='"+e.getId()+"'/></td></tr>");  
       
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");  
        out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+e.getPassword()+"'/>  </td></tr>");  
        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");  
        out.print("<tr><td>Country:</td><td>");  
        out.print("<select name='country' style='width:227px;height:27px'>");  
        out.print("<option>India</option>");  
        out.print("<option>USA</option>");  
        out.print("<option>UK</option>");  
        out.print("<option>Other</option>");  
        out.print("</select>");  
        out.print("</td></tr>");  
          
        out.print("</table>");  
        out.print("<input type='submit' value='Edit & Save ' class='sub'/>");
        out.print("</form>");  
        
        out.close();  
    }  
}  