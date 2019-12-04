package br.ufal.ic.ufood.presentation.restaurant

import br.ufal.ic.ufood.data.restaurant.RestaurantRepository
import br.ufal.ic.ufood.presentation.shared.mvp.Presenter
import java.lang.Exception

class RestaurantsPresenter(
    private val restaurantRepository: RestaurantRepository
) : Presenter<RestaurantsView>(RestaurantsView::class.java) {

    fun onLoadNearestRestaurants() {
        val restaurants = restaurantRepository.getNearestRestaurants()
        view.showRestaurants(restaurants)
    }

    fun onSearchNearestRestaurants() {
        val search = view.requestSearch()
        val restaurants = restaurantRepository.searchNearestRestaurants(search)
        view.showRestaurants(restaurants)
    }

    fun onGoToRestaurant() {
        val restaurantId = view.requestRestaurantId()
        try {
            val restaurant = restaurantRepository.getRestaurant(restaurantId)
            view.navigateToRestaurant(restaurant)
        } catch (e: Exception) {
            view.onError(e.localizedMessage)
        }
    }

}
