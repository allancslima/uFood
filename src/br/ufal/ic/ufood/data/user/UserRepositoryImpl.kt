package br.ufal.ic.ufood.data.user

import br.ufal.ic.ufood.domain.Address
import br.ufal.ic.ufood.domain.Credentials
import br.ufal.ic.ufood.domain.User

class UserRepositoryImpl : UserRepository {

    companion object {

        private val users: MutableMap<String, User> by lazy { HashMap<String, User>() }
        private val addresses: MutableMap<String, MutableList<Address>> by lazy { HashMap<String, MutableList<Address>>() }

    }

    @Throws(IllegalArgumentException::class)
    override fun signIn(credentials: Credentials): User {
        val user = users[credentials.email]

        if (user == null || user.credentials == credentials) {
            throw IllegalArgumentException("Invalid email and/or password.")
        }
        return user
    }

    @Throws(IllegalArgumentException::class)
    override fun signUp(user: User) {
        if (users.containsKey(user.credentials.email)) {
            throw IllegalArgumentException("Already used email.")
        }
        users[user.credentials.email] = user
    }

    override fun getAddresses(user: User): List<Address> {
        return addresses[user.credentials.email] ?: emptyList()
    }

    override fun addAddress(user: User, address: Address) {
        if (addresses[user.credentials.email] == null) {
            addresses[user.credentials.email] = arrayListOf()
        }
        addresses[user.credentials.email]?.add(address)
    }

    override fun deleteAddress(user: User, addressId: Int) {
        val addresses = addresses[user.credentials.email]

        if (addresses != null && addressId in 0 until addresses.size) {
            addresses.removeAt(addressId)
        } else {
            throw IllegalArgumentException("Invalid address ID.")
        }
    }

}
