package br.ufal.ic.ufood.domain.coupon

import br.ufal.ic.ufood.domain.Restaurant
import br.ufal.ic.ufood.domain.Restaurant.Category.*

class BreakfastCoupon : Coupon(5) {

    private val allowedCategories: List<Restaurant.Category> by lazy {
        arrayListOf(CAKE, COOKIE, DRINK, HOT_DOG, SNACK)
    }

    override fun isValid(restaurant: Restaurant): Boolean {
        val todayService = getTodayService(restaurant)

        return if (todayService != null) {
            getHourOfDay() in 8..10 && restaurant.categories.intersect(allowedCategories).isNotEmpty()
        } else {
            false
        }
    }

}
