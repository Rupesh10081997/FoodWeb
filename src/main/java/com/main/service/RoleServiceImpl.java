package com.main.service;

import com.main.dao.RoleDao;
import com.main.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
@Autowired
    RoleDao roleDao;
    public Role CretaeRole(Role role)
    {
    return roleDao.save(role);
    }

    @Override
    public List<Role> getAllRole() {
        return roleDao.findAll();
    }
}
