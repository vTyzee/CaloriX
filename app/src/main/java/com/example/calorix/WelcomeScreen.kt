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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Canvas
import com.example.calorix.R

@Composable
fun WelcomeScreen(
    onLoginClick: () -> Unit = {},
    onSignUpClick: () -> Unit = {}
) {

    val nunito = FontFamily(

        Font(R.font.nunito_regular)

    )

    Box(

        modifier = Modifier

            .fillMaxSize()

            .background(Color(0xFFE6E8E6))

    ) {

        // Контент

        Column(

            modifier = Modifier

                .fillMaxSize()

                .padding(top = 120.dp),

            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Image(

                painter = painterResource(id = R.drawable.ic_logo),

                contentDescription = null,

                modifier = Modifier.size(155.dp)

            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(

                text = "CaloriX",

                fontSize = 32.sp,

                color = Color(0xFF548C64),

                fontFamily = nunito

            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(

                text = "Kontrolli oma toitumist hõlpsalt",

                fontSize = 14.sp,

                color = Color(0xFF487956),

                fontFamily = nunito

            )

            Spacer(modifier = Modifier.height(30.dp))

            Row {

                Button(

                    onClick = { onLoginClick() },

                    modifier = Modifier.size(140.dp, 50.dp),

                    colors = ButtonDefaults.buttonColors(

                        containerColor = Color(0xFF62A87C),

                        contentColor = Color(0xFFE6E8E6)

                    ),

                    shape = RoundedCornerShape(25.dp)

                ) {

                    Text("Log In", fontFamily = nunito)

                }

                Spacer(modifier = Modifier.width(10.dp))

                Box(

                    modifier = Modifier

                        .size(140.dp, 50.dp)

                        .clip(RoundedCornerShape(25.dp))

                        .border(2.dp, Color(0xFF62A87C), RoundedCornerShape(25.dp))

                        .clickable { onSignUpClick() },

                    contentAlignment = Alignment.Center

                ) {

                    Text(

                        text = "Sign Up",

                        color = Color(0xFF62A87C),

                        fontFamily = nunito

                    )

                }

            }

        }

        // 🌊 Волны

        Waves(

            modifier = Modifier.align(Alignment.BottomCenter)

        )

    }

}

@Composable
fun Waves(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(350.dp)
    ) {
        val w = size.width
        val h = size.height

        // 1. Back layer (lightest)
        val backWave = Path().apply {
            moveTo(0f, h * 0.8f)
            cubicTo(
                w * 0.3f, h * 0.75f,
                w * 0.7f, h * 0.3f,
                w, h * 0.45f
            )
            lineTo(w, h)
            lineTo(0f, h)
            close()
        }
        drawPath(backWave, Color(0xFF5F8A68))

        // 2. Middle layer
        val middleWave = Path().apply {
            moveTo(0f, h * 0.9f)
            cubicTo(
                w * 0.4f, h * 0.85f,
                w * 0.7f, h * 0.5f,
                w, h * 0.65f
            )
            lineTo(w, h)
            lineTo(0f, h)
            close()
        }
        drawPath(middleWave, Color(0xFF4D7757))

        // 3. Front layer (darkest)
        val frontWave = Path().apply {
            moveTo(0f, h)
            cubicTo(
                w * 0.35f, h * 0.95f,
                w * 0.75f, h * 0.65f,
                w, h * 0.78f
            )
            lineTo(w, h)
            lineTo(0f, h)
            close()
        }
        drawPath(frontWave, Color(0xFF43664B))
    }
}
