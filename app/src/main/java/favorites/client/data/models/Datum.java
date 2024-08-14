
package favorites.client.data.models;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class Datum {

    @SerializedName("_score")
    @Expose
    private Double score;
    @SerializedName("thumbnail")
    @Expose
    private Thumbnail thumbnail;
    @SerializedName("api_model")
    @Expose
    private String apiModel;
    @SerializedName("is_boosted")
    @Expose
    private Boolean isBoosted;
    @SerializedName("api_link")
    @Expose
    private String apiLink;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getApiModel() {
        return apiModel;
    }

    public void setApiModel(String apiModel) {
        this.apiModel = apiModel;
    }

    public Boolean getIsBoosted() {
        return isBoosted;
    }

    public void setIsBoosted(Boolean isBoosted) {
        this.isBoosted = isBoosted;
    }

    public String getApiLink() {
        return apiLink;
    }

    public void setApiLink(String apiLink) {
        this.apiLink = apiLink;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
