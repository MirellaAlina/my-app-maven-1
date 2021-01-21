package ar.com.ada.second.online.maven.model.dao;

import ar.com.ada.second.online.maven.model.dto.PostDTO;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Post")
public class PostDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Column(name = "body", columnDefinition = "Text", nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn(name = "User_Id", nullable = false, foreignKey = @ForeignKey(name = "fk_Post_User"))
    private UserDAO user;

    public PostDAO(String body, UserDAO user) {
        this.body = body;
        this.user = user;
    }

    public static PostDAO toDAO(PostDTO postDTO) {
        UserDAO userDAO = UserDAO.toDAO(postDTO.getUser());
        PostDAO postDAO = new PostDAO(postDTO.getBody(), userDAO);

        if (postDTO.getId() != null)
            postDAO.setId(postDAO.getId());

        return postDAO;
    }
}
