package com.main.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
public class RolePrivilidge {
@Id
   private int	role_id;
    @NotNull(message="Name do not null")
    private int	module_id;
    @NotNull(message="Name do not null")
   private int	activity_id;
   private int	privilege_id;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getModule_id() {
        return module_id;
    }

    public void setModule_id(int module_id) {
        this.module_id = module_id;
    }

    public int getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(int activity_id) {
        this.activity_id = activity_id;
    }

    public int getPrivilege_id() {
        return privilege_id;
    }

    public void setPrivilege_id(int privilege_id) {
        this.privilege_id = privilege_id;
    }

    @Override
    public String toString() {
        return "RolePrivilidge{" +
                "role_id=" + role_id +
                ", module_id=" + module_id +
                ", activity_id=" + activity_id +
                ", privilege_id=" + privilege_id +
                '}';
    }
}
