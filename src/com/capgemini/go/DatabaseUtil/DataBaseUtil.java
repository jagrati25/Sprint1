package com.capgemini.go.DatabaseUtil;



	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
		
			public class DataBaseUtil {
				
				static Connection connection;
				
				static {
					try {
						DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				public static Connection myconnection() throws SQLException {
					if(connection==null)
						connection=DriverManager.getConnection
						("jdbc:oracle:thin:@localhost:1521:XE", "system", "jagratiaj");
					return connection;
				}
			}


