package com.naveen.navhostcompose.basic.navigation

sealed class BasicScreens(val route: String) {
    object FirstScreen : BasicScreens("firstScreen")
    object SecondScreen : BasicScreens("secondScreen/?optionalData={optionalData}") {
        fun createRoute(optionalData: String) = "secondScreen/?optionalData=$optionalData"
    }
    object ThreadScreen : BasicScreens("threadScreen")
    object FourthScreen : BasicScreens("fourthScreen/{name}") {  // fourthScreen/?name={name} is optional
        fun createRoute(name: String) = "fourthScreen/$name"
    }

}
