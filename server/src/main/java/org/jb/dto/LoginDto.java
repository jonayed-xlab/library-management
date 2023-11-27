package org.jb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginDto {
    @JsonProperty
    private String userName;
    @JsonProperty
    private String password;
}
