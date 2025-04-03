import kotlin.random.Random

class Hacker(name: String, health: Int, damage: Int) :
    Hero(name, health, damage, SuperAbility.HEALTH_HACK) {

    private var canSteal = true

    override fun applySuperPower(boss: Boss, heroes: Array<Hero>) {
        if (canSteal) {
            val target = heroes[Random.nextInt(heroes.size)]
            boss.health -= 30
            target.health += 30
            println("$name украл 30 HP у босса и дал ${target.name}")
            canSteal = false
        } else {
            canSteal = true
        }
    }
}
