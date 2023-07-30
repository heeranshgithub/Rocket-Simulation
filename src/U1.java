public class U1 extends Rocket{

    public U1(){
        cost = 100; //100 million dollars
        weight = 10;
        currWeight = weight;
        maxWeight = 18;
        launchExplosionChance = 5.0;
        landingExplosionChance = 1.0;
    }
    @Override
    public boolean launch() {
        int random = (int) ((Math.random() * 100) + 1);

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
