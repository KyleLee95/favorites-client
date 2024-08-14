package favorites.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.gson.Gson


object Constants {
    val modifier = Modifier.padding(paddingValues = PaddingValues(all = 0.dp))
    val favoritesServiceBaseUrl = "localhost:8000" //change for prod
    val loggingServiceBaseUrl = "localhost:8001" //change for prod
//    val fakeResponse: BusinessResponse
//    val fakeBusiness: Business

    init {
        val gson = Gson()
        val exampleResponse = """
           {
    "businesses": [
        {
            "id": "b03cgB8GM7J3TjwOA0BGSg",
            "alias": "hoanh-long-chicago",
            "name": "Hoanh Long",
            "image_url": "https://s3-media1.fl.yelpcdn.com/bphoto/K-5zD4RsPOG--YCZK8eYpg/o.jpg",
            "is_closed": false,
            "url": "https://www.yelp.com/biz/hoanh-long-chicago?adjust_creative=8g0DbLVHtXGSnEoDFqGhYw&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=8g0DbLVHtXGSnEoDFqGhYw",
            "review_count": 366,
            "categories": [
                {
                    "alias": "vietnamese",
                    "title": "Vietnamese"
                },
                {
                    "alias": "chinese",
                    "title": "Chinese"
                }
            ],
            "rating": 4.0,
            "coordinates": {
                "latitude": 41.9937167,
                "longitude": -87.7132667
            },
            "transactions": [
                "delivery",
                "pickup"
            ],
            "price": "${'$'}${'$'}",
            "location": {
                "address1": "6148 N Lincoln Ave",
                "address2": "",
                "address3": "",
                "city": "Chicago",
                "zip_code": "60659",
                "country": "US",
                "state": "IL",
                "display_address": [
                    "6148 N Lincoln Ave",
                    "Chicago, IL 60659"
                ]
            },
            "phone": "+17735837770",
            "display_phone": "(773) 583-7770",
            "distance": 10275.499859160936,
            "business_hours": [
                {
                    "open": [
                        {
                            "is_overnight": false,
                            "start": "1030",
                            "end": "2100",
                            "day": 1
                        },
                        {
                            "is_overnight": false,
                            "start": "1030",
                            "end": "2100",
                            "day": 2
                        },
                        {
                            "is_overnight": false,
                            "start": "1030",
                            "end": "2100",
                            "day": 3
                        },
                        {
                            "is_overnight": false,
                            "start": "1030",
                            "end": "2200",
                            "day": 4
                        },
                        {
                            "is_overnight": false,
                            "start": "1030",
                            "end": "2200",
                            "day": 5
                        },
                        {
                            "is_overnight": false,
                            "start": "1030",
                            "end": "2100",
                            "day": 6
                        }
                    ],
                    "hours_type": "REGULAR",
                    "is_open_now": false
                }
            ],
            "attributes": {
                "business_temp_closed": null,
                "menu_url": "http://www.hoanhlong.com/#menu",
                "open24_hours": null,
                "waitlist_reservation": null
            }
        },
        {
            "id": "p2cCK4Vu-3L-skOMd93VVg",
            "alias": "jj-thai-street-food-chicago",
            "name": "JJ Thai Street Food",
            "image_url": "https://s3-media3.fl.yelpcdn.com/bphoto/Fab5uQe-lYI3zD_zyY-XSQ/o.jpg",
            "is_closed": false,
            "url": "https://www.yelp.com/biz/jj-thai-street-food-chicago?adjust_creative=8g0DbLVHtXGSnEoDFqGhYw&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=8g0DbLVHtXGSnEoDFqGhYw",
            "review_count": 498,
            "categories": [
                {
                    "alias": "thai",
                    "title": "Thai"
                }
            ],
            "rating": 4.3,
            "coordinates": {
                "latitude": 41.8958251,
                "longitude": -87.6703764
            },
            "transactions": [
                "delivery",
                "pickup"
            ],
            "price": "${'$'}${'$'}",
            "location": {
                "address1": "1715 W Chicago Ave",
                "address2": "",
                "address3": "",
                "city": "Chicago",
                "zip_code": "60622",
                "country": "US",
                "state": "IL",
                "display_address": [
                    "1715 W Chicago Ave",
                    "Chicago, IL 60622"
                ]
            },
            "phone": "+13129294435",
            "display_phone": "(312) 929-4435",
            "distance": 1204.6495685214984,
            "business_hours": [
                {
                    "open": [
                        {
                            "is_overnight": false,
                            "start": "1130",
                            "end": "1500",
                            "day": 0
                        },
                        {
                            "is_overnight": false,
                            "start": "1700",
                            "end": "2100",
                            "day": 0
                        },
                        {
                            "is_overnight": false,
                            "start": "1130",
                            "end": "1500",
                            "day": 2
                        },
                        {
                            "is_overnight": false,
                            "start": "1700",
                            "end": "2100",
                            "day": 2
                        },
                        {
                            "is_overnight": false,
                            "start": "1130",
                            "end": "1500",
                            "day": 3
                        },
                        {
                            "is_overnight": false,
                            "start": "1700",
                            "end": "2100",
                            "day": 3
                        },
                        {
                            "is_overnight": false,
                            "start": "1130",
                            "end": "1500",
                            "day": 4
                        },
                        {
                            "is_overnight": false,
                            "start": "1700",
                            "end": "2200",
                            "day": 4
                        },
                        {
                            "is_overnight": false,
                            "start": "1130",
                            "end": "1500",
                            "day": 5
                        },
                        {
                            "is_overnight": false,
                            "start": "1700",
                            "end": "2200",
                            "day": 5
                        },
                        {
                            "is_overnight": false,
                            "start": "1130",
                            "end": "1500",
                            "day": 6
                        },
                        {
                            "is_overnight": false,
                            "start": "1700",
                            "end": "2100",
                            "day": 6
                        }
                    ],
                    "hours_type": "REGULAR",
                    "is_open_now": false
                }
            ],
            "attributes": {
                "business_temp_closed": null,
                "menu_url": "https://www.jjthaistreetfood.com/menu",
                "open24_hours": null,
                "waitlist_reservation": null
            }
        },
        {
            "id": "tZw353aqH3YYVkx_gKis4g",
            "alias": "gold-ladle-chicago",
            "name": "Gold Ladle",
            "image_url": "https://s3-media2.fl.yelpcdn.com/bphoto/2T_3MYEL-ugMBZTHO6hsHQ/o.jpg",
            "is_closed": false,
            "url": "https://www.yelp.com/biz/gold-ladle-chicago?adjust_creative=8g0DbLVHtXGSnEoDFqGhYw&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=8g0DbLVHtXGSnEoDFqGhYw",
            "review_count": 8,
            "categories": [
                {
                    "alias": "thai",
                    "title": "Thai"
                }
            ],
            "rating": 5.0,
            "coordinates": {
                "latitude": 41.9181596,
                "longitude": -87.6774271
            },
            "transactions": [
                "delivery",
                "pickup"
            ],
            "location": {
                "address1": "2011 N Damen Ave",
                "address2": null,
                "address3": null,
                "city": "Chicago",
                "zip_code": "60647",
                "country": "US",
                "state": "IL",
                "display_address": [
                    "2011 N Damen Ave",
                    "Chicago, IL 60647"
                ]
            },
            "phone": "+17739691921",
            "display_phone": "(773) 969-1921",
            "distance": 1445.84088922537,
            "business_hours": [
                {
                    "open": [
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2100",
                            "day": 0
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2100",
                            "day": 2
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2100",
                            "day": 3
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2200",
                            "day": 4
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2200",
                            "day": 5
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2100",
                            "day": 6
                        }
                    ],
                    "hours_type": "REGULAR",
                    "is_open_now": false
                }
            ],
            "attributes": {
                "business_temp_closed": null,
                "menu_url": null,
                "open24_hours": null,
                "waitlist_reservation": null
            }
        },
        {
            "id": "zYmfgb7QvbSbZ7_XoH3OKg",
            "alias": "saigon-sisters-chicago-2",
            "name": "Saigon Sisters",
            "image_url": "https://s3-media3.fl.yelpcdn.com/bphoto/Y8YqwTCHxYxcTV34LAN6IA/o.jpg",
            "is_closed": false,
            "url": "https://www.yelp.com/biz/saigon-sisters-chicago-2?adjust_creative=8g0DbLVHtXGSnEoDFqGhYw&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=8g0DbLVHtXGSnEoDFqGhYw",
            "review_count": 623,
            "categories": [
                {
                    "alias": "vietnamese",
                    "title": "Vietnamese"
                },
                {
                    "alias": "thai",
                    "title": "Thai"
                },
                {
                    "alias": "soup",
                    "title": "Soup"
                }
            ],
            "rating": 3.7,
            "coordinates": {
                "latitude": 41.8855816945462,
                "longitude": -87.64216643922539
            },
            "transactions": [
                "delivery",
                "pickup"
            ],
            "price": "${'$'}${'$'}",
            "location": {
                "address1": "567 W Lake St",
                "address2": "",
                "address3": "",
                "city": "Chicago",
                "zip_code": "60661",
                "country": "US",
                "state": "IL",
                "display_address": [
                    "567 W Lake St",
                    "Chicago, IL 60661"
                ]
            },
            "phone": "+13124960090",
            "display_phone": "(312) 496-0090",
            "distance": 3663.423636916213,
            "business_hours": [
                {
                    "open": [
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2100",
                            "day": 1
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2100",
                            "day": 2
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2100",
                            "day": 3
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2200",
                            "day": 4
                        },
                        {
                            "is_overnight": false,
                            "start": "1200",
                            "end": "1530",
                            "day": 5
                        },
                        {
                            "is_overnight": false,
                            "start": "1700",
                            "end": "2200",
                            "day": 5
                        }
                    ],
                    "hours_type": "REGULAR",
                    "is_open_now": false
                }
            ],
            "attributes": {
                "business_temp_closed": null,
                "menu_url": "http://ordersaigonsisters.com/menu",
                "open24_hours": null,
                "waitlist_reservation": null
            }
        },
        {
            "id": "dGd1qhWgmwVDaoLQjON1Pw",
            "alias": "tank-kitchen-and-bar-chicago",
            "name": "Tank Kitchen & Bar",
            "image_url": "https://s3-media4.fl.yelpcdn.com/bphoto/jBxqAm5LRPe5zJPLKHFTyg/o.jpg",
            "is_closed": false,
            "url": "https://www.yelp.com/biz/tank-kitchen-and-bar-chicago?adjust_creative=8g0DbLVHtXGSnEoDFqGhYw&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=8g0DbLVHtXGSnEoDFqGhYw",
            "review_count": 56,
            "categories": [
                {
                    "alias": "vietnamese",
                    "title": "Vietnamese"
                }
            ],
            "rating": 4.2,
            "coordinates": {
                "latitude": 41.95358,
                "longitude": -87.74597
            },
            "transactions": [
                "delivery",
                "pickup"
            ],
            "price": "${'$'}${'$'}",
            "location": {
                "address1": "4706 W Irving Park Rd",
                "address2": "",
                "address3": null,
                "city": "Chicago",
                "zip_code": "60641",
                "country": "US",
                "state": "IL",
                "display_address": [
                    "4706 W Irving Park Rd",
                    "Chicago, IL 60641"
                ]
            },
            "phone": "+17086670252",
            "display_phone": "(708) 667-0252",
            "distance": 7801.529298563922,
            "business_hours": [
                {
                    "open": [
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2100",
                            "day": 0
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2100",
                            "day": 1
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2100",
                            "day": 3
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2100",
                            "day": 4
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2100",
                            "day": 5
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2100",
                            "day": 6
                        }
                    ],
                    "hours_type": "REGULAR",
                    "is_open_now": false
                }
            ],
            "attributes": {
                "business_temp_closed": null,
                "menu_url": "https://tankkitchen.com/chicago-portage-park-tank-kitchen-and-bar-food-menu",
                "open24_hours": null,
                "waitlist_reservation": null
            }
        },
        {
            "id": "Dy4TMIVDR8U89VLE2J3SjQ",
            "alias": "ni-s-kitchen-wilmette",
            "name": "Ni’s Kitchen",
            "image_url": "https://s3-media2.fl.yelpcdn.com/bphoto/c_DFL-r4F4liaNKSStS2oQ/o.jpg",
            "is_closed": false,
            "url": "https://www.yelp.com/biz/ni-s-kitchen-wilmette?adjust_creative=8g0DbLVHtXGSnEoDFqGhYw&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=8g0DbLVHtXGSnEoDFqGhYw",
            "review_count": 38,
            "categories": [
                {
                    "alias": "vietnamese",
                    "title": "Vietnamese"
                }
            ],
            "rating": 4.7,
            "coordinates": {
                "latitude": 42.07692602551211,
                "longitude": -87.70748561490608
            },
            "transactions": [],
            "location": {
                "address1": "708 12th St",
                "address2": "",
                "address3": null,
                "city": "Wilmette",
                "zip_code": "60091",
                "country": "US",
                "state": "IL",
                "display_address": [
                    "708 12th St",
                    "Wilmette, IL 60091"
                ]
            },
            "phone": "+18477280867",
            "display_phone": "(847) 728-0867",
            "distance": 19256.868050119247,
            "business_hours": [
                {
                    "open": [
                        {
                            "is_overnight": false,
                            "start": "1130",
                            "end": "2100",
                            "day": 0
                        },
                        {
                            "is_overnight": false,
                            "start": "1130",
                            "end": "2100",
                            "day": 2
                        },
                        {
                            "is_overnight": false,
                            "start": "1130",
                            "end": "2100",
                            "day": 3
                        },
                        {
                            "is_overnight": false,
                            "start": "1130",
                            "end": "2100",
                            "day": 4
                        },
                        {
                            "is_overnight": false,
                            "start": "1130",
                            "end": "2100",
                            "day": 5
                        },
                        {
                            "is_overnight": false,
                            "start": "1130",
                            "end": "2000",
                            "day": 6
                        }
                    ],
                    "hours_type": "REGULAR",
                    "is_open_now": false
                }
            ],
            "attributes": {
                "business_temp_closed": null,
                "menu_url": null,
                "open24_hours": null,
                "waitlist_reservation": null
            }
        },
        {
            "id": "9BVbkFK0mbkt8T1Bw5J8fg",
            "alias": "the-noodle-vietnamese-cuisine-chicago",
            "name": "The Noodle Vietnamese Cuisine",
            "image_url": "https://s3-media4.fl.yelpcdn.com/bphoto/vCF0jbXz-qrH0eM6BptjyA/o.jpg",
            "is_closed": false,
            "url": "https://www.yelp.com/biz/the-noodle-vietnamese-cuisine-chicago?adjust_creative=8g0DbLVHtXGSnEoDFqGhYw&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=8g0DbLVHtXGSnEoDFqGhYw",
            "review_count": 393,
            "categories": [
                {
                    "alias": "vietnamese",
                    "title": "Vietnamese"
                },
                {
                    "alias": "noodles",
                    "title": "Noodles"
                }
            ],
            "rating": 3.2,
            "coordinates": {
                "latitude": 41.8497742,
                "longitude": -87.6321189
            },
            "transactions": [
                "delivery",
                "pickup"
            ],
            "price": "${'$'}${'$'}",
            "location": {
                "address1": "2336 S Wentworth Ave",
                "address2": "Unit 101",
                "address3": "",
                "city": "Chicago",
                "zip_code": "60616",
                "country": "US",
                "state": "IL",
                "display_address": [
                    "2336 S Wentworth Ave",
                    "Unit 101",
                    "Chicago, IL 60616"
                ]
            },
            "phone": "+13126741168",
            "display_phone": "(312) 674-1168",
            "distance": 7216.259901989629,
            "business_hours": [
                {
                    "open": [
                        {
                            "is_overnight": false,
                            "start": "1000",
                            "end": "2100",
                            "day": 0
                        },
                        {
                            "is_overnight": false,
                            "start": "1000",
                            "end": "2100",
                            "day": 1
                        },
                        {
                            "is_overnight": false,
                            "start": "1000",
                            "end": "2100",
                            "day": 2
                        },
                        {
                            "is_overnight": false,
                            "start": "1000",
                            "end": "2100",
                            "day": 4
                        },
                        {
                            "is_overnight": false,
                            "start": "1000",
                            "end": "2100",
                            "day": 5
                        },
                        {
                            "is_overnight": false,
                            "start": "1000",
                            "end": "2100",
                            "day": 6
                        }
                    ],
                    "hours_type": "REGULAR",
                    "is_open_now": true
                }
            ],
            "attributes": {
                "business_temp_closed": null,
                "menu_url": "https://www.thenoodleschicago.com/menus",
                "open24_hours": null,
                "waitlist_reservation": null
            }
        },
        {
            "id": "jXFtE49rqbJyHuyc8DZuzA",
            "alias": "ld-pho-chicago-2",
            "name": "LD Pho",
            "image_url": "https://s3-media1.fl.yelpcdn.com/bphoto/4JQCo8MxpQhyeEU43R8aUw/o.jpg",
            "is_closed": false,
            "url": "https://www.yelp.com/biz/ld-pho-chicago-2?adjust_creative=8g0DbLVHtXGSnEoDFqGhYw&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=8g0DbLVHtXGSnEoDFqGhYw",
            "review_count": 213,
            "categories": [
                {
                    "alias": "vietnamese",
                    "title": "Vietnamese"
                }
            ],
            "rating": 4.5,
            "coordinates": {
                "latitude": 41.9672852,
                "longitude": -87.7086269
            },
            "transactions": [
                "delivery",
                "pickup"
            ],
            "price": "${'$'}${'$'}",
            "location": {
                "address1": "4722 N Kedzie Ave",
                "address2": "",
                "address3": "",
                "city": "Chicago",
                "zip_code": "60625",
                "country": "US",
                "state": "IL",
                "display_address": [
                    "4722 N Kedzie Ave",
                    "Chicago, IL 60625"
                ]
            },
            "phone": "+17739618551",
            "display_phone": "(773) 961-8551",
            "distance": 7367.279595028401,
            "business_hours": [
                {
                    "open": [
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2100",
                            "day": 0
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2100",
                            "day": 2
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2100",
                            "day": 3
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2100",
                            "day": 4
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2100",
                            "day": 5
                        },
                        {
                            "is_overnight": false,
                            "start": "1100",
                            "end": "2100",
                            "day": 6
                        }
                    ],
                    "hours_type": "REGULAR",
                    "is_open_now": false
                }
            ],
            "attributes": {
                "business_temp_closed": null,
                "menu_url": "https://ldphoil.com/menu",
                "open24_hours": null,
                "waitlist_reservation": null
            }
        },
        {
            "id": "nHiQ7H4nKzYmoDDy9ZI0aQ",
            "alias": "sochi-saigon-kitchen-chicago",
            "name": "Sochi Saigon Kitchen",
            "image_url": "https://s3-media3.fl.yelpcdn.com/bphoto/mcKWq_15GSk3C4ynAD3EMg/o.jpg",
            "is_closed": false,
            "url": "https://www.yelp.com/biz/sochi-saigon-kitchen-chicago?adjust_creative=8g0DbLVHtXGSnEoDFqGhYw&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=8g0DbLVHtXGSnEoDFqGhYw",
            "review_count": 158,
            "categories": [
                {
                    "alias": "vietnamese",
                    "title": "Vietnamese"
                },
                {
                    "alias": "cocktailbars",
                    "title": "Cocktail Bars"
                },
                {
                    "alias": "wine_bars",
                    "title": "Wine Bars"
                }
            ],
            "rating": 4.2,
            "coordinates": {
                "latitude": 41.940026652688616,
                "longitude": -87.663398964418
            },
            "transactions": [
                "delivery",
                "pickup"
            ],
            "location": {
                "address1": "1358 W Belmont Ave",
                "address2": "",
                "address3": null,
                "city": "Chicago",
                "zip_code": "60657",
                "country": "US",
                "state": "IL",
                "display_address": [
                    "1358 W Belmont Ave",
                    "Chicago, IL 60657"
                ]
            },
            "phone": "+17739048511",
            "display_phone": "(773) 904-8511",
            "distance": 4055.1645809415727,
            "business_hours": [
                {
                    "open": [
                        {
                            "is_overnight": false,
                            "start": "1600",
                            "end": "2030",
                            "day": 2
                        },
                        {
                            "is_overnight": false,
                            "start": "1600",
                            "end": "2030",
                            "day": 3
                        },
                        {
                            "is_overnight": false,
                            "start": "1600",
                            "end": "2130",
                            "day": 4
                        },
                        {
                            "is_overnight": false,
                            "start": "1600",
                            "end": "2130",
                            "day": 5
                        }
                    ],
                    "hours_type": "REGULAR",
                    "is_open_now": false
                }
            ],
            "attributes": {
                "business_temp_closed": null,
                "menu_url": null,
                "open24_hours": null,
                "waitlist_reservation": null
            }
        },
        {
            "id": "DYdO9Zp3rFZvzmYIHrSjgg",
            "alias": "ba-le-sandwich-chicago-2",
            "name": "Ba Le Sandwich",
            "image_url": "https://s3-media3.fl.yelpcdn.com/bphoto/fyrqeqtPtqUQGq8Xgf_XGg/o.jpg",
            "is_closed": false,
            "url": "https://www.yelp.com/biz/ba-le-sandwich-chicago-2?adjust_creative=8g0DbLVHtXGSnEoDFqGhYw&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=8g0DbLVHtXGSnEoDFqGhYw",
            "review_count": 893,
            "categories": [
                {
                    "alias": "bakeries",
                    "title": "Bakeries"
                },
                {
                    "alias": "vietnamese",
                    "title": "Vietnamese"
                },
                {
                    "alias": "sandwiches",
                    "title": "Sandwiches"
                }
            ],
            "rating": 3.9,
            "coordinates": {
                "latitude": 41.973162052089414,
                "longitude": -87.65998325531476
            },
            "transactions": [
                "delivery",
                "pickup"
            ],
            "price": "${'$'}",
            "location": {
                "address1": "5014 N Broadway St",
                "address2": "",
                "address3": "",
                "city": "Chicago",
                "zip_code": "60640",
                "country": "US",
                "state": "IL",
                "display_address": [
                    "5014 N Broadway St",
                    "Chicago, IL 60640"
                ]
            },
            "phone": "+17735614424",
            "display_phone": "(773) 561-4424",
            "distance": 7703.266368493816,
            "business_hours": [
                {
                    "open": [
                        {
                            "is_overnight": false,
                            "start": "0800",
                            "end": "1900",
                            "day": 0
                        },
                        {
                            "is_overnight": false,
                            "start": "0800",
                            "end": "1900",
                            "day": 1
                        },
                        {
                            "is_overnight": false,
                            "start": "0800",
                            "end": "1900",
                            "day": 2
                        },
                        {
                            "is_overnight": false,
                            "start": "0800",
                            "end": "1900",
                            "day": 3
                        },
                        {
                            "is_overnight": false,
                            "start": "0800",
                            "end": "1900",
                            "day": 4
                        },
                        {
                            "is_overnight": false,
                            "start": "0800",
                            "end": "2000",
                            "day": 5
                        },
                        {
                            "is_overnight": false,
                            "start": "0800",
                            "end": "2000",
                            "day": 6
                        }
                    ],
                    "hours_type": "REGULAR",
                    "is_open_now": true
                }
            ],
            "attributes": {
                "business_temp_closed": null,
                "menu_url": "http://www.balesandwich.com/menu/",
                "open24_hours": null,
                "waitlist_reservation": null
            }
        }
    ],
    "total": 406,
    "region": {
        "center": {
            "longitude": -87.67776489257812,
            "latitude": 41.90515925618311
        }
    }
}"""
//        fakeResponse =
//            gson.fromJson<BusinessResponse>(exampleResponse, BusinessResponse::class.java)
//
//        fakeBusiness = fakeResponse.businesses[0]


    }
}