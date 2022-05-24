package com.example.myfigma

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFigmaTheme {
                //ScreenContent()
                SheetContent()
            }

        }
    }
}

data class Card(val title: String, val id: String, val defaultText: String, val balance: String)

data class Buttons(val titleTransfer: String, val titleCheck: String)

data class MyButton(val title: String, val img: Int)

@Composable
fun ScreenContent() {
    val buttonsList: List<MyButton> = listOf(
        MyButton("Платежи", R.drawable.data_transfer),
        MyButton("Выписка", R.drawable.check)
    )
    Column(
        modifier = Modifier.background(colorResource(R.color.bottom_menu_background)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyHeader()
        ShowCardConstraint(
            Card(
                "Title",
                "UA 000000000000000",
                "По умолчанию",
                "11 500 500.00 UA"
            )
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            for (item in buttonsList) {
                ShowButton(button = item)
            }
        }
//        SootheBottomNavigation()
    }
}

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
                .size(30.dp)
                .fillMaxSize()
                .clickable {/* Do something! */ }
        )

        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .size(height = 48.dp, width = 143.dp)
        )

        Image(
            painter = painterResource(R.drawable.header_button_chat),
            contentDescription = null,
            modifier = Modifier
                .size(30.dp)
                .fillMaxSize()
                .clickable {/* Do something! */ }
        )

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
            .padding(16.dp)
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
fun ShowButtonsAll(buttons: Buttons) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .size(width = 88.dp, height = 88.dp)
                .clickable { /* Do something! */ },
            verticalArrangement = Arrangement.Top
        ) {
//            Button(
//                onClick = { /* Do something! */ },
//                modifier = Modifier
//                    .size(width = 50.dp, height = 50.dp)
//                    .clip(RoundedCornerShape(8.dp)),
//                colors = ButtonDefaults.textButtonColors(
//                    backgroundColor = colorResource(R.color.secondary)
//                )
//            ) {
//                Image(
//                    painter = painterResource(R.drawable.data_transfer),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .size(24.dp)
//                        .fillMaxSize()
//                )
//            }

            Box(
                modifier = Modifier
                    .size(width = 50.dp, height = 50.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(colorResource(R.color.secondary))
            ) {
                Image(
                    painter = painterResource(R.drawable.data_transfer),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .fillMaxSize()
                        .align(alignment = Alignment.Center)
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
                .size(width = 88.dp, height = 88.dp)
                .clickable { /* Do something! */ },
            verticalArrangement = Arrangement.Top
        ) {
            Box(
                modifier = Modifier
                    .size(width = 50.dp, height = 50.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(colorResource(R.color.secondary))
            ) {
                Image(
                    painter = painterResource(R.drawable.check),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .fillMaxSize()
                        .align(alignment = Alignment.Center)
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

@Composable
fun ShowButton(button: MyButton) {

    Column(
        modifier = Modifier
            .size(width = 88.dp, height = 88.dp)
            .clickable { /* Do something! */ },
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .size(width = 50.dp, height = 50.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(colorResource(R.color.secondary))
        ) {
            Image(
                painter = painterResource(button.img),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .fillMaxSize()
                    .align(alignment = Alignment.Center)
            )
        }
        Text(
            text = button.title,
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

data class TransactionItem(
    val icon: Int,
    val title: String,
    val iban: String,
    val attention: String,
    val sum: String
)

data class TransactionHeader(val title: String, val listTransactionItems: List<TransactionItem>)

@Composable
fun BottomSheetListItem(transactionItem: TransactionItem, onItemClick: (String) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { onItemClick(transactionItem.title) })
            .heightIn(min = 88.dp, max = 112.dp)
            //.height(112.dp)
            .background(color = colorResource(id = R.color.background_sheet))
            .padding(all = 16.dp)
    ) {
        Row() {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(colorResource(R.color.primary))
            ) {
                Image(
                    painter = painterResource(id = transactionItem.icon),
                    contentDescription = "",
                    modifier = Modifier
                        .size(24.dp)
                        .fillMaxSize()
                        .align(alignment = Alignment.Center)
                )
            }
            Column(
                modifier = Modifier.padding(start = 17.dp, top = 0.dp, end = 0.dp, bottom = 0.dp),
                verticalArrangement = Arrangement.Top
            ) {

                Text(
                    text = transactionItem.title,
                    style = TextStyle(fontSize = 15.sp, color = colorResource(R.color.on_surface))
                )
                Text(
                    text = transactionItem.iban,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = colorResource(R.color.on_surface_variant)
                    )
                )
                if (!transactionItem.attention.equals("")) {
                    Text(
                        text = transactionItem.attention,
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = colorResource(R.color.attention)
                        )
                    )
                }
            }
        }
        Text(
            text = transactionItem.sum,
            style = TextStyle(fontSize = 14.sp, color = colorResource(R.color.on_surface)),
            modifier = Modifier
                .align(Alignment.BottomEnd)
        )
    }
}

@Composable
fun BottomSheetListTopHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(
                RoundedCornerShape(
                    topEnd = 14.dp,
                    topStart = 14.dp
                )
            )
            .background(color = colorResource(id = R.color.background_sheet))
            .padding(horizontal = 16.dp, vertical = 13.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(R.string.bottom_sheet_list_top_header),
            style = TextStyle(fontSize = 18.sp, color = colorResource(R.color.surface_selected))
        )
        Image(
            painter = painterResource(R.drawable.button_search),
            contentDescription = "",
            modifier = Modifier
                .size(24.dp)
                .fillMaxSize()
        )
    }
}

@Composable
fun BottomSheetListHeader(transactionHeader: TransactionHeader) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = colorResource(id = R.color.background_sheet))
            .padding(horizontal = 16.dp, vertical = 13.dp)
    ) {
        Text(
            text = transactionHeader.title,
            style = TextStyle(fontSize = 18.sp, color = colorResource(R.color.surface_selected))
        )
    }
}

