package com.example.myfigma.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfigma.R
import com.example.myfigma.ui.theme.Surface

@Composable
fun BottomSheetListItem(transactionItem: TransactionItem, onItemClick: (String) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { onItemClick(transactionItem.title) })
            .heightIn(min = 88.dp, max = 112.dp)
            //.height(112.dp)
            .background(color = Surface)
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
            .background(color = Surface)
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
            .background(color = Surface)
            .padding(horizontal = 16.dp, vertical = 13.dp)
    ) {
        Text(
            text = transactionHeader.title,
            style = TextStyle(fontSize = 18.sp, color = colorResource(R.color.surface_selected))
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
