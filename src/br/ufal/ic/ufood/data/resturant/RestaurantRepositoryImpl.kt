package br.ufal.ic.ufood.data.resturant

import br.ufal.ic.ufood.domain.Restaurant
import br.ufal.ic.ufood.domain.Restaurant.Category.*
import br.ufal.ic.ufood.domain.Restaurant.ServiceDay.*

class RestaurantRepositoryImpl : RestaurantRepository {

    override fun getNearestRestaurants(): List<Restaurant> {
        return RestaurantMockFactory.nearestRestaurants
    }

    override fun searchNearestRestaurants(search: String): List<Restaurant> {
        return RestaurantMockFactory.nearestRestaurants.filter {
            it.name.toLowerCase().contains(search.toLowerCase())
        }
    }

    @Throws(IllegalArgumentException::class)
    override fun getRestaurant(id: Int): Restaurant {
        if (id !in 0 until RestaurantMockFactory.nearestRestaurants.size) {
            throw IllegalArgumentException("Invalid restaurant ID.")
        }
        return RestaurantMockFactory.nearestRestaurants[id]
    }

}
