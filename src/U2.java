public class U2 extends Rocket{

    public U2(){
        cost = 120;
        weight = 18;
        currWeight = weight;
        maxWeight = 29;
        launchExplosionChance = 4.0;
        landingExplosionChance = 8.0;
    }
    @Override
    public boolean launch() {
        int random =  (int) ((Math.random() * 100) + 1);

        int cargoCarried = currWeight - weight;
        int cargoLimit = maxWeight - weight;
        double probability = launchExplosionChance * (cargoCarried/(double) cargoLimit);

        return probability < random;
    }

    @Override
    public boolean land() {
        int random =  (int) ((Math.random() * 100) + 1);

        int cargoCarried = currWeight - weight;
        int cargoLimit = maxWeight - weight;
        double probability = landingExplosionChance * (cargoCarried/(double) cargoLimit);

        return probability < random;
    }
}
