package com.naveen.navhostcompose.basic.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.naveen.navhostcompose.basic.screens.FourthScreen
import com.naveen.navhostcompose.basic.screens.SecondScreen
import com.naveen.navhostcompose.basic.screens.ThreadScreen
import com.naveen.navhostcompose.basic.screens.firstScreen

@Composable
fun navigation(
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = BasicScreens.FirstScreen.route
    ) {
        composable(
            route = BasicScreens.FirstScreen.route
        ) {
            firstScreen(
                onClick = {
//                    navController.navigate(Screens.SecondScreen.createRoute("Naveen Kumar"))
                    navController.navigate(BasicScreens.SecondScreen.route)
                }
            )
        }

        composable(
            route = BasicScreens.SecondScreen.route,
            arguments = listOf(
                navArgument("optionalData") {
                    nullable = true
                }
            )
        ) {
            SecondScreen(
                onNextScreen = { data ->
                    navController.navigate(BasicScreens.ThreadScreen.route + "/$data/20112023")
                },
                onBackScreen = { navController.popBackStack() },
                optionalData = it.arguments?.getString("optionalData")
            )
        }

        otherScreens(navController)

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



fun NavGraphBuilder.otherScreens(navController: NavHostController){
    composable(
        route = BasicScreens.ThreadScreen.route + "/{data}/{date}",
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
                    BasicScreens.FirstScreen.route,
                    false
                )
            },
            onNextScreen = { navController.navigate(BasicScreens.FourthScreen.createRoute("Naveen")) },
            data = NavBackStackEntry.arguments?.getString("data", "NA"),
            date = NavBackStackEntry.arguments?.getInt("date", 2023)
        )
    }


    composable(
        route = BasicScreens.FourthScreen.route
    ) { NavBackStackEntry ->
        FourthScreen(
            onClick = { navController.popBackStack(BasicScreens.SecondScreen.route, true) },
            name = NavBackStackEntry.arguments?.getString("name")
        )
    }
}
