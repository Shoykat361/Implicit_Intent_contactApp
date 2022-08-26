package com.example.contactapp

class Contact_DB(
    val id:Long,
    val name: String,
    val phone: String,
    val email: String,
    val address: String
)


val ContactDetails= mutableListOf<Contact_DB>()