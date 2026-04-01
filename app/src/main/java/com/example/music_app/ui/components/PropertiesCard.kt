package com.example.music_app.ui.components

import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.music_app.R
import com.example.music_app.core.model.Property
import com.example.music_app.utils.getDrawableId


@Composable
fun PropertiesCard(item: Property){
    val white = colorResource(R.color.white);
    val blue = colorResource(R.color.blue);
    val black = colorResource(R.color.black);
    val grey = colorResource(R.color.grey);

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .height(320.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(30.dp))
            .background(white)

    ) {
        Box {
            Image(
                painter = painterResource(getDrawableId(item.pickPath)), contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(white)
                    .height(233.dp)
                    .padding(12.dp)
                    .clip(RoundedCornerShape(30.dp)),
                contentScale = ContentScale.Crop

            )

            Text(
                text = "$${item.price}k",
                color = colorResource(R.color.white),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(start = 28.dp, bottom = 28.dp)
                    .align(Alignment.BottomStart)
                    .clip(RoundedCornerShape(50.dp))
                    .background(blue)
                    .padding(horizontal = 16.dp, vertical = 6.dp)

            )
        }
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(30.dp))
                    .padding(horizontal = 16.dp)
            ) {
                Spacer(Modifier.height(8.dp))
                Text(
                    text = item.title,
                    color = black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp

                )
                Text(
                    text = item.description,
                    color = grey,
                    fontSize = 13.sp
                )
                Spacer(Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    MetaChip(R.drawable.bed,"${item.bed} Bed")
                    MetaChip(R.drawable.bath,"${item.bath} Bath")
                    MetaChip(R.drawable.garage,if(item.isGarage)"Car Garage" else "Non- Car Garage");
                    MetaChip(R.drawable.size,"${item.size} m2")

                }
            }

    }
}

@Preview()
@Composable
fun PropertiesCardPreview() {
    // Providing a dummy Property object for the preview to avoid NullPointerException
    PropertiesCard(
        item = Property(
            type = "House",
            title = "Modern Villa",
            address = "123 Main St",
            pickPath = "pic_1",
            price = 500000,
            bed = 3,
            bath = 2,
            size = 200,
            isGarage = true,
            score = 4.5,
            description = "A beautiful modern villa."
        )
    )
}
