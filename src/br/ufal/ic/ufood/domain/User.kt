package br.ufal.ic.ufood.domain

data class User(
    var credentials: Credentials,
    var name: String,
    var phoneNumber: String
)
