package br.ufal.ic.ufood.domain.coupon

import br.ufal.ic.ufood.domain.Food
import br.ufal.ic.ufood.domain.Food.Category.*
import br.ufal.ic.ufood.domain.Restaurant

class DinnerCoupon : Coupon(8) {

    private val allowedCategories: List<Food.Category> by lazy {
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
