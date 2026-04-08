package com.example.calorix

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import androidx.compose.foundation.isSystemInDarkTheme

@Composable
fun FoodListScreen(
    onNavigateBack: () -> Unit = {},
    onNavigateToHome: () -> Unit = {},
    onNavigateToAdd: () -> Unit = {},
    onNavigateToHistory: () -> Unit = {},
    onNavigateToProfile: () -> Unit = {},
    onNavigateToRecommendation: () -> Unit = {}
) {
    val nunitoMedium = FontFamily(Font(R.font.nunito_medium))
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))

    // Bottom Navigation state - we can keep 'Home' (0) active or no selection
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

    val foodItems = listOf(
        "Banaan" to "89 kcal",
        "Riis (keedetud)" to "130 kcal",
        "Juust" to "402 kcal",
        "Leib" to "265 kcal",
        "Lõhe" to "208 kcal"
    )

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
                Spacer(modifier = Modifier.height(20.dp))

                // Header
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(Color.White, RoundedCornerShape(12.dp))
                            .border(0.5.dp, Color.Gray, RoundedCornerShape(12.dp))
                            .clickable { onNavigateBack() },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back_arrow),
                            contentDescription = "Back",
                            tint = Color.Black,
                            modifier = Modifier
                                .size(20.dp)
                                .graphicsLayer { rotationZ = 180f }
                        )
                    }
                    
                    Spacer(modifier = Modifier.width(16.dp))
                    
                    Column {
                        Text(
                            text = "Tooted",
                            fontFamily = nunitoRegular,
                            fontSize = 24.sp,
                            color = Color.Black
                        )
                        Text(
                            text = "Kalorite tabel",
                            fontFamily = nunitoRegular,
                            fontSize = 14.sp,
                            color = Color(0x99000000)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))

                // Search Bar Section
                Text(
                    text = "Otsing",
                    fontFamily = nunitoRegular,
                    fontSize = 20.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 4.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                
                var searchQuery by remember { mutableStateOf("") }
                
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = { 
                        Text(
                            "Otsi toodet", 
                            fontFamily = nunitoRegular,
                            fontSize = 15.sp,
                            color = Color.Gray
                        ) 
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedBorderColor = Color(0xFF9C9C9C),
                        unfocusedBorderColor = Color(0xFF9C9C9C),
                        cursorColor = Color.Black
                    ),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Categories Box (looks like search bar but bigger)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .background(Color.White, RoundedCornerShape(14.dp))
                        .border(0.5.dp, Color(0xFF9C9C9C), RoundedCornerShape(14.dp))
                        .padding(horizontal = 16.dp, vertical = 14.dp),
                    contentAlignment = Alignment.TopStart
                ) {
                    Text(
                        text = "Kategooriad: Liha * Puuviljad * Joogid",
                        fontFamily = nunitoRegular,
                        fontSize = 15.sp,
                        color = Color.Gray
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Nimekiri Section
                Text(
                    text = "Nimekiri",
                    fontFamily = nunitoRegular,
                    fontSize = 22.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 4.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))

                foodItems.forEach { (name, calories) ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 14.dp)
                            .height(60.dp)
                            .background(Color.White, RoundedCornerShape(14.dp))
                            .border(0.5.dp, Color(0xFF9C9C9C), RoundedCornerShape(14.dp))
                            .padding(horizontal = 20.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(verticalArrangement = Arrangement.Center) {
                                Text(
                                    text = name,
                                    fontFamily = nunitoRegular,
                                    fontSize = 16.sp,
                                    color = Color.Black
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = calories,
                                    fontFamily = nunitoRegular,
                                    fontSize = 12.sp,
                                    color = Color.Gray
                                )
                            }
                            
                            Box(
                                modifier = Modifier
                                    .size(32.dp)
                                    .background(Color.White, RoundedCornerShape(12.dp))
                                    .border(1.dp, Color.Black, RoundedCornerShape(12.dp))
                                    .clickable { /* Add logic */ },
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = "Add",
                                    tint = Color.Black,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(32.dp))

                // Nõuanded Button
                Button(
                    onClick = onNavigateToRecommendation,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF549D5C)
                    )
                ) {
                    Text(
                        text = "Nõuanded",
                        fontSize = 22.sp,
                        color = Color.White,
                        fontFamily = nunitoMedium
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}
