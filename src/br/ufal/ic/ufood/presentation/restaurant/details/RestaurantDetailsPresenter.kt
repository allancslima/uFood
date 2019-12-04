package br.ufal.ic.ufood.presentation.restaurant.details

import br.ufal.ic.ufood.data.order.OrderRepository
import br.ufal.ic.ufood.data.user.UserRepository
import br.ufal.ic.ufood.domain.Cart
import br.ufal.ic.ufood.domain.Food
import br.ufal.ic.ufood.domain.Restaurant
import br.ufal.ic.ufood.presentation.auth.UserSession
import br.ufal.ic.ufood.presentation.shared.mvp.Presenter

class RestaurantDetailsPresenter(
    private val restaurant: Restaurant,
    private val userRepository: UserRepository,
    private val orderRepository: OrderRepository
) : Presenter<RestaurantDetailsView>(RestaurantDetailsView::class.java) {

    private val cart: Cart by lazy { Cart(restaurant) }

    fun onShowFoods() {
        view.showFoods(restaurant.foods)
    }

    fun onAddFoodToCart() {
        val pair = view.requestFoodIdAndQuantity()
        try {
            val food = resolveFood(restaurant, pair.first)
            cart.add(food, pair.second)
            view.onCartUpdated()
        } catch (e: Exception) {
            view.onError(e.localizedMessage)
        }
    }

    fun onRemoveFoodFromCart() {
        val pair = view.requestFoodIdAndQuantity()
        try {
            val food = resolveFood(restaurant, pair.first)
            cart.remove(food, pair.second)
            view.onCartUpdated()
        } catch (e: Exception) {
            view.onError(e.localizedMessage)
        }
    }

    fun onViewCart() {
        view.showCart(cart.getItems(), cart.getPrice(), cart.discount)
    }

    fun onClearCart() {
        cart.clear()
        view.onCartUpdated()
    }

    fun onApplyCoupon() {
        val couponId = view.requestCouponId()
        try {
            val user = UserSession.getUserOrError()
            val coupon = userRepository.getCoupon(user, couponId)

            if (cart.applyCoupon(coupon)) {
                view.onCouponApplied(cart.getPrice())
            } else {
                view.onError(MSG_COUPON_NOT_APPLIED)
            }
        } catch (e: Exception) {
            view.onError(e.localizedMessage)
        }
    }

    fun onPlaceOrder() {
        try {
            val user = UserSession.getUserOrError()
            val order = orderRepository.placeOrder(user, cart)
            view.onOrderPlaced(order.price)
        } catch (e: Exception) {
            view.onError(e.localizedMessage)
        }
    }

    @Throws(IllegalArgumentException::class)
    private fun resolveFood(restaurant: Restaurant, foodId: Int): Food {
        if (foodId !in 0 until restaurant.foods.size) {
            throw IllegalArgumentException("Invalid food ID.")
        }
        return restaurant.foods[foodId]
    }

}
