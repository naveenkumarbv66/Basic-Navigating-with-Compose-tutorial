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
fun SecondScreen(
    onNextScreen: (String) -> Unit,
    onBackScreen: () -> Unit,
    optionalData: String?
) {
    Column {
        Text(
            text = "Second Screen!"
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

        Text(
            text = "optionalData: " + if (optionalData.isNullOrBlank()) "NA" else optionalData
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))


        Button(onClick = { onNextScreen("This is my data from second screen") }) {
            Text(text = "Click to Thread Screen")
        }

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

        Button(onClick = onBackScreen) {
            Text(text = "PopBack")
        }
    }

}