package com.sn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sn.model.Emp;  
  
public class EmpDao {  
	private static Connection con=null;  
    public static Connection getConnect(){  
    	String url;
        
        try{  
        	url="jdbc:oracle:thin:@localhost:1521:orcl";
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            con=DriverManager.getConnection(url,"C##ORACLE","oracle");  
            
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    
    //method for insertion of employee details
    public static int save(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnect();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into user905(ID,NAME,PWORD,EMAIL,COUNTRY)  values (?,?,?,?,?)");  
          
            ps.setInt(1, e.getId());
            ps.setString(2,e.getName());  
            ps.setString(3,e.getPassword());  
            ps.setString(4,e.getEmail());  
            ps.setString(5,e.getCountry());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
            return status;  
    }  
    
    //logic to update employee data
    
    public static int update(Emp e){  
        int status=0;  
        try{  
        	Connection con=EmpDao.getConnect();  
            PreparedStatement ps=con.prepareStatement(  
                         "update user905 set name=?,pword=?,email=?,country=? where id=?");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getPassword());  
            ps.setString(3,e.getEmail());  
            ps.setString(4,e.getCountry());  
            ps.setInt(5,e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    
    //logic to delete the employee details
    
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnect();  
            PreparedStatement ps=con.prepareStatement("delete from user905 where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    
    //logics to get the employee details based on ID
    
    public static Emp getEmployeeById(int id){  
        Emp e=new Emp();  
          
        try{  
            Connection con=EmpDao.getConnect();  
            PreparedStatement ps=con.prepareStatement("select * from user905 where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                e.setCountry(rs.getString(5));  
            }  
           con.close();
        }catch(Exception ex)
        {
        	ex.printStackTrace();
        	}
		return e;  
          
        
    }  
    
    //logic to get all the details of the employee
    
    public static List<Emp> getAllEmployees(){  
        List<Emp> list=new ArrayList<Emp>();  
          
        try{  
            Connection con=EmpDao.getConnect();  
            PreparedStatement ps=con.prepareStatement("select * from user905");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Emp e=new Emp();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                e.setCountry(rs.getString(5));  
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}  
