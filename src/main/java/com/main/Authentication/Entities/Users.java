package com.main.Authentication.Entities;

import com.main.entities.AbstractEntity;
import com.main.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Users extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message="Username do not null")
    private String userName;
    @NotNull(message="Password do not null")
    private String password;
    @Enumerated(EnumType.STRING)
    private Status status;

}