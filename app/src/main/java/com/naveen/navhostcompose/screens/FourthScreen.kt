package com.naveen.navhostcompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.naveen.navhostcompose.navigation.Screens

@Composable
fun FourthScreen(onClick: () -> Unit, name: String?) {
    Column {
        Text(
            text = "Fourth Screen! : $name"
        )
        Button(onClick = onClick) {
            Text(text = "Click to first Screen")
        }
    }

}


data class PersonInfo(val name: String, val age: Int)