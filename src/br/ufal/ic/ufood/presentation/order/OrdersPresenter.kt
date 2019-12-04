package br.ufal.ic.ufood.presentation.order

import br.ufal.ic.ufood.data.order.OrderRepository
import br.ufal.ic.ufood.presentation.auth.UserSession
import br.ufal.ic.ufood.presentation.shared.mvp.Presenter

class OrdersPresenter(
    private val orderRepository: OrderRepository
) : Presenter<OrdersView>(OrdersView::class.java) {

    fun onLoadPendingOrders() {
        try {
            val user = UserSession.getUserOrError()
            val orders = orderRepository.getPendingOrders(user)
            view.showOrders(orders)
        } catch (e: Exception) {
            view.onError(e.localizedMessage)
        }
    }

    fun onLoadCompleteOrders() {
        try {
            val user = UserSession.getUserOrError()
            val orders = orderRepository.getCompleteOrders(user)
            view.showOrders(orders)
        } catch (e: Exception) {
            view.onError(e.localizedMessage)
        }
    }

    fun onConfirmOrderDelivery() {
        try {
            val orderId = view.requestOrderId()
            val user = UserSession.getUserOrError()
            orderRepository.confirmOrderDelivery(user, orderId)
            view.onOrderDeliveredConfirmation()
        } catch (e: Exception) {
            view.onError(e.localizedMessage)
        }
    }

}
