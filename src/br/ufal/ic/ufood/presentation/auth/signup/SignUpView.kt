package br.ufal.ic.ufood.presentation.auth.signup

import br.ufal.ic.ufood.domain.User
import br.ufal.ic.ufood.presentation.shared.mvp.BasicView

interface SignUpView : BasicView {

    fun requestUser(): User

    fun onSignUpSuccess(user: User)

    fun onSignUpError(message: String)

}
