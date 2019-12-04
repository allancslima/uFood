package br.ufal.ic.ufood.presentation.profile

import br.ufal.ic.ufood.presentation.profile.address.AddressConsole
import br.ufal.ic.ufood.presentation.profile.coupon.CouponConsole
import br.ufal.ic.ufood.presentation.shared.MSG_INVALID_OPTION
import br.ufal.ic.ufood.presentation.shared.mvp.BasicConsole

class ProfileConsole : BasicConsole() {

    override fun showMenu() {
        println("PROFILE\n")
        println("1 - Addresses")
        println("2 - Coupons")
        println("0 - Back")
        print("\nOption: ")

        when (scanner.nextLine().toInt()) {
            1 -> AddressConsole().start()
            2 -> CouponConsole().start()
            0 -> holdOutput()
            else -> {
                println(MSG_INVALID_OPTION)
                holdOutput()
                showMenu()
            }
        }
    }

    override fun start() {
        super.start()
        showMenu()
    }

}
