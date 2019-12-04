package br.ufal.ic.ufood.data.order

import br.ufal.ic.ufood.domain.Cart
import br.ufal.ic.ufood.domain.Order
import br.ufal.ic.ufood.domain.User
import java.util.*

class OrderRepositoryImpl : OrderRepository {

    companion object {

        private val pendingOrders: MutableMap<String, MutableList<Order>> by lazy {
            hashMapOf<String, MutableList<Order>>()
        }
        private val completeOrders: MutableMap<String, MutableList<Order>> by lazy {
            hashMapOf<String, MutableList<Order>>()
        }

    }

    override fun getPendingOrders(user: User): List<Order> {
        return pendingOrders[user.credentials.email] ?: emptyList()
    }

    override fun getCompleteOrders(user: User): List<Order> {
        return completeOrders[user.credentials.email] ?: emptyList()
    }

    override fun placeOrder(user: User, cart: Cart): Order {
        val order = Order(Date(), cart.getItems(), cart.getPrice())

        if (pendingOrders[user.credentials.email] == null) {
            pendingOrders[user.credentials.email] = arrayListOf()
        }
        pendingOrders[user.credentials.email]?.add(order)

        return order
    }

    @Throws(IllegalArgumentException::class)
    override fun confirmOrderDelivery(user: User, orderId: Int) {
        val pendingOrders = pendingOrders[user.credentials.email]

        if (pendingOrders == null || orderId !in 0 until pendingOrders.size) {
            throw IllegalArgumentException("User or order ID invalid.")
        }
        val order = pendingOrders.removeAt(orderId)

        if (completeOrders[user.credentials.email] == null) {
            completeOrders[user.credentials.email] = arrayListOf()
        }
        completeOrders[user.credentials.email]?.add(order)
    }

}
