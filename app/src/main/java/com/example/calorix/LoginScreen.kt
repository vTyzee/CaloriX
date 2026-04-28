package com.example.calorix

import androidx.compose.foundation.Canvas
<<<<<<< HEAD
=======
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
>>>>>>> af8f53d (Seadistasin registreerimise ja sisselogimise ning lisasin ka tooteotsingu (lihtne))
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(
    onNavigateBack: () -> Unit = {},
    onNavigateToRegister: () -> Unit = {},
    onNavigateToForgotPassword: () -> Unit = {},
    onLogicSuccess: () -> Unit = {}
) {
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))
    val nunitoMedium = FontFamily(Font(R.font.nunito_medium))
    val nunitoSemiBold = FontFamily(Font(R.font.nunito_semibold))

<<<<<<< HEAD
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
=======
    val scope = rememberCoroutineScope()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
>>>>>>> af8f53d (Seadistasin registreerimise ja sisselogimise ning lisasin ka tooteotsingu (lihtne))

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE6E8E6))
    ) {
        // Top banner wave
        Image(
            painter = painterResource(id = R.drawable.ic_top_wave),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .scale(2.75f)
                .align(Alignment.TopCenter),
            contentScale = ContentScale.FillWidth
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp)
        ) {
            // Header: Logo, CaloriX, and Logi sisse (perfectly stacked safely)
            Spacer(modifier = Modifier.height(60.dp))
            
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "CaloriX Logo",
                modifier = Modifier
                    .size(125.dp) // layout остаётся прежним
                    .graphicsLayer {
                        scaleX = 1.25f
                        scaleY = 1.25f
                    }
                    .align(Alignment.CenterHorizontally)
                    .wrapContentWidth(unbounded = true)
                    .offset(y = 28.dp)
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = "CaloriX",
                fontSize = 24.sp,
                color = Color(0xFF548C64),
                fontFamily = nunitoMedium,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            // "Logi sisse" title
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Logi sisse",
                fontSize = 32.sp,
                color = Color.Black,
                fontFamily = nunitoRegular,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

<<<<<<< HEAD
=======
            if (errorMessage != null) {
                Text(
                    text = errorMessage!!,
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                    textAlign = TextAlign.Center
                )
            }

>>>>>>> af8f53d (Seadistasin registreerimise ja sisselogimise ning lisasin ka tooteotsingu (lihtne))
            // E-post section
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_email),
                    contentDescription = "Email icon",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "E-post",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontFamily = nunitoRegular
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = {
                    Text(
                        text = "Sisesta e-post",
                        fontSize = 16.sp,
                        fontFamily = nunitoRegular,
                        color = Color.Black.copy(alpha = 0.5f)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0xFF41674C),
                    focusedBorderColor = Color(0xFF41674C),
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                textStyle = androidx.compose.ui.text.TextStyle(
                    fontSize = 16.sp,
                    fontFamily = nunitoRegular
                )
            )

            // Parool section
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_lock),
                    contentDescription = "Lock icon",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Parool",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontFamily = nunitoRegular
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = {
                    Text(
                        text = "Sisesta parool",
                        fontSize = 16.sp,
                        fontFamily = nunitoRegular,
                        color = Color.Black.copy(alpha = 0.5f)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0xFF41674C),
                    focusedBorderColor = Color(0xFF41674C),
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent
                ),
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                textStyle = androidx.compose.ui.text.TextStyle(
                    fontSize = 16.sp,
                    fontFamily = nunitoRegular
                )
            )

            // "Unustasid parooli?" link
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Unustasid parooli?",
                fontSize = 16.sp,
                fontFamily = nunitoRegular,
                color = Color(0xFF62A87C),
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .padding(start = 12.dp)
                    .clickable { onNavigateToForgotPassword() }
            )

            // "Logi sisse" button
            Spacer(modifier = Modifier.height(24.dp))
<<<<<<< HEAD
            Button(
                onClick = { onLogicSuccess() },
                modifier = Modifier
                    .size(150.dp, 54.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF62A87C),
                    contentColor = Color(0xFFE6E8E6)
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = "Logi sisse",
                    fontSize = 20.sp,
                    fontFamily = nunitoSemiBold
                )
=======
            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            } else {
                Button(
                    onClick = {
                        if (email.isBlank() || password.isBlank()) {
                            errorMessage = "Palun täida kõik väljad"
                            return@Button
                        }
                        
                        isLoading = true
                        errorMessage = null
                        scope.launch {
                            val success = FirebaseManager.signIn(email, password)
                            isLoading = false
                            if (success) {
                                onLogicSuccess()
                            } else {
                                errorMessage = "Sisselogimine ebaõnnestus. Kontrolli andmeid."
                            }
                        }
                    },
                    modifier = Modifier
                        .size(150.dp, 54.dp)
                        .align(Alignment.CenterHorizontally),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF62A87C),
                        contentColor = Color(0xFFE6E8E6)
                    ),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(
                        text = "Logi sisse",
                        fontSize = 20.sp,
                        fontFamily = nunitoSemiBold
                    )
                }
>>>>>>> af8f53d (Seadistasin registreerimise ja sisselogimise ning lisasin ka tooteotsingu (lihtne))
            }

            // "Mine tagasi"
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clickable { onNavigateBack() },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back_arrow),
                    contentDescription = "Back",
                    modifier = Modifier.size(12.dp),
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Mine tagasi",
                    fontSize = 12.sp,
                    color = Color.Black,
                    fontFamily = nunitoRegular,
                    textDecoration = TextDecoration.Underline
                )
            }

            // "Kas sul ei ole kontod? Registreeru"
            Spacer(modifier = Modifier.height(8.dp))
            val annotatedRegister = buildAnnotatedString {
                withStyle(SpanStyle(
                    color = Color.Black,
                    fontSize = 13.sp,
                    fontFamily = nunitoRegular
                )) {
                    append("Kas sul ei ole kontod? ")
                }
                pushStringAnnotation(tag = "register", annotation = "register")
                withStyle(SpanStyle(
                    color = Color(0xFF62A87C),
                    fontSize = 13.sp,
                    fontFamily = nunitoRegular,
                    textDecoration = TextDecoration.Underline
                )) {
                    append("Registreeru")
                }
                pop()
            }
            Text(
                text = annotatedRegister,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onNavigateToRegister() }
            )
        }

        // Bottom waves
        Image(
            painter = painterResource(id = R.drawable.ic_wave_bottom),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(x = 40.dp, y = 50.dp)
                .width(3000.dp)
                .wrapContentWidth(unbounded = true),
            contentScale = ContentScale.FillWidth
        )
    }
}
