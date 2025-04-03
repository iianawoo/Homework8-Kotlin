class Boss(
    val name: String,
    var health: Int,
    var damage: Int
) {
    fun attack(heroes: Array<Hero>) {
        for (hero in heroes) {
            if (hero.health > 0) {
                hero.takeDamage(damage)
            }
        }
    }

    override fun toString(): String {
        return "$name HP: $health DMG: $damage"
    }
}
