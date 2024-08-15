
package favorites.client.data.models.favorites;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;

import favorites.client.data.models.favorites.Favorite;

@Generated("jsonschema2pojo")
public class FavoritesResponse {

    @SerializedName("pagination")
    @Expose
    private Pagination pagination;
    @SerializedName("data")
    @Expose
    private List<Favorite> data;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<Favorite> getData() {
        return data;
    }

    public void setData(List<Favorite> data) {
        this.data = data;
    }

}
