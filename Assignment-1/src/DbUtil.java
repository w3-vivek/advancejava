import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";
	public static final String DB_USER = "w3_80747_vivek";
	public static final String DB_PASSWORD = "80747";

	static {

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.exit(0);
		}
	}

	public static Connection getConnection() throws SQLException {

		Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

		return connection;

	}

}
