package br.ufal.ic.ufood.presentation.home

import br.ufal.ic.ufood.presentation.order.OrdersConsole
import br.ufal.ic.ufood.presentation.profile.ProfileConsole
import br.ufal.ic.ufood.presentation.restaurant.RestaurantsConsole
import br.ufal.ic.ufood.presentation.shared.mvp.BasicConsole

class HomeConsole : BasicConsole() {

    override fun showMenu() {
        println("HOME\n")
        println("1 - Go to restaurants")
        println("2 - Go to orders")
        println("3 - Go to profile")
        println("0 - Exit")
        print("\nOption: ")

        when (scanner.nextLine().toInt()) {
            1 -> RestaurantsConsole().start()
            2 -> OrdersConsole().start()
            3 -> ProfileConsole().start()
            0 -> {
                holdOutput()
                stop()
            }
            else -> println("Invalid option.")
        }
        showMenu()
    }

    override fun start() {
        super.start()
        showMenu()
    }

}
