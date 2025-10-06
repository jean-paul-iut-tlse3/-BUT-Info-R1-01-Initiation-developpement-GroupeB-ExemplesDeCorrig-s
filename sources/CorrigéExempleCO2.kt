package tp03.activite03
// Original


fun main() {
    // Menu principal
    var choixTransport: String
    var nomTransport = "Non renseigné"
    val distance = demander("Entrez la distance parcourue en km : ").toDouble()
    val nombreVoyageurs = demander("Entrez le nombre de voyageurs : ").toInt()

    afficherMenu()
    do {
        choixTransport = demander("Quel est votre choix : ")
        // Évaluation du nom du transport si le choix est valide
        // On se rend compte de l'utilité d'une fonction choixInvalide
        // qui testera la triple inégalité pour alléger l'écriture
        if (estCodeInvalide(choixTransport)) { println("Choix invalide.")
        } else {
            // Évaluation du nom du transport en fonction de son numéro
           nomTransport = num2nom(choixTransport)
        }
    } while ( estCodeInvalide(choixTransport))

    // Ce calcul sera déporté dans une fonction qui suivant le nombre de passagers et
    // le type de transport évaluera le coût en CO2
    val emissionCO2enGParKmParVoyageur = poidsCo2ParKm(choixTransport,nombreVoyageurs)
    val emissionsCO2TotaleParVoyageurEnKg = emissionCO2enGParKmParVoyageur * distance / 1000


    println("""
        Dans le cas de ce voyage de $distance km en $nomTransport, la quantité de CO2 émise 
        - par chaque voyageur est de $emissionsCO2TotaleParVoyageurEnKg kg.
        - pour tous les voyageurs est de ${emissionsCO2TotaleParVoyageurEnKg * nombreVoyageurs} kg
        """.trimIndent())
}
fun afficherMenu() {
    println(
    """
            Entrez le mode de transports :
            1. Voiture
            2. Train
            3. Avion
        """.trimIndent()
)}
fun estCodeInvalide (choixTransport:String): Boolean {
    return (choixTransport != "1" && choixTransport != "2" && choixTransport != "3")
}

fun num2nom (choixTransport: String) : String {
    val nomTransport: String
    if (choixTransport == "1") {
        nomTransport = "Voiture"
    } else if (choixTransport == "2") {
        nomTransport = "Train"
    } else {
        nomTransport = "Avion"
    }
    return nomTransport
}
fun poidsCo2ParKm(choixTransport:String,nombreVoyageurs: Int): Int {
    return if (choixTransport == "1") {
                120 / nombreVoyageurs
                } else if (choixTransport == "2") {
                14
                } else {
                        285
                        }
}
fun demander(invite:String) : String {
    print(invite)
    return readln()
}