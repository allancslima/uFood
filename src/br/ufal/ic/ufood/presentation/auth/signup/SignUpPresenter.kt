package br.ufal.ic.ufood.presentation.auth.signup

import br.ufal.ic.ufood.data.user.UserRepository
import br.ufal.ic.ufood.domain.User
import br.ufal.ic.ufood.presentation.auth.MSG_INVALID_EMAIL
import br.ufal.ic.ufood.presentation.auth.MSG_INVALID_PASSWORD
import br.ufal.ic.ufood.presentation.auth.MSG_INVALID_PHONE_NUMBER
import br.ufal.ic.ufood.presentation.shared.mvp.Presenter
import br.ufal.ic.ufood.shared.validation.UserFieldValidator

class SignUpPresenter(
    private val userRepository: UserRepository
) : Presenter<SignUpView>(SignUpView::class.java) {

    fun onEnterUser() {
        val user = view.requestUser()
        try {
            validateUser(user)
            userRepository.signUp(user)
            view.onSignUpSuccess(user)
        } catch (e: Exception) {
            view.onSignUpError(e.localizedMessage)
        }
    }

    @Throws(IllegalArgumentException::class)
    fun validateUser(user: User) {
        val fieldError: String? = when {
            !UserFieldValidator.validateEmail(user.credentials.email) -> MSG_INVALID_EMAIL
            !UserFieldValidator.validatePassword(user.credentials.password) -> MSG_INVALID_PASSWORD
            !UserFieldValidator.validateName(user.name) -> MSG_INVALID_EMAIL
            !UserFieldValidator.validatePhoneNumber(user.phoneNumber) -> MSG_INVALID_PHONE_NUMBER
            else -> null
        }
        fieldError?.let { throw IllegalArgumentException(it) }
    }

}
