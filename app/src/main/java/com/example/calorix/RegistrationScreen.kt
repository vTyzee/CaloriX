package com.example.calorix

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegistrationScreen(
    onNavigateToLogin: () -> Unit = {},
    onNavigateBack: () -> Unit = {},
    onRegistrationSuccess: () -> Unit = {}
) {
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))
    val nunitoMedium = FontFamily(Font(R.font.nunito_medium))
    val nunitoSemiBold = FontFamily(Font(R.font.nunito_semibold))

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

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

        // Scrollable content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 10.dp)
        ) {
            // Header: Logo, CaloriX (perfectly centered)
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

            // "Registreerimine" title
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Registreerimine",
                fontSize = 28.sp,
                color = Color.Black,
                fontFamily = nunitoRegular,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            // ---- Nimi field ----
            Spacer(modifier = Modifier.height(14.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_person),
                    contentDescription = "Person icon",
                    modifier = Modifier.size(21.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Nimi",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontFamily = nunitoRegular
                )
            }

            Spacer(modifier = Modifier.height(6.dp))
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                placeholder = {
                    Text(
                        text = "Sisesta nimi",
                        fontSize = 12.5.sp,
                        fontFamily = nunitoRegular,
                        color = Color.Black.copy(alpha = 0.5f)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0xFF41674C),
                    focusedBorderColor = Color(0xFF41674C),
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent
                ),
                singleLine = true,
                textStyle = androidx.compose.ui.text.TextStyle(
                    fontSize = 14.sp,
                    fontFamily = nunitoRegular
                )
            )

            // ---- E-post field ----
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_email),
                    contentDescription = "Email icon",
                    modifier = Modifier.size(21.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "E-post",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontFamily = nunitoRegular
                )
            }

            Spacer(modifier = Modifier.height(6.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = {
                    Text(
                        text = "Sisesta e-post",
                        fontSize = 12.5.sp,
                        fontFamily = nunitoRegular,
                        color = Color.Black.copy(alpha = 0.5f)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
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
                    fontSize = 14.sp,
                    fontFamily = nunitoRegular
                )
            )

            // ---- Parool field ----
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_lock),
                    contentDescription = "Lock icon",
                    modifier = Modifier.size(21.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Parool",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontFamily = nunitoRegular
                )
            }

            Spacer(modifier = Modifier.height(6.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = {
                    Text(
                        text = "Sisesta parool",
                        fontSize = 12.5.sp,
                        fontFamily = nunitoRegular,
                        color = Color.Black.copy(alpha = 0.5f)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
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
                    fontSize = 14.sp,
                    fontFamily = nunitoRegular
                )
            )

            // ---- Kinnita parool field ----
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_lock),
                    contentDescription = "Lock icon",
                    modifier = Modifier.size(21.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Kinnita parool",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontFamily = nunitoRegular
                )
            }

            Spacer(modifier = Modifier.height(6.dp))
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                placeholder = {
                    Text(
                        text = "Kinnita parool",
                        fontSize = 12.5.sp,
                        fontFamily = nunitoRegular,
                        color = Color.Black.copy(alpha = 0.5f)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
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
                    fontSize = 14.sp,
                    fontFamily = nunitoRegular
                )
            )

            // Register button
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { onRegistrationSuccess() },
                modifier = Modifier
                    .size(150.dp, 54.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF62A87C),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = "Register",
                    fontSize = 20.sp,
                    fontFamily = nunitoSemiBold
                )
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

            // "Kas sul on juba konto? Logi sisse."
            Spacer(modifier = Modifier.height(8.dp))
            val annotatedLogin = buildAnnotatedString {
                withStyle(SpanStyle(
                    color = Color.Black,
                    fontSize = 13.sp,
                    fontFamily = nunitoRegular
                )) {
                    append("Kas sul on juba konto? ")
                }
                pushStringAnnotation(tag = "login", annotation = "login")
                withStyle(SpanStyle(
                    color = Color(0xFF62A87C),
                    fontSize = 13.sp,
                    fontFamily = nunitoRegular,
                    textDecoration = TextDecoration.Underline
                )) {
                    append("Logi sisse.")
                }
                pop()
            }
            Text(
                text = annotatedLogin,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onNavigateToLogin() }
            )

            // "või" text
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "või",
                fontSize = 20.sp,
                color = Color.Black,
                fontFamily = nunitoRegular,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            // Social login icons: Facebook + Google
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_facebook),
                    contentDescription = "Facebook",
                    modifier = Modifier
                        .size(40.dp)
                        .clickable { /* TODO: Facebook login */ }
                )
                Spacer(modifier = Modifier.width(26.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = "Google",
                    modifier = Modifier
                        .size(40.dp)
                        .clickable { /* TODO: Google login */ }
                )
            }

            // Bottom padding for scroll
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}
