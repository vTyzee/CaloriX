package com.example.calorix

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.isSystemInDarkTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    onNavigateToAdd: () -> Unit = {},
    onNavigateToHistory: () -> Unit = {},
    onNavigateToProfile: () -> Unit = {}
) {
    val nunitoMedium = FontFamily(Font(R.font.nunito_medium))
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))
    
    // Bottom Navigation state
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Add", "History", "Profile")
    val icons = listOf(Icons.Filled.Home, Icons.Filled.Add, Icons.AutoMirrored.Filled.List, Icons.Filled.Person)

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()

    DisposableEffect(systemUiController, useDarkIcons) {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = useDarkIcons
        )
        onDispose {}
    }

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color.White,
                contentColor = Color.Black
            ) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon(icons[index], contentDescription = item) },
                        label = { Text(item, fontFamily = nunitoMedium) },
                        selected = selectedItem == index,
                        onClick = {
                            selectedItem = index
                            when(index) {
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
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFE6E8E6))
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp)
            ) {
                // Header (Täna, Date)
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "Täna",
                    fontSize = 32.sp,
                    color = Color.Black,
                    fontFamily = nunitoMedium
                )
                Text(
                    text = "N, 29. jaan",
                    fontSize = 16.sp,
                    color = Color.Gray,
                    fontFamily = nunitoMedium,
                    modifier = Modifier.offset(y = (-4).dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Päeva kalorid Summary Card
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color.White)
                        .padding(20.dp)
                ) {
                    Column {
                        Text(
                            text = "Päeva kalorid",
                            fontSize = 22.sp,
                            color = Color.Black,
                            fontFamily = nunitoMedium
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(
                                    text = "Söödud",
                                    fontSize = 14.sp,
                                    color = Color.Gray,
                                    fontFamily = nunitoMedium
                                )
                                Text(
                                    text = "1240 kcal",
                                    fontSize = 18.sp,
                                    color = Color.Black,
                                    fontFamily = nunitoMedium
                                )
                            }
                            Column(horizontalAlignment = Alignment.End) {
                                Text(
                                    text = "Eesmärk",
                                    fontSize = 14.sp,
                                    color = Color.Gray,
                                    fontFamily = nunitoMedium
                                )
                                Text(
                                    text = "2000 kcal",
                                    fontSize = 18.sp,
                                    color = Color.Black,
                                    fontFamily = nunitoMedium
                                )
                            }
                        }

                        // Progress Bar
                        Spacer(modifier = Modifier.height(16.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(14.dp)
                                .clip(RoundedCornerShape(7.dp))
                                .background(Color(0xFFEFEFEF))
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(fraction = 1240f / 2000f) // 62%
                                    .fillMaxHeight()
                                    .clip(RoundedCornerShape(7.dp))
                                    .background(Color(0xFF4CAE50)) // 43a34a equivalent
                            )
                        }
                    }
                }

                // Tooted Button
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = { /* Handle Tooted Action */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF549D5C)
                    )
                ) {
                    Text(
                        text = "Tooted",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontFamily = nunitoMedium
                    )
                }

                // Toidukorrad Title
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "Toidukorrad",
                    fontSize = 24.sp,
                    color = Color.Black,
                    fontFamily = nunitoMedium
                )
                Spacer(modifier = Modifier.height(12.dp))

                // Meal Cards Loop
                val meals = listOf(
                    "Hommikusöök" to "420 kcal",
                    "Lõunasöök" to "560 kcal",
                    "Õhtusöök" to "260 kcal",
                    "Vahepalad" to "0 kcal"
                )

                meals.forEach { (mealName, mealCalories) ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp)
                            .height(64.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.White)
                            .clickable { /* Handle Nav */ }
                            .padding(horizontal = 20.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = mealName,
                                fontSize = 18.sp,
                                color = Color.Black,
                                fontFamily = nunitoMedium
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = mealCalories,
                                    fontSize = 16.sp,
                                    color = Color.Black,
                                    fontFamily = nunitoMedium
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_back_arrow),
                                    contentDescription = "Forward Icon",
                                    tint = Color.Black,
                                    modifier = Modifier
                                        .size(12.dp)
                                        .graphicsLayer { rotationZ = 180f } // Rotate back arrow to face fully right
                                )
                            }
                        }
                    }
                }
                
                // Extra bottom padding
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}
