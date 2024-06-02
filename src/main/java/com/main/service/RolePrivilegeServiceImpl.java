package com.main.service;

import com.main.dao.RolePrivilegeDao;
import com.main.entities.RolePrivilege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolePrivilegeServiceImpl implements RolePrivilegeService {
    @Autowired
    RolePrivilegeDao rolePrivilegeDao;

    @Override
    public RolePrivilege assignAssignPrivilegeRole(RolePrivilege rolePrivilege) {
        return rolePrivilegeDao.save(rolePrivilege);
    }
}
