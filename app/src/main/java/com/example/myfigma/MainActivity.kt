package com.example.myfigma

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfigma.ui.theme.MyFigmaTheme
import androidx.constraintlayout.compose.ConstraintLayout


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFigmaTheme {
                //Header()
                ShowCardConstraint(Card("Title", "UA 000000000000000", "11 500 500.00", "UA"))
                ShowButtons(Buttons("Платежи", "Выписка"))
            }
        }
    }
}

data class Card(val title: String, val id: String, val defaultText: String, val balance: String)

data class Buttons(val titleTransfer: String, val titleCheck: String)

@Composable
fun Header() {
//    Button(onClick = { /* Do something! */ }) {
//        Icon(
//            Icons.Filled.header_button_chat,
//            contentDescription = null,
//            modifier = Modifier.size(ButtonDefaults.IconSize)
//        )
//    }

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
        Column(
            verticalArrangement = Arrangement.Top
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

@Composable
fun ShowCardConstraint(card: Card) {
    ConstraintLayout(
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
    ) {
        val (titleText, editImg, walletImg, idText, defaultText, starImg, balanceText) = createRefs()

        Text(
            text = card.title,
            modifier = Modifier
                .padding(start = 0.dp, top = 0.dp, end = 8.dp, bottom = 0.dp)
                .constrainAs(titleText) {},
            style = TextStyle(fontSize = 15.sp)
        )
        Image(
            painter = painterResource(R.drawable.edit),
            contentDescription = null,
            modifier = Modifier
                .size(12.dp)
                .constrainAs(editImg) {
                    bottom.linkTo(titleText.bottom)
                    top.linkTo(titleText.top)
                    start.linkTo(titleText.end)
                }
        )

        Image(
            painter = painterResource(R.drawable.wallet),
            contentDescription = null,
            modifier = Modifier
                .size(width = 24.dp, height = 24.dp)
                .constrainAs(walletImg) {
                    end.linkTo(parent.end)
                }
        )
        Text(
            text = card.id,
            style = TextStyle(fontSize = 14.sp),
            modifier = Modifier
                .constrainAs(defaultText) {
                    top.linkTo(titleText.bottom)
                }
        )
        Text(
            text = card.defaultText,
            style = TextStyle(fontSize = 10.sp),
            modifier = Modifier
                .constrainAs(idText) {
                    bottom.linkTo(starImg.top)
                }
                .padding(horizontal = 0.dp, vertical = 8.dp)
        )
        Image(
            painter = painterResource(R.drawable.star),
            contentDescription = null,
            modifier = Modifier
                .size(width = 24.dp, height = 24.dp)
                .constrainAs(starImg) {
                    bottom.linkTo(parent.bottom)
                }
        )
        Text(
            text = card.balance,
            style = TextStyle(fontSize = 24.sp),
            modifier = Modifier
                .constrainAs(balanceText) {
                    top.linkTo(starImg.top)
                    end.linkTo(parent.end)
                }
        )
    }

}

@Composable
fun ShowButtons(buttons: Buttons) {
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center) {
        Column(
            modifier = Modifier
                .size(width = 88.dp, height = 88.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Button(
                onClick = { /* Do something! */ },
                modifier = Modifier
                    .size(width = 50.dp, height = 50.dp)
                    .clip(RoundedCornerShape(8.dp)),
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = colorResource(R.color.secondary)
                )
            ) {
                Image(
                    painter = painterResource(R.drawable.data_transfer),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .fillMaxSize()
                )
            }
            Text(
                text = buttons.titleTransfer,
                style = TextStyle(fontSize = 13.sp),
                modifier = Modifier.padding(
                    start = 0.dp,
                    top = 6.dp,
                    end = 0.dp,
                    bottom = 0.dp
                )
            )
        }
        Column(
            modifier = Modifier
                .size(width = 88.dp, height = 88.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Button(
                onClick = { /* Do something! */ },
                modifier = Modifier
                    .size(width = 50.dp, height = 50.dp)
                    .clip(RoundedCornerShape(8.dp)),
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = colorResource(R.color.secondary)
                )
            ) {
                Image(
                    painter = painterResource(R.drawable.check),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .fillMaxSize()
                )
            }
            Text(
                text = buttons.titleCheck,
                style = TextStyle(fontSize = 13.sp),
                modifier = Modifier.padding(
                    start = 0.dp,
                    top = 6.dp,
                    end = 0.dp,
                    bottom = 0.dp
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyFigmaTheme {
        //Header()

        //ShowCardBox(Card("Title", "UA 000000000000000", "По умолчанию", "11 500 500.00 UAH"))
        //ShowCardColumn(Card("Title", "UA 000000000000000", "По умолчанию", "11 500 500.00 UAH"))
        //ShowCardConstraint(Card("Title", "UA 000000000000000", "По умолчанию", "11 500 500.00 UAH"))

        ShowButtons(Buttons("Платежи", "Выписка"))
    }
}


