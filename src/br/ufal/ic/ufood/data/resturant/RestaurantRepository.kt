package br.ufal.ic.ufood.data.resturant

import br.ufal.ic.ufood.domain.Restaurant

interface RestaurantRepository {

    fun getNearestRestaurants(): List<Restaurant>

}
