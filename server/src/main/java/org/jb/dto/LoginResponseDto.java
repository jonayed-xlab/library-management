package org.jb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.jb.entity.Role;

import java.util.List;

@Data
public class LoginResponseDto {
    @JsonProperty
    private Long userId;
    @JsonProperty
    private String userName;
    @JsonProperty
    private String password;
    @JsonProperty
    Role role;
}
