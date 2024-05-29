package com.main.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class PrivilegeActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int privilegeActivityId;
    private String privilegeActivityDesc;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Privilege> privilege = new ArrayList<>();
}
