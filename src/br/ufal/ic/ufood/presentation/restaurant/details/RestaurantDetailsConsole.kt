package br.ufal.ic.ufood.presentation.restaurant.details

import br.ufal.ic.ufood.data.user.UserRepositoryImpl
import br.ufal.ic.ufood.domain.Food
import br.ufal.ic.ufood.domain.Restaurant
import br.ufal.ic.ufood.presentation.shared.LABEL_TYPE_OPTION
import br.ufal.ic.ufood.presentation.shared.MSG_INVALID_OPTION
import br.ufal.ic.ufood.presentation.shared.mvp.BasicConsole

class RestaurantDetailsConsole(private val restaurant: Restaurant) : BasicConsole(), RestaurantDetailsView {

    private val presenter: RestaurantDetailsPresenter by lazy {
        RestaurantDetailsPresenter(restaurant, UserRepositoryImpl())
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

    override fun showFoods(foods: List<Food>) {
        println(LABEL_FOODS)
        foods.forEachIndexed { index, food ->
            println(
                String.format(
                    LABEL_FOOD_DETAILS,
                    index,
                    food.name,
                    food.description,
                    food.category.name.toLowerCase().capitalize().replace("_", " "),
                    food.price
                )
            )
        }
        holdOutput()
        showMenu()
    }

    override fun requestFoodIdAndQuantity(): Pair<Int, Int> {
        print(LABEL_TYPE_FOOD_ID)
        val foodId = scanner.nextLine().toInt()
        print(LABEL_TYPE_QUANTITY)
        val quantity = scanner.nextLine().toInt()

        return Pair(foodId, quantity)
    }

    override fun onCartUpdated() {
        println(MSG_CART_UPDATED)
        holdOutput()
        showMenu()
    }

    override fun showCart(iterable: Iterable<Map.Entry<Food, Int>>, cartPrice: Double, discount: Double) {
        println(LABEL_CART)
        iterable.forEach {
            println(String.format(LABEL_CART_ITEM, it.key.name, it.key.price, it.value))
        }
        println(String.format(LABEL_CART_PRICE, cartPrice, discount))
        holdOutput()
        showMenu()
    }

    override fun requestCouponId(): Int {
        print(LABEL_TYPE_COUPON_ID)
        return scanner.nextLine().toInt()
    }

    override fun onCouponApplied(newCartPrice: Double) {
        println(String.format(MSG_COUPON_APPLIED, newCartPrice))
        holdOutput()
        showMenu()
    }

    override fun onOrderPlaced(cartPrice: Double) {
        println(MSG_ORDER_PLACED)
        holdOutput()
        showMenu()
    }

    override fun onError(message: String) {
        println("An error occurred: $message")
        holdOutput()
        showMenu()
    }

    private fun showMenu() {
        println("Restaurant - ${restaurant.name}\n")
        println("1 - Show foods")
        println("2 - Add food to cart")
        println("3 - Remove food from cart")
        println("4 - View cart")
        println("5 - Clear cart")
        println("6 - Apply coupon")
        println("7 - Place order")
        println("0 - Back")
        print(LABEL_TYPE_OPTION)

        when (scanner.nextLine().toInt()) {
            1 -> presenter.onShowFoods()
            2 -> presenter.onAddFoodToCart()
            3 -> presenter.onRemoveFoodFromCart()
            4 -> presenter.onViewCart()
            5 -> presenter.onClearCart()
            6 -> presenter.onApplyCoupon()
            7 -> presenter.onPlaceOrder()
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

}
