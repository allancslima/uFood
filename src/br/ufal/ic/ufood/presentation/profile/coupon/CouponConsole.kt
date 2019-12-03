package br.ufal.ic.ufood.presentation.profile.coupon

import br.ufal.ic.ufood.data.user.UserRepositoryImpl
import br.ufal.ic.ufood.domain.coupon.BreakfastCoupon
import br.ufal.ic.ufood.domain.coupon.Coupon
import br.ufal.ic.ufood.domain.coupon.DinnerCoupon
import br.ufal.ic.ufood.domain.coupon.LunchCoupon
import br.ufal.ic.ufood.presentation.shared.LABEL_TYPE_OPTION
import br.ufal.ic.ufood.presentation.shared.MSG_INVALID_OPTION
import br.ufal.ic.ufood.presentation.shared.mvp.BasicConsole

class CouponConsole : BasicConsole(), CouponView {

    private val presenter: CouponPresenter by lazy {
        CouponPresenter(UserRepositoryImpl())
    }

    override fun start() {
        super.start()
        presenter.attachView(this)
        showMenu()
    }

    override fun stop() {
        super.stop()
        presenter.detachView()
    }

    override fun showCoupons(coupons: List<Coupon>) {
        coupons.forEachIndexed { index, coupon ->
            val couponType = when (coupon) {
                is BreakfastCoupon -> LABEL_BREAKFAST
                is LunchCoupon -> LABEL_LUNCH
                is DinnerCoupon -> LABEL_DINNER
                else -> LABEL_OTHER
            }
            println("${String.format(LABEL_COUPON_DETAILS, index, couponType, coupon.discount)}\n")
        }
        holdOutput()
        showMenu()
    }

    override fun requireCouponCode(): String {
        print(LABEL_TYPE_COUPON_CODE)
        return scanner.nextLine()
    }

    override fun onValidCouponCode() {
        println("\n$MSG_COUPON_ADDED")
        holdOutput()
        showMenu()
    }

    override fun onError(message: String) {
        println("\nAn error occurred: $message")
        holdOutput()
        showMenu()
    }

    private fun showMenu() {
        println("COUPONS\n")
        println("1 - My coupons")
        println("2 - Apply coupon code")
        println("0 - Back")
        print(LABEL_TYPE_OPTION)

        when (scanner.nextLine().toInt()) {
            1 -> presenter.onLoadMyCoupons()
            2 -> presenter.onApplyCouponCode()
            0 -> {
                holdOutput()
                stop()
            }
            else -> {
                println(MSG_INVALID_OPTION)
                holdOutput()
                showMenu()
            }
        }
    }

}
