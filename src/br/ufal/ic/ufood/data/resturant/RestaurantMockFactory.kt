package br.ufal.ic.ufood.data.resturant

import br.ufal.ic.ufood.domain.Restaurant
import br.ufal.ic.ufood.domain.Restaurant.Category.*
import br.ufal.ic.ufood.domain.Restaurant.ServiceDay.*

object RestaurantMockFactory {

    private val serviceDays1: List<Restaurant.ServiceDay> by lazy {
        arrayListOf(
            Sunday(12, 19),
            Monday(12, 23),
            Tuesday(12, 23),
            Wednesday(12, 23),
            Thursday(12, 23),
            Friday(12, 23),
            Saturday(12, 19)
        )
    }
    private val serviceDays2: List<Restaurant.ServiceDay> by lazy {
        arrayListOf(
            Monday(10, 15),
            Tuesday(10, 15),
            Wednesday(10, 15),
            Thursday(10, 15),
            Friday(10, 15),
            Saturday(10, 13)
        )
    }
    private val serviceDays3: List<Restaurant.ServiceDay> by lazy {
        arrayListOf(
            Sunday(11, 21),
            Monday(11, 21),
            Tuesday(11, 21),
            Wednesday(11, 21),
            Thursday(11, 21),
            Friday(11, 21),
            Saturday(11, 21)
        )
    }
    private val serviceDays4: List<Restaurant.ServiceDay> by lazy {
        arrayListOf(
            Sunday(15, 23),
            Monday(15, 23),
            Tuesday(15, 23),
            Wednesday(15, 23),
            Thursday(15, 23),
            Friday(15, 23),
            Saturday(15, 23)
        )
    }
    val nearestRestaurants: List<Restaurant> by lazy {
        arrayListOf(
            Restaurant(
                "Açai Concept",
                "Açaí Concept, a maior franquia de açaí do mundo",
                arrayListOf(ACAI, DRINK),
                serviceDays1
            ),
            Restaurant(
                "Galeto São Luíz",
                "Comida brasileira.",
                arrayListOf(BEEF, BRAZILIAN, DRINK),
                serviceDays2
            ),
            Restaurant(
                "Chiquinho Sorvetes",
                "Sabor de bons momentos",
                arrayListOf(ACAI, ICE_CREAM),
                serviceDays3
            ),
            Restaurant(
                "Super Pizza",
                "Bateu aquela fome? Delivery de pizza.",
                arrayListOf(ACAI, BEEF, ICE_CREAM, PIZZA, SNACK),
                serviceDays4
            ),
            Restaurant(
                "Mercato Restaurante e Pizzaria",
                "Rodízio de pizza e de carnes",
                arrayListOf(BEEF, BRAZILIAN, DRINK, ITALIAN, PIZZA),
                serviceDays4
            )
        )
    }

}
