package com.example.myfigma.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.myfigma.R
import com.example.myfigma.ui.theme.CardBgFinish
import com.example.myfigma.ui.theme.CardBgStart
import com.example.myfigma.ui.theme.MyFigmaTheme

@Composable
fun ShowCardBox(card: Card) {
    Box(
        modifier = Modifier
            .size(width = 312.dp, height = 184.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        CardBgStart,
                        CardBgFinish
                    )
                )
            )
            .padding(16.dp)
    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = card.title,
                softWrap = false,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .widthIn(0.dp, 224.dp),
                style = TextStyle(fontSize = 15.sp)
            )
            Image(
                painter = painterResource(R.drawable.edit),
                contentDescription = null
            )
        }
        Image(
            painter = painterResource(R.drawable.wallet),
            contentDescription = null,
            modifier = Modifier
                .align(alignment = Alignment.TopEnd)
        )
        Text(
            text = card.id,
            softWrap = false,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(fontSize = 14.sp),
            modifier = Modifier
                .padding(vertical = 24.dp)
                .widthIn(0.dp, 280.dp),
        )
        Text(
            text = card.defaultText,
            softWrap = false,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(fontSize = 10.sp),
            modifier = Modifier
                .padding(top = 104.dp, bottom = 32.dp)
                .widthIn(0.dp, 224.dp),
        )
        Image(
            painter = painterResource(R.drawable.star),
            contentDescription = null,
            modifier = Modifier
                .align(alignment = Alignment.BottomStart)
        )
        Text(
            text = card.balance,
            style = TextStyle(fontSize = 24.sp),
            modifier = Modifier
                .align(alignment = Alignment.BottomEnd)
                .padding(start = 32.dp)
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
                        CardBgStart,
                        CardBgFinish
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
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .widthIn(0.dp, 248.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = card.title,
                        softWrap = false,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .widthIn(0.dp, 224.dp),
                        style = TextStyle(fontSize = 15.sp)
                    )
                    Image(
                        painter = painterResource(R.drawable.edit),
                        contentDescription = null
                    )
                }

                Image(
                    painter = painterResource(R.drawable.wallet),
                    contentDescription = null
                )
            }

            Text(
                text = card.id,
                softWrap = false,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier
                    .widthIn(0.dp, 280.dp)
            )
        }
        Column(verticalArrangement = Arrangement.Bottom) {
            Text(
                text = card.defaultText,
                softWrap = false,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(fontSize = 10.sp),
                modifier = Modifier
                    .widthIn(0.dp, 280.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.star),
                    contentDescription = null
                )
                Text(
                    text = card.balance,
                    style = TextStyle(fontSize = 24.sp),
                    softWrap = false,
                    modifier = Modifier
                        .padding(start = 32.dp)
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
                        CardBgStart,
                        CardBgFinish
                    )
                )
            )
            .padding(16.dp)
    ) {
        val (titleText, editImg, walletImg, idText, defaultText, starImg, balanceText) = createRefs()

        Text(
            text = card.title,
            softWrap = false,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(end = 8.dp)
                .widthIn(0.dp, 224.dp)
                .constrainAs(titleText) {},
            style = TextStyle(fontSize = 15.sp)
        )
        Image(
            painter = painterResource(R.drawable.edit),
            contentDescription = null,
            modifier = Modifier
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
                .constrainAs(walletImg) {
                    end.linkTo(parent.end)
                }
        )
        Text(
            text = card.id,
            softWrap = false,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(fontSize = 14.sp),
            modifier = Modifier
                .widthIn(0.dp, 280.dp)
                .constrainAs(defaultText) {
                    top.linkTo(titleText.bottom)
                }
        )
        Text(
            text = card.defaultText,
            softWrap = false,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(fontSize = 10.sp),
            modifier = Modifier
                .widthIn(0.dp, 280.dp)
                .constrainAs(idText) {
                    bottom.linkTo(starImg.top)
                }
                .padding(vertical = 8.dp)
        )
        Image(
            painter = painterResource(R.drawable.star),
            contentDescription = null,
            modifier = Modifier
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

@Preview(showBackground = true)
@Composable
fun ShowCardColumnPreview() {
    MyFigmaTheme {
        ShowCardColumn(
            Card(
                "Title LongLongTitle Very Long Title LongLongTitle Very Long Title",
                "UA 000000000000000",
                "По умолчанию",
                "11 5004444444444 500.00 UAH"
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShowCardConstraintPreview() {
    MyFigmaTheme {
        ShowCardConstraint(
            Card(
                "Title LongLongTitle Very Long Title LongLongTitle Very Long Title",
                "UA 000000000000000",
                "По умолчанию",
                "11 5004444444444 500.00 UAH"
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShowCardBoxPreview() {
    MyFigmaTheme {
        ShowCardBox(
            Card(
                "Title LongLongTitle Very Long Title LongLongTitle Very Long Title",
                "UA 000000000000000",
                "По умолчанию",
                "11 5004444444444 500.00 UAH"
            )
        )
    }
}