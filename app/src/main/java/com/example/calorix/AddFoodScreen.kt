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
fun AddFoodScreen(
    onNavigateBack: () -> Unit = {},
    onNavigateToHome: () -> Unit = {},
    onNavigateToHistory: () -> Unit = {},
    onNavigateToProfile: () -> Unit = {}
) {
    val nunitoMedium = FontFamily(Font(R.font.nunito_medium))
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))

    // Bottom Navigation state - 'Add' is index 1
    var selectedItem by remember { mutableStateOf(1) }
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

    var selectedMeal by remember { mutableStateOf("Hommik") }
    val mealOptions = listOf("Hommik", "Lõuna", "Õhtu", "Vahepala")

<<<<<<< HEAD
    val popularFoods = when (selectedMeal) {
        "Hommik" -> listOf(
            "Kanarind" to "165 kcal - 100 g",
            "Jogurt" to "59 kcal - 100 g",
            "Õun" to "52 kcal - 100 g",
            "Riis" to "130 kcal - 100 g",
            "Kaerahelbed" to "67 kcal - 100 g",
            "Lõhefilee" to "260 kcal - 100 g",
            "Kohupiim" to "121 kcal - 100 g"
        )
        "Lõuna" -> listOf(
            "Kanafilee" to "165 kcal - 100 g",
            "Riis" to "130 kcal - 100 g",
            "Keedetud kartul" to "87 kcal - 100 g",
            "Köögiviljasalat oliiviõliga" to "120 kcal - 100 g",
            "Pasta tomatikastmega" to "150 kcal - 100 g",
            "Küpsetatud lõhe" to "208 kcal - 100 g",
            "Tatar" to "110 kcal - 100 g"
        )
        "Õhtu" -> listOf(
            "Omlett köögiviljadega" to "140 kcal - 100 g",
            "Kodujuust" to "121 kcal - 100 g",
            "Ahjuköögiviljad" to "90 kcal - 100 g",
            "Aurutatud kala" to "120 kcal - 100 g",
            "Kana salat" to "150 kcal - 100 g",
            "Keefir" to "52 kcal - 100 g",
            "Tofu" to "76 kcal - 100 g"
        )
        "Vahepala" -> listOf(
            "Õun" to "52 kcal - 100 g",
            "Jogurt" to "59 kcal - 100 g",
            "Mandlid" to "579 kcal - 100 g",
            "Banaan" to "89 kcal - 100 g",
            "Valgubatoon" to "200 kcal - 100 g",
            "Porgand" to "41 kcal - 100 g",
            "Hummus" to "166 kcal - 100 g"
        )
        else -> emptyList()
=======
    var searchQuery by remember { mutableStateOf("") }
    var searchResults by remember { mutableStateOf<List<FoodProduct>>(emptyList()) }
    var isLoading by remember { mutableStateOf(false) }

    // Seed database on first launch and load initial products
    LaunchedEffect(Unit) {
        FirebaseManager.seedDatabaseIfEmpty()
    }

    // Search logic with debounce or simple trigger
    LaunchedEffect(searchQuery) {
        if (searchQuery.isNotEmpty()) {
            isLoading = true
            searchResults = FirebaseManager.searchProducts(searchQuery)
            isLoading = false
        } else {
            searchResults = emptyList()
        }
>>>>>>> af8f53d (Seadistasin registreerimise ja sisselogimise ning lisasin ka tooteotsingu (lihtne))
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
                                0 -> onNavigateToHome()
                                1 -> { /* already here */ }
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
                            text = "Lisa toit",
                            fontFamily = nunitoRegular,
                            fontSize = 24.sp,
                            color = Color.Black
                        )
                        Text(
                            text = "Vali toode ja söögikord",
                            fontFamily = nunitoRegular,
                            fontSize = 14.sp,
                            color = Color(0x99000000)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Meal Selection
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    mealOptions.forEach { option ->
                        val isSelected = selectedMeal == option
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 4.dp)
                                .height(40.dp)
                                .background(
                                    color = if (isSelected) Color(0xFF549D5C) else Color.Transparent,
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .border(
                                    width = if (isSelected) 0.dp else 0.5.dp,
                                    color = if (isSelected) Color.Transparent else Color(0xFF9C9C9C),
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .clickable { selectedMeal = option },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = option,
                                fontFamily = nunitoRegular,
                                fontSize = 15.sp,
                                color = if (isSelected) Color.White else Color.Black
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Search Bar
<<<<<<< HEAD
                Text(
                    text = "Otsing",
                    fontFamily = nunitoRegular,
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 4.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                
                var searchQuery by remember { mutableStateOf("") }
                
=======
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Otsing",
                        fontFamily = nunitoRegular,
                        fontSize = 20.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                    
                    // Visual Search Button
                    IconButton(onClick = { /* TODO: Implement Barcode Scanner */ }) {
                        Icon(
                            imageVector = Icons.Default.Add, // Using Add icon as a placeholder since ic_camera is missing
                            contentDescription = "Visual Search",
                            tint = Color(0xFF549D5C),
                            modifier = Modifier.size(28.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                
>>>>>>> af8f53d (Seadistasin registreerimise ja sisselogimise ning lisasin ka tooteotsingu (lihtne))
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = { 
                        Text(
                            "näiteks: kana", 
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

                Spacer(modifier = Modifier.height(28.dp))

<<<<<<< HEAD
                // Popular Section
                Text(
                    text = "Populaarsed",
=======
                // Results Section
                Text(
                    text = if (searchQuery.isEmpty()) "Populaarsed" else "Tulemused",
>>>>>>> af8f53d (Seadistasin registreerimise ja sisselogimise ning lisasin ka tooteotsingu (lihtne))
                    fontFamily = nunitoRegular,
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 4.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))

<<<<<<< HEAD
                popularFoods.forEach { (name, info) ->
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
                                    text = info,
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
=======
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        color = Color(0xFF549D5C)
                    )
                } else if (searchResults.isEmpty() && searchQuery.isNotEmpty()) {
                    Text(
                        text = "Tooteid ei leitud",
                        modifier = Modifier.padding(16.dp),
                        fontFamily = nunitoRegular,
                        color = Color.Gray
                    )
                } else {
                    // Show search results or some defaults if empty
                    val displayList = if (searchResults.isNotEmpty()) searchResults else emptyList()
                    
                    displayList.forEach { product ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 14.dp)
                                .height(70.dp)
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
                                        text = product.name,
                                        fontFamily = nunitoRegular,
                                        fontSize = 16.sp,
                                        color = Color.Black
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))
                                    Text(
                                        text = "${product.calories} kcal - ${product.unit}",
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
                                        .clickable { /* Add to daily log logic */ },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Add,
                                        contentDescription = "Add",
                                        tint = Color.Black,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
>>>>>>> af8f53d (Seadistasin registreerimise ja sisselogimise ning lisasin ka tooteotsingu (lihtne))
                            }
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}
