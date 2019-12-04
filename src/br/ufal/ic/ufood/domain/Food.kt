package br.ufal.ic.ufood.domain

data class Food(
    var name: String,
    var description: String,
    var category: Category,
    var price: Double
) {

    enum class Category {
        ACAI, BEEF, BRAZILIAN, CAKE, CHINESE, COOKIE, DRINK, HOT_DOG, ICE_CREAM, ITALIAN, JAPANESE, PIZZA, SNACK
    }

}
