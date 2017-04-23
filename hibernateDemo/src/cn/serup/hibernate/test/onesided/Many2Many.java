package cn.serup.hibernate.test.onesided;  
  
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.serup.model.onesided.many2many.Role;
import cn.serup.model.onesided.many2many.User;
import cn.serup.util.HibernateUtil;
  
public class Many2Many {  
      
    private static SessionFactory sessionFactory ;  
      
    
  @Test  
  public void testSaveUR() {  
      Role r1 = new Role() ;  
      r1.setRoleName("项目组长") ;  
        
      Role r3 = new Role() ;  
      r3.setRoleName("项目经理") ;  
        
      Role r2 = new Role() ;  
      r2.setRoleName("技术总监") ;  
        
        
      User u1 = new User() ;  
      u1.setUsername("唐骏") ;  

      User u2 = new User() ;  
      u2.setUsername("李开复") ;  
        
      User u3 = new User() ;  
      u3.setUsername("柳传志") ;  
        
      Set<Role> s1 = new HashSet<Role>() ;  
      s1.add(r1) ;  
      s1.add(r3) ;  
        
      Set<Role> s2 = new HashSet<Role>() ;  
      s2.add(r1) ;  
      s2.add(r2) ;  
        
      Set<Role> s3 = new HashSet<Role>() ;  
      s3.add(r1) ;  
      s3.add(r2) ;  
      s3.add(r3) ;  
        
      u1.setRole(s1) ;  
      u2.setRole(s2) ;  
      u3.setRole(s3) ;  
        
      Session session = sessionFactory.getCurrentSession() ;  
      Transaction tr = session.beginTransaction();
        
      session.save(r1) ;  
      session.save(r2) ;  
      session.save(r3) ;  
        
      session.save(u1) ;  
      session.save(u2) ;  
      session.save(u3) ;  
        
      tr.commit() ;  
  }  
    
  @Test  
  public void testLoadUR() {  
      Session session = sessionFactory.getCurrentSession() ;  
      Transaction tr = session.beginTransaction() ;  
      
      User u = (User) session.get(User.class,3) ;  
        
      System.out.println("用户："+u.getUsername()) ;  
        
      Set<Role> s1 = u.getRole() ;  
      System.out.print("拥有职务：");  
      for(Iterator<Role> it = s1.iterator(); it.hasNext();) {  
          Role r = (Role) it.next() ;  
          System.out.print("\t【"+r.getRoleName()+"】");  
      }  
        
      tr.commit() ;  
  }  
      
    @BeforeClass  
    public static void beforeClass() {  
//        new SchemaExport(new AnnotationConfiguration().configure())  
//        .create(true, true) ;  
//          
//        sessionFactory = new AnnotationConfiguration().configure()  
//        .buildSessionFactory() ;  
        
        sessionFactory = HibernateUtil.getSessionFactory();
    }  
      
    @AfterClass  
    public static void afterClass() {  
        sessionFactory.close() ;  
    }  
  
}