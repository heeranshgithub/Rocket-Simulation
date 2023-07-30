import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Simulation {
    public ArrayList<Item> loadItems(String fileName) throws FileNotFoundException{
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        ArrayList<Item> itemsList = new ArrayList<>();

        while(scan.hasNextLine()){
            String line = scan.nextLine();
            String[] oneItem = line.split("=");

            itemsList.add( new Item(oneItem[0], Integer.parseInt(oneItem[1])/1000) );
        }

        return itemsList;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> itemsList){
        ArrayList<Rocket> u1Fleet = new ArrayList<>();
        Rocket u1 = new U1();

        for(Item item : itemsList){
            if(!u1.canCarry(item)) {

                u1Fleet.add(u1);
                u1 = new U1();
            }

            u1.carry(item);
        }

        u1Fleet.add(u1);
        return u1Fleet;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> itemsList){
        ArrayList<Rocket> u2Fleet = new ArrayList<>();
        Rocket u2 = new U2();

        for(Item item : itemsList){
            if(!u2.canCarry(item)) {
                u2Fleet.add(u2);
                u2 = new U2();
            }

            u2.carry(item);
        }

        u2Fleet.add(u2);
        return u2Fleet;
    }

    public int runSimulation(ArrayList<Rocket> fleet){
        int totalBudget = 0;

        int counter = 0;
        int crashed = 0;

        while(counter < fleet.size()){
            if(fleet.get(counter).launch() && fleet.get(counter).land()){
                totalBudget += fleet.get(counter).cost;
                counter++;
            }
            else {
                totalBudget += fleet.get(counter).cost;
                crashed++;
            }
        }
        System.out.println(counter + " successful landings and " + crashed + " crashed");

        return totalBudget;
    }
}






















