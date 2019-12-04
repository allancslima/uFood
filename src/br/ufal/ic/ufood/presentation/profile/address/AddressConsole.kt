package br.ufal.ic.ufood.presentation.profile.address

import br.ufal.ic.ufood.data.user.UserRepositoryImpl
import br.ufal.ic.ufood.domain.Address
import br.ufal.ic.ufood.presentation.shared.LABEL_TYPE_OPTION
import br.ufal.ic.ufood.presentation.shared.mvp.BasicConsole

class AddressConsole : BasicConsole(), AddressView {

    private val presenter: AddressPresenter by lazy { AddressPresenter(UserRepositoryImpl()) }

    override fun showMenu() {
        println("ADDRESS\n")
        println("1 - My addresses")
        println("2 - Add address")
        println("3 - Delete address")
        println("0 - Back")
        print(LABEL_TYPE_OPTION)

        when (scanner.nextLine().toInt()) {
            1 -> presenter.onLoadMyAddresses()
            2 -> presenter.onAddAddress()
            3 -> presenter.onDeleteAddress()
            0 -> {
                holdOutput()
                stop()
            }
            else -> {
                println("Invalid option.")
                holdOutput()
                showMenu()
            }
        }
    }

    override fun start() {
        super.start()
        presenter.attachView(this)
        showMenu()
    }

    override fun stop() {
        super.stop()
        presenter.detachView()
    }

    override fun showAddresses(addresses: List<Address>) {
        addresses.forEachIndexed { index, address ->
            println(
                String.format(
                    LABEL_ADDRESS_DETAILS,
                    index,
                    address.street,
                    address.number,
                    address.complement
                )
            )
        }
        holdOutput()
        showMenu()
    }

    override fun requestAddress(): Address {
        print(LABEL_TYPE_STREET)
        val street = scanner.nextLine()
        print(LABEL_TYPE_NUMBER)
        val number = scanner.nextLine().toInt()
        print(LABEL_TYPE_COMPLEMENT)
        val complement = scanner.nextLine()

        return Address(
            street,
            number,
            complement
        )
    }

    override fun requestAddressId(): Int {
        print(LABEL_TYPE_ADDRESS_ID)
        return scanner.nextLine().toInt()
    }

    override fun onAddressAdded() {
        println("\n$MSG_ADDRESS_ADDED")
        holdOutput()
        showMenu()
    }

    override fun onAddressDeleted() {
        println("\n$MSG_ADDRESS_DELETED")
        holdOutput()
        showMenu()
    }

}
