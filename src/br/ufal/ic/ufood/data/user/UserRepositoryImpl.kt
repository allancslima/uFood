package br.ufal.ic.ufood.data.user

import br.ufal.ic.ufood.domain.Credentials
import br.ufal.ic.ufood.domain.User

class UserRepositoryImpl : UserRepository {

    companion object {

        private val users: MutableMap<String, User> by lazy { HashMap<String, User>() }

    }

    @Throws(IllegalArgumentException::class)
    override fun signIn(credentials: Credentials): User {
        val user = users[credentials.email]

        if (user == null || user.credentials == credentials) {
            throw IllegalArgumentException("Invalid email and/or password.")
        }
        return user
    }

    override fun signUp(user: User) {
        if (users.containsKey(user.credentials.email)) {
            throw IllegalArgumentException("Already used email.")
        }
        users[user.credentials.email] = user
    }

}
