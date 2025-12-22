package com.example.music_app.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.music_app.R
import com.example.music_app.ui.components.CategoriesRow
import com.example.music_app.ui.components.HeaderSection
import com.example.music_app.ui.components.SearchRow


@Composable
@Preview(showSystemUi = true)
fun MainScreen(){

    val items = remember { sampleProperties() }

    LazyColumn (
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .background(color = colorResource(R.color.LightGrey)),
        contentPadding = PaddingValues(bottom = 100.dp)
    ){
        item { HeaderSection()}
        item { Spacer(Modifier.height(16.dp)) }
        item { SearchRow() }
        item { Spacer(Modifier.height(16.dp)) }
        item { CategoriesRow() }

    }

}