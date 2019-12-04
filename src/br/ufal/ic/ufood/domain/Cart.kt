package br.ufal.ic.ufood.domain

class Cart {

    private val foods: MutableMap<Food, Int> by lazy {
        HashMap<Food, Int>()
    }

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

    fun getFoodsIterable(): Iterable<Map.Entry<Food, Int>> {
        return foods.asIterable()
    }

    fun getTotalPrice(): Double {
        return foods.asIterable().sumByDouble { it.key.price * it.value }
    }

}
