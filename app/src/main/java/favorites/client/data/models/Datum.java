
package favorites.client.data.models;

import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import favorites.client.data.models.DimensionsDetail;

//@Generated("jsonschema2pojo")
public class Datum {

    @SerializedName("_score")
    @Expose
    private Double score;
    @SerializedName("dimensions_detail")
    @Expose
    private List<DimensionsDetail> dimensionsDetail;
    @SerializedName("medium_display")
    @Expose
    private String mediumDisplay;
    @SerializedName("artist_display")
    @Expose
    private String artistDisplay;
    @SerializedName("alt_titles")
    @Expose
    private Object altTitles;
    @SerializedName("style_title")
    @Expose
    private String styleTitle;
    @SerializedName("exhibition_history")
    @Expose
    private String exhibitionHistory;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("gallery_title")
    @Expose
    private Object galleryTitle;
    @SerializedName("place_of_origin")
    @Expose
    private String placeOfOrigin;
    @SerializedName("api_model")
    @Expose
    private String apiModel;
    @SerializedName("api_link")
    @Expose
    private String apiLink;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("image_id")
    @Expose
    private String imageId;
    @SerializedName("dimensions")
    @Expose
    private String dimensions;

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public List<DimensionsDetail> getDimensionsDetail() {
        return dimensionsDetail;
    }

    public void setDimensionsDetail(List<DimensionsDetail> dimensionsDetail) {
        this.dimensionsDetail = dimensionsDetail;
    }

    public String getMediumDisplay() {
        return mediumDisplay;
    }

    public void setMediumDisplay(String mediumDisplay) {
        this.mediumDisplay = mediumDisplay;
    }

    public String getArtistDisplay() {
        return artistDisplay;
    }

    public void setArtistDisplay(String artistDisplay) {
        this.artistDisplay = artistDisplay;
    }

    public Object getAltTitles() {
        return altTitles;
    }

    public void setAltTitles(Object altTitles) {
        this.altTitles = altTitles;
    }

    public String getStyleTitle() {
        return styleTitle;
    }

    public void setStyleTitle(String styleTitle) {
        this.styleTitle = styleTitle;
    }

    public String getExhibitionHistory() {
        return exhibitionHistory;
    }

    public void setExhibitionHistory(String exhibitionHistory) {
        this.exhibitionHistory = exhibitionHistory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getGalleryTitle() {
        return galleryTitle;
    }

    public void setGalleryTitle(Object galleryTitle) {
        this.galleryTitle = galleryTitle;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public String getApiModel() {
        return apiModel;
    }

    public void setApiModel(String apiModel) {
        this.apiModel = apiModel;
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

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

}
