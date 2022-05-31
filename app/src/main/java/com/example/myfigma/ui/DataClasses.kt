package com.example.myfigma.ui

import com.example.myfigma.R

data class Card(
    val title: String,
    val id: String,
    val defaultText: String,
    val balance: String
)

data class TransactionItemDto(
    val icon: Int = 0,
    val title: String = "",
    val iban: String = "",
    val attention: String = "",
    val sum: String = ""
)

data class TransactionHeaderDto(
    val title: String = ""
)

val sectionTransactions = listOf(
    TransactionHeaderDto(
        title = "Сегодня"
    ),
    TransactionItemDto(
        icon = R.drawable.transfer,
        title = "Между своими счетами",
        iban = "UA 85 399622 0000026205500011673",
        attention = "",
        sum = "-100.00 UAH"
    ),
    TransactionItemDto(
        icon = R.drawable.swift,
        title = "SWIFT - платёж",
        iban = "UA 85 399622 0000026205500011673",
        attention = "",
        sum = "-100.00 UAH"
    ),
    TransactionItemDto(
        icon = R.drawable.uk_territory,
        title = "Платежи по Украине",
        iban = "UA 85 399622 0000026205500011673",
        attention = "",
        sum = "-57 870.00 UAH"
    ),
    TransactionItemDto(
        icon = R.drawable.transfer_error,
        title = "Между своими счетами",
        iban = "UA 85 399622 0000026205500011673",
        attention = "Ошибка перевода",
        sum = "-57 870.00 UAH"
    ),
    TransactionHeaderDto(
        title = "Вчера"
    ),
    TransactionItemDto(
        icon = R.drawable.swift,
        title = "SWIFT - платёж",
        iban = "UA 85 399622 0000026205500011673",
        attention = "",
        sum = "-100.00 UAH"
    ),
    TransactionItemDto(
        icon = R.drawable.uk_territory,
        title = "Платежи по Украине",
        iban = "UA 85 399622 0000026205500011673",
        attention = "",
        sum = "-57 870.00 UAH"
    ),
    TransactionItemDto(
        icon = R.drawable.swift,
        title = "SWIFT - платёж",
        iban = "UA 85 399622 0000026205500011673",
        attention = "",
        sum = "-100.00 UAH"
    ),
    TransactionHeaderDto(
        title = "19.05.2021"
    ),
    TransactionItemDto(
        icon = R.drawable.transfer_error,
        title = "Между своими счетами",
        iban = "UA 85 399622 0000026205500011673",
        attention = "Ошибка перевода",
        sum = "-57 870.00 UAH"
    ),
    TransactionItemDto(
        icon = R.drawable.swift_error,
        title = "SWIFT - платёж",
        iban = "UA 85 399622 0000026205500011673",
        attention = "Ошибка перевода",
        sum = "-100.00 UAH"
    ),
    TransactionItemDto(
        icon = R.drawable.transfer_error,
        title = "Между своими счетами",
        iban = "UA 85 399622 0000026205500011673",
        attention = "Ошибка перевода",
        sum = "-57 870.00 UAH"
    ),
    TransactionItemDto(
        icon = R.drawable.uk_territory,
        title = "Платежи по Украине",
        iban = "UA 85 399622 0000026205500011673",
        attention = "",
        sum = "-57 870.00 UAH"
    )
)
