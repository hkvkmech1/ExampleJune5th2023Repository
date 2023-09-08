package com.sginstitute.dbutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtility {
//Return number of records from given query from SQL
	public static int getRecordscount(String query) {
int rc=0;
Connection conn=null;
try
{
	Class.forName("Oracle.jdbcdriver.OracleDriver");
	conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","tiger");
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				rc=rc+1;
			}
}catch (Exception e)
{
	e.printStackTrace();
}
finally
{
	try
	{
		conn.close();
	}catch (Exception e)
	{
		e.printStackTrace();
	}
}
return rc;
	}
}
