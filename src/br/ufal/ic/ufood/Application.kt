package br.ufal.ic.ufood

import br.ufal.ic.ufood.presentation.auth.signin.SignInConsole
import br.ufal.ic.ufood.presentation.home.HomeConsole

class Application {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            SignInConsole { signed ->
                if (signed) {
                    HomeConsole { logout -> if (logout) main(args) }.start()
                }
            }.start()
        }

    }

}
