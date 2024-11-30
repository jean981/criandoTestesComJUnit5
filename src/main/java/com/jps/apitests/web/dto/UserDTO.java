package com.jps.apitests.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

  //  private ModelMapper modelMapper = new ModelMapper();

    private Integer id;
    private String name;
    private String email;

    @JsonIgnore
    private String password;
}
