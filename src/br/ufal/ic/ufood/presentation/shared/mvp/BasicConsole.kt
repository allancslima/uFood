package br.ufal.ic.ufood.presentation.shared.mvp

import java.util.*

open class BasicConsole : BasicView {

    protected lateinit var scanner: Scanner
        private set

    override fun showMessage(message: String) {
        print(message)
    }

    open fun start() {
        scanner = Scanner(System.`in`)
    }

    open fun stop() {
        scanner.close()
    }

}
