package br.ufal.ic.ufood.data.resturant

import br.ufal.ic.ufood.domain.Restaurant
import br.ufal.ic.ufood.domain.Restaurant.Category.*
import br.ufal.ic.ufood.domain.Restaurant.ServiceDay.*

class RestaurantRepositoryImpl : RestaurantRepository {

    override fun getNearestRestaurants(): List<Restaurant> {
        return RestaurantMockFactory.nearestRestaurants
    }

}
