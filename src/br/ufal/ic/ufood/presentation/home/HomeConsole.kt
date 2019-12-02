package br.ufal.ic.ufood.presentation.home

import br.ufal.ic.ufood.presentation.profile.ProfileConsole
import br.ufal.ic.ufood.presentation.shared.mvp.BasicConsole

class HomeConsole : BasicConsole() {

    override fun start() {
        super.start()
        showMenu()
    }

    private fun showMenu() {
        println("HOME\n")
        println("1 - Go to restaurants search")
        println("2 - Go to orders")
        println("3 - Go to profile")
        println("0 - Exit")
        print("\nOption: ")

        when (scanner.nextLine().toInt()) {
            3 -> ProfileConsole().start()
            0 -> {
                holdOutput()
                stop()
            }
            else -> println("Invalid option.")
        }
        showMenu()
    }

}
