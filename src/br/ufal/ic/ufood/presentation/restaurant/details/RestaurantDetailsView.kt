package br.ufal.ic.ufood.presentation.restaurant.details

import br.ufal.ic.ufood.domain.Food
import br.ufal.ic.ufood.presentation.shared.mvp.BasicView

interface RestaurantDetailsView : BasicView {

    fun showFoods(foods: List<Food>)

    fun requestFoodIdAndQuantity(): Pair<Int, Int>

    fun onCartUpdated()

    fun showCart(iterable: Iterable<Map.Entry<Food, Int>>, totalPrice: Double)

    fun requestCouponId(): Int

    fun onCouponApplied(newTotalPrice: Double)

    fun onOrderPlaced(totalPrice: Double)

}
