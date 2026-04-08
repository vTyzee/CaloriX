package com.example.calorix

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
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
fun HistoryScreen(
    onNavigateToHome: () -> Unit = {},
    onNavigateToAdd: () -> Unit = {},
    onNavigateToProfile: () -> Unit = {}
) {
    val nunitoMedium = FontFamily(Font(R.font.nunito_medium))
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))

    var selectedItem by remember { mutableStateOf(2) }
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
                                // 2 -> History
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
                
                Text("Ajalugu", fontFamily = nunitoRegular, fontSize = 32.sp, color = Color.Black)
                Text("Viimased 7 päeva", fontFamily = nunitoRegular, fontSize = 18.sp, color = Color.Gray)
                
                Spacer(modifier = Modifier.height(24.dp))
                
                Text("Kalorite graafik", fontFamily = nunitoRegular, fontSize = 24.sp, color = Color.Black)
                Spacer(modifier = Modifier.height(10.dp))

                Box(
                    modifier = Modifier.fillMaxWidth().height(180.dp)
                        .background(Color.White, RoundedCornerShape(14.dp))
                        .border(0.5.dp, Color(0xFFCBCBCB), RoundedCornerShape(14.dp))
                        .padding(horizontal = 16.dp, vertical = 20.dp),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    val heights = listOf(0.6f, 1f, 0.3f, 1.1f, 0.7f, 0.5f, 0.8f) // fake relative heights
                    Row(
                        modifier = Modifier.fillMaxWidth().height(140.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        heights.forEach { h ->
                            Box(
                                modifier = Modifier
                                    .width(36.dp)
                                    .fillMaxHeight(h * 0.85f)
                                    .background(Color(0xFF549D5C), RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp))
                            )
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(30.dp))
                
                val historyItems = listOf(
                    "29 jaanuar" to "2013 kcal",
                    "28 jaanuar" to "1695 kcal",
                    "27 jaanuar" to "1782 kcal",
                    "26 jaanuar" to "1814 kcal"
                )
                
                historyItems.forEach { (date, kcal) ->
                    Box(
                        modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp).height(56.dp)
                            .background(Color.White, RoundedCornerShape(12.dp))
                            .border(0.5.dp, Color(0xFFCBCBCB), RoundedCornerShape(12.dp))
                            .padding(horizontal = 20.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                            Text(date, fontFamily = nunitoRegular, fontSize = 18.sp, color = Color.Black)
                            Text(kcal, fontFamily = nunitoRegular, fontSize = 18.sp, color = Color.Black)
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }
}
