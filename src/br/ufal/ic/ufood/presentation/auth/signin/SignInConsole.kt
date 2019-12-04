package br.ufal.ic.ufood.presentation.auth.signin

import br.ufal.ic.ufood.data.user.UserRepositoryImpl
import br.ufal.ic.ufood.domain.Credentials
import br.ufal.ic.ufood.domain.User
import br.ufal.ic.ufood.presentation.auth.LABEL_TYPE_EMAIL
import br.ufal.ic.ufood.presentation.auth.LABEL_TYPE_PASSWORD
import br.ufal.ic.ufood.presentation.auth.MSG_WELCOME_USER
import br.ufal.ic.ufood.presentation.auth.signup.SignUpConsole
import br.ufal.ic.ufood.presentation.shared.LABEL_TYPE_OPTION
import br.ufal.ic.ufood.presentation.shared.MSG_INVALID_OPTION
import br.ufal.ic.ufood.presentation.shared.mvp.BasicConsole

class SignInConsole(private val result: (signed: Boolean) -> Unit) : BasicConsole(), SignInView {

    private val presenter: SignInPresenter by lazy { SignInPresenter(UserRepositoryImpl()) }

    override fun showMenu() {
        println("SIGN IN\n")
        println("1 - Enter credentials")
        println("2 - Go to sign up")
        println("0 - Exit")
        print(LABEL_TYPE_OPTION)

        when (scanner.nextLine().toInt()) {
            1 -> presenter.onEnterCredentials()
            2 -> presenter.onGoToSignUp()
            0 -> {
                holdOutput()
                stop()
            }
            else -> {
                println(MSG_INVALID_OPTION)
                holdOutput()
                showMenu()
            }
        }
    }

    override fun start() {
        super.start()
        presenter.attachView(this)
        showMenu()
    }

    override fun stop() {
        super.stop()
        presenter.detachView()
    }

    override fun navigateToSignUp() {
        SignUpConsole { signed ->
            if (signed) {
                stop()
                result(true)
            } else {
                showMenu()
            }
        }.start()
    }

    override fun requestCredentials(): Credentials {
        print(LABEL_TYPE_EMAIL)
        val email = scanner.nextLine()
        print(LABEL_TYPE_PASSWORD)
        val password = scanner.nextLine()

        return Credentials(email, password)
    }

    override fun onSignInSuccess(user: User) {
        println(String.format(MSG_WELCOME_USER, user.name))
        holdOutput()
        result(true)
    }

    override fun onSignInError(message: String) {
        println("\n$message")
        holdOutput()
        showMenu()
    }

}