@Composable
private fun SootheBottomNavigation() {
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.bottom_menu_background)
    ) {
        BottomNavigationItem(
            icon = {
                Image(
                    painter = painterResource(R.drawable.home),
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_home))
            },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Image(
                    painter = painterResource(R.drawable.credit),
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_credit))
            },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Image(
                    painter = painterResource(R.drawable.deposit),
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_deposit))
            },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Image(
                    painter = painterResource(R.drawable.settings),
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_settings))
            },
            selected = true,
            onClick = {}
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SheetContent() {

    val sectionListItemsToday = listOf(
        TransactionItem(
            R.drawable.transfer,
            "Между своими счетами",
            "UA 85 399622 0000026205500011673",
            "",
            "-100.00 UAH"
        ),
        TransactionItem(
            R.drawable.swift,
            "SWIFT - платёж",
            "UA 85 399622 0000026205500011673",
            "",
            "-100.00 UAH"
        ),
        TransactionItem(
            R.drawable.uk_territory,
            "Платежи по Украине",
            "UA 85 399622 0000026205500011673",
            "",
            "-57 870.00 UAH"
        ),
        TransactionItem(
            R.drawable.transfer,
            "Между своими счетами",
            "UA 85 399622 0000026205500011673",
            "Ошибка перевода",
            "-57 870.00 UAH"
        )
    )

    val sectionListItemsTomorrow = listOf(
        TransactionItem(
            R.drawable.swift,
            "SWIFT - платёж",
            "UA 85 399622 0000026205500011673",
            "",
            "-100.00 UAH"
        ),
        TransactionItem(
            R.drawable.uk_territory,
            "Платежи по Украине",
            "UA 85 399622 0000026205500011673",
            "",
            "-57 870.00 UAH"
        ),
        TransactionItem(
            R.drawable.swift,
            "SWIFT - платёж",
            "UA 85 399622 0000026205500011673",
            "",
            "-100.00 UAH"
        )
    )

    val sectionListItemsSomeDay = listOf(
        TransactionItem(
            R.drawable.transfer,
            "Между своими счетами",
            "UA 85 399622 0000026205500011673",
            "Ошибка перевода",
            "-57 870.00 UAH"
        ),
        TransactionItem(
            R.drawable.swift,
            "SWIFT - платёж",
            "UA 85 399622 0000026205500011673",
            "Ошибка перевода",
            "-100.00 UAH"
        ),
        TransactionItem(
            R.drawable.transfer,
            "Между своими счетами",
            "UA 85 399622 0000026205500011673",
            "Ошибка перевода",
            "-57 870.00 UAH"
        ),
        TransactionItem(
            R.drawable.uk_territory,
            "Платежи по Украине",
            "UA 85 399622 0000026205500011673",
            "",
            "-57 870.00 UAH"
        )
    )

    val sectionHeaders = listOf(
        TransactionHeader("Сегодня", sectionListItemsToday),
        TransactionHeader("Вчера", sectionListItemsTomorrow),
        TransactionHeader("19.05.2021", sectionListItemsSomeDay)
    )

    LazyColumn() {
        stickyHeader {
            BottomSheetListTopHeader()
        }
        sectionHeaders.forEach { section ->
            item {
                BottomSheetListHeader(section)
            }
            items(section.listTransactionItems.count()) {
                BottomSheetListItem(section.listTransactionItems[it], onItemClick = { })
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun BottomSheetListItemPreview() {
//    BottomSheetListItem(
//        TransactionItem(
//            R.drawable.swift,
//            "SWIFT - платёж",
//            "UA 85 399622 0000026205500011673",
//            "Ошибка перевода",
//            "-100.00 UAH"
//        ), onItemClick = { })
//}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyFigmaTheme {
        //ScreenContent()
        //SootheBottomNavigation()

        SheetContent()
    }
}


