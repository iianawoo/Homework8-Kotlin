open class Hero(
    var name: String,
    var health: Int,
    var damage: Int,
    val ability: SuperAbility
) {
    open fun attack(boss: Boss) {
        boss.health -= damage
    }

    open fun applySuperPower(boss: Boss, heroes: Array<Hero>) {}

    open fun takeDamage(amount: Int) {
        health -= amount
        if (health < 0) health = 0
    }

    override fun toString(): String {
        val className = this::class.simpleName ?: "Hero"
        return "[$className] $name - HP: $health, DMG: $damage"
    }
}
