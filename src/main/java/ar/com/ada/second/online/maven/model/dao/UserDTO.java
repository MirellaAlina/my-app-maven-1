package ar.com.ada.second.online.maven.model.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// DTO : DATA TRANSFER OBJECT
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {


    private Integer Id;
    private String nickname;
    private String email;

}
