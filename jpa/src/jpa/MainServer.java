package jpa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainServer {
	public static void main(String[] args) {
		try {
			Student s1=new Student();
			
			s1.setName("kiran");
			Address a1=new Address();
			a1.setHouseInfo("297/11");
			a1.setState("ap");
			a1.setCity("srikakulam");
			a1.setPincode(532405);
			s1.setPermanentAddress(a1);
			Address a2=new Address();
			a2.setHouseInfo("297/11");
			a2.setState("ap");
			a2.setCity("srikakulam");
			a2.setPincode(532405);
			s1.setTemporaryAddress(a2);
			Configuration cfg = new Configuration();
			@SuppressWarnings("deprecation")
			SessionFactory factory = cfg.configure().buildSessionFactory();
			Session hibernate = factory.openSession(); 
			Transaction t = hibernate.beginTransaction();
			hibernate.save(s1);
			t.commit();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
