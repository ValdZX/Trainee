package com.example.myfigma.ui

import com.example.myfigma.R

data class Card(
    val title: String,
    val id: String,
    val defaultText: String,
    val balance: String)

data class TransactionItemDto(
    val isHeader: Boolean = false,
    val icon: Int = 0,
    val title: String = "",
    val iban: String = "",
    val attention: String = "",
    val sum: String = ""
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
