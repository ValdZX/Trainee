package com.example.myfigma

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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
                ShowCardColumn(Card("Title", "UA 000000000000000", "11 500 500.00", "UA"))

            }
        }
    }
}

data class Card(val title: String, val id: String, val defaultText: String, val balance: String)

@Composable
fun ShowCard(card: Card) {

    Box(contentAlignment = Alignment.Center) {
        Surface(
            shape = MaterialTheme.shapes.medium
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                colorResource(R.color.card_bg_start),
                                colorResource(R.color.card_bg_finish)
                            )
                        )
                    )
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.padding(all = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = card.title,
                        //modifier = Modifier.padding(all = 16.dp),
                        style = TextStyle(fontSize = 15.sp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(R.drawable.edit),
                        contentDescription = null,
                        alignment = Alignment.BottomCenter,
                        modifier = Modifier
                            .size(12.dp)
                    )
                    Spacer(modifier = Modifier.width(203.96.dp))
                    Image(
                        painter = painterResource(R.drawable.wallet),
                        contentDescription = null,
                        modifier = Modifier
                            .size(width = 22.08.dp, height = 18.24.dp)
                    )

                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = card.id)
                Spacer(modifier = Modifier.height(40.dp))
                Text(text = card.balance)
                Spacer(modifier = Modifier.width(4.dp))


            }
        }

    }
}

@Composable
fun ShowCardBox(card: Card) {
    Box(
        modifier = Modifier
            .size(width = 312.dp, height = 184.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        colorResource(R.color.card_bg_start),
                        colorResource(R.color.card_bg_finish)
                    )
                )
            )
            .padding(16.dp)
    )
    {
        Row(
            modifier = Modifier.padding(0.dp, 0.dp, 56.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = card.title,
                modifier = Modifier.padding(start = 0.dp, top = 0.dp, end = 8.dp, bottom = 0.dp),
                style = TextStyle(fontSize = 15.sp)
            )
            Image(
                painter = painterResource(R.drawable.edit),
                contentDescription = null,
                modifier = Modifier
                    .size(12.dp)
            )
        }
        Image(
            painter = painterResource(R.drawable.wallet),
            contentDescription = null,
            modifier = Modifier
                .size(width = 24.dp, height = 24.dp)
                .align(alignment = Alignment.TopEnd)
        )
        Text(
            text = card.id,
            style = TextStyle(fontSize = 14.sp),
            modifier = Modifier.padding(horizontal = 0.dp, vertical = 24.dp)
        )
        Text(
            text = card.defaultText,
            style = TextStyle(fontSize = 10.sp),
            modifier = Modifier.padding(start = 0.dp, top = 104.dp, end = 0.dp, bottom = 32.dp)
        )
        Image(
            painter = painterResource(R.drawable.star),
            contentDescription = null,
            modifier = Modifier
                .size(width = 24.dp, height = 24.dp)
                .align(alignment = Alignment.BottomStart)
        )
        Text(
            text = card.balance,
            style = TextStyle(fontSize = 24.sp),
            modifier = Modifier
                .align(alignment = Alignment.BottomEnd)
                .padding(32.dp, 0.dp, 0.dp, 0.dp)
        )
    }
}

@Composable
fun ShowCardColumn(card: Card) {
    Column(
        modifier = Modifier
            .size(width = 312.dp, height = 184.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        colorResource(R.color.card_bg_start),
                        colorResource(R.color.card_bg_finish)
                    )
                )
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(verticalArrangement = Arrangement.Top
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(
                        start = 0.dp,
                        top = 0.dp,
                        end = 56.dp,
                        bottom = 0.dp
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = card.title,
                        modifier = Modifier.padding(
                            start = 0.dp,
                            top = 0.dp,
                            end = 8.dp,
                            bottom = 0.dp
                        ),
                        style = TextStyle(fontSize = 15.sp)
                    )
                    Image(
                        painter = painterResource(R.drawable.edit),
                        contentDescription = null,
                        modifier = Modifier
                            .size(12.dp)
                    )
                }

                Image(
                    painter = painterResource(R.drawable.wallet),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 24.dp, height = 24.dp)
                )
            }

            Text(
                text = card.id,
                style = TextStyle(fontSize = 14.sp)
            )
        }
        Column(verticalArrangement = Arrangement.Bottom) {
            Text(
                text = card.defaultText,
                style = TextStyle(fontSize = 10.sp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.star),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 24.dp, height = 24.dp)
                )
                Text(
                    text = card.balance,
                    style = TextStyle(fontSize = 24.sp),
                    modifier = Modifier.padding(
                        start = 32.dp,
                        top = 0.dp,
                        end = 0.dp,
                        bottom = 0.dp
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyFigmaTheme {
        //ShowCardBox(Card("Title", "UA 000000000000000", "По умолчанию", "11 500 500.00 UAH"))
        ShowCardColumn(Card("Title", "UA 000000000000000", "По умолчанию", "11 500 500.00 UAH"))
    }
}


