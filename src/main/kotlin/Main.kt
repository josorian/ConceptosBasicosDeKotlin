fun main(args: Array<String>) {
    /*2. Notificaciones móviles
Por lo general, el teléfono te proporciona un resumen de las notificaciones.

En el código inicial que se proporciona en el siguiente fragmento de código, escribe un programa que imprima el mensaje de resumen según la cantidad de notificaciones que recibiste. El mensaje debe incluir lo siguiente:

La cantidad exacta de notificaciones cuando haya menos de 100
99+ como cantidad de notificaciones cuando haya 100 o más
     */
    val morningNotification = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
    /*Las entradas de cine suelen tener un precio diferente según la edad de los espectadores.

En el código inicial que se proporciona en el siguiente fragmento de código, escribe un programa que calcule los precios de estas entradas basados en la edad:

Un precio de entrada infantil de USD 15 para personas de 12 años o menos.
Un precio de entrada estándar de USD 30 para personas de entre 13 y 60 años. Los lunes, un precio estándar con descuento de USD 25 para el mismo grupo etario
Un precio para adultos mayores de USD 20 para personas de 61 años o más (asumimos que la edad máxima de un espectador es de 100 años)
Un valor de -1 para indicar que el precio no es válido cuando un usuario ingresa una edad fuera de las especificaciones
     */
    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true

    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
/*4. Conversor de temperatura
En el mundo, se usan tres escalas de temperatura principales: Celsius, Fahrenheit y Kelvin.

En el código inicial que se proporciona en el siguiente fragmento de código, escribe un programa que convierta una temperatura de una escala a otra con estas fórmulas:

De grados Celsius a Fahrenheit: °F = 9/5 (°C) + 32
Kelvin a Celsius: °C = K - 273.15
De Fahrenheit a Kelvin: K = 5/9 (°F - 32) + 273.15
Ten en cuenta que el método String.format("%.2f", /* measurement */ ) se usa para convertir un número en un tipo String con 2 decimales.
 */
    printFinalTemperature(27.0, "Celsius", "Fahrenheit") { 9.0 / 5.0 * it + 32 }
    printFinalTemperature(350.0, "Kelvin", "Celsius") { it - 273.15 }
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin") { 5.0 / 9.0 * (it - 32) + 273.15 }
/*5. Catálogo de canciones
Imagina que necesitas crear una app de reproducción de música.

Crea una clase que pueda representar la estructura de una canción. La clase Song debe incluir estos elementos de código:

Propiedades para el título, el artista, el año de publicación y el recuento de reproducciones
Propiedad que indica si la canción es popular (si el recuento de reproducciones es inferior a 1,000, considera que es poco popular)
Un método para imprimir la descripción de una canción en este formato:
"[Título], interpretada por [artista], se lanzó en [año de lanzamiento]".
 */
    val brunoSong = Song("We Don't Talk About Bruno", "Encanto Cast", 2022, 1_000_000)
    brunoSong.printDescription()
    println(brunoSong.isPopular)
    /*A menudo, debes completar los perfiles de sitios web en línea que contienen campos obligatorios y no obligatorios. Por ejemplo, puedes agregar tu información personal y un vínculo a otras personas que te refirieron para que registraras tu perfil.

En el código inicial que se proporciona en el siguiente fragmento de código, escribe un programa que imprima los detalles del perfil de una persona.
     */
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()
    /*7. Teléfonos plegables
Por lo general, la pantalla del teléfono se enciende y se apaga cuando se presiona el botón de encendido. En cambio, si un teléfono plegable está plegado, su pantalla interna principal no se enciende cuando se presiona el botón de encendido.

En el código inicial que se proporciona en el siguiente fragmento de código, escribe una clase FoldablePhone que se herede de la clase Phone. Debe contener lo siguiente:

Una propiedad que indique si el teléfono está plegado
Un comportamiento de función switchOn() diferente del de la clase Phone para que solo encienda la pantalla cuando el teléfono no esté plegado
Métodos para cambiar el estado de plegado
     */
    val newFoldablePhone = FoldablePhone()

    newFoldablePhone.switchOn()
    newFoldablePhone.checkPhoneScreenLight()
    newFoldablePhone.unfold()
    newFoldablePhone.switchOn()
    newFoldablePhone.checkPhoneScreenLight()
    /*8. Subasta especial
Por lo general, en una subasta, el ofertante que ofrece el importe más alto determina el precio de un artículo. En esta subasta especial, si nadie oferta por un artículo, este se vende automáticamente a la casa de subastas al precio mínimo.

En el código inicial que se proporciona en el siguiente fragmento de código, se te proporciona una función auctionPrice() que acepta un tipo Bid? anulable como argumento:
     */
    val winningBid = Bid(5000, "Private Collector")

    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")
    println("Item B is sold at ${auctionPrice(null, 3000)}.")
}

fun printNotificationSummary(numberOfMessages: Int) {
    if(numberOfMessages<100){
        println("You have $numberOfMessages notifications.")
    }else{
        println("Your phone is blowing up! You have 99+ notifications.")
    }
}
fun ticketPrice(age: Int, isMonday: Boolean): Int {
    return when(age){
        in 0..12 -> 15
        in 13..60-> if (isMonday) 25 else 30
        in 61..100 -> 20
        else -> -1
    }
}
fun printFinalTemperature(initialMeasurement: Double, initialUnit: String, finalUnit: String, conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}
class Song(
    val title: String,
    val artist: String,
    val yearPublished: Int,
    val playCount: Int
){
    val isPopular: Boolean
        get() = playCount >= 1000

    fun printDescription() {
        println("$title, performed by $artist, was released in $yearPublished.")
    }
}
class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        println("Name: $name")
        println("Age: $age")
        if(hobby != null) {
            print("Likes to $hobby. ")
        }
        if(referrer != null) {
            print("Has a referrer named ${referrer.name}")
            if(referrer.hobby != null) {
                print(", who likes to ${referrer.hobby}.")
            } else {
                print(".")
            }
        } else {
            print("Doesn't have a referrer.")
        }
        print("\n\n")
    }
}
open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(var isFolded: Boolean = true): Phone() {
    override fun switchOn() {
        if (!isFolded) {
            isScreenLightOn = true
        }
    }

    fun fold() {
        isFolded = true
    }

    fun unfold() {
        isFolded = false
    }
}
class Bid(val amount: Int, val bidder: String)

fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
    return bid?.amount ?: minimumPrice
}