package com.naveen.navhostcompose.topbar.toolbar

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.naveen.navhostcompose.R

@Composable
fun HomeScreen(onClick: () -> Unit){
    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
    ) {
        Text("Home Screen ")

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

        Button(onClick = onClick) {
            Text(text = "Click to Details Screen")
        }
    }
}



@Composable
fun DetailsScreen(){
    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        repeat(100) {
            Text("Item $it", modifier = Modifier.padding(2.dp))
        }
    }
}

enum class TopBarScreens(val title: String) {
    HomeScreen("HomeScreen"),
    DetailsScreen("DetailsScreen")
}
