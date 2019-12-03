package br.ufal.ic.ufood.data.user

import br.ufal.ic.ufood.domain.Address
import br.ufal.ic.ufood.domain.Credentials
import br.ufal.ic.ufood.domain.User
import br.ufal.ic.ufood.domain.coupon.Coupon

interface UserRepository {

    @Throws(IllegalArgumentException::class)
    fun signIn(credentials: Credentials): User

    @Throws(IllegalArgumentException::class)
    fun signUp(user: User)

    fun getAddresses(user: User): List<Address>

    fun addAddress(user: User, address: Address)

    @Throws(IllegalArgumentException::class)
    fun deleteAddress(user: User, addressId: Int)

    fun getCoupons(user: User): List<Coupon>

    @Throws(IllegalArgumentException::class)
    fun applyCouponCode(user: User, couponCode: String)

}
