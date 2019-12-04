package br.ufal.ic.ufood.data.order

import br.ufal.ic.ufood.domain.Cart
import br.ufal.ic.ufood.domain.Order
import br.ufal.ic.ufood.domain.User

interface OrderRepository {

    fun getPendingOrders(user: User): List<Order>

    fun getCompleteOrders(user: User): List<Order>

    fun placeOrder(user: User, cart: Cart): Order

    @Throws(IllegalArgumentException::class)
    fun confirmOrderDelivery(user: User, orderId: Int)

}
