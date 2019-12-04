package br.ufal.ic.ufood.presentation.home

import br.ufal.ic.ufood.presentation.order.OrdersConsole
import br.ufal.ic.ufood.presentation.profile.ProfileConsole
import br.ufal.ic.ufood.presentation.restaurant.RestaurantsConsole
import br.ufal.ic.ufood.presentation.shared.LABEL_TYPE_OPTION
import br.ufal.ic.ufood.presentation.shared.MSG_INVALID_OPTION
import br.ufal.ic.ufood.presentation.shared.mvp.BasicConsole

class HomeConsole(private val result: (logout: Boolean) -> Unit) : BasicConsole() {

    override fun showMenu() {
        println("HOME\n")
        println("1 - Go to restaurants")
        println("2 - Go to orders")
        println("3 - Go to profile")
        println("4 - Logout")
        println("0 - Exit")
        print(LABEL_TYPE_OPTION)

        when (scanner.nextLine().toInt()) {
            1 -> RestaurantsConsole().start()
            2 -> OrdersConsole().start()
            3 -> ProfileConsole().start()
            4 -> {
                holdOutput()
                result(true)
                return
            }
            0 -> {
                holdOutput()
                stop()
                result(false)
                return
            }
            else -> {
                println(MSG_INVALID_OPTION)
                holdOutput()
            }
        }
        showMenu()
    }

    override fun start() {
        super.start()
        showMenu()
    }

}
