package com.example.calorix

import androidx.compose.foundation.Canvas
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
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
    onNavigateToForgotPassword: () -> Unit = {}
) {
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))
    val nunitoMedium = FontFamily(Font(R.font.nunito_medium))
    val nunitoSemiBold = FontFamily(Font(R.font.nunito_semibold))

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE6E8E6))
    ) {
        // Green decorative shapes in top-right corner (from Figma assets)
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
        ) {
            // Back shape (lighter green) — 110x124
            Image(
                painter = painterResource(id = R.drawable.corner_shape_back),
                contentDescription = null,
                modifier = Modifier
                    .width(110.dp)
                    .height(124.dp),
                contentScale = ContentScale.FillBounds
            )
            // Front shape (darker green) — 93x105, overlaid on top
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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp)
        ) {
            // Header row: Logo + CaloriX (centered)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
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

            // "Logimine" title
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Logimine",
                fontSize = 25.sp,
                color = Color.Black,
                fontFamily = nunitoRegular,
                textAlign = TextAlign.Center, // Выравнивание внутри строки
                modifier = Modifier.fillMaxWidth() // Занимаем всю ширину, чтобы было от чего центрировать
            )

            // E-post section
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 0.dp)
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

            Spacer(modifier = Modifier.height(8.dp))
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
                    .height(52.dp),
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

            // Parool section
            Spacer(modifier = Modifier.height(14.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 0.dp)
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

            Spacer(modifier = Modifier.height(8.dp))
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
                    .height(52.dp),
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

            // "Unustasid parooli?" link
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Unustasid parooli?",
                fontSize = 14.sp,
                fontFamily = nunitoRegular,
                color = Color(0xFF35503F),
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .clickable { onNavigateToForgotPassword() }
            )

            // "Log In" button
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /* TODO: Handle login */ },
                modifier = Modifier
                    .size(140.dp, 50.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF62A87C),
                    contentColor = Color(0xFFE6E8E6)
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = "Log In",
                    fontSize = 18.sp,
                    fontFamily = nunitoSemiBold
                )
            }

            // "Kas sul ei ole kontod? Registreeru"
            Spacer(modifier = Modifier.height(14.dp))
            val annotatedRegister = buildAnnotatedString {
                withStyle(SpanStyle(
                    color = Color.Black,
                    fontSize = 12.sp,
                    fontFamily = nunitoRegular
                )) {
                    append("Kas sul ei ole kontod? ")
                }
                pushStringAnnotation(tag = "register", annotation = "register")
                withStyle(SpanStyle(
                    color = Color(0xFF62A87C),
                    fontSize = 12.sp,
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
        Waves(
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}
