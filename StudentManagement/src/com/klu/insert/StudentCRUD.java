package com.klu.insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.klu.Bean.StudentBean;
import com.klu.Connections.DBUtil;

public class StudentCRUD {
	static Scanner s=new Scanner(System.in);
public int StudentInsert(StudentBean student) throws ClassNotFoundException, SQLException
{
	Connection con=DBUtil.DBConnection();
	PreparedStatement s1=con.prepareStatement("insert into Student values(?,?,?)");
	s1.setInt(1,student.getRegno());
	s1.setString(2,student.getName());
	s1.setString(3, student.getEmail());
	int i=s1.executeUpdate();
	con.close();
	return i;
	
}
public int Sdelete() throws ClassNotFoundException, SQLException
{
  System.out.println("ENTER REGNO: ");
  int reno=s.nextInt();
  Connection con=DBUtil.DBConnection();
  PreparedStatement delete=con.prepareStatement(" delete from Student where regno=?");  
  delete.setInt(1,reno);  
  int k=delete.executeUpdate();    
  con.close();  
  return k;
}
public int Supdate() throws ClassNotFoundException, SQLException
{
  System.out.println("ENTER COLUMN NAME  AND REGNO ");
  String col=s.next();
  int reno=s.nextInt();
  Connection con=DBUtil.DBConnection();
  PreparedStatement update=con.prepareStatement("update Student set name=? where regno=?");  
  update.setString(1,col);
  update.setInt(2,reno); 
  int k=update.executeUpdate();    
  con.close();  
  return k;
}

public void Sdisplay() throws ClassNotFoundException, SQLException
{
  System.out.println("STUDENTS LIST ");
  Connection con=DBUtil.DBConnection();
  PreparedStatement display=con.prepareStatement("Select * from Student");  
  ResultSet rs=display.executeQuery();    
  while(rs.next()){  
  System.out.println("Regno:- "+rs.getInt(1)+"----"+"Name:- "+rs.getString(2)+"----"+"Email:- "+rs.getString(3));  
  }  
  
  con.close();  
}

}