package com.example.music_app.feature.home

import com.example.music_app.core.model.Property


fun sampleProperties(): List<Property> = listOf(
    Property(
        id = 1,
        type = "Apartment",
        title = "Royal Apartment",
        address = "LosAngles LA",
        pickPath = "pic_1",
        price = 1500.0,
        bed = 2,
        bath = 3,
        size = 350,
        isGarage = true,
        score = 4.5,
        description = "This 2 bed /1 bath home boasts an enormous, open-living plan..."
    ),
    Property(
        id = 2,
        type = "House",
        title = "House with Great View",
        address = "Newyork NY",
        pickPath = "pic_2",
        price = 800.0,
        bed = 1,
        bath = 2,
        size = 500,
        isGarage = false,
        score = 4.9,
        description = "This 2 bed /1 bath home boasts an enormous, open-living plan..."
    ),
    Property(
        id = 3,
        type = "Villa",
        title = "Royal Villa",
        address = "LosAngles La",
        pickPath = "pic_3",
        price = 999.0,
        bed = 2,
        bath = 1,
        size = 400,
        isGarage = true,
        score = 4.7,
        description = "This 2 bed /1 bath home boasts an enormous, open-living plan..."
    ),
    Property(
        id = 4,
        type = "House",
        title = "beauty house",
        address = "Newyork NY",
        pickPath = "pic_4",
        price = 1750.0,
        bed = 3,
        bath = 2,
        size = 1100,
        isGarage = true,
        score = 4.3,
        description = "This 2 bed /1 bath home boasts an enormous, open-living plan..."
    )
)
