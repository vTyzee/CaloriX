package com.example.calorix

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ForgotPasswordScreen(
    onNavigateBack: () -> Unit = {}
) {
    val nunitoRegular = FontFamily(Font(R.font.nunito_regular))
    val nunitoMedium = FontFamily(Font(R.font.nunito_medium))

    var email by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE6E8E6))
    ) {
        // Top-right corner decorative shapes
        Box(
            modifier = Modifier.align(Alignment.TopEnd)
        ) {
            Image(
                painter = painterResource(id = R.drawable.corner_shape_back),
                contentDescription = null,
                modifier = Modifier
                    .width(97.dp)
                    .height(109.dp),
                contentScale = ContentScale.FillBounds
            )
            Image(
                painter = painterResource(id = R.drawable.corner_shape_front),
                contentDescription = null,
                modifier = Modifier
                    .width(82.dp)
                    .height(92.dp)
                    .align(Alignment.TopEnd),
                contentScale = ContentScale.FillBounds
            )
        }

        // Bottom wave
        Image(
            painter = painterResource(id = R.drawable.ic_wave_bottom),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                // Adjusting the bottom alignment to match the other screens if needed, 
                // but the wave itself usually fills the bottom part
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )

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

            // "Parooli vahetamine" title
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Parooli vahetamine",
                fontSize = 25.sp,
                color = Color.Black,
                fontFamily = nunitoRegular,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            // ---- E-post field ----
            Spacer(modifier = Modifier.height(30.dp))
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

            // "Saada email" button
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = { /* TODO: Send reset email logic */ },
                modifier = Modifier
                    .size(200.dp, 50.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF62A87C),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = "Saada email",
                    fontSize = 18.sp,
                    fontFamily = nunitoRegular
                )
            }

            // "Mine tagasi" back link 
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onNavigateBack() },
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_back_arrow),
                    contentDescription = "Back arrow",
                    modifier = Modifier
                        .size(34.dp, 15.dp)
                        .rotate(180f) // The original vector points right, so we rotate 180 to point left
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Mine tagasi",
                    fontSize = 15.sp,
                    color = Color.Black,
                    fontFamily = nunitoRegular,
                    textDecoration = TextDecoration.Underline,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
