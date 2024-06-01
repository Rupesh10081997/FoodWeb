package com.main.service;

import com.main.dao.RolePrivilidgeDao;
import com.main.entities.RolePrivilidge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolePrivilidgeServiceImpl implements RolePrivilidgeService{
    @Autowired
    RolePrivilidgeDao rolePrivilidgeDao;
    @Override
    public RolePrivilidge AssignRole(RolePrivilidge rolePrivilidge) {
        return rolePrivilidgeDao.save(rolePrivilidge);
    }
}
