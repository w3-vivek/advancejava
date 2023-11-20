import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao implements AutoCloseable {

	private Connection connection;

	public BookDao() throws SQLException {

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

//----------------------------------------------------------------

	// delete query

	public int deleteBYId(int id) throws Exception {

		String sql = "delete from books where id=?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			int count = statement.executeUpdate();
			return count;
		} // statement.close();
	}

//----------------------------------------------------------------------

	// select query

	public List<Book> findAll() throws Exception {

		List<Book> list = new ArrayList<Book>();
		String sql = "select * from books";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			try (ResultSet rs = statement.executeQuery()) {

				while (rs.next()) {

					int id = rs.getInt("id");
					String name = rs.getString("name");
					String author = rs.getString("author");
					String subject = rs.getString("subject");
					double price = rs.getDouble("price");

					Book b = new Book(id, name, author, subject, price);
					list.add(b);

				}
			} // rs.close();

		} // statement.close();

		return list;

	}

//---------------------------------------------------------------------------------

	// select query by subject

	public List<Book> findBookBySubject(String subject) throws Exception {
		List<Book> list = new ArrayList<>();
		String sql = "select * from books where subject=?";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, subject);
			try (ResultSet result = statement.executeQuery()) {

				while (result.next()) {

					int id = result.getInt("id");
					String name = result.getString("name");
					String author = result.getString("author");
					subject = result.getString("subject");
					double price = result.getDouble("price");

					Book book = new Book(id, name, author, subject, price);
					list.add(book);

				}

			}

		}

		return list;

	}

//-----------------------------------------------------------------------------------	

	// select query by id

	public Book findById(int id) throws Exception {

		String sql = "select * from books where id=?";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setInt(1, id);
			try (ResultSet result = statement.executeQuery()) {

				if (result.next()) {

					id = result.getInt("id");
					String name = result.getString("name");
					String author = result.getString("author");
					String subject = result.getString("subject");
					double price = result.getDouble("price");

					Book book = new Book(id, name, author, subject, price);
					return book;

				}

			} // result.close();

		} // statement.close();

		return null;
	}
//---------------------------------------------------------------------------------

	// update query

	public int update(Book b) throws Exception {
		String sql = "UPDATE books SET name=?, author=?, subject=?, price=? WHERE id=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, b.getName());
			stmt.setString(2, b.getAuthor());
			stmt.setString(3, b.getSubject());
			stmt.setDouble(4, b.getPrice());
			stmt.setInt(5, b.getId());
			int count = stmt.executeUpdate();
			return count;
		} // stmt.close();
	}

//---------------------------------------------------------------------------	

	// Distinct query

	public List<String> getSubjects() throws Exception {
		List<String> list = new ArrayList<>();

		String sql = "select distinct subject from books";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				String subject = result.getString("subject");
				list.add(subject);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}
//-------------------------------------------------------------------------

	//save query
	
	public int save(Book b) throws Exception {
		String sql = "insert into  books values(?,?,?,?,?)";
		try (PreparedStatement s = connection.prepareStatement(sql)) {
			s.setInt(1, b.getId());
			s.setString(2, b.getName());
			s.setString(3, b.getAuthor());
			s.setString(4, b.getSubject());
			s.setDouble(5, b.getPrice());
			
			int count = s.executeUpdate();
			return count;
		} // stmt.close();

		
//-----------------------------------------------------------------------		
		
	}



}
