package com.chatweb.repository;

import com.chatweb.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query(" SELECT r.id,  r.name, r.description,  0 AS selected " +
            "FROM  Role r  WHERE r.available = 1")
    List<Role> queryRoleListWithSelected(@Param("userId") Long userId);
//( CASE WHEN (  SELECT ur.roleId  FROM UserRole ur WHERE  ur.user_id = :userId  AND  ur.roleId = r.id ) THEN 1 ELSE 0 END )

    @Query("SELECT r.id, r.name ,r.description FROM Role r ,UserRole ur  WHERE  ur.roleId = r.id and ur.userId = userId AND r.available = 1")
    List<Role> listRolesByUserId (Long userId);
}