package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "favourites")
public class Favourites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private String liked;

    @ManyToMany(mappedBy="favourites")
    private List<User> userList;


    public Favourites(int id, String liked) {
        this.id = id;
        this.liked = liked;
    }

    public Favourites() {

    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getLiked() {
        return liked;
    }

    public void setLiked(String liked) {
        this.liked = liked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addUserList(User user) {
        this.userList.add(user);
    }
}