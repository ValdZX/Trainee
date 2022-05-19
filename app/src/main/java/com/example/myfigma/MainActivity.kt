package com.example.myfigma

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfigma.ui.theme.MyFigmaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFigmaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ShowCard(Card("Title", "UA 000000000000000", "11 500 500.00", "UA"))
                }
            }
        }
    }
}

data class Card(val title: String, val id: String, val balance: String, val currency: String)

@Composable
fun ShowCard(card: Card) {
    Column(modifier = Modifier.background(Green)) {
        Text(text = card.title)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = card.id)
        Spacer(modifier = Modifier.height(40.dp))
        Row() {
            Text(text = card.balance)
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = card.currency)
        }


    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyFigmaTheme {
        ShowCard(Card("Title", "UA 000000000000000", "11 500 500.00", "UA"))
    }
}

