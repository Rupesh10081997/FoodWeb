package com.main.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class RolePrivilege {
    @Id
    @NotNull(message="role_id should not null")
    private int	roleId;
    @NotNull(message="module_id should not null")
    private int	privilegeModuleId;
    @NotNull(message="activity_id should not null")
    private int	privilegeActivityId;
    @NotNull(message="privilege_id should not null")
    private int	privilegeId;
}
