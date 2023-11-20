import java.util.List;
import java.util.Scanner;

public class Demo3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
//		try (BookDao bdoa = new BookDao()){
//			
//			System.out.println("Enter book id for delete:");
//			int id = sc.nextInt();
//			int count = bdoa.deleteBYId(id);
//			System.out.println("Book deleted :"+count);
//			
//			
//			
//		}//bdao.close() ;
//		catch (Exception e) {
//			e.printStackTrace();
//		}
	//------------------------------------------------------------	
//		try(BookDao bdao = new BookDao()) {
//			
//			List<Book> list =  bdao.findAll();
//			for(Book b : list)
//			System.out.println(b);
//			
//			
//			
//		}//bdao.close() ;
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
	//------------------------------------------------------------------	
		
//		try (BookDao bdao = new BookDao()){
//			
//			System.out.println("Enter subject : ");
//			String subject = sc.next();
//			List<Book> list = bdao.findBookBySubject(subject);
//			for(Book b : list)
//				System.out.println(b);
//			
//			
//		}//bdao.close();
//		catch (Exception e) {
//			// TODO: handle exception
//		}
		
//------------------------------------------------------------------
		
//		try(BookDao dao = new BookDao()) {
//			System.out.print("Enter id: ");
//			int id = sc.nextInt();
//			Book b = dao.findById(id);
//			if(b == null)
//				System.out.println("Book not found");
//			else
//				System.out.println("Found: " + b);
//		} // dao.close();
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//------------------------------------------------------------		
//		try(BookDao dao = new BookDao()) {
//			System.out.print("Enter Id: ");
//			int id = sc.nextInt();				
//			System.out.print("Enter name: ");
//			String name = sc.next();				
//			System.out.print("Enter author: ");
//			String author = sc.next();				
//			System.out.print("Enter subject: ");
//			String subject = sc.next();				
//			System.out.print("Enter price: ");
//			double price = sc.nextDouble();
//			Book b = new Book(id, name, author, subject, price);
//			int count = dao.update(b);
//			System.out.println("Rows Updated: " + count);
//		} // dao.close();
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//-----------------------------------------------------------------------
		
		
//		try (BookDao bdoa = new BookDao()){
//		
//			List<String> r = bdoa.getSubjects();
//			System.out.println("Subject names are :");
//			for(String b : r) {
//				System.out.println(b.toString());
//			}
//			
//			
//		}//bdao.close() ;
//		catch (Exception e) {
//			e.printStackTrace();
//		}
		
//--------------------------------------------------------------------	
	
//		try(BookDao dao = new BookDao()) {
//			System.out.print("Enter Id: ");
//			int id = sc.nextInt();				
//			System.out.print("Enter name: ");
//			String name = sc.next();				
//			System.out.print("Enter author: ");
//			String author = sc.next();				
//			System.out.print("Enter subject: ");
//			String subject = sc.next();				
//			System.out.print("Enter price: ");
//			double price = sc.nextDouble();
//			Book b = new Book(id, name, author, subject, price);
//			int count = dao.save(b);
//			System.out.println("Rows saved: " + count);
//		} // dao.close();
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//	
	
		//--------------------------------------------------------------------
	
		try(UserDao userDao = new UserDao()) {
			System.out.print("Enter Email: ");
			String email = sc.next();
			User u = userDao.findByEmail(email);
			if(u == null)
				System.out.println("User not found");
			else
				System.out.println("Found: " + u);
		} catch (Exception e) {
			e.printStackTrace();
		}
//-----------------------------------------------------------------------	
	
	}

}
