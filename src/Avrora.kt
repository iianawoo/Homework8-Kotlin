class Avrora(name: String, health: Int, damage: Int) :
    Hero(name, health, damage, SuperAbility.INVISIBILITY) {

    private var isInvisible = false
    private var invisibleRounds = 0
    private var storedDamage = 0
    private var hasUsedAbility = false

    override fun applySuperPower(boss: Boss, heroes: Array<Hero>) {
        if (!hasUsedAbility) {
            isInvisible = true
            invisibleRounds = 2
            hasUsedAbility = true
            println("$name ушла в невидимость на 2 раунда!")
        }

        if (isInvisible) {
            storedDamage += boss.damage
            println("$name избежала урона, накопила $storedDamage")
            invisibleRounds--
            if (invisibleRounds == 0) {
                isInvisible = false
                boss.health -= storedDamage
                println("$name вернула боссу $storedDamage урона!")
                storedDamage = 0
            }
        }
    }

    override fun takeDamage(amount: Int) {
        if (!isInvisible) {
            super.takeDamage(amount)
        }
    }
}
