package br.ufal.ic.ufood

import br.ufal.ic.ufood.presentation.auth.signin.SignInConsole

class Application {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            SignInConsole {
                println("Go to home")
            }.start()
        }

    }

}
