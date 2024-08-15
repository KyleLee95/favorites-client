package favorites.client.data.models.artworks;


//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class Config {

    @SerializedName("iiif_url")
    @Expose
    private String iiifUrl;
    @SerializedName("website_url")
    @Expose
    private String websiteUrl;

    public String getIiifUrl() {
        return iiifUrl;
    }

    public void setIiifUrl(String iiifUrl) {
        this.iiifUrl = iiifUrl;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

}
