package com.naveen.navhostcompose.navigation

sealed class Screens(val route: String) {
    object FirstScreen : Screens("firstScreen")
    object SecondScreen : Screens("secondScreen/?optionalData={optionalData}"){
        fun createRoute(optionalData: String) = "secondScreen/?optionalData=$optionalData"
    }
    object ThreadScreen : Screens("threadScreen")
    object FourthScreen : Screens("fourthScreen/{name}") {  // fourthScreen/?name={name} is optional
        fun createRoute(name: String) = "fourthScreen/$name"
    }

}
