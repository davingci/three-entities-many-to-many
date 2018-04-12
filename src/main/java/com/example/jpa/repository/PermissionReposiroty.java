package com.example.jpa.repository;

import com.example.jpa.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionReposiroty extends JpaRepository<Permission, Long> {

}
