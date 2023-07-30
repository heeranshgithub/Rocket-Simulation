public class Rocket implements Spaceship{

    int cost;
    int weight;
    int maxWeight;
    int currWeight;
    double launchExplosionChance;
    double landingExplosionChance;


    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        return (this.currWeight + item.weight) <= maxWeight;
    }

    @Override
    public void carry(Item item) {
        this.currWeight += item.weight;
    }
}
