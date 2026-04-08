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
                        },
                        onLogicSuccess = {
                            navController.navigate("home") {
                                popUpTo("welcome") { inclusive = true }
                            }
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
                        },
                        onRegistrationSuccess = {
                            navController.navigate("home") {
                                popUpTo("welcome") { inclusive = true }
                            }
                        }
                    )
                }
                composable("forgot_password") {
                    ForgotPasswordScreen(
                        onNavigateBack = {
                            navController.popBackStack()
                        },
                        onNavigateToUusParool = {
                            navController.navigate("uus_parool")
                        }
                    )
                }
                composable("uus_parool") {
                    UusParoolScreen(
                        onNavigateToLogin = {
                            navController.navigate("login") {
                                popUpTo("welcome")
                            }
                        }
                    )
                }
                composable("home") {
                    HomeScreen(
                        onNavigateToAdd = {
                            navController.navigate("add_food")
                        },
                        onNavigateToFoodList = {
                            navController.navigate("food_list")
                        },
                        onNavigateToProfile = {
                            navController.navigate("profile")
                        },
                        onNavigateToHistory = {
                            navController.navigate("history")
                        }
                    )
                }
                composable("add_food") {
                    AddFoodScreen(
                        onNavigateBack = {
                            navController.popBackStack()
                        },
                        onNavigateToHome = {
                            navController.navigate("home") {
                                popUpTo("home") { inclusive = true }
                            }
                        },
                        onNavigateToProfile = {
                            navController.navigate("profile")
                        },
                        onNavigateToHistory = {
                            navController.navigate("history")
                        }
                    )
                }
                composable("food_list") {
                    FoodListScreen(
                        onNavigateBack = {
                            navController.popBackStack()
                        },
                        onNavigateToHome = {
                            navController.navigate("home") {
                                popUpTo("home") { inclusive = true }
                            }
                        },
                        onNavigateToAdd = {
                            navController.navigate("add_food")
                        },
                        onNavigateToProfile = {
                            navController.navigate("profile")
                        },
                        onNavigateToHistory = {
                            navController.navigate("history")
                        },
                        onNavigateToRecommendation = {
                            navController.navigate("recommendation")
                        }
                    )
                }
                composable("profile") {
                    ProfileScreen(
                        onNavigateToHome = {
                            navController.navigate("home") {
                                popUpTo("home") { inclusive = true }
                            }
                        },
                        onNavigateToAdd = {
                            navController.navigate("add_food")
                        },
                        onNavigateToHistory = {
                            navController.navigate("history")
                        },
                        onNavigateToEditProfile = {
                            navController.navigate("edit_profile")
                        },
                        onLogout = {
                            navController.navigate("welcome") {
                                popUpTo(0) { inclusive = true } // Clear all history
                            }
                        }
                    )
                }
                composable("edit_profile") {
                    EditProfileScreen(
                        onNavigateBack = {
                            navController.popBackStack()
                        },
                        onNavigateToHome = {
                            navController.navigate("home") {
                                popUpTo("home") { inclusive = true }
                            }
                        },
                        onNavigateToAdd = {
                            navController.navigate("add_food")
                        },
                        onNavigateToHistory = {
                            navController.navigate("history")
                        },
                        onNavigateToProfile = {
                            navController.navigate("profile")
                        }
                    )
                }
                composable("history") {
                    HistoryScreen(
                        onNavigateToHome = {
                            navController.navigate("home") {
                                popUpTo("home") { inclusive = true }
                            }
                        },
                        onNavigateToAdd = {
                            navController.navigate("add_food")
                        },
                        onNavigateToProfile = {
                            navController.navigate("profile")
                        }
                    )
                }
                composable("recommendation") {
                    RecommendationScreen(
                        onNavigateToHome = {
                            navController.navigate("home") {
                                popUpTo("home") { inclusive = true }
                            }
                        },
                        onNavigateToAdd = {
                            navController.navigate("add_food")
                        },
                        onNavigateToHistory = {
                            navController.navigate("history")
                        },
                        onNavigateToProfile = {
                            navController.navigate("profile")
                        }
                    )
                }
            }
        }
    }
}