package br.ufal.ic.ufood.presentation.profile.coupon

import br.ufal.ic.ufood.data.user.UserRepository
import br.ufal.ic.ufood.presentation.auth.UserSession
import br.ufal.ic.ufood.presentation.shared.mvp.Presenter

class CouponPresenter(
    private val userRepository: UserRepository
) : Presenter<CouponView>(CouponView::class.java) {

    fun onLoadMyCoupons() {
        try {
            val user = UserSession.getUserOrError()
            val coupons = userRepository.getCoupons(user)
            view.showCoupons(coupons)
        } catch (e: Exception) {
            view.onError(e.localizedMessage)
        }
    }

    fun onApplyCouponCode() {
        val couponCode = view.requireCouponCode()
        try {
            val user = UserSession.getUserOrError()
            userRepository.applyCouponCode(user, couponCode)
            view.onValidCouponCode()
        } catch (e: Exception) {
            view.onError(e.localizedMessage)
        }
    }

}
