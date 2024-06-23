package com.main.Authentication.Entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class AuthRequestDto {
    @Schema(example = "admin", description = "this field is used to pass username")
    private String userName;

    @Schema(example = "admin", description = "this field is used to pass password")
    private String password;



}
