package com.klu.Main;

import java.sql.SQLException;
import java.util.Scanner;

import com.kl.insert.MarketDAO;
import com.klu.Bean.MarketBean;

public class Marketmain {
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
	  Scanner s=new Scanner(System.in);
	  MarketBean sb=new MarketBean();
	  MarketDAO sc=new MarketDAO();
	  System.out.println("1.INSERT");
	  System.out.println("2.DISPLAY");
	  System.out.println("3.TOTAL COST");
	  System.out.println("Enter choice");
	  int ch=s.nextInt();
	  switch(ch) 
	  {
	    case 1:
	      System.out.println("Enter itemid,itemname,itemcost");
	      int itemid=s.nextInt();
	      String itemname=s.next();
	      int cost=s.nextInt();
	        sb.setItemid(itemid);
	        sb.setItemname(itemname);
	        sb.setCost(cost);
	      int num=sc.Insert(sb);
	      if(num>0)
	      {
	        System.out.println("Insertion successful");
	      }
	      else
	      {
	        System.out.println("Insertion unsuccessful");
	      }
	      break;
	    case 2:
	    	 sc.display();
		      break;
	    case 3:
	    	sc.totcost();
	        break;
	    default:
		      System.out.println(" Please enter correct choice number from above list");
	                    break;
	  }
	}
  }