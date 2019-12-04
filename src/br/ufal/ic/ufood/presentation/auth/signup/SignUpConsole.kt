package br.ufal.ic.ufood.presentation.auth.signup

import br.ufal.ic.ufood.data.user.UserRepositoryImpl
import br.ufal.ic.ufood.domain.Credentials
import br.ufal.ic.ufood.domain.User
import br.ufal.ic.ufood.presentation.auth.*
import br.ufal.ic.ufood.presentation.shared.LABEL_TYPE_OPTION
import br.ufal.ic.ufood.presentation.shared.MSG_INVALID_OPTION
import br.ufal.ic.ufood.presentation.shared.mvp.BasicConsole

class SignUpConsole(private val result: (signed: Boolean) -> Unit) : BasicConsole(), SignUpView {

    private val presenter: SignUpPresenter by lazy { SignUpPresenter(UserRepositoryImpl()) }

    override fun showMenu() {
        println("SIGN UP\n")
        println("1 - Enter user")
        println("0 - Back")
        print(LABEL_TYPE_OPTION)

        when (scanner.nextLine().toInt()) {
            1 -> presenter.onEnterUser()
            0 -> {
                holdOutput()
                stop()
                result(false)
            }
            else -> println(MSG_INVALID_OPTION)
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

    override fun requestUser(): User {
        print(LABEL_TYPE_EMAIL)
        val email = scanner.nextLine()
        print(LABEL_TYPE_PASSWORD)
        val password = scanner.nextLine()
        print(LABEL_TYPE_NAME)
        val name = scanner.nextLine()
        print(LABEL_TYPE_PHONE_NUMBER)
        val phoneNumber = scanner.nextLine()

        return User(Credentials(email, password), name, phoneNumber)
    }

    override fun onSignUpSuccess(user: User) {
        println(String.format(MSG_WELCOME_USER, user.name))
        holdOutput()
        stop()
        result(true)
    }

    override fun onSignUpError(message: String) {
        println("\n$message")
        holdOutput()
        showMenu()
    }

}
