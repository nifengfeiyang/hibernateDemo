package cn.serup.hibernate.test.twosided;  
  
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.serup.model.twosided.one2many.Company;
import cn.serup.model.twosided.one2many.Organization;
import cn.serup.util.HibernateUtil;
  
public class One2Many {  
      
    private static SessionFactory sessionFactory ;  
      
    @SuppressWarnings("unchecked")  
    @Test  
    public void testSaveOne2Many() {  
        Organization o = new Organization() ;  
        o.setOrgName("谷度培训机构") ;  
  
        Company c = new Company() ;  
        c.setCompayName("广州分公司") ;  
        c.setOrg(o);
          
        Company c1 = new Company() ;  
        c1.setCompayName("成都分公司") ;  
        c1.setOrg(o);
        
        Company c2 = new Company() ;  
        c2.setCompayName("天津分公司") ;
        c2.setOrg(o);
          
//        Set set = new HashSet() ;  
//        set.add(c) ;  
//        set.add(c1) ;  
//        set.add(c2) ;  
//          
//        o.setCompany(set) ;  
          
        Session session = sessionFactory.getCurrentSession() ;  
        Transaction tr = session.beginTransaction() ;  
          
        session.save(o) ;  
        session.save(c) ;  
        session.save(c1) ;  
        session.save(c2) ;  
          
        tr.commit() ;  
    }  
      
    @SuppressWarnings("unchecked")  
    @Test  
    public void testLoadOne2Many() {  
        Session session = sessionFactory.getCurrentSession() ;  
        Transaction tr = session.beginTransaction() ;  
          
        Organization o = (Organization)session.load(Organization.class, 1) ;  
          
        System.out.println(o.getId()+" "+o.getOrgName()) ;  
          
        Set list = o.getCompany() ;  
          
        for(Iterator it = list.iterator(); it.hasNext();) {  
            Company c = (Company)it.next() ;  
            System.out.println(c.getId()+" "+c.getCompayName());  
        }  
          
        tr.commit() ;  
    }  
      
    @Test  
    public void testDeleteOne2Many() {  
        Session session = sessionFactory.getCurrentSession() ;  
        Transaction tr = session.beginTransaction() ;  
  
        Organization c = (Organization) session.load(Organization.class, 1) ;  
          
        session.delete(c) ;  
          
        tr.commit() ;  
    }
    
    @Test  
    public void testDeleteOne2Many2() {  
        Session session = sessionFactory.getCurrentSession() ;  
        Transaction tr = session.beginTransaction() ;  
  
        Company c = (Company) session.load(Company.class, 1) ;  
          
        session.delete(c) ;  
          
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