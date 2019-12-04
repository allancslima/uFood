package br.ufal.ic.ufood.data.restaurant

import br.ufal.ic.ufood.domain.Restaurant

interface RestaurantRepository {

    fun getNearestRestaurants(): List<Restaurant>

    fun searchNearestRestaurants(search: String): List<Restaurant>

    @Throws(IllegalArgumentException::class)
    fun getRestaurant(id: Int): Restaurant

}
