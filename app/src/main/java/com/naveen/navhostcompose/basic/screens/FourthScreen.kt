package com.naveen.navhostcompose.basic.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

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