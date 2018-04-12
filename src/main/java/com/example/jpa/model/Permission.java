package com.example.jpa.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "permissions")
public class Permission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @NotNull
    @Size(max = 30)
    @Column(unique = true)
    private String canRead;
    
    @NotNull
    @Size(max = 30)
    @Column(unique = true)
    private String canDelete;
    
    @NotNull
    @Size(max = 30)
    @Column(unique = true)
    private String canUpdate;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "get_time")
    private Date getTime = new Date();
    
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "permission")//be responsible from role
    private Set<Role> roles = new HashSet<>();
    
    public Permission() {
    	
    }
    public Permission(String canRead, String canDelete, String canUpdate) {
    	this.canRead = canRead;
    	this.canDelete = canDelete;
    	this.canUpdate = canUpdate;
    }
    public Long getId() {
    	return id;
    }
    public void setId(Long id) {
    	this.id = id;
    }
    public String getCanRead() {
    	return canRead;
    }
    public void setCanRead(String canRead) {
    	this.canRead = canRead;
    }
    public String getCanDelete() {
    	return canDelete;
    }
    public void setCanDelete(String canDelete) {
    	this.canDelete = canDelete;
    }
    public String getCanUpdate() {
    	return canUpdate;
    }
    public void setCanUpdate(String canUpdate) {
    	this.canUpdate = canUpdate;
    }
    public Date getGetTime() {
    	return getTime;
    }
    public void setGetTime(Date getTime) {
    	this.getTime = getTime;
    }
    public Set<Role> getRole() {
    	return roles;
    }
    public void setRole(Set<Role> roles) {
    	this.roles = roles;
    }
    

}
