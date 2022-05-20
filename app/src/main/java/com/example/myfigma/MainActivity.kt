package com.example.myfigma

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfigma.ui.theme.MyFigmaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFigmaTheme {
                    ShowCard(Card("Title", "UA 000000000000000", "11 500 500.00", "UA"))

            }
        }
    }
}

data class Card(val title: String, val id: String, val balance: String, val currency: String)

@Composable
fun ShowCard(card: Card) {

    Box(contentAlignment = Alignment.Center ) {
        Surface(
            shape = MaterialTheme.shapes.medium
        ) {
            Column(modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            colorResource(R.color.card_bg_start),
                            colorResource(R.color.card_bg_finish)
                        )
                    )
                )) {
                Row(modifier = Modifier.padding(all = 16.dp)) {
                    Text(
                        text = card.title,
                        //modifier = Modifier.padding(all = 16.dp),
                        style = TextStyle(fontSize = 15.sp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(R.drawable.body_clarification_edit),
                        contentDescription = null,
                        alignment = Alignment.BottomCenter,
                        modifier = Modifier
                            .size(12.dp)
                    )
                    Spacer(modifier = Modifier.width(203.96.dp))
                    Image(
                        painter = painterResource(R.drawable.vector),
                        contentDescription = null,
                        modifier = Modifier
                            .size(width = 22.08.dp,height = 18.24.dp)
                    )

                }
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

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyFigmaTheme {
        ShowCard(Card("Title", "UA 000000000000000", "11 500 500.00", "UA"))
    }
}

