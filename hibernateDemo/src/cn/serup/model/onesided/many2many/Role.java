package cn.serup.model.onesided.many2many;
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;
import javax.persistence.Id;  
  
@Entity  
public class Role {  
      
    private int id ;  
      
    private String roleName ;  
      
    /*private Set<User> user = new HashSet<User>() ; 
 
    @ManyToMany 
    public Set<User> getUser() { 
        return user; 
    } 
 
    public void setUser(Set<User> user) { 
        this.user = user; 
    }*/  
  
    @Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    public int getId() {  
        return id;  
    }  
  
    public void setId(int id) {  
        this.id = id;  
    }  
  
    public String getRoleName() {  
        return roleName;  
    }  
  
    public void setRoleName(String roleName) {  
        this.roleName = roleName;  
    }  
      
} 