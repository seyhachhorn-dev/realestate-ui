package com.example.music_app.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.music_app.R
import com.example.music_app.ui.components.CategoriesRow
import com.example.music_app.ui.components.HeaderSection
import com.example.music_app.ui.components.PropertiesCard
import com.example.music_app.ui.components.SearchRow


@Composable
fun MainScreen(viewModel: PropertyViewModel = viewModel()){

    val properties by viewModel.properties
    val isLoading by viewModel.isLoading
    val error by viewModel.error

    Box(modifier = Modifier.fillMaxSize()) {
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
            
            if (error != null) {
                item {
                    Text(text = error ?: "Unknown error", modifier = Modifier.fillMaxWidth())
                }
            }

            items(properties) { property -> 
                PropertiesCard(property) 
            }
            
            item{Spacer(Modifier.height(16.dp ))}
        }

        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}
