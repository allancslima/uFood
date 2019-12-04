package br.ufal.ic.ufood.presentation.restaurant

import br.ufal.ic.ufood.domain.Restaurant
import br.ufal.ic.ufood.presentation.shared.mvp.BasicView

interface RestaurantsView : BasicView {

    fun showRestaurants(restaurants: List<Restaurant>)

    fun requestSearch(): String

    fun requestRestaurantId(): Int

    fun navigateToRestaurant(restaurant: Restaurant)

}
