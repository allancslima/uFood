package br.ufal.ic.ufood.domain

import java.util.*

data class Order(
    val createdAt: Date,
    val items: List<Pair<Food, Int>>,
    val price: Double
)
