package com.example.myfigma.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myfigma.R

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
