package br.ufal.ic.ufood.presentation.auth.signin

import br.ufal.ic.ufood.domain.Credentials
import br.ufal.ic.ufood.domain.User
import br.ufal.ic.ufood.presentation.shared.mvp.BasicView

interface SignInView : BasicView {

    fun navigateToSignUp()

    fun requestCredentials(): Credentials

    fun onSignInSuccess(user: User)

    fun onSignInError(message: String)

}
