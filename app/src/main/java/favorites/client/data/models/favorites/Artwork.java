
package favorites.client.data.models.favorites;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Artwork {

    @SerializedName("_score")
    @Expose
    private Integer score;
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
    private Object exhibitionHistory;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("gallery_title")
    @Expose
    private String galleryTitle;
    @SerializedName("place_of_origin")
    @Expose
    private String placeOfOrigin;
    @SerializedName("api_model")
    @Expose
    private String apiModel;
    @SerializedName("api_link")
    @Expose
    private String apiLink;
    @SerializedName("image_id")
    @Expose
    private String imageId;
    @SerializedName("dimensions")
    @Expose
    private String dimensions;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
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

    public Object getExhibitionHistory() {
        return exhibitionHistory;
    }

    public void setExhibitionHistory(Object exhibitionHistory) {
        this.exhibitionHistory = exhibitionHistory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGalleryTitle() {
        return galleryTitle;
    }

    public void setGalleryTitle(String galleryTitle) {
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
