package tae.dbconnection.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import tae.jdbc.dbcp.Context;

public class ConnectionDB {
	private static final Log log = LogFactory.getLog(ConnectionDB.class);

	public static void main(String[] args) {
		Connection connection = null;
		try {
			Context context = new Context();
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			log.info("데이터베이스 연결 - " + connection);
		} catch (SQLException e) {
			log.info("데이터베이스 연결 실패 - " + e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
