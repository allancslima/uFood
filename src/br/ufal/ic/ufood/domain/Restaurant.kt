package br.ufal.ic.ufood.domain

data class Restaurant(
    var name: String,
    var description: String,
    var categories: List<Food.Category>,
    var serviceDays: List<ServiceDay>
) {

    sealed class ServiceDay(val day: Int, val start: Int, val end: Int) {

        class Sunday(start: Int, end: Int) : ServiceDay(0, start, end)
        class Monday(start: Int, end: Int) : ServiceDay(1, start, end)
        class Tuesday(start: Int, end: Int) : ServiceDay(2, start, end)
        class Wednesday(start: Int, end: Int) : ServiceDay(3, start, end)
        class Thursday(start: Int, end: Int) : ServiceDay(4, start, end)
        class Friday(start: Int, end: Int) : ServiceDay(5, start, end)
        class Saturday(start: Int, end: Int) : ServiceDay(6, start, end)

    }

}
