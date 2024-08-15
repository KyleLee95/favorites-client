
package favorites.client.data.models.favorites;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class DimensionsDetail {

    @SerializedName("depth")
    @Expose
    private Object depth;
    @SerializedName("diameter")
    @Expose
    private Object diameter;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("clarification")
    @Expose
    private Object clarification;
    @SerializedName("height")
    @Expose
    private Integer height;

    public Object getDepth() {
        return depth;
    }

    public void setDepth(Object depth) {
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

    public Object getClarification() {
        return clarification;
    }

    public void setClarification(Object clarification) {
        this.clarification = clarification;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

}
