package br.ufal.ic.ufood.presentation.profile.coupon

import br.ufal.ic.ufood.domain.coupon.Coupon
import br.ufal.ic.ufood.presentation.shared.mvp.BasicView

interface CouponView : BasicView {

    fun showCoupons(coupons: List<Coupon>)

    fun requireCouponCode(): String

    fun onValidCouponCode()

    fun onError(message: String)

}
