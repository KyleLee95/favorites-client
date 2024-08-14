package favorites.client.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.gson.Gson
import favorites.client.data.models.ArtResponse
import favorites.client.data.models.Datum


object Constants {
    val modifier = Modifier.padding(paddingValues = PaddingValues(all = 0.dp))
    val favoritesServiceBaseUrl = "http://localhost:8000/favorites/" //change for prod
    val loggingServiceBaseUrl = "http://localhost:8001/logging-service/" //change for prod
    val artApiServiceBaseUrl = "https://d7ce-70-107-215-6.ngrok-free.app/" // Route our outbound API calls through our own backend.

    val fakeArtworkResponse: ArtResponse
    val fakeArtwork: Datum

    init {
        val gson = Gson()
        val exampleArtworkResponse = """
{
    "preference": null,
    "pagination": {
        "total": 126065,
        "limit": 2,
        "offset": 0,
        "total_pages": 63033,
        "current_page": 1
    },
    "data": [
        {
            "_score": 20628.336,
            "dimensions_detail": [
                {
                    "depth": null,
                    "diameter": null,
                    "width": 134,
                    "clarification": null,
                    "height": 152
                }
            ],
            "medium_display": "Acrylic on canvas",
            "artist_display": "Alma Thomas\nAmerican, 1891–1978",
            "alt_titles": null,
            "style_title": "contemporary",
            "exhibition_history": null,
            "title": "Starry Night and the Astronauts",
            "gallery_title": "Gallery 291",
            "place_of_origin": "United States",
            "api_model": "artworks",
            "api_link": "https://api.artic.edu/api/v1/artworks/129884",
            "id": 129884,
            "image_id": "e966799b-97ee-1cc6-bd2f-a94b4b8bb8f9",
            "dimensions": "152.4 × 134.6 cm (60 × 53 in.)"
        },
        {
            "_score": 10314.168,
            "dimensions_detail": [
                {
                    "depth": null,
                    "diameter": null,
                    "width": 92,
                    "clarification": null,
                    "height": 73
                },
                {
                    "depth": 8,
                    "diameter": null,
                    "width": 108,
                    "clarification": "Framed",
                    "height": 88
                }
            ],
            "medium_display": "Oil on canvas",
            "artist_display": "Vincent van Gogh (Dutch, 1853–1890)",
            "alt_titles": null,
            "style_title": "Post-Impressionism",
            "exhibition_history": "Paris, Galerie Vollard, 1895, no cat.\n\nParis, Galerie Bernheim-Jeune, Vincent van Gogh, Mar. 15–31, 1901, cat. 19, as La Chambre de Vincent à Arles.\n\nVienna Secession, Internationalen Kunstschau, May–Oct. 1909, room 14, cat. 1, as Das Schlafzimmer.\n\nBerlin, Paul Cassirer, Zehnte Ausstellung: Vincent van Gogh: 30 März 1853–29 Juli 1890, May–June 1914, cat. 53, as Das Schlafzimmer.\n\nNew York, Museum of Modern Art, First Loan Exhibition: Cézanne, Gauguin, Seurat, Van Gogh, Nov. 7–Dec. 7, 1929, cat. 79, as Van Gogh's Room at Arles (La Chambre à Arles).\n\nArt Institute of Chicago, A Century of Progress, June 1–Nov. 1, 1933, cat. 376.\n\nArt Institute of Chicago, A Century of Progress, June 1–Nov. 1, 1934, cat. 310.\n\nToledo Museum of Art, French Impressionists and Post Impressionists, Nov. 1934, cat. 24.\n\nArt Institute of Chicago, Paintings and Drawings by Vincent van Gogh, lent through the Museum of Modern Art, N.Y., Aug. 26–Sep. 23, 1936, no cat.\n\nAmsterdam, Van Gogh Museum, Vincent van Gogh Paintings, Mar. 30–July 29, 1990, cat. 7.\n\nEssen, Museum Folkwang, Vincent van Gogh und die Moderne 1890–1914, Aug. 11–Nov. 4, 1990, cat. 40, as Das Schlafzimmer; Amsterdam, Van Gogh Museum, Nov. 16, 1990–Feb. 18, 1991.\n\nArt Institute of Chicago, Van Gogh and Gauguin: The Studio of the South, Sep. 22, 2001–Jan. 13, 2002, cat. 120.\n\nAmsterdam, Van Gogh Museum, Van Gogh and Expressionism, Nov. 24, 2006-Mar. 2, 2007; New York, Neue Gallery, Mar. 23-July 2, 2007 [New York only].\n\nFort Worth, TX, Kimbell Museum of Art, The Impressionists: Master Paintings from the Art Institute of Chicago, June 29–Nov. 2, 2008, cat. 58.\n\nAmsterdam, Van Gogh Museum, Van Gogh at Work, Sep. 1, 2013 - Jan. 13, 2014, cat. 266.\n\nArt Institute of Chicago, Van Gogh’s Bedrooms, Feb. 14–May 10, 2016, no cat. no., plate 26.\n\nDetroit Institute of Art, Van Gogh and America, Oct. 2, 2022 - Jan. 22, 2023, cat. 53.",
            "title": "The Bedroom",
            "gallery_title": null,
            "place_of_origin": "Saint-Rémy-de-Provence",
            "api_model": "artworks",
            "api_link": "https://api.artic.edu/api/v1/artworks/28560",
            "id": 28560,
            "image_id": "25c31d8d-21a4-9ea1-1d73-6a2eca4dda7e",
            "dimensions": "73.6 × 92.3 cm (29 × 36 5/8 in.); Framed: 88.9 × 108 × 8.9 cm (35 × 42 1/2 × 3 1/2 in.)"
        }
    ],
    "info": {
        "license_text": "The `description` field in this response is licensed under a Creative Commons Attribution 4.0 Generic License (CC-By) and the Terms and Conditions of artic.edu. All other data in this response is licensed under a Creative Commons Zero (CC0) 1.0 designation and the Terms and Conditions of artic.edu.",
        "license_links": [
            "https://creativecommons.org/publicdomain/zero/1.0/",
            "https://www.artic.edu/terms"
        ],
        "version": "1.10"
    },
    "config": {
        "iiif_url": "https://www.artic.edu/iiif/2",
        "website_url": "http://www.artic.edu"
    }
}
"""

        fakeArtworkResponse = gson.fromJson<ArtResponse>(exampleArtworkResponse, ArtResponse::class.java)
        fakeArtwork= fakeArtworkResponse.data[0]
    }
}