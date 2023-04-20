
package dtos;

import entities.Favourites;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class FavouritesDTO {
    private long id;
    private List<String> liked;
    private List<String> userDTOList;



    // Method that returns a list of DTOs
    public static List<FavouritesDTO> getDtos(List<Favourites> favouritesList){
        List<FavouritesDTO> favouritesDTOList = new ArrayList();
        favouritesList.forEach(favourites->favouritesDTOList.add(new FavouritesDTO(favourites)));
        return favouritesDTOList;
    }

    // Constructor to check if ID from entity is null.
    public FavouritesDTO(Favourites favourites) {
        if(favourites.getId() != 0)
            this.id = favourites.getId();
        this.liked = Collections.singletonList(favourites.getLiked());
        if (favourites.getUserList() != null){
            this.userDTOList = favourites.getUserList().stream().map(user -> user.getUserName()).collect(Collectors.toList());
        }
    }


    // Getters & Setters
    public List<String> getLiked() {
        return liked;
    }

    public void setLiked(List<String> liked) {
        this.liked = liked;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // To string
    @Override
    public String toString() {
        return "FavouritesDTO{" +
                "id=" + id +
                ", liked='" + liked + '\'' +
                '}';
    }
}
