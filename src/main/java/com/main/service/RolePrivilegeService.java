package com.main.service;

import com.main.entities.RolePrivilege;
import java.util.List;

public interface RolePrivilegeService {

    RolePrivilege assignAssignPrivilegeRole(RolePrivilege rolePrivilidge);

    List<RolePrivilege> getPrivilegeRole();
}
