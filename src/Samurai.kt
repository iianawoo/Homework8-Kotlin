import kotlin.random.Random

class Samurai(name: String, health: Int, damage: Int) :
    Hero(name, health, damage, SuperAbility.SHURIKEN_ATTACK) {

    override fun applySuperPower(boss: Boss, heroes: Array<Hero>) {
        val isVirus = Random.nextBoolean()
        val value = Random.nextInt(10, 30)

        if (isVirus) {
            boss.health -= value
            println("$name бросил вирусный сюрикен, урон: $value")
        } else {
            boss.health += value
            println("$name бросил лечебный сюрикен, лечение: $value")
        }
    }
}
