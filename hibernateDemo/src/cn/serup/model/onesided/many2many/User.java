package cn.serup.model.onesided.many2many;

import java.util.HashSet;  
import java.util.Set;  
  

import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.JoinColumn;  
import javax.persistence.JoinTable;  
import javax.persistence.ManyToMany;  
  
@Entity  
public class User {  
      
    private int id ;  
      
    private String username ;  
      
    private Set<Role> role = new HashSet<Role>() ;  
  
    @Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    public int getId() {  
        return id;  
    }  
  
    public void setId(int id) {  
        this.id = id;  
    }  
  
    public String getUsername() {  
        return username;  
    }  
  
    public void setUsername(String username) {  
        this.username = username;  
    }  
  
    @ManyToMany  
    /** 
     * 多对多映射：注解@ManyToMany（单向） 
     * 默认情况下，hibernate会自动的创建一张中间表， 
     * 来维护多对多关系 
     * 默认中间表的名称 ：user_role中间表，字段的名称user_id role_id 
     * 如果想更换表名和字段名称，注解如下： 
     */  
    @JoinTable(name="t_u_r",  
            joinColumns={@JoinColumn(name="u_id")},  
            inverseJoinColumns={@JoinColumn(name="r_id")}  
    )  
    public Set<Role> getRole() {  
        return role;  
    }  
  
    public void setRole(Set<Role> role) {  
        this.role = role;  
    }  
  
      
} 