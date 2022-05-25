package com.example.myfigma.ui

data class Card(
    val title: String,
    val id: String,
    val defaultText: String,
    val balance: String)

data class MyButton(val title: String, val img: Int)

data class TransactionItem(
    val icon: Int,
    val title: String,
    val iban: String,
    val attention: String,
    val sum: String
)

data class TransactionHeader(val title: String, val listTransactionItems: List<TransactionItem>)
