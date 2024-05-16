package learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {

    public static void main(String[] args) {

        // Setting data in database 
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        SessionFactory sf = con.buildSessionFactory();
        
        

        // Laptop laptop1 = new Laptop();
        // laptop1.setLid(101);
        // laptop1.setLname("dell");
        // Laptop laptop2 = new Laptop();
        // laptop2.setLid(102);
        // laptop2.setLname("Acer");
        // Laptop laptop3 = new Laptop();
        // laptop3.setLid(103);
        // laptop3.setLname("MSi");
        // Student s1 =new Student();
        // s1.getLaptop().add(laptop1);
        // s1.getLaptop().add(laptop2);
        // s1.setRollno(1);
        // s1.setMarks(95);
        // s1.setName("krish");
        // Student s2 =new Student();
        // s2.getLaptop().add(laptop3);
        // s2.setRollno(2);
        // s2.setMarks(85);
        // s2.setName("rahul");
        // session.persist(s1);
        // session.persist(s2);
        // session.persist(laptop1);
        // session.persist(laptop2);
        // session.persist(laptop3);
        //Student s1 =session.get(Student.class, 1);
        //System.out.println(s1.getName());
        // Collection <Laptop> lap = s1.getLaptop();

        // for(Laptop l: lap){
        //     System.out.println(l);
        // }



        //First-Level Cache
        // session1.beginTransaction();
        // Student s1 =session1.get(Student.class, 1);
        // System.out.println(s1);

        // Student s2 =session1.get(Student.class, 1);
        // System.out.println(s2);
        // session1.getTransaction().commit();


        //Second-Level Cache
        // Session session1 = sf.openSession();
        // session1.beginTransaction();
        // Student s1 =session1.get(Student.class, 1);
        // System.out.println(s1);
        // session1.getTransaction().commit();
        // session1.close();

        // Session session2 = sf.openSession();
        // session2.beginTransaction();
        // Student s2 =session2.get(Student.class, 1);
        // System.out.println(s2);
        // session2.getTransaction().commit();
        // session2.close();

            //Second level cahce with query
        Session session1 = sf.openSession();
        session1.beginTransaction();
        Query q1 =session1.createQuery("from Student where id =1");
        q1.setCacheable(true);
        Student s1= (Student) q1.uniqueResult();
        System.out.println(s1);
        session1.getTransaction().commit();
        session1.close();

        Session session2 = sf.openSession();
        session2.beginTransaction();
        Query q2 =session2.createQuery("from Student where id =1");
        q2.setCacheable(true);
        Student s2= (Student) q2.uniqueResult();
        System.out.println(s2);
        session2.getTransaction().commit();
        session2.close();


    



       

    }
}
