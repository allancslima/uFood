package br.ufal.ic.ufood.presentation.shared.mvp

import java.util.*

open class BasicConsole : BasicView {

    companion object {

        @JvmField
        val scanner: Scanner = Scanner(System.`in`)

    }

    override fun showMessage(message: String) {
        print(message)
    }

    open fun start() { }

    open fun stop() { }

    fun holdOutput() {
        println("\nPress enter to continue...")
        scanner.nextLine()
    }

}
