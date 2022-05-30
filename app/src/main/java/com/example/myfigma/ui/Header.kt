package com.example.myfigma.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfigma.R

@Composable
fun MyHeader(value: Float) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(R.drawable.header_button_menu),
            contentDescription = null,
            modifier = Modifier
                .clickable {/* Do something! */ }
        )
        Box(contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                alpha = if (value < 0.75f) 1f else 1 - (value - 0.75f) * 4
            )
            AutoSizeText(
                text = "11 500 44444444444444444 500.00 UA",
                modifier = Modifier
                    .width(250.dp)
                    .alpha(if (value < 0.75f) 0f else (value - 0.75f) * 4),
                textStyle = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Medium),
                textAlign = TextAlign.Center
            )
        }
        Image(
            painter = painterResource(R.drawable.header_button_chat),
            contentDescription = null,
            modifier = Modifier
                .clickable {/* Do something! */ }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyHeaderPreview() {
    MyHeader(1f)
}