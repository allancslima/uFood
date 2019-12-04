package br.ufal.ic.ufood.data.restaurant

import br.ufal.ic.ufood.domain.Food
import br.ufal.ic.ufood.domain.Food.Category.*
import br.ufal.ic.ufood.domain.Restaurant
import br.ufal.ic.ufood.domain.Restaurant.ServiceDay.*

object RestaurantMockFactory {

    val nearestRestaurants: List<Restaurant> by lazy {
        arrayListOf(
            Restaurant(
                "Açai Concept",
                "Açaí Concept, a maior franquia de açaí do mundo",
                arrayListOf(ACAI, DRINK),
                ServiceDayMockFactory.serviceDays1,
                arrayListOf(FoodMockFactory.acai1, FoodMockFactory.acai2, FoodMockFactory.acai3)
            ),
            Restaurant(
                "Galeto São Luíz",
                "Comida brasileira.",
                arrayListOf(BEEF, BRAZILIAN, DRINK),
                ServiceDayMockFactory.serviceDays2,
                arrayListOf(
                    FoodMockFactory.brazilian1, FoodMockFactory.brazilian2, FoodMockFactory.brazilian3,
                    FoodMockFactory.drink1, FoodMockFactory.drink2, FoodMockFactory.drink3
                )
            ),
            Restaurant(
                "Chiquinho Sorvetes",
                "Sabor de bons momentos",
                arrayListOf(ACAI, ICE_CREAM),
                ServiceDayMockFactory.serviceDays3,
                arrayListOf(FoodMockFactory.iceCream1, FoodMockFactory.iceCream2, FoodMockFactory.iceCream3)
            ),
            Restaurant(
                "Super Pizza",
                "Bateu aquela fome? Delivery de pizza.",
                arrayListOf(ACAI, BEEF, ICE_CREAM, PIZZA, SNACK),
                ServiceDayMockFactory.serviceDays4,
                arrayListOf(
                    FoodMockFactory.pizza1, FoodMockFactory.pizza2, FoodMockFactory.pizza3,
                    FoodMockFactory.drink1, FoodMockFactory.drink2, FoodMockFactory.drink3
                )
            ),
            Restaurant(
                "Mercatto Restaurante e Pizzaria",
                "Rodízio de pizza e de carnes",
                arrayListOf(BEEF, BRAZILIAN, DRINK, ITALIAN, PIZZA),
                ServiceDayMockFactory.serviceDays4,
                arrayListOf(
                    FoodMockFactory.pizza1, FoodMockFactory.pizza2, FoodMockFactory.pizza3,
                    FoodMockFactory.italian1, FoodMockFactory.snack1, FoodMockFactory.snack2,
                    FoodMockFactory.drink1, FoodMockFactory.drink2, FoodMockFactory.drink3
                )
            )
        )
    }

    object ServiceDayMockFactory {

        val serviceDays1: List<Restaurant.ServiceDay> by lazy {
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
        val serviceDays2: List<Restaurant.ServiceDay> by lazy {
            arrayListOf(
                Monday(10, 15),
                Tuesday(10, 15),
                Wednesday(10, 15),
                Thursday(10, 15),
                Friday(10, 15),
                Saturday(10, 13)
            )
        }
        val serviceDays3: List<Restaurant.ServiceDay> by lazy {
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
        val serviceDays4: List<Restaurant.ServiceDay> by lazy {
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

    }

    object FoodMockFactory {

        val acai1 = Food(
            "Açai tradicional",
            "Açai tradicional 500ml + granola + paçoca + banana.",
            ACAI,
            13.9
        )
        val acai2 = Food(
            "Promoção upgrade",
            "Leve 500ml pelo preço de 300ml, diversas caldas e acompanhamentos.",
            ACAI,
            15.9
        )
        val acai3 = Food(
            "Açai tradicional 750ml",
            "Com diversas caldas e acompanhamentos.",
            ACAI,
            27.9
        )
        val iceCream1 = Food(
            "Ovomaltine 360ml",
            "Delicioso creme de Ovomaltine.",
            ICE_CREAM,
            12.8
        )
        val iceCream2 = Food(
            "KitKat 360ml",
            "Mistura deliciosa de calda ganache e KitKat.",
            ICE_CREAM,
            12.0
        )
        val iceCream3 = Food(
            "Sundae",
            "Calda quente 220ml.",
            ICE_CREAM,
            8.0
        )
        val pizza1 = Food(
            "Pizza baby",
            "Escolha o sabor da sua pizza.",
            PIZZA,
            17.0
        )
        val pizza2 = Food(
            "Pizza média 30cm",
            "Escolha até 2 sabores.",
            PIZZA,
            37.0
        )
        val pizza3 = Food(
            "Pizza grande 35cm",
            "Escolha até 2 sabores.",
            PIZZA,
            49.0
        )
        val drink1 = Food(
            "Refrigerante 350ml",
            "Coca-cola, Fanta, Sprite, etc.",
            DRINK,
            6.0
        )
        val drink2 = Food(
            "Água mineral com gás",
            "330ml.",
            DRINK,
            3.0
        )
        val drink3 = Food(
            "Heineken lata",
            "350ml.",
            DRINK,
            6.0
        )
        val brazilian1 = Food(
            "Quentinha de galeto",
            "Arroz, feijão, macarrão, batata fritas e maionese.",
            BRAZILIAN,
            12.99
        )
        val brazilian2 = Food(
            "Quentinha de carne de porco",
            "Arroz, feijão, macarrão, batata fritas e maionese.",
            BRAZILIAN,
            15.99
        )
        val brazilian3 = Food(
            "Porção de feijão caseiro",
            "Porção grande de feijão caseiro",
            BRAZILIAN,
            10.0
        )
        val italian1 = Food(
            "Espaguete à Bolonhesa",
            "Massa Italiana com Molho a Bolonhesa e Manjericão.",
            ITALIAN,
            29.99
        )
        val snack1 = Food(
            "Green burguer",
            "Burguer artesanal de costela bovina, 3x muçarela e tomate envolto por alface.",
            SNACK,
            22.0
        )
        val snack2 = Food(
            "Cheeseburguer",
            "Pão artesanal, burguer bovino de 120g com 3x mais queijo.",
            SNACK,
            17.0
        )
    }

}
