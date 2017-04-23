package cn.serup.model.onesided.one2many;  
  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;
import javax.persistence.Id;  
  
@Entity  
public class Company {  
      
    private int id ;  
      
    private String compayName ;  
      
    @Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {  
        return id;  
    }  
  
    public void setId(int id) {  
        this.id = id;  
    }  
  
    public String getCompayName() {  
        return compayName;  
    }  
  
    public void setCompayName(String compayName) {  
        this.compayName = compayName;  
    }  
}
