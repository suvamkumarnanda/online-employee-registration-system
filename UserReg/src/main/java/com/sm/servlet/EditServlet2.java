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
@WebServlet("/EditServlet2")  
public class EditServlet2 extends HttpServlet {  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
 System.out.println("1-->"+request.getParameter("id"));
          int id=Integer.parseInt(request.getParameter("id"));  
        System.out.println("2--->"+request.getParameter("name"));
        String name=request.getParameter("name");  
        
        String password=request.getParameter("password");  
        System.out.println("2--->"+request.getParameter("password"));
        String email=request.getParameter("email");  
        System.out.println("2--->"+request.getParameter("email"));
        String country=request.getParameter("country");  
        System.out.println("2--->"+request.getParameter("country"));
          
        Emp e=new Emp();  
        e.setId(id);  
        e.setName(name);  
        e.setPassword(password);  
        e.setEmail(email);  
        e.setCountry(country);  
         System.out.println("--------------------"+e.toString()); 
        int status=EmpDao.update(e);  
        if(status>0){  
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}  
