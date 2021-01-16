package ar.com.ada.second.online.maven.model.dao;

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
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Column(name ="body", columnDefinition = "Text", nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn(name ="User_Id", nullable = false, foreignKey = @ForeignKey(name = "fk_Post_User"))
    private UserDAO user;

}
