package com.example.calorix

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import androidx.compose.foundation.isSystemInDarkTheme

@Composable
fun ProfileScreen(
    onNavigateToHome: () -> Unit = {},
    onNavigateToAdd: () -> Unit = {},
    onNavigateToHistory: () -> Unit = {},
    onNavigateToEditProfile: () -> Unit = {},
    onLogout: () -> Unit = {}
) {
    val nunitoMedium = FontFamily(Font(R.font.nunito_medium))
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))

    var selectedItem by remember { mutableStateOf(3) }
    val items = listOf("Home", "Add", "History", "Profile")
    val icons = listOf(Icons.Filled.Home, Icons.Filled.Add, Icons.AutoMirrored.Filled.List, Icons.Filled.Person)

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()
<<<<<<< HEAD
=======
    
    val currentUser = FirebaseManager.getCurrentUser()
>>>>>>> af8f53d (Seadistasin registreerimise ja sisselogimise ning lisasin ka tooteotsingu (lihtne))

    DisposableEffect(systemUiController, useDarkIcons) {
        systemUiController.setSystemBarsColor(color = Color.Transparent, darkIcons = useDarkIcons)
        onDispose {}
    }

    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = Color.White, contentColor = Color.Black) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon(icons[index], contentDescription = item, modifier = Modifier.size(28.dp)) },
                        label = { Text(item, fontFamily = nunitoMedium, fontSize = 14.sp) },
                        selected = selectedItem == index,
                        onClick = {
                            selectedItem = index
                            when(index) {
                                0 -> onNavigateToHome()
                                1 -> onNavigateToAdd()
                                2 -> onNavigateToHistory()
                                // 3 -> Profile
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF548C64),
                            unselectedIconColor = Color.Gray,
                            selectedTextColor = Color(0xFF548C64),
                            unselectedTextColor = Color.Gray,
                            indicatorColor = Color.Transparent
                        )
                    )
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier.fillMaxSize().background(Color(0xFFE6E8E6)).padding(paddingValues)
        ) {
            Column(
                modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 20.dp)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                
                Text("Profiil", fontFamily = nunitoRegular, fontSize = 32.sp, color = Color.Black)
                Text("Akauund ja eesmärgid", fontFamily = nunitoRegular, fontSize = 18.sp, color = Color.Gray)
                
                Spacer(modifier = Modifier.height(24.dp))
                
                // Top Card
                Box(
                    modifier = Modifier.fillMaxWidth().height(140.dp)
                        .background(Color.White, RoundedCornerShape(14.dp))
                        .padding(horizontal = 20.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier.size(86.dp).clip(CircleShape).background(Color.Gray),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Filled.Person, contentDescription = "Avatar", tint = Color.White, modifier = Modifier.size(52.dp))
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
<<<<<<< HEAD
                            Text("Toomas, 20", fontFamily = nunitoRegular, fontSize = 24.sp, color = Color.Black)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text("Eesmärk: 2000 kcal/päev", fontFamily = nunitoRegular, fontSize = 16.sp, color = Color.Gray)
=======
                            val displayName = currentUser?.displayName ?: "Kasutaja"
                            val displayEmail = currentUser?.email ?: ""
                            Text(displayName, fontFamily = nunitoRegular, fontSize = 24.sp, color = Color.Black)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(displayEmail, fontFamily = nunitoRegular, fontSize = 16.sp, color = Color.Gray)
                            Text("Eesmärk: 2000 kcal/päev", fontFamily = nunitoRegular, fontSize = 14.sp, color = Color.Gray)
>>>>>>> af8f53d (Seadistasin registreerimise ja sisselogimise ning lisasin ka tooteotsingu (lihtne))
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(24.dp))
                
                // Edit profile buttons
                Box(
                    modifier = Modifier.fillMaxWidth().height(56.dp)
                        .background(Color.White, RoundedCornerShape(12.dp))
                        .clickable { onNavigateToEditProfile() },
                    contentAlignment = Alignment.Center
                ) {
                    Text("Muuda profiili", fontFamily = nunitoRegular, fontSize = 20.sp, color = Color.Black)
                }
                
                Spacer(modifier = Modifier.height(30.dp))
                
                // Seaded
                Text("Seaded", fontFamily = nunitoRegular, fontSize = 28.sp, color = Color.Black)
                Spacer(modifier = Modifier.height(16.dp))
                
                val settings = listOf("Päevane norm", "Mõõtühikud", "Teavitused", "Rakendusest")
                settings.forEach { setting ->
                    Box(
                        modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp).height(64.dp)
                            .background(Color.White, RoundedCornerShape(12.dp))
                            .clickable { }
                            .padding(horizontal = 20.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                            Text(setting, fontFamily = nunitoRegular, fontSize = 18.sp, color = Color.Black)
                            Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null, tint = Color.Black, modifier = Modifier.size(28.dp))
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(20.dp))
                
                Button(
<<<<<<< HEAD
                    onClick = onLogout,
=======
                    onClick = {
                        FirebaseManager.logout()
                        onLogout()
                    },
>>>>>>> af8f53d (Seadistasin registreerimise ja sisselogimise ning lisasin ka tooteotsingu (lihtne))
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 40.dp).height(64.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF549D5C))
                ) {
                    Text("Logi välja", fontSize = 20.sp, color = Color.White, fontFamily = nunitoMedium)
                }
                
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }
}
