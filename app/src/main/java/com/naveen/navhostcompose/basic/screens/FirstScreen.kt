package com.naveen.navhostcompose.basic.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.naveen.navhostcompose.R

@Composable
fun firstScreen(onClick: () -> Unit){
    Column {

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

        Text(
            text = "first Screen!"
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

        Button(onClick = onClick) {
            Text(text = "Click to Second Screen")
        }
    }
}