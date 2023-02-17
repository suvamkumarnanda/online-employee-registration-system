package com.sm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sn.dao.EmpDao;
import com.sn.model.Emp;  
@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet {  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.print("<marquee>Online Employee Registration System</marquee><br><br>");

        out.println("<h1>Employees List</h1>");  
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
           		+ "  color:Black;\r\n"
           		+" background-color:white;\r\n"
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
           out.print("<head><style>button{color:white;\r\n"
           		+ "   font-size: medium;\r\n"
           		+ "   font-style: normal;\r\n"
           		+ "   font-weight: bold;\r\n"
           		+ "   border:none;\r\n"
           		+ "   background-color: green;\r\n"
           		+ "   cursor: pointer;\r\n"
           		+ "   padding: 4px 8px;"
           		+ "}</style></head>");
           out.print("<head><style>a{"
           		+ "color:black"
           		+ "}</style></head>");
           out.print("<div align='center'>");
        List<Emp> list=EmpDao.getAllEmployees();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th>  <th>Edit</th><th>Delete</th></tr>");  
        for(Emp e:list){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPassword()+"</td>  <td>"+e.getEmail()+"</td><td>"+e.getCountry()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td>   <td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
        out.println("<br><button ><a href='index.html' >Add New Employee</button></a>");  
        out.close();  
    }  
}  