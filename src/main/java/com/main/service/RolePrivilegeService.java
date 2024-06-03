package com.main.service;

import com.main.entities.RolePrivilege;
import java.util.List;

public interface RolePrivilegeService {

    RolePrivilege assignPrivilegeRole(RolePrivilege rolePrivilidge);

    List<RolePrivilege> getPrivilegeRole();
}
