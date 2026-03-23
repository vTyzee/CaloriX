package com.example.calorix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "welcome"
            ) {
                composable("welcome") {
                    WelcomeScreen(
                        onLoginClick = {
                            navController.navigate("login")
                        },
                        onSignUpClick = {
                            navController.navigate("register")
                        }
                    )
                }
                composable("login") {
                    LoginScreen(
                        onNavigateBack = {
                            navController.popBackStack()
                        },
                        onNavigateToRegister = {
                            navController.navigate("register")
                        },
                        onNavigateToForgotPassword = {
                            navController.navigate("forgot_password")
                        }
                    )
                }
                composable("register") {
                    RegistrationScreen(
                        onNavigateToLogin = {
                            navController.navigate("login") {
                                popUpTo("welcome")
                            }
                        },
                        onNavigateBack = {
                            navController.popBackStack()
                        }
                    )
                }
                composable("forgot_password") {
                    ForgotPasswordScreen(
                        onNavigateBack = {
                            navController.popBackStack()
                        }
                    )
                }
            }
        }
    }
}