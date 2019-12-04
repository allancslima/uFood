package br.ufal.ic.ufood.presentation.shared.mvp

import java.util.*

abstract class BasicConsole : BasicView {

    companion object {

        @JvmField
        val scanner: Scanner = Scanner(System.`in`)

    }

    protected abstract fun showMenu()

    open fun start() { }

    open fun stop() { }

    override fun onError(message: String) {
        println("\nAn error occurred: $message")
        holdOutput()
        showMenu()
    }

    fun holdOutput() {
        println("\nPress enter to continue...")
        scanner.nextLine()
    }

}
