package br.ufal.ic.ufood.domain

data class Address(
    var street: String,
    var number: Int,
    var complement: String,
    var location: Location
)
