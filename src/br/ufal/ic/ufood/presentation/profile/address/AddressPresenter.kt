package br.ufal.ic.ufood.presentation.profile.address

import br.ufal.ic.ufood.data.user.UserRepository
import br.ufal.ic.ufood.presentation.auth.UserSession
import br.ufal.ic.ufood.presentation.shared.mvp.Presenter

class AddressPresenter(
    private val userRepository: UserRepository
) : Presenter<AddressView>(AddressView::class.java) {

    fun onLoadMyAddresses() {
        try {
            val user = UserSession.getUserOrError()
            val addresses = userRepository.getAddresses(user)
            view.showAddresses(addresses)
        } catch (e: Exception) {
            view.onError(e.localizedMessage)
        }
    }

    fun onAddAddress() {
        val address = view.requestAddress()
        try {
            val user = UserSession.getUserOrError()
            userRepository.addAddress(user, address)
            view.onAddressAdded()
        } catch (e: Exception) {
            view.onError(e.localizedMessage)
        }
    }

    fun onDeleteAddress() {
        val addressId = view.requestAddressId()
        try {
            val user = UserSession.getUserOrError()
            userRepository.deleteAddress(user, addressId)
            view.onAddressDeleted()
        } catch (e: Exception) {
            view.onError(e.localizedMessage)
        }
    }

}
