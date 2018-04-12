package com.example.jpa.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @NotNull
    @Size(max = 30)
    @Column(unique = true)
    private String rankOne;
    
    @NotNull
    @Size(max = 30)
    @Column(unique = true)
    private String rankTwo;
    
    @NotNull
    @Size(max = 30)
    @Column(unique = true)
    private String rankThree;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "get_time")
    private Date getTime = new Date();
    
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "roles")//be responsible from user
    private Set<User> users = new HashSet<>();
    
    
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    //responsible for permission
    @JoinTable(name = "roles_permission",
            joinColumns = { @JoinColumn(name = "roles_id") },
            inverseJoinColumns = { @JoinColumn(name = "permission_id") })
    private Set<Permission> permission = new HashSet<>();
    
    public Role() {
    	
    }
    public Role(String rankOne, String rankTwo, String rankThree) {
    	this.rankOne = rankOne;
    	this.rankTwo = rankTwo;
    	this.rankThree= rankThree;
    }
    public Long getId() {
    	return id;
    }
    public void setId(Long id) {
    	this.id = id;
    }
    public String getRankOne() {
    	return rankOne;
    }
    public void setRankOne(String rankOne) {
    	this.rankOne = rankOne;
    }
    public String getRankTwo() {
    	return rankTwo;
    }
    public void setRankTwo(String rankTwo) {
    	this.rankTwo = rankTwo;
    }
    public String getRankThree() {
    	return rankThree;
    }
    public void setRankThree(String rankThree) {
    	this.rankThree = rankThree;
    }
    public Set<User> getUsesr() {
    	return users;
    }
    public void setUsers(Set<User> users) {
    	this.users = users;    	
    }
    public Set<Permission> getPermission() {
    	return permission;
    }
    public void setPermission(Set<Permission> permission) {
    	this.permission = permission;
    }
    

}
