package com.example.calorix

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import androidx.compose.foundation.isSystemInDarkTheme
import java.text.SimpleDateFormat
import java.util.Date
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen(
    onNavigateBack: () -> Unit = {},
    onNavigateToHome: () -> Unit = {},
    onNavigateToAdd: () -> Unit = {},
    onNavigateToHistory: () -> Unit = {},
    onNavigateToProfile: () -> Unit = {}
) {
    val nunitoMedium = FontFamily(Font(R.font.nunito_medium))
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()

    DisposableEffect(systemUiController, useDarkIcons) {
        systemUiController.setSystemBarsColor(color = Color.Transparent, darkIcons = useDarkIcons)
        onDispose {}
    }

    var selectedItem by remember { mutableStateOf(3) }
    val items = listOf("Home", "Add", "History", "Profile")
    val icons = listOf(Icons.Filled.Home, Icons.Filled.Add, Icons.AutoMirrored.Filled.List, Icons.Filled.Person)

    Scaffold(
        containerColor = Color(0xFFE6E8E6),
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
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(paddingValues).padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            
            // Header
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier.size(56.dp).background(Color.White, RoundedCornerShape(12.dp))
                        .border(1.dp, Color(0xFFCBCBCB), RoundedCornerShape(12.dp))
                        .clickable { onNavigateBack() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.Black, modifier = Modifier.size(32.dp))
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text("Muuda profiili", fontFamily = nunitoRegular, fontSize = 28.sp, color = Color.Black)
                    Text("Andmete muutmine", fontFamily = nunitoRegular, fontSize = 18.sp, color = Color.Gray)
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Top Card
            Box(
                modifier = Modifier.fillMaxWidth().height(140.dp)
                    .border(1.dp, Color(0xFFE2E2E2), RoundedCornerShape(14.dp))
                    .background(Color.White, RoundedCornerShape(14.dp))
                    .padding(horizontal = 20.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier.size(86.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(modifier = Modifier.size(86.dp).clip(CircleShape).background(Color.Gray))
                        Icon(Icons.Filled.Person, contentDescription = "Avatar overlay", tint = Color(0x66FFFFFF), modifier = Modifier.size(52.dp))
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text("Toomas, 20", fontFamily = nunitoRegular, fontSize = 24.sp, color = Color.Black)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text("Eesmärk: 2000 kcal/päev", fontFamily = nunitoRegular, fontSize = 16.sp, color = Color.Gray)
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            var bDay by remember { mutableStateOf("") }
            var bMonth by remember { mutableStateOf("") }
            var bYear by remember { mutableStateOf("") }
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            
            var dayExpanded by remember { mutableStateOf(false) }
            var monthExpanded by remember { mutableStateOf(false) }
            var yearExpanded by remember { mutableStateOf(false) }
            
            val currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR)
            val years = (currentYear downTo 1900).toList()
            val months = (1..12).toList()
            
            val getDaysInMonth = { month: Int, year: Int -> 
                when(month) {
                    2 -> if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) 29 else 28
                    4, 6, 9, 11 -> 30
                    else -> 31
                }
            }
            
            val selectedMonth = bMonth.toIntOrNull() ?: 1
            val selectedYear = bYear.toIntOrNull() ?: currentYear
            val maxDays = getDaysInMonth(selectedMonth, selectedYear)
            val days = (1..maxDays).toList()
            
            LaunchedEffect(maxDays) {
                val currentDayInt = bDay.toIntOrNull()
                if (currentDayInt != null && currentDayInt > maxDays) {
                    bDay = maxDays.toString()
                }
            }
            
            Text("Sisestage sünnikuupäev", fontFamily = nunitoRegular, fontSize = 16.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Päev
                ExposedDropdownMenuBox(
                    expanded = dayExpanded,
                    onExpandedChange = { dayExpanded = it },
                    modifier = Modifier.weight(1f)
                ) {
                    TextField(
                        value = bDay,
                        onValueChange = { },
                        readOnly = true,
                        placeholder = { Text("PP", fontFamily = nunitoRegular, fontSize = 16.sp, color = Color(0xFFCBCBCB)) },
                        modifier = Modifier.menuAnchor().fillMaxWidth().border(1.dp, Color(0xFFE2E2E2), RoundedCornerShape(12.dp)),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White, unfocusedContainerColor = Color.White,
                            focusedIndicatorColor = Color.Transparent, unfocusedIndicatorColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(12.dp),
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = dayExpanded) }
                    )
                    ExposedDropdownMenu(
                        expanded = dayExpanded,
                        onDismissRequest = { dayExpanded = false }
                    ) {
                        days.forEach { d ->
                            DropdownMenuItem(
                                text = { Text(d.toString()) },
                                onClick = { bDay = d.toString(); dayExpanded = false }
                            )
                        }
                    }
                }
                
                // Kuu
                ExposedDropdownMenuBox(
                    expanded = monthExpanded,
                    onExpandedChange = { monthExpanded = it },
                    modifier = Modifier.weight(1f)
                ) {
                    TextField(
                        value = bMonth,
                        onValueChange = { },
                        readOnly = true,
                        placeholder = { Text("KK", fontFamily = nunitoRegular, fontSize = 16.sp, color = Color(0xFFCBCBCB)) },
                        modifier = Modifier.menuAnchor().fillMaxWidth().border(1.dp, Color(0xFFE2E2E2), RoundedCornerShape(12.dp)),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White, unfocusedContainerColor = Color.White,
                            focusedIndicatorColor = Color.Transparent, unfocusedIndicatorColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(12.dp),
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = monthExpanded) }
                    )
                    ExposedDropdownMenu(
                        expanded = monthExpanded,
                        onDismissRequest = { monthExpanded = false }
                    ) {
                        months.forEach { m ->
                            DropdownMenuItem(
                                text = { Text(m.toString()) },
                                onClick = { bMonth = m.toString(); monthExpanded = false }
                            )
                        }
                    }
                }
                
                // Aasta
                ExposedDropdownMenuBox(
                    expanded = yearExpanded,
                    onExpandedChange = { yearExpanded = it },
                    modifier = Modifier.weight(1.2f)
                ) {
                    TextField(
                        value = bYear,
                        onValueChange = { },
                        readOnly = true,
                        placeholder = { Text("AAAA", fontFamily = nunitoRegular, fontSize = 16.sp, color = Color(0xFFCBCBCB)) },
                        modifier = Modifier.menuAnchor().fillMaxWidth().border(1.dp, Color(0xFFE2E2E2), RoundedCornerShape(12.dp)),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White, unfocusedContainerColor = Color.White,
                            focusedIndicatorColor = Color.Transparent, unfocusedIndicatorColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(12.dp),
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = yearExpanded) }
                    )
                    ExposedDropdownMenu(
                        expanded = yearExpanded,
                        onDismissRequest = { yearExpanded = false }
                    ) {
                        years.forEach { y ->
                            DropdownMenuItem(
                                text = { Text(y.toString()) },
                                onClick = { bYear = y.toString(); yearExpanded = false }
                            )
                        }
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(14.dp))

            TextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text("Uus e-post", fontFamily = nunitoRegular, fontSize = 16.sp, color = Color(0xFFCBCBCB)) },
                leadingIcon = { Icon(Icons.Filled.Email, contentDescription = null, tint = Color.Black, modifier = Modifier.size(28.dp)) },
                modifier = Modifier.fillMaxWidth().border(1.dp, Color(0xFFE2E2E2), RoundedCornerShape(12.dp)),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White, unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent, unfocusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(12.dp)
            )
            
            Spacer(modifier = Modifier.height(14.dp))
            
            TextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text("Uus parool", fontFamily = nunitoRegular, fontSize = 16.sp, color = Color(0xFFCBCBCB)) },
                leadingIcon = { 
                    Image(
                        painter = painterResource(id = R.drawable.ic_lock),
                        contentDescription = "Lock icon",
                        modifier = Modifier.size(24.dp)
                    )
                },
                modifier = Modifier.fillMaxWidth().border(1.dp, Color(0xFFE2E2E2), RoundedCornerShape(12.dp)),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White, unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent, unfocusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(12.dp)
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Button(
                    onClick = { /* save logic */ },
                    modifier = Modifier.width(260.dp).height(64.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF549D5C))
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                        Icon(Icons.Filled.CheckCircle, contentDescription = null, tint = Color.White, modifier = Modifier.size(28.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Salvesta", fontSize = 20.sp, color = Color.White, fontFamily = nunitoRegular)
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}
