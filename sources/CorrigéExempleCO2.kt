package tp03.activite03

fun main() {
    println("Entrez la distance parcourue en km:")
    val distance = readln().toDouble()
    println("Entrez le nombre de voyageurs:")
    val nombreVoyageurs = readln().toInt()
    println(
        """
            Entrez le mode de transports :
            1. Voiture
            2. Train
            3. Avion
        """.trimIndent()
    )
    var choixTransport: String
    var nomTransport = "Non renseigné"
    do {
        choixTransport = readln()
        if (choixTransport != "1" && choixTransport != "2" && choixTransport != "3") {
            println("Choix invalide.")
        } else {
            if (choixTransport == "1") {
                nomTransport = "Voiture"
            } else if (choixTransport == "2") {
                nomTransport = "Train"
            } else {
                nomTransport = "Avion"
            }
        }
    } while (choixTransport != "1" && choixTransport != "2" && choixTransport != "3")

    val emissionCO2enGParKmParVoyageur = if (choixTransport == "1") {
        120 / nombreVoyageurs
    } else if (choixTransport == "2") {
        14
    } else {
        285
    }
    val emissionsCO2TotaleParVoyageurEnKg = emissionCO2enGParKmParVoyageur * distance / 1000
    println("""
        Dans le cas de ce voyage de $distance km en $nomTransport, la quantité de CO2 émise 
        - par chaque voyageur est de $emissionsCO2TotaleParVoyageurEnKg kg.
        - pour tous les voyageurs est de ${emissionsCO2TotaleParVoyageurEnKg * nombreVoyageurs} kg
        """.trimIndent())
}