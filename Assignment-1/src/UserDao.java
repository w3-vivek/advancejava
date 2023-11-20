import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements AutoCloseable {

	private Connection connection;

	public UserDao() throws Exception {

		connection = DbUtil.getConnection();
	}

	@Override
	public void close() {

		try {

			if (connection != null) {

				connection.close();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	// -------------------------------------------------------------

	public User findByEmail(String email) throws Exception {
		String sql = "SELECT * FROM users WHERE email=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, email);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String password = rs.getString("password");
					String mobile = rs.getString("mobile");
					email = rs.getString("email");
					String address = rs.getString("address");
					Date birth = rs.getDate("birth");
					int enabled = rs.getInt("enabled");
					String role = rs.getString("role");
					User u = new User(id, name, password, mobile, email, address, birth, enabled, role);
					return u;
				}
			} // rs.close();
		} // stmt.close();
		return null;
	}
//------------------------------------------------------------

	// save query

	public int save(User u) throws Exception {
		String sql = "insert into  books values(?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement s = connection.prepareStatement(sql)) {
			s.setInt(1, u.getId());
			s.setString(2, u.getName());
			s.setString(3, u.getPassword());
			s.setString(4, u.getMobile());
			s.setString(5, u.getEmail());
			s.setString(6, u.getAddress());
			s.setDate(7, u.getBirth());
			s.setInt(8, u.getEnabled());
			s.setString(5, u.getRole());

			int count = s.executeUpdate();
			return count;
		} // stmt.close();

	}

//--------------------------------------------------------------------------

	public int update(User u) throws Exception {

		String sql = "UPDATE books SET name=?, password=?, mobile=?, email=?,"
				+ " address=?,birth=?,enabled=?,role=? WHERE id=?";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, u.getName());
			statement.setString(2, u.getPassword());
			statement.setString(3, u.getMobile());
			statement.setString(4, u.getEmail());
			statement.setString(5, u.getAddress());
			statement.setDate(6, u.getBirth());
			statement.setInt(7, u.getEnabled());
			statement.setString(8, u.getRole());
			statement.setInt(9, u.getId());

			int count = statement.executeUpdate();

			return count;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;

	}

//---------------------------------------------------------------	

	public int deleteBYId(int id) throws Exception {

		String sql = "delete from users where id=?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			int count = statement.executeUpdate();
			return count;
		} // statement.close();
	}

	// ----------------------------------------------------------------------

	public List<User> findAll() throws Exception {

		List<User> list = new ArrayList<User>();
		String sql = "select * from users";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			try (ResultSet rs = statement.executeQuery()) {

				while (rs.next()) {

					int id = rs.getInt("id");
					String name = rs.getString("name");
					String password = rs.getString("password");
					String mobile = rs.getString("mobile");
					String email = rs.getString("email");
					String address = rs.getString("address");
					Date birth = rs.getDate("birth");
					int enabled = rs.getInt("enabled");
					String role = rs.getString("role");

					User b = new User(id, name, password, mobile, email, address, birth, enabled, role);
					list.add(b);

				}
			} // rs.close();

		} // statement.close();

		return list;

	}

}
