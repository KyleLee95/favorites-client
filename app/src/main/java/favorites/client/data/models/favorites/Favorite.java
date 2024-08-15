
package favorites.client.data.models.favorites;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class Favorite {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("user_session_email")
    @Expose
    private String userSessionEmail;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("artwork")
    @Expose
    private Artwork artwork;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserSessionEmail() {
        return userSessionEmail;
    }

    public void setUserSessionEmail(String userSessionEmail) {
        this.userSessionEmail = userSessionEmail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artwork getArtwork() {
        return artwork;
    }

    public void setArtwork(Artwork artwork) {
        this.artwork = artwork;
    }

}
