package br.ufal.ic.ufood.presentation.auth.signin

import br.ufal.ic.ufood.data.user.UserRepository
import br.ufal.ic.ufood.domain.Credentials
import br.ufal.ic.ufood.presentation.auth.MSG_INVALID_EMAIL
import br.ufal.ic.ufood.presentation.auth.MSG_INVALID_PASSWORD
import br.ufal.ic.ufood.presentation.auth.UserSession
import br.ufal.ic.ufood.presentation.shared.mvp.Presenter
import br.ufal.ic.ufood.shared.validation.UserFieldValidator

class SignInPresenter(
    private val userRepository: UserRepository
) : Presenter<SignInView>(SignInView::class.java) {

    fun onEnterCredentials() {
        val credentials = view.requestCredentials()
        try {
            validateCredentials(credentials)
            val user = userRepository.signIn(credentials)
            UserSession.currentUser = user
            view.onSignInSuccess(user)
        } catch (e: Exception) {
            view.onSignInError(e.localizedMessage)
        }
    }

    fun onGoToSignUp() {
        view.navigateToSignUp()
    }

    @Throws(IllegalArgumentException::class)
    fun validateCredentials(credentials: Credentials) {
        val fieldError: String? = when {
            !UserFieldValidator.validateEmail(credentials.email) -> MSG_INVALID_EMAIL
            !UserFieldValidator.validatePassword(credentials.password) -> MSG_INVALID_PASSWORD
            else -> null
        }
        fieldError?.let { throw IllegalArgumentException(it) }
    }

}
