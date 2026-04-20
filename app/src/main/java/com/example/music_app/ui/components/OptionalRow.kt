package com.example.music_app.ui.components
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.music_app.R
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import okio.Options

@Composable
fun OptionRow(title: String, onClick: () -> Unit = {}) {
    val white = colorResource(R.color.white)

    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 10.dp) // outer spacing
            .fillMaxWidth()
            .clip(RoundedCornerShape(30.dp))
            .background(white)
            .clickable { onClick() }
            .padding(horizontal = 20.dp, vertical = 14.dp), //  ADD vertical here
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            title,
            modifier = Modifier.weight(1f),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.black)
        )

        Image(
            painter = painterResource(R.drawable.arrow),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview
@Composable
fun OptionRowPreview(){
    OptionRow("Simple Title")
}