# Usage

I've configured the project `build.gradle` to read the both the `YELP_API_KEY` and the `MAPS_API_KEY` from local shell variables. Relevant lines are:

```gradle
// inside android-retro-<student-githubID>/app/build.gradle
android{
    //... your configuration

    defaultConfig{


    def yelpApiKey = project.hasProperty('YELP_API_KEY') ? project.YELP_API_KEY : ""
    buildConfigField("String", "YELP_API_KEY", "\"${yelpApiKey}\"")

    def mapsApiKey = project.hasProperty('MAPS_API_KEY') ? project.MAPS_API_KEY : ""
    buildConfigField("String", "MAPS_API_KEY", "\"${mapsApiKey}\"")
}

    buildFeatures{
        compose true
        buildConfig = true
    }

}
```

1. Navigate to [Yelp's Developer Portal to get your API key](https://www.yelp.com/developers/v3/manage_app) and [Google Console to get your Maps API key](https://console.cloud.google.com/google/maps-apis/onboard;flow=gmp-api-key-flow)
2. Open this project in your IDE (assuming latest version of Android Studio)

3. Inside the project's root directory, run the following shell command to set
   your yelp api key as a shell variable:

   ```shell
   $ export YELP_API_KEY=your-yelp-api-key
   $ export MAPS_API_KEY=your-google-maps-api-key
   ```

4. Build and run the project
