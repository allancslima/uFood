package br.ufal.ic.ufood.domain.coupon

import br.ufal.ic.ufood.domain.Restaurant
import java.util.*

abstract class Coupon(val discount: Double, val minPrice: Double) {

    fun isValid(restaurant: Restaurant, cartPrice: Double): Boolean {
        return cartPrice >= minPrice && isValid(restaurant)
    }

    protected abstract fun isValid(restaurant: Restaurant): Boolean

    protected fun getTodayService(restaurant: Restaurant): Restaurant.ServiceDay? {
        val calendar = Calendar.getInstance()
        val today = calendar.get(Calendar.DAY_OF_WEEK)
        val todayService = restaurant.serviceDays.find { it.day == today }

        return todayService?.let {
            if (getHourOfDay() in it.start..it.end) {
                it
            } else {
                null
            }
        }
    }

    protected fun getHourOfDay(): Int {
        return Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    }

}
