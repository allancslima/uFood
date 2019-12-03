package br.ufal.ic.ufood.domain.coupon

import br.ufal.ic.ufood.domain.Restaurant
import br.ufal.ic.ufood.domain.Restaurant.Category.*

class DinnerCoupon : Coupon(8) {

    private val allowedCategories: List<Restaurant.Category> by lazy {
        arrayListOf(BEEF, CHINESE, DRINK, HOT_DOG, JAPANESE, PIZZA, SNACK, ICE_CREAM)
    }

    override fun isValid(restaurant: Restaurant): Boolean {
        val todayService = getTodayService(restaurant)

        return if (todayService != null) {
            getHourOfDay() in 18..22 && restaurant.categories.intersect(allowedCategories).isNotEmpty()
        } else {
            false
        }
    }

}
