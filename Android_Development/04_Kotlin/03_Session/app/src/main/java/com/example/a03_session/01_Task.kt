enum class Building {
    VILLA,
    APARTMENT
}

data class Person(val name: String, val address: Address) {
    data class Address(val streetName: String, val city: String, val building: Building)
}

fun main() {

    val address = Person.Address("Main St", "Springfield", Building.VILLA)

    val person = Person("John Doe", address)

    println("Name: ${person}")
   // println("Address: ${person.address.streetName}, ${person.address.city}, ${person.address.building}")
}
