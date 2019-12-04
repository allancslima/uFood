package br.ufal.ic.ufood.domain

import br.ufal.ic.ufood.domain.coupon.Coupon

class Cart(private val restaurant: Restaurant) {

    private val items: MutableMap<Food, Int> by lazy {
        HashMap<Food, Int>()
    }
    var discount: Double = 0.0
        private set

    @Throws(IllegalArgumentException::class)
    fun add(food: Food, quantity: Int) {
        if (quantity < 1) {
            throw IllegalArgumentException("Invalid quantity.")
        }
        val currentQuantity = items[food]

        items[food] = if (currentQuantity == null) {
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
        val currentQuantity = items[food]

        if (currentQuantity != null) {
            val newQuantity = currentQuantity - quantity

            if (newQuantity < 1) {
                items.remove(food)
            } else {
                items[food] = newQuantity
            }
        } else {
            throw IllegalStateException("Food does not exist in the cart.")
        }
    }

    fun clear() {
        items.clear()
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
        return items.asIterable()
    }

    fun getPrice(): Double {
        return getTotalPrice() - discount
    }

    private fun getTotalPrice(): Double {
        return items.asIterable().sumByDouble { it.key.price * it.value }
    }

}
