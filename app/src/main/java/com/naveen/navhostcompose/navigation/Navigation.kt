package com.naveen.navhostcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.naveen.navhostcompose.screens.FourthScreen
import com.naveen.navhostcompose.screens.SecondScreen
import com.naveen.navhostcompose.screens.ThreadScreen
import com.naveen.navhostcompose.screens.firstScreen

@Composable
fun navigation(
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = Screens.FirstScreen.route
    ) {
        composable(
            route = Screens.FirstScreen.route
        ) {
            firstScreen(
                onClick = {
//                    navController.navigate(Screens.SecondScreen.createRoute("Naveen Kumar"))
                    navController.navigate(Screens.SecondScreen.route)
                }
            )
        }

        composable(
            route = Screens.SecondScreen.route,
            arguments = listOf(
                navArgument("optionalData") {
                    nullable = true
                }
            )
        ) {
            SecondScreen(
                onNextScreen = { data ->
                    navController.navigate(Screens.ThreadScreen.route + "/$data/20112023")
                },
                onBackScreen = { navController.popBackStack() },
                optionalData = it.arguments?.getString("optionalData")
            )
        }

        OtherScreens(navController)

        /*composable(
            route = Screens.ThreadScreen.route + "/{data}/{date}",
            arguments = listOf(
                navArgument("data") {
                    type = NavType.StringType
                    defaultValue = "Nothing"
                    nullable = false
                },
                navArgument("date") {
                    type = NavType.IntType
                    defaultValue = 2023
                }
            )
        ) { NavBackStackEntry ->
            ThreadScreen(
                onStartFirstScreen = {
                    navController.popBackStack(
                        Screens.FirstScreen.route,
                        false
                    )
                },
                onNextScreen = { navController.navigate(Screens.FourthScreen.createRoute("Naveen")) },
                data = NavBackStackEntry.arguments?.getString("data", "NA"),
                date = NavBackStackEntry.arguments?.getInt("date", 2023)
            )
        }


        composable(
            route = Screens.FourthScreen.route
        ) { NavBackStackEntry ->
            FourthScreen(
                onClick = { navController.popBackStack(Screens.SecondScreen.route, true) },
                name = NavBackStackEntry.arguments?.getString("name")
            )
        }*/

    }
}



fun NavGraphBuilder.OtherScreens(navController: NavHostController){
    composable(
        route = Screens.ThreadScreen.route + "/{data}/{date}",
        arguments = listOf(
            navArgument("data") {
                type = NavType.StringType
                defaultValue = "Nothing"
                nullable = false
            },
            navArgument("date") {
                type = NavType.IntType
                defaultValue = 2023
            }
        )
    ) { NavBackStackEntry ->
        ThreadScreen(
            onStartFirstScreen = {
                navController.popBackStack(
                    Screens.FirstScreen.route,
                    false
                )
            },
            onNextScreen = { navController.navigate(Screens.FourthScreen.createRoute("Naveen")) },
            data = NavBackStackEntry.arguments?.getString("data", "NA"),
            date = NavBackStackEntry.arguments?.getInt("date", 2023)
        )
    }


    composable(
        route = Screens.FourthScreen.route
    ) { NavBackStackEntry ->
        FourthScreen(
            onClick = { navController.popBackStack(Screens.SecondScreen.route, true) },
            name = NavBackStackEntry.arguments?.getString("name")
        )
    }
}
