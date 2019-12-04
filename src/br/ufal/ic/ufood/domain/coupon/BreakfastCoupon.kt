package br.ufal.ic.ufood.domain.coupon

import br.ufal.ic.ufood.domain.Food
import br.ufal.ic.ufood.domain.Food.Category.*
import br.ufal.ic.ufood.domain.Restaurant

class BreakfastCoupon : Coupon(5.0, 7.0) {

    private val allowedCategories: List<Food.Category> by lazy {
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
