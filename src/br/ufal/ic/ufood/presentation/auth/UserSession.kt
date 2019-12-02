package br.ufal.ic.ufood.presentation.auth

import br.ufal.ic.ufood.domain.User

object UserSession {

    var currentUser: User? = null

    @Throws(IllegalStateException::class)
    fun getUserOrError(): User {
        return currentUser ?: throw IllegalStateException("No user signed in.")
    }

}
