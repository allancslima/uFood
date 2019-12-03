package br.ufal.ic.ufood.presentation.profile

import br.ufal.ic.ufood.presentation.profile.address.AddressConsole
import br.ufal.ic.ufood.presentation.profile.coupon.CouponConsole
import br.ufal.ic.ufood.presentation.shared.mvp.BasicConsole

class ProfileConsole : BasicConsole() {

    override fun start() {
        super.start()
        showMenu()
    }

    private fun showMenu() {
        println("PROFILE\n")
        println("1 - Addresses")
        println("2 - Payment methods")
        println("3 - Coupons")
        println("0 - Back")
        print("\nOption: ")

        when (scanner.nextLine().toInt()) {
            1 -> AddressConsole().start()
            3 -> CouponConsole().start()
            0 -> holdOutput()
            else -> {
                println("Invalid option.")
                holdOutput()
                showMenu()
            }
        }
    }

}
