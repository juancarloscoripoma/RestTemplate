package com.soft.rtemplate.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"id"})
public class UserDTO implements Serializable {

    private Long id;

    @NotNull
    private String user;

    @NotNull
    private String password;

    private String fullname;

    @NotNull
    private String cardCode;

    @NotNull
    private BigDecimal amount;

    private Boolean status;

    private String message;

}
