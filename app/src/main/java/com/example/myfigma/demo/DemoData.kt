package com.example.myfigma.demo

import com.example.myfigma.R
import com.example.myfigma.ui.Card
import com.example.myfigma.ui.TransactionItemDto

val cards = listOf(
    Card(
        "Account name",
        "UA 000000000000000",
        "По умолчанию",
        "11 500.00 UA"
    ),
    Card(
        "Title",
        "UA 000000000000000",
        "По умолчанию",
        "11.00 UA"
    ),
    Card(
        "Title LongLongTitle Very Long Title LongLongTitle Very Long Title",
        "UA 000000000000000",
        "По умолчанию",
        "11 500 44444444444444444 500.00 UA"
    ),
    Card(
        "fours card",
        "UA 000000000000000",
        "По умолчанию",
        "0.00 UA"
    )
)

val sectionTransactions = listOf(
    TransactionItemDto(
        isHeader = true,
        title = "Сегодня"
    ),
    TransactionItemDto(
        false,
        R.drawable.transfer,
        "Между своими счетами",
        "UA 85 399622 0000026205500011673",
        "",
        "-100.00 UAH"
    ),
    TransactionItemDto(
        false,
        R.drawable.swift,
        "SWIFT - платёж",
        "UA 85 399622 0000026205500011673",
        "",
        "-100.00 UAH"
    ),
    TransactionItemDto(
        false,
        R.drawable.uk_territory,
        "Платежи по Украине",
        "UA 85 399622 0000026205500011673",
        "",
        "-57 870.00 UAH"
    ),
    TransactionItemDto(
        false,
        R.drawable.transfer_error,
        "Между своими счетами",
        "UA 85 399622 0000026205500011673",
        "Ошибка перевода",
        "-57 870.00 UAH"
    ),
    TransactionItemDto(
        isHeader = true,
        title = "Вчера"
    ),
    TransactionItemDto(
        false,
        R.drawable.swift,
        "SWIFT - платёж",
        "UA 85 399622 0000026205500011673",
        "",
        "-100.00 UAH"
    ),
    TransactionItemDto(
        false,
        R.drawable.uk_territory,
        "Платежи по Украине",
        "UA 85 399622 0000026205500011673",
        "",
        "-57 870.00 UAH"
    ),
    TransactionItemDto(
        false,
        R.drawable.swift,
        "SWIFT - платёж",
        "UA 85 399622 0000026205500011673",
        "",
        "-100.00 UAH"
    ),
    TransactionItemDto(
        isHeader = true,
        title = "19.05.2021"
    ),
    TransactionItemDto(
        false,
        R.drawable.transfer_error,
        "Между своими счетами",
        "UA 85 399622 0000026205500011673",
        "Ошибка перевода",
        "-57 870.00 UAH"
    ),
    TransactionItemDto(
        false,
        R.drawable.swift_error,
        "SWIFT - платёж",
        "UA 85 399622 0000026205500011673",
        "Ошибка перевода",
        "-100.00 UAH"
    ),
    TransactionItemDto(
        false,
        R.drawable.transfer_error,
        "Между своими счетами",
        "UA 85 399622 0000026205500011673",
        "Ошибка перевода",
        "-57 870.00 UAH"
    ),
    TransactionItemDto(
        false,
        R.drawable.uk_territory,
        "Платежи по Украине",
        "UA 85 399622 0000026205500011673",
        "",
        "-57 870.00 UAH"
    )
)
