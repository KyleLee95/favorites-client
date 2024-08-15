
package favorites.client.data.models.artworks;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class DimensionsDetail {

    @SerializedName("depth")
    @Expose
    private Integer depth;
    @SerializedName("diameter")
    @Expose
    private Object diameter;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("clarification")
    @Expose
    private String clarification;
    @SerializedName("height")
    @Expose
    private Integer height;

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public Object getDiameter() {
        return diameter;
    }

    public void setDiameter(Object diameter) {
        this.diameter = diameter;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getClarification() {
        return clarification;
    }

    public void setClarification(String clarification) {
        this.clarification = clarification;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

}
