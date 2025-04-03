class Magic(name: String, health: Int, damage: Int) :
    Hero(name, health, damage, SuperAbility.BOOST) {

    private var roundsBoosted = 0

    override fun applySuperPower(boss: Boss, heroes: Array<Hero>) {
        if (roundsBoosted < 4) {
            for (hero in heroes) {
                if (hero != this && hero.health > 0) {
                    hero.damage += 5
                }
            }
            roundsBoosted++
            println("$name усилил атаку героев на 5")
        }
    }
}
