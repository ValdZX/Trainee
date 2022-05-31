package com.example.myfigma.ui

data class Card(
    val title: String,
    val id: String,
    val defaultText: String,
    val balance: String
)

data class TransactionItemDto(
    val isHeader: Boolean = false,
    val icon: Int = 0,
    val title: String = "",
    val iban: String = "",
    val attention: String = "",
    val sum: String = ""
)