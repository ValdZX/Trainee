package com.example.myfigma.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfigma.R
import com.example.myfigma.bl.MainAction
import com.example.myfigma.bl.MainState
import com.example.myfigma.ui.theme.Background
import com.example.myfigma.ui.theme.ScrolledHeader

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainPage(state: MainState, dispatch: (MainAction) -> Unit) {

    val currentScrollOffset = rememberSaveable { mutableStateOf(0f) }

    Column(
        modifier = Modifier
            .background(color = ScrolledHeader.copy(alpha = if (currentScrollOffset.value < 0.75f) 0f else (currentScrollOffset.value - 0.75f) * 4))
            .fillMaxSize()
    ) {
        MyHeader(value = currentScrollOffset.value, dispatch = dispatch)
        Box(
            modifier = Modifier
                .weight(1f)
        ) {
            ScreenContent(
                state = state,
                dispatch = dispatch
            ) {
                currentScrollOffset.value = it
            }
        }
        ShowBottomNavigation()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ScreenContent(
    state: MainState,
    dispatch: (MainAction) -> Unit,
    onItemScrollOffsetChange: (Float) -> Unit
) {

    val lazyListState = rememberLazyListState()
    var scrolledY = 0f
    var previousOffset = 0

    var firstItemSize: Int

    LazyColumn(
        Modifier.fillMaxSize(),
        lazyListState
    ) {

        item {
            Box(modifier = Modifier
                .graphicsLayer {

                    scrolledY += lazyListState.firstVisibleItemScrollOffset - previousOffset
                    translationY = scrolledY * 1f
                    previousOffset = lazyListState.firstVisibleItemScrollOffset

                    if (lazyListState.firstVisibleItemIndex == 0) {
                        firstItemSize = lazyListState.layoutInfo.visibleItemsInfo[0].size
                        onItemScrollOffsetChange(lazyListState.firstVisibleItemScrollOffset.toFloat() / firstItemSize.toFloat())
                    } else
                        onItemScrollOffsetChange(1f)
                }) {
                MainScreen()
            }
        }
        stickyHeader {
            SearchHeader()
            ShowDivider()
        }
        val transactions = state.transactions
        items(transactions.count()) {
            if (transactions[it].isHeader)
                TransactionsListHeader(transactions[it])
            else {
                TransactionsListItem(transactions[it], onItemClick = { })
                ShowDivider()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ShowHorizontalPager()
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            ShowButton("Платежи", R.drawable.data_transfer)
            ShowButton("Выписка", R.drawable.check)
        }
    }
}

@Composable
fun ShowButton(title: String, img: Int) {
    Column(
        modifier = Modifier
            .clickable { /* Do something! */ }
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(img),
            modifier = Modifier
                .padding(bottom = 6.dp),
            contentDescription = null
        )
        Text(
            text = title,
            style = TextStyle(fontSize = 13.sp)
        )
    }
}

@Composable
private fun ShowBottomNavigation() {
    BottomNavigation(
        backgroundColor = Background
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
