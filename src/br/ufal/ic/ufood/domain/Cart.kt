package br.ufal.ic.ufood.domain

import br.ufal.ic.ufood.domain.coupon.Coupon

class Cart(private val restaurant: Restaurant) {

    private val foods: MutableMap<Food, Int> by lazy {
        HashMap<Food, Int>()
    }
    var discount: Double = 0.0
        private set

    @Throws(IllegalArgumentException::class)
    fun add(food: Food, quantity: Int) {
        if (quantity < 1) {
            throw IllegalArgumentException("Invalid quantity.")
        }
        val currentQuantity = foods[food]

        foods[food] = if (currentQuantity == null) {
            quantity
        } else {
            currentQuantity + quantity
        }
    }

    @Throws(IllegalArgumentException::class)
    fun remove(food: Food, quantity: Int) {
        if (quantity < 1) {
            throw IllegalArgumentException("Invalid quantity.")
        }
        val currentQuantity = foods[food]

        if (currentQuantity != null) {
            val newQuantity = currentQuantity - quantity

            if (newQuantity < 1) {
                foods.remove(food)
            } else {
                foods[food] = newQuantity
            }
        }
    }

    fun clear() {
        foods.clear()
    }

    fun applyCoupon(coupon: Coupon): Boolean {
        return if (coupon.isValid(restaurant, getTotalPrice())) {
            discount = coupon.discount
            true
        } else {
            false
        }
    }

    fun getFoodsIterable(): Iterable<Map.Entry<Food, Int>> {
        return foods.asIterable()
    }

    fun getPrice(): Double {
        return getTotalPrice() - discount
    }

    private fun getTotalPrice(): Double {
        return foods.asIterable().sumByDouble { it.key.price * it.value }
    }

}
