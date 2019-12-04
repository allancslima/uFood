package br.ufal.ic.ufood.presentation.order

import br.ufal.ic.ufood.domain.Order
import br.ufal.ic.ufood.presentation.shared.mvp.BasicView

interface OrdersView : BasicView {

    fun showOrders(orders: List<Order>)

    fun requestOrderId(): Int

    fun onOrderDeliveredConfirmation()

    fun onError(message: String)

}
