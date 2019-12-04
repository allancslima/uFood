package br.ufal.ic.ufood.domain.coupon

import br.ufal.ic.ufood.domain.Food
import br.ufal.ic.ufood.domain.Food.Category.*
import br.ufal.ic.ufood.domain.Restaurant

class LunchCoupon : Coupon(10) {

    private val allowedCategories: List<Food.Category> by lazy {
        arrayListOf(ACAI, BEEF, BRAZILIAN, DRINK, HOT_DOG, ICE_CREAM, ITALIAN, SNACK)
    }

    override fun isValid(restaurant: Restaurant): Boolean {
        val todayService = getTodayService(restaurant)

        return if (todayService != null) {
            getHourOfDay() in 11..14 && restaurant.categories.intersect(allowedCategories).isNotEmpty()
        } else {
            false
        }
    }

}
