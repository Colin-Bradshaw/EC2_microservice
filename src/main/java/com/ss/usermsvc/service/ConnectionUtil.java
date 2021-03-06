/**
 * 
 */
package com.ss.usermsvc.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Colin Bradshaw
 *
 */
@Service
public class ConnectionUtil {
	public final String driver = "com.mysql.cj.jdbc.Driver";
	public final String url = "jdbc:mysql://172.18.0.2:3306/utopia";
	public final String username = "root";
	public final String password = "A1l1ngAgedAlb@tross";

	@Bean
	public Connection getConnection() {
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(Boolean.FALSE);
			return conn;
		} catch (ClassNotFoundException c){
			c.printStackTrace();
		} catch (SQLException s){
			s.printStackTrace();
		}
		return null;
	}

}
