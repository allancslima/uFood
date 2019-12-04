package br.ufal.ic.ufood.presentation.restaurant

import br.ufal.ic.ufood.data.restaurant.RestaurantRepositoryImpl
import br.ufal.ic.ufood.domain.Restaurant
import br.ufal.ic.ufood.presentation.restaurant.details.RestaurantDetailsConsole
import br.ufal.ic.ufood.presentation.shared.LABEL_TYPE_OPTION
import br.ufal.ic.ufood.presentation.shared.MSG_INVALID_OPTION
import br.ufal.ic.ufood.presentation.shared.mvp.BasicConsole

class RestaurantsConsole : BasicConsole(), RestaurantsView {

    private val presenter: RestaurantsPresenter by lazy {
        RestaurantsPresenter(RestaurantRepositoryImpl())
    }

    override fun showMenu() {
        println("RESTAURANTS\n")
        println("1 - Show nearest restaurants")
        println("2 - Search nearest restaurants")
        println("3 - Go to a restaurant")
        println("0 - Back")
        print(LABEL_TYPE_OPTION)

        when (scanner.nextLine().toInt()) {
            1 -> presenter.onLoadNearestRestaurants()
            2 -> presenter.onSearchNearestRestaurants()
            3 -> presenter.onGoToRestaurant()
            0 -> {
                holdOutput()
                stop()
            }
            else -> {
                println(MSG_INVALID_OPTION)
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

    override fun showRestaurants(restaurants: List<Restaurant>) {
        restaurants.forEachIndexed { index, restaurant ->
            println(String.format(LABEL_RESTAURANT_DETAILS, index, restaurant.name, restaurant.description))
            print(LABEL_CATEGORIES)

            val categoriesString = restaurant.categories.joinToString(", ") {
                it.name.toLowerCase().capitalize().replace("_", " ")
            }
            println(categoriesString)
            println(LABEL_SERVICE_DAYS)

            restaurant.serviceDays.forEach {
                println(String.format(LABEL_SERVICE_DAY_DETAILS, it.javaClass.simpleName, it.start, it.end))
            }
            println()
        }
        holdOutput()
        showMenu()
    }

    override fun requestSearch(): String {
        print(LABEL_TYPE_SEARCH)
        return scanner.nextLine()
    }

    override fun requestRestaurantId(): Int {
        print(LABEL_TYPE_RESTAURANT_ID)
        return scanner.nextLine().toInt()
    }

    override fun navigateToRestaurant(restaurant: Restaurant) {
        RestaurantDetailsConsole(restaurant).start()
        holdOutput()
        showMenu()
    }

}
