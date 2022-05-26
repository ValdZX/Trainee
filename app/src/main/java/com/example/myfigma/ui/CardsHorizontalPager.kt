package com.example.myfigma.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ShowHorizontalPager(){

    val pagerState = rememberPagerState()
    HorizontalPager(
        count = 3,
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 16.dp),
    ) { page ->
        when(page){
            0 ->
                ShowCardColumn(
                    Card(
                        "Title LongLongTitle Very Long Title LongLongTitle Very Long Title",
                        "UA 000000000000000",
                        "По умолчанию",
                        "11 500 44444444444444444 500.00 UA"
                    ))
            1 ->
                ShowCardConstraint(
                    Card(
                        "Title2 LongLongTitle Very Long Title LongLongTitle Very Long Title",
                        "UA 1111111111111111111111",
                        "По умолчанию1",
                        "11 500 44444444444444444 500.00 UA"
                    ))
            2 ->
                ShowCardBox(
                    Card(
                        "Title3 LongLongTitle Very Long Title LongLongTitle Very Long Title",
                        "UA 222222222222222222222",
                        "По умолчанию2",
                        "11 500 44444444444444444 500.00 UA"
                    ))
        }


    }
    HorizontalPagerIndicator(
        pagerState = pagerState,
        modifier = Modifier
            .padding(16.dp),
    )

}
