package com.example.calorix

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import androidx.compose.foundation.isSystemInDarkTheme

@Composable
fun RecommendationScreen(
    onNavigateToHome: () -> Unit = {},
    onNavigateToAdd: () -> Unit = {},
    onNavigateToHistory: () -> Unit = {},
    onNavigateToProfile: () -> Unit = {}
) {
    val nunitoMedium = FontFamily(Font(R.font.nunito_medium))
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))

    var selectedItem by remember { mutableStateOf(-1) }
    val items = listOf("Home", "Add", "History", "Profile")
    val icons = listOf(Icons.Filled.Home, Icons.Filled.Add, Icons.AutoMirrored.Filled.List, Icons.Filled.Person)

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()

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
                                3 -> onNavigateToProfile()
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
                
                Text("Nõuanded", fontFamily = nunitoRegular, fontSize = 32.sp, color = Color.Black)
                Text("Lihtne ja kasulik", fontFamily = nunitoRegular, fontSize = 18.sp, color = Color.Gray)
                
                Spacer(modifier = Modifier.height(24.dp))
                
                val recs = listOf(
                    "Joo vett" to "6–8 klaasi päevas",
                    "Köögiviljad iga päev" to "Lisa 2 portsjonit",
                    "Valk igas toidukorras" to "Toitvam ja kasulikum",
                    "Ära jäta hommikusööki vahele" to "Energia kogu päevaks",
                    "Magusat — mõõdukalt" to "Planeeri ette"
                )
                
                recs.forEach { (title, subtitle) ->
                    Box(
                        modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp).height(80.dp)
                            .background(Color.White, RoundedCornerShape(14.dp))
                            .padding(horizontal = 20.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Filled.CheckCircle, 
                                contentDescription = null, 
                                tint = Color(0xFF549D5C), 
                                modifier = Modifier.size(40.dp)
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Column {
                                Text(title, fontFamily = nunitoMedium, fontSize = 20.sp, color = Color.Black)
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(subtitle, fontFamily = nunitoRegular, fontSize = 16.sp, color = Color.Gray)
                            }
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }
}
