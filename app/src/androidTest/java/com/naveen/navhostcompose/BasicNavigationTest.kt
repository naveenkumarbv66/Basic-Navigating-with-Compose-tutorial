package com.naveen.navhostcompose

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.naveen.navhostcompose.basic.navigation.navigation
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class BasicNavigationTest {

    @get: Rule
    val composeTestRule = createComposeRule()
    lateinit var navController: TestNavHostController

    @Before
    fun setupAppNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            navigation(navController = navController)
        }
    }

    @Test
    fun appNavHost_verifyStartDestination() {
        composeTestRule
            .onNodeWithText("first Screen!")
            .assertIsDisplayed()
    }

    @Test
    fun appNavHost_OnClikc() {
        composeTestRule
            .onNodeWithText("Click to Second Screen")
            .performClick()

        composeTestRule
            .onNodeWithText("Second Screen!")
            .assertIsDisplayed()
    }
}