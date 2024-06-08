package com.main.dao;

import com.main.entities.RolePrivilege;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface RolePrivilegeDao extends JpaRepository<RolePrivilege,Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM RolePrivilege rp WHERE rp.privilegeId IN :privilegeIds")
    void deleteAllByPrivilegeIdIn(@Param("privilegeIds") List<Integer> privilegeIds);

    List<RolePrivilege> findAllByRoleId(int roleId);

    @Modifying
    @Transactional
    @Query("DELETE FROM RolePrivilege rp WHERE rp.rolePrivilegeId IN :rolePrivilegeIds")
    void deleteAllByRoleIdIn(@Param("rolePrivilegeIds") Set<Integer> rolePrivilegeIds);
}
