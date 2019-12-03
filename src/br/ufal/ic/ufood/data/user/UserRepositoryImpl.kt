package br.ufal.ic.ufood.data.user

import br.ufal.ic.ufood.domain.Address
import br.ufal.ic.ufood.domain.Credentials
import br.ufal.ic.ufood.domain.User
import br.ufal.ic.ufood.domain.coupon.BreakfastCoupon
import br.ufal.ic.ufood.domain.coupon.Coupon
import br.ufal.ic.ufood.domain.coupon.DinnerCoupon
import br.ufal.ic.ufood.domain.coupon.LunchCoupon

class UserRepositoryImpl : UserRepository {

    companion object {

        private val validCouponCodes: Map<String, Coupon> by lazy {
            hashMapOf(
                "BREAKFAST_5" to BreakfastCoupon(),
                "LUNCH_10" to LunchCoupon(),
                "DINNER_8" to DinnerCoupon(),
                "XyZ_coupon_10" to LunchCoupon()
            )
        }

        private val users: MutableMap<String, User> by lazy { HashMap<String, User>() }
        private val addresses: MutableMap<String, MutableList<Address>> by lazy { HashMap<String, MutableList<Address>>() }
        private val coupons: MutableMap<String, MutableSet<Coupon>> by lazy { HashMap<String, MutableSet<Coupon>>() }

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

    override fun getCoupons(user: User): List<Coupon> {
        return coupons[user.credentials.email]?.toList() ?: emptyList()
    }

    @Throws(IllegalArgumentException::class)
    override fun applyCouponCode(user: User, couponCode: String) {
        val coupon = validCouponCodes[couponCode] ?: throw IllegalArgumentException("Invalid coupon.")

        if (coupons[user.credentials.email] == null) {
            coupons[user.credentials.email] = hashSetOf()
        }
        if (coupons[user.credentials.email]?.add(coupon) == false) {
            throw IllegalArgumentException("Coupon already added.")
        }
    }

}
