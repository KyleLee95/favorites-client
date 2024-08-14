
package favorites.client.data.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Thumbnail {

    @SerializedName("alt_text")
    @Expose
    private String altText;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("lqip")
    @Expose
    private String lqip;
    @SerializedName("height")
    @Expose
    private Integer height;

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getLqip() {
        return lqip;
    }

    public void setLqip(String lqip) {
        this.lqip = lqip;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

}
