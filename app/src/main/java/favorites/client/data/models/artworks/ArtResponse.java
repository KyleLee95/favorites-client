package favorites.client.data.models.artworks;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ArtResponse {

    @SerializedName("preference")
    @Expose
    private Object preference;
    @SerializedName("pagination")
    @Expose
    private favorites.client.data.models.artworks.Pagination pagination;
    @SerializedName("data")
    @Expose
    private List<favorites.client.data.models.artworks.Datum> data;
    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("config")
    @Expose
    private Config config;

    public Object getPreference() {
        return preference;
    }

    public void setPreference(Object preference) {
        this.preference = preference;
    }

    public favorites.client.data.models.artworks.Pagination getPagination() {
        return pagination;
    }

    public void setPagination(favorites.client.data.models.artworks.Pagination pagination) {
        this.pagination = pagination;
    }

    public List<favorites.client.data.models.artworks.Datum> getData() {
        return data;
    }

    public void setData(List<favorites.client.data.models.artworks.Datum> data) {
        this.data = data;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

}
