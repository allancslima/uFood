package br.ufal.ic.ufood.presentation.restaurant.details

import br.ufal.ic.ufood.data.user.UserRepository
import br.ufal.ic.ufood.domain.Cart
import br.ufal.ic.ufood.domain.Restaurant
import br.ufal.ic.ufood.presentation.shared.mvp.Presenter

class RestaurantDetailsPresenter(
    private val restaurant: Restaurant,
    private val userRepository: UserRepository
) : Presenter<RestaurantDetailsView>(RestaurantDetailsView::class.java) {

    private val cart: Cart by lazy { Cart() }

    fun onShowFoods() {

    }

    fun onAddFoodToCart() {

    }

    fun onRemoveFoodFromCart() {

    }

    fun onViewCart() {

    }

    fun onClearCart() {

    }

    fun onApplyCoupon() {

    }

    fun onPlaceOrder() {

    }

}
