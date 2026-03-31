package com.example.calorix

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.assertIsDisplayed
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RegistrationScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testRegistrationScreenDisplaysCorrectly() {
        composeTestRule.setContent {
            RegistrationScreen()
        }

        // Verify the main title is displayed
        composeTestRule.onNodeWithText("Registreerimine").assertIsDisplayed()

        // Verify the fields exist
        composeTestRule.onNodeWithText("Nimi").assertIsDisplayed()
        composeTestRule.onNodeWithText("E-post").assertIsDisplayed()
        composeTestRule.onNodeWithText("Parool").assertIsDisplayed()
        
        // "Kinnita parool" exists both as a Label and a Placeholder, so we get the first matching node
        composeTestRule.onAllNodesWithText("Kinnita parool").onFirst().assertIsDisplayed()

        // Verify Register button is on screen
        composeTestRule.onNodeWithText("Register").assertIsDisplayed()
        
        // Verify backward navigation links
        composeTestRule.onNodeWithText("Mine tagasi").assertIsDisplayed()
    }
}
