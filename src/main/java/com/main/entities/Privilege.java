package com.main.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int privilegeId;
    private String privilegeDesc;
    @Transient
    private boolean isAssign = false;
}
