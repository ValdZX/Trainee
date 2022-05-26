package com.example.myfigma.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfigma.R
import com.example.myfigma.ui.theme.ScrolledHeader

@Composable
fun MyHeader() {
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
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = null
        )
        Image(
            painter = painterResource(R.drawable.header_button_chat),
            contentDescription = null,
            modifier = Modifier
                .clickable {/* Do something! */ }
        )
    }
}

@Composable
fun MyScrolledHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(ScrolledHeader)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.header_button_menu),
            contentDescription = null,
            modifier = Modifier
                .clickable {/* Do something! */ }
        )
        AutoSizeText(
            text = "11 500 44444444444444444 500.00 UA",
            modifier = Modifier
                .width(250.dp),
            textStyle = TextStyle(fontSize = 24.sp),
            textAlign = TextAlign.Center
        )
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
fun MyScrolledHeaderPreview() {
    MyScrolledHeader()
}

@Preview(showBackground = true)
@Composable
fun MyHeaderPreview() {
    MyHeader()
}