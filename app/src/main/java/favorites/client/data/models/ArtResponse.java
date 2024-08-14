
package favorites.client.data.models;

import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class ArtResponse {

    @SerializedName("preference")
    @Expose
    private Object preference;
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;
    @SerializedName("data")
    @Expose
    private List<Datum> data;
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

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
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
