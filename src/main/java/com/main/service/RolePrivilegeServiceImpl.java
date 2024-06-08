package com.main.service;

import com.main.dao.RolePrivilegeDao;
import com.main.entities.RolePrivilege;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Slf4j
@Service
public class RolePrivilegeServiceImpl implements RolePrivilegeService {
    @Autowired
    RolePrivilegeDao rolePrivilegeDao;

    @Override
    public RolePrivilege assignPrivilegeRole(RolePrivilege rolePrivilege) {
        return rolePrivilegeDao.save(rolePrivilege);
    }

    @Override
    public List<RolePrivilege> getPrivilegeRole() {
        return rolePrivilegeDao.findAll();
    }

    @Override
    @Transactional
    public String updatePrivilegeRole(List<RolePrivilege> rolePrivilegeList, int roleId) {
        List<RolePrivilege> rolePrivileges = rolePrivilegeDao.findAllByRoleId(roleId);

        List<Integer> rolePrivilegeIds = rolePrivileges.stream().map(RolePrivilege::getRolePrivilegeId).collect(Collectors.toList());

        List<Integer> privilegeIds = rolePrivilegeList.stream()
                .map(RolePrivilege::getRolePrivilegeId)
                .collect(Collectors.toList());

        deletePrivilegeRole(privilegeIds,rolePrivilegeIds);


        rolePrivilegeDao.saveAll(rolePrivilegeList);

        return "Privilege updated successfully";
    }

    private void deletePrivilegeRole(List<Integer> privilegeIds, List<Integer> rolePrivilegeIds) {
        Set<Integer> set1 = privilegeIds.stream().collect(Collectors.toSet());
        Set<Integer> set2 = rolePrivilegeIds.stream().collect(Collectors.toSet());

        Set<Integer> nonMatchingprivilegeIds = set2.stream()
                .filter(n -> !set1.contains(n))
                .collect(Collectors.toSet());

        log.info("nonMatching :{}",nonMatchingprivilegeIds);
        if(nonMatchingprivilegeIds.size()>0){
            rolePrivilegeDao.deleteAllByRoleIdIn(nonMatchingprivilegeIds);
        }

    }

}
