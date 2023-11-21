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
fun ThreadScreen(
    onStartFirstScreen: () -> Unit,
    onNextScreen: () -> Unit,
    data : String?,
    date: Int?
) {
    Column {
        Text(
            text = "Thread Screen! $data"
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

        Text(text = "Data:  $data")

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

        Text(text = "Date:  $date")

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

        Button(onClick = onStartFirstScreen) {
            Text(text = "Click to first Screen")
        }

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))


        Button(onClick = onNextScreen) {
            Text(text = "Click to Fourth Screen")
        }
    }

}