package com.youtube.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.sun.corba.se.pept.transport.Connection;
import com.youtube.entity.YoutubeEmployee;

public class YoutubeDAO implements YoutubeDAOInterface {
private YoutubeDAO()
{}

	public static YoutubeDAOInterface createDAOObject() {
		// TODO Auto-generated method stub
		return new YoutubeDAO();
	}

	public int createProfileDAO(YoutubeEmployee ye) {
		// TODO Auto-generated method stub
		int i=0;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			java.sql.Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Zensar123");
			PreparedStatement ps=con.prepareStatement("insert into youtubeemployee values(?,?,?,?)");
			ps.setString(1,ye.getName());	
			ps.setString(2,ye.getPass());
			ps.setString(3,ye.getEmail());
			ps.setString(4,ye.getAddress());
			i=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}

		}

