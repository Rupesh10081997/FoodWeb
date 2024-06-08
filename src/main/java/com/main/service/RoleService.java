package com.main.service;

import com.main.entities.Role;

import java.util.List;

public interface RoleService {

    Role CretaeRole(Role role);

    List<Role> getAllRole();

}
