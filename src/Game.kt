object Game {
    private var round = 0

    fun startGame() {
        val boss = Boss("Aleksey", 1000, 50)

        val heroes = arrayOf(
            Magic("Ayana", 270, 10),
            Avrora("Elya", 300, 15),
            Hacker("Rustam", 280, 10),
            Samurai("Kais", 290, 12)
        )

        printStatistics(boss, heroes)

        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes)
        }
    }

    private fun playRound(boss: Boss, heroes: Array<Hero>) {
        round++
        println("ROUND $round -----------------")
        boss.attack(heroes)

        for (hero in heroes) {
            if (hero.health > 0 && boss.health > 0) {
                hero.attack(boss)
                hero.applySuperPower(boss, heroes)
            }
        }

        printStatistics(boss, heroes)
    }

    private fun printStatistics(boss: Boss, heroes: Array<Hero>) {
        println(boss)
        for (hero in heroes) {
            println(hero)
        }
    }

    private fun isGameOver(boss: Boss, heroes: Array<Hero>): Boolean {
        if (boss.health <= 0) {
            println("Heroes won!")
            return true
        }
        if (heroes.all { it.health <= 0 }) {
            println("Boss won!")
            return true
        }
        return false
    }
}
