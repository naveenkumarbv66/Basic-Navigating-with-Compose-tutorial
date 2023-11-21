package com.naveen.navhostcompose.topbar.toolbar

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.naveen.navhostcompose.R
import com.naveen.navhostcompose.basic.navigation.BasicScreens
import com.naveen.navhostcompose.basic.screens.firstScreen

fun showToast(context: Context, msg: String) {
    Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topBarAppBar(
    currentScreen: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Row (verticalAlignment = Alignment.CenterVertically){
                val contextLocal = LocalContext.current
                IconButton(onClick = {
                    showToast(contextLocal, "User image clicked")
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_android_black_24dp),
                        contentDescription = null // decorative element
                    )
                }
                Text(
                   text =  currentScreen
                )
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "back button"
                    )
                }
            }
        }
    )
}

@Composable
fun TopBarExample(navController: NavHostController = rememberNavController()) {

    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = TopBarScreens.valueOf(
        backStackEntry?.destination?.route ?: TopBarScreens.HomeScreen.title
    )


    Scaffold(
        topBar = {
            topBarAppBar(
                currentScreen = currentScreen.title,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = TopBarScreens.HomeScreen.title,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(route = TopBarScreens.HomeScreen.title) {
                HomeScreen(
                    onClick = {
                        navController.navigate(TopBarScreens.DetailsScreen.title)
                    }
                )
            }

            composable(route = TopBarScreens.DetailsScreen.title) {
                DetailsScreen()
            }
        }
    }

}