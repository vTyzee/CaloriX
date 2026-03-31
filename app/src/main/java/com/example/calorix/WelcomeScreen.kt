package com.example.calorix

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeScreen(
    onLoginClick: () -> Unit = {},
    onSignUpClick: () -> Unit = {}
) {
    val nunitoMedium = FontFamily(Font(R.font.nunito_medium))
    val nunitoSemiBold = FontFamily(Font(R.font.nunito_semibold))

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

        // Bottom wave
        Image(
            painter = painterResource(id = R.drawable.ic_wave_bottom),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(x = 40.dp, y = 10.dp)
                .width(3000.dp)
                .scale(1.5f)
                .wrapContentWidth(unbounded = true),  // Adjusting slightly if needed, helps avoid gaps
            contentScale = ContentScale.FillWidth

        )

        // Center Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 140.dp), // Adjust padding based on visual center
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "CaloriX",
                fontSize = 36.sp,
                color = Color(0xFF548C64),
                fontFamily = nunitoMedium
            )

            // Spacing to sub-header
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Kontrolli oma toitumist hõlpsalt",
                fontSize = 16.sp, 
                color = Color(0xFF487956),
                fontFamily = nunitoMedium
            )

            // Spacing to buttons
            Spacer(modifier = Modifier.height(60.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                // Logi sisse button
                Button(
                    onClick = { onLoginClick() },
                    modifier = Modifier.size(140.dp, 50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF548C64),
                        contentColor = Color(0xFFE6E8E6)
                    ),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(
                        text = "Logi sisse",
                        fontSize = 18.sp,
                        fontFamily = nunitoSemiBold
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                // Register button
                Box(
                    modifier = Modifier
                        .size(140.dp, 50.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .border(1.5.dp, Color(0xFF548C64), RoundedCornerShape(16.dp))
                        .clickable { onSignUpClick() },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Register",
                        fontSize = 18.sp,
                        color = Color(0xFF548C64),
                        fontFamily = nunitoSemiBold
                    )
                }
            }
        }
    }
}
