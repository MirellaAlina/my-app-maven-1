package ar.com.ada.second.online.maven.model.dao;

import ar.com.ada.second.online.maven.model.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

// DAO : DATA ACCESS OBJECT

// con estas anotaciones, aplican codigo en tiempo de compilador
@NoArgsConstructor // se genera el constructor vacio
@AllArgsConstructor // se genera el constructor cargado con los argumentos
@Getter // se generan los getters
@Setter // se generan los setters
@Entity
@Table(name = "User")
public class UserDAO {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nickname", length = 30, nullable = false, unique = true)
    private String nickname;

    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "user")
    private List<PostDAO> posts;

    public UserDAO(String nickname, String email) {
        this.nickname = nickname;
        this.email = email;
    }

    public static UserDAO toDAO(UserDTO dto){
        UserDAO userDAO = new UserDAO(dto.getNickname(), dto.getEmail());
        if (dto.getId() != null)
            userDAO.setId(dto.getId());
        return userDAO;
    }

    public static UserDTO toDTO(UserDAO dao) {
        UserDTO dto = new UserDTO(dao.getNickname(), dao.getEmail());
        if (dao.getId() != null)
            dto.setId(dao.getId());
        return dto;
    }

}
