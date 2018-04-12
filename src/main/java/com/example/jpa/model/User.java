package com.example.jpa.model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String loginName; 
    
    @NotNull
    @Size(max = 25)    
    private String password;
    
    @NotNull
    @Size(max = 30)
    private String userName;
    
    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String email;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gen_time")
    private Date genTime = new Date();
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "login_time")
    private Date loginTime = new Date();
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_login_time")
    private Date lastLoginTime = new Date();
    
    @NotNull
    private Integer count;
    
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    //responsible for Role
    @JoinTable(name = "user_role",
    joinColumns = { @JoinColumn(name = "user_id") },
    inverseJoinColumns = { @JoinColumn(name = "role_id") })    
    private Set<Role> roles = new HashSet<>();
    
    public User() {
    	
    }
    
    public User (String loginName, String password) {
    	this.loginName = loginName;
    	this.password = password;
    }
    
    public long getId() {
    	return id;
    }
    public void setId(Long id) {
    	this.id = id;
    }
    public String getLoginName() {
    	return loginName;
    }
    public void setLoginName(String loginName) {
    	this.loginName = loginName;
    }
    public String getPassword() {
    	return loginName;
    }
    public void setPassword(String password) {
    	this.password = password;
    }
    public String getUserName() {
    	return userName;
    }
    public void setUserName(String userName) {
    	this.userName = userName;
    }
    public String getEmail() {
    	return email;
    }
    public void setEmail(String email) {
    	this.email = email;
    }
    public Date getGenTime() {
    	return genTime;
    }
    public void setGenTime(Date genTime) {
    	this.genTime = genTime;
    }
    public Date getLoginTime() {
    	return loginTime;
    }
    public void setLoginTime(Date loginTime) {
    	this.loginTime = loginTime;
    }
    public Date getLastLoginTime() {
    	return lastLoginTime;
    }
    public void setLastLoginTime(Date lastLoginTime) {
    	this.lastLoginTime = lastLoginTime;
    }
    public Integer getCount() {
    	return count;
    }
    public void setCount(Integer count) {
    	this.count = count;
    }
    public Set<Role> getRoles() {
    	return roles;
    }
    public void setRoles(Set<Role> roles) {
    	this.roles = roles;
    }      

  
}
