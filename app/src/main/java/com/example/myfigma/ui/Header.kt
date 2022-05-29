package com.example.myfigma.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfigma.R
import com.example.myfigma.ui.theme.Background
import com.example.myfigma.ui.theme.ScrolledHeader

@Composable
fun MyHeader(value: Float) {
    Row(
        modifier = Modifier
            .background(color = ScrolledHeader.copy(alpha = value))
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
                alpha = 1 - value * 2
            )
            AutoSizeText(
                text = "11 500 44444444444444444 500.00 UA",
                modifier = Modifier
                    .width(250.dp)
                    .alpha(value * 2-1),
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