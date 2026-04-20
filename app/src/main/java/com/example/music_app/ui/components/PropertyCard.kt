package com.example.music_app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.music_app.R
import com.example.music_app.core.model.Property
import com.example.music_app.utils.getDrawableId

@Composable
fun PropertyCard(item: Property){
    val white = colorResource(R.color.white);
    val blue = colorResource(R.color.blue);
    val black = colorResource(R.color.black);
    val grey = colorResource(R.color.grey);

    Column (
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .height(320.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(30.dp))
            .background(white)
    ) {
        Box{
            Image(
                painter = painterResource(getDrawableId(item.pickPath)),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(white)
                    .height(233.dp)
                    .padding(12.dp)
                    .clip(RoundedCornerShape(30.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PropertyCardPreview() {
    PropertyCard(
        item = Property(
            id = 1,
            type = "Apartment",
            title = "Modern Luxury Apartment",
            address = "Phnom Penh, Cambodia",
            pickPath = "pic_1.jpg",
            price = 120000.0,
            bed = 3,
            bath = 2,
            size = 120,
            isGarage = true,
            score = 4.8,
            description = "A modern apartment located in the city center with great facilities."
        )
    )
}
