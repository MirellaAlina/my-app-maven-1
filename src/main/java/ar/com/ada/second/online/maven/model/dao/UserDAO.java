package ar.com.ada.second.online.maven.model.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// DAO : DATA ACCESS OBJECT

// con estas anotaciones, aplican codigo en tiempo de compilador
@NoArgsConstructor // se genera el constructor vacio
@AllArgsConstructor // se genera el constructor cargado con los argumentos
@Getter // se generan los getters
@Setter // se generan los setters
public class UserDAO {


    private Integer Id;
    private String nickname;
    private String email;



}
