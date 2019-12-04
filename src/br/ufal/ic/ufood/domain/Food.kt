package br.ufal.ic.ufood.domain

data class Food(
    var name: String,
    var category: Category,
    var price: Double,
    var description: String
) {

    enum class Category {
        ACAI, BEEF, BRAZILIAN, CAKE, CHINESE, COOKIE, DRINK, HOT_DOG, ICE_CREAM, ITALIAN, JAPANESE, PIZZA, SNACK
    }

}
