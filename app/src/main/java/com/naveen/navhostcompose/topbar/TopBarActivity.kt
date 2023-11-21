package com.naveen.navhostcompose.topbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.naveen.navhostcompose.topbar.basic.MediumTopAppBarExample
import com.naveen.navhostcompose.topbar.toolbar.TopBarExample
import com.naveen.navhostcompose.ui.theme.NavhostComposeTheme

class TopBarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavhostComposeTheme {
                // A surface container using the 'background' color from the theme
//                MediumTopAppBarExample()
                TopBarExample()
            }
        }
    }
}