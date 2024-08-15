
package favorites.client.data.models.artworks;

import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class Info {

    @SerializedName("license_text")
    @Expose
    private String licenseText;
    @SerializedName("license_links")
    @Expose
    private List<String> licenseLinks;
    @SerializedName("version")
    @Expose
    private String version;

    public String getLicenseText() {
        return licenseText;
    }

    public void setLicenseText(String licenseText) {
        this.licenseText = licenseText;
    }

    public List<String> getLicenseLinks() {
        return licenseLinks;
    }

    public void setLicenseLinks(List<String> licenseLinks) {
        this.licenseLinks = licenseLinks;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
