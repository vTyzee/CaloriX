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
import androidx.compose.ui.graphics.Color
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
    onNavigateBack: () -> Unit = {}
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
        // Top-right corner decorative shapes (same as login)
        Box(
            modifier = Modifier.align(Alignment.TopEnd)
        ) {
            Image(
                painter = painterResource(id = R.drawable.corner_shape_back),
                contentDescription = null,
                modifier = Modifier
                    .width(110.dp)
                    .height(124.dp),
                contentScale = ContentScale.FillBounds
            )
            Image(
                painter = painterResource(id = R.drawable.corner_shape_front),
                contentDescription = null,
                modifier = Modifier
                    .width(93.dp)
                    .height(105.dp)
                    .align(Alignment.TopEnd),
                contentScale = ContentScale.FillBounds
            )
        }

        // Bottom-left corner decorative shapes (rotated 180°)
        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .rotate(180f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.corner_shape_back),
                contentDescription = null,
                modifier = Modifier
                    .width(110.dp)
                    .height(124.dp),
                contentScale = ContentScale.FillBounds
            )
            Image(
                painter = painterResource(id = R.drawable.corner_shape_front),
                contentDescription = null,
                modifier = Modifier
                    .width(93.dp)
                    .height(105.dp)
                    .align(Alignment.TopEnd),
                contentScale = ContentScale.FillBounds
            )
        }

        // Scrollable content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 10.dp)
        ) {
            // Header: Logo + CaloriX (centered)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 22.dp)
                    .height(80.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = "CaloriX Logo",
                    modifier = Modifier.size(80.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "CaloriX",
                    fontSize = 32.sp,
                    color = Color(0xFF548C64),
                    fontFamily = nunitoMedium,
                    textAlign = TextAlign.Center
                )
            }

            // "Registreerimine" title
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Registreerimine",
                fontSize = 25.sp,
                color = Color.Black,
                fontFamily = nunitoRegular,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            // "Kas sul on juba konto? Logi sisse."
            Spacer(modifier = Modifier.height(4.dp))
            val annotatedLogin = buildAnnotatedString {
                withStyle(SpanStyle(
                    color = Color.Black,
                    fontSize = 10.sp,
                    fontFamily = nunitoRegular
                )) {
                    append("Kas sul on juba konto? ")
                }
                pushStringAnnotation(tag = "login", annotation = "login")
                withStyle(SpanStyle(
                    color = Color(0xFF448AFF),
                    fontSize = 10.sp,
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
                onClick = { /* TODO: Handle registration */ },
                modifier = Modifier
                    .size(140.dp, 50.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF62A87C),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "Register",
                    fontSize = 18.sp,
                    fontFamily = nunitoSemiBold
                )
            }

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
