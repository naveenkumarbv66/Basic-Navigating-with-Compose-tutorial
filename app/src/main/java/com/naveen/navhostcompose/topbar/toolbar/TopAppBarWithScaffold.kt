package com.naveen.navhostcompose.topbar.toolbar

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    val contextLocal = LocalContext.current
   // var showMenu by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Row (verticalAlignment = Alignment.CenterVertically){
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
        },
        actions = {
            topBarActions(currentScreen)
           /* if(currentScreen == TopBarScreens.HomeScreen.title){
                IconButton(onClick = {showToast(contextLocal, "Edit") }) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = "back button"
                    )
                }
            }else{
                IconButton(onClick = {showToast(contextLocal, "Account Box") }) {
                    Icon(
                        imageVector = Icons.Filled.AccountBox,
                        contentDescription = "back button"
                    )
                }

                IconButton(onClick = { showMenu = !showMenu }) {
                    Icon(
                        imageVector = Icons.Filled.MoreVert,
                        contentDescription = "More",
                    )
                }

                DropdownMenu(
                    expanded = showMenu,
                    onDismissRequest = { showMenu = false }
                ){
                    DropdownMenuItem(
                        text = {
                            Text("Refresh")
                        },
                        onClick = { showToast(contextLocal, "Refresh")
                            showMenu = false},
                    )
                    DropdownMenuItem(
                        text = {
                            Text("Settings")
                        },
                        onClick = { showToast(contextLocal, "Settings") },
                    )
                    DropdownMenuItem(
                        text = {
                            Text("About")
                        },
                        onClick = { showToast(contextLocal, "About") },
                    )
                }
            }*/
        }
    )
}

@Composable
fun TopBarExample(navController: NavHostController = rememberNavController()) {

    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = backStackEntry?.destination?.route ?: TopBarScreens.HomeScreen.title


    Scaffold(
        topBar = {
            topBarAppBar(
                currentScreen = currentScreen,
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


@Composable
fun topBarActions(currentScreen: String){
    var showMenu by remember { mutableStateOf(false) }
    val contextLocal = LocalContext.current
    if(currentScreen == TopBarScreens.HomeScreen.title){
        IconButton(onClick = {showToast(contextLocal, "Edit") }) {
            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription = "back button"
            )
        }
    }else {
        IconButton(onClick = { showToast(contextLocal, "Account Box") }) {
            Icon(
                imageVector = Icons.Filled.AccountBox,
                contentDescription = "back button"
            )
        }

        IconButton(onClick = { showMenu = !showMenu }) {
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = "More",
            )
        }

        DropdownMenu(
            expanded = showMenu,
            onDismissRequest = { showMenu = false }
        ) {
            DropdownMenuItem(
                text = {
                    Text("Refresh")
                },
                onClick = {
                    showToast(contextLocal, "Refresh")
                    showMenu = false
                },
            )
            DropdownMenuItem(
                text = {
                    Text("Settings")
                },
                onClick = { showToast(contextLocal, "Settings") },
            )
            DropdownMenuItem(
                text = {
                    Text("About")
                },
                onClick = { showToast(contextLocal, "About") },
            )
        }
    }
}