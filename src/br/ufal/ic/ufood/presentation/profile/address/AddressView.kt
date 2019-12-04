package br.ufal.ic.ufood.presentation.profile.address

import br.ufal.ic.ufood.domain.Address
import br.ufal.ic.ufood.presentation.shared.mvp.BasicView

interface AddressView : BasicView {

    fun showAddresses(addresses: List<Address>)

    fun requestAddress(): Address

    fun requestAddressId(): Int

    fun onAddressAdded()

    fun onAddressDeleted()

}
