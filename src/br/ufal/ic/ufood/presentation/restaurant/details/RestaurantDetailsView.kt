package br.ufal.ic.ufood.presentation.restaurant.details

import br.ufal.ic.ufood.domain.Food
import br.ufal.ic.ufood.presentation.shared.mvp.BasicView

interface RestaurantDetailsView : BasicView {

    fun showFoods(foods: List<Food>)

    fun requestFoodIdAndQuantity(): Pair<Int, Int>

    fun onCartUpdated()

    fun showCart(items: List<Pair<Food, Int>>, cartPrice: Double, discount: Double)

    fun requestCouponId(): Int

    fun onCouponApplied(newCartPrice: Double)

    fun requestAddressId(): Int

    fun onOrderPlaced(cartPrice: Double)

    fun onError(message: String)

}
