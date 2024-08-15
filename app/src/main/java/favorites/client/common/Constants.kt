package favorites.client.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.gson.Gson
import favorites.client.data.models.artworks.ArtResponse
import favorites.client.data.models.artworks.Datum
import favorites.client.data.models.favorites.FavoritesResponse
import favorites.client.data.models.favorites.Favorite


object Constants {
    val modifier = Modifier.padding(paddingValues = PaddingValues(all = 0.dp))
    val favoritesServiceBaseUrl = "http://localhost:8000/favorites/" //change for prod
    val loggingServiceBaseUrl = " https://2aa2-70-107-215-6.ngrok-free.app/"
    val artApiServiceBaseUrl = "https://d7ce-70-107-215-6.ngrok-free.app/" // Route our outbound API calls through our own backend.
    val samMailerBaseUrl =  "https://an9qng3mw0.execute-api.us-east-1.amazonaws.com/Prod/"
    var authenticate = true

    val fakeArtworkResponse: ArtResponse
    val fakeArtwork: Datum

    val fakeFavoritesResponse: FavoritesResponse
    val fakeFavorite: Favorite

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


        val exampleFavoritesResponse = """
           {
    "pagination": {
        "current_page": 1,
        "total_pages": 1,
        "total_items": 10,
        "limit": 10
    },
    "data": [
        {
            "id": "66bd3501ed1b8b261b705311",
            "user_session_email": "chandlerchristopher@example.org",
            "title": "Behind voice which brother range quality religious.",
            "artwork": {
                "_score": 27975,
                "dimensions_detail": [
                    {
                        "depth": null,
                        "diameter": null,
                        "width": 359,
                        "clarification": null,
                        "height": 442
                    }
                ],
                "medium_display": "country on canvas",
                "artist_display": "Sherry Wright",
                "alt_titles": null,
                "style_title": "move",
                "exhibition_history": null,
                "title": "Major dark.",
                "gallery_title": "hit",
                "place_of_origin": "Azerbaijan",
                "api_model": "artworks",
                "api_link": "http://www.carter.com/",
                "image_id": "66bd3501ed1b8b261b705312",
                "dimensions": "63 × 5 cm"
            }
        },
        {
            "id": "66bd3501ed1b8b261b705313",
            "user_session_email": "jamesjason@example.net",
            "title": "Stuff recent girl great southern share.",
            "artwork": {
                "_score": 93196,
                "dimensions_detail": [
                    {
                        "depth": null,
                        "diameter": null,
                        "width": 263,
                        "clarification": null,
                        "height": 805
                    }
                ],
                "medium_display": "meet on canvas",
                "artist_display": "Ronnie Russell",
                "alt_titles": null,
                "style_title": "card",
                "exhibition_history": null,
                "title": "Spend other.",
                "gallery_title": "according",
                "place_of_origin": "Argentina",
                "api_model": "artworks",
                "api_link": "http://www.benton-woods.com/",
                "image_id": "66bd3501ed1b8b261b705314",
                "dimensions": "51 × 13 cm"
            }
        },
        {
            "id": "66bd3501ed1b8b261b705315",
            "user_session_email": "jasonking@example.net",
            "title": "Why hold resource.",
            "artwork": {
                "_score": 14673,
                "dimensions_detail": [
                    {
                        "depth": null,
                        "diameter": null,
                        "width": 940,
                        "clarification": null,
                        "height": 26
                    }
                ],
                "medium_display": "according on canvas",
                "artist_display": "Charles Ballard",
                "alt_titles": null,
                "style_title": "difference",
                "exhibition_history": null,
                "title": "Among high.",
                "gallery_title": "whose",
                "place_of_origin": "Poland",
                "api_model": "artworks",
                "api_link": "https://kelly.com/",
                "image_id": "66bd3501ed1b8b261b705316",
                "dimensions": "29 × 85 cm"
            }
        },
        {
            "id": "66bd3501ed1b8b261b705317",
            "user_session_email": "andrewbutler@example.net",
            "title": "Establish maintain total agree.",
            "artwork": {
                "_score": 59425,
                "dimensions_detail": [
                    {
                        "depth": null,
                        "diameter": null,
                        "width": 896,
                        "clarification": null,
                        "height": 860
                    }
                ],
                "medium_display": "wall on canvas",
                "artist_display": "Kathleen Vazquez",
                "alt_titles": null,
                "style_title": "American",
                "exhibition_history": null,
                "title": "Chair tough.",
                "gallery_title": "imagine",
                "place_of_origin": "Iraq",
                "api_model": "artworks",
                "api_link": "https://www.brooks.com/",
                "image_id": "66bd3501ed1b8b261b705318",
                "dimensions": "11 × 50 cm"
            }
        },
        {
            "id": "66bd3501ed1b8b261b705319",
            "user_session_email": "alexander34@example.net",
            "title": "Manage nothing build.",
            "artwork": {
                "_score": 60815,
                "dimensions_detail": [
                    {
                        "depth": null,
                        "diameter": null,
                        "width": 385,
                        "clarification": null,
                        "height": 874
                    }
                ],
                "medium_display": "hand on canvas",
                "artist_display": "Judith King",
                "alt_titles": null,
                "style_title": "trial",
                "exhibition_history": null,
                "title": "Fear success.",
                "gallery_title": "magazine",
                "place_of_origin": "Barbados",
                "api_model": "artworks",
                "api_link": "http://www.rhodes.com/",
                "image_id": "66bd3501ed1b8b261b70531a",
                "dimensions": "90 × 34 cm"
            }
        },
        {
            "id": "66bd3501ed1b8b261b70531b",
            "user_session_email": "cooperann@example.net",
            "title": "Husband hope five financial pay avoid.",
            "artwork": {
                "_score": 20299,
                "dimensions_detail": [
                    {
                        "depth": null,
                        "diameter": null,
                        "width": 21,
                        "clarification": null,
                        "height": 953
                    }
                ],
                "medium_display": "traditional on canvas",
                "artist_display": "Amanda Smith",
                "alt_titles": null,
                "style_title": "available",
                "exhibition_history": null,
                "title": "Threat.",
                "gallery_title": "mean",
                "place_of_origin": "Bouvet Island (Bouvetoya)",
                "api_model": "artworks",
                "api_link": "https://gordon-ortega.net/",
                "image_id": "66bd3501ed1b8b261b70531c",
                "dimensions": "10 × 58 cm"
            }
        },
        {
            "id": "66bd3501ed1b8b261b70531d",
            "user_session_email": "joannathomas@example.net",
            "title": "Buy notice parent enjoy seek special beautiful.",
            "artwork": {
                "_score": 45362,
                "dimensions_detail": [
                    {
                        "depth": null,
                        "diameter": null,
                        "width": 1,
                        "clarification": null,
                        "height": 355
                    }
                ],
                "medium_display": "table on canvas",
                "artist_display": "Renee Schmidt",
                "alt_titles": null,
                "style_title": "appear",
                "exhibition_history": null,
                "title": "Hard other.",
                "gallery_title": "hear",
                "place_of_origin": "Reunion",
                "api_model": "artworks",
                "api_link": "https://www.stevens-stout.com/",
                "image_id": "66bd3501ed1b8b261b70531e",
                "dimensions": "18 × 24 cm"
            }
        },
        {
            "id": "66bd3501ed1b8b261b70531f",
            "user_session_email": "savannahbrady@example.com",
            "title": "Soldier nearly attack drug the central cell.",
            "artwork": {
                "_score": 69121,
                "dimensions_detail": [
                    {
                        "depth": null,
                        "diameter": null,
                        "width": 159,
                        "clarification": null,
                        "height": 0
                    }
                ],
                "medium_display": "beautiful on canvas",
                "artist_display": "Angela Morrow",
                "alt_titles": null,
                "style_title": "approach",
                "exhibition_history": null,
                "title": "Success forget purpose.",
                "gallery_title": "either",
                "place_of_origin": "Western Sahara",
                "api_model": "artworks",
                "api_link": "http://www.le.com/",
                "image_id": "66bd3501ed1b8b261b705320",
                "dimensions": "96 × 0 cm"
            }
        },
        {
            "id": "66bd3501ed1b8b261b705321",
            "user_session_email": "fadams@example.org",
            "title": "Experience drug note skill forward.",
            "artwork": {
                "_score": 5354,
                "dimensions_detail": [
                    {
                        "depth": null,
                        "diameter": null,
                        "width": 982,
                        "clarification": null,
                        "height": 970
                    }
                ],
                "medium_display": "hundred on canvas",
                "artist_display": "Valerie Hansen",
                "alt_titles": null,
                "style_title": "data",
                "exhibition_history": null,
                "title": "Class.",
                "gallery_title": "care",
                "place_of_origin": "Liberia",
                "api_model": "artworks",
                "api_link": "https://galloway.com/",
                "image_id": "66bd3501ed1b8b261b705322",
                "dimensions": "24 × 73 cm"
            }
        },
        {
            "id": "66bd3501ed1b8b261b705323",
            "user_session_email": "patrick88@example.org",
            "title": "Explain edge voice son.",
            "artwork": {
                "_score": 92843,
                "dimensions_detail": [
                    {
                        "depth": null,
                        "diameter": null,
                        "width": 647,
                        "clarification": null,
                        "height": 260
                    }
                ],
                "medium_display": "table on canvas",
                "artist_display": "Nicole George",
                "alt_titles": null,
                "style_title": "share",
                "exhibition_history": null,
                "title": "Tend question.",
                "gallery_title": "before",
                "place_of_origin": "Bulgaria",
                "api_model": "artworks",
                "api_link": "https://www.fowler.com/",
                "image_id": "66bd3501ed1b8b261b705324",
                "dimensions": "63 × 3 cm"
            }
        }
    ]
} 
"""
        fakeFavoritesResponse = gson.fromJson<FavoritesResponse>(exampleFavoritesResponse, FavoritesResponse::class.java)
        fakeFavorite = fakeFavoritesResponse.data[0]

        fakeArtworkResponse = gson.fromJson<ArtResponse>(exampleArtworkResponse, ArtResponse::class.java)
        fakeArtwork= fakeArtworkResponse.data[0]
    }
}