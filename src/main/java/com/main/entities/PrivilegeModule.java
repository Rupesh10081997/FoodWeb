package com.main.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class PrivilegeModule {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int privilegeModuleId;
    private String privilegeModuleDesc;
    private String privilegeModuleLang2Desc;
    private String status;
    private String privilegeModuleIcons;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PrivilegeActivity> activity = new ArrayList<>();

}
