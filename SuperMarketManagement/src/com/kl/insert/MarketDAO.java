package com.kl.insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.klu.Bean.MarketBean;
import com.klu.Connections.DBUtil;

public class MarketDAO {
	public int Insert(MarketBean sales) throws ClassNotFoundException, SQLException
	{
		Connection con=DBUtil.DBConnection();
		PreparedStatement s1=con.prepareStatement("insert into sales values(?,?,?)");
		s1.setInt(1,sales.getItemid());
		s1.setString(2,sales.getItemname());
		s1.setInt(3, sales.getCost());
		int i=s1.executeUpdate();
		con.close();
		return i;
	}
	public void display() throws ClassNotFoundException, SQLException
	{
	  Connection con=DBUtil.DBConnection();
	  PreparedStatement display=con.prepareStatement("Select * from Sales");  
	  ResultSet rs=display.executeQuery();    
	  while(rs.next()){  
	  System.out.println("ItemID:- "+rs.getInt(1)+"----"+"ItemName:- "+rs.getString(2)+"----"+"ItemCost:- "+rs.getInt(3));  
	  }  
	  con.close();  
	}
	public int totcost() throws ClassNotFoundException, SQLException
	{
		Connection con=DBUtil.DBConnection();
		PreparedStatement ps=con.prepareStatement("Select sum(cost) FROM sales;");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			System.out.println("Total cost of items:-"+rs.getInt(1));
		}
		int i=ps.executeUpdate();
		con.close();
		return i;
	}
}
