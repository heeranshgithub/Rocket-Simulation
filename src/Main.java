import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Simulation sim = new Simulation();

        ArrayList<Item> phase1ItemsList = sim.loadItems("phase1.txt");
        ArrayList<Item> phase2ItemsList = sim.loadItems("phase2.txt");
        System.out.println("Number of Items in Phase 1: " + phase1ItemsList.size());
        System.out.println("Number of Items in Phase 2: " + phase2ItemsList.size());

        System.out.println("\nU1 fleet simulation:");
        U1 u1 = new U1();
        System.out.println("U1 rocket weight: " + u1.weight + " Tonnes and max weight: " + u1.maxWeight + " Tonnes");
        System.out.println("U1 rocket cost: $" + u1.cost + " million");
        System.out.println("Phase 1: ");
        ArrayList<Rocket> U1FleetPhase1= sim.loadU1(phase1ItemsList);
        int U1Phase1Budget = sim.runSimulation(U1FleetPhase1);
        System.out.println("Budget of U1 fleet for phase 1: $" + U1Phase1Budget + " million");
        System.out.println("Phase 2: ");
        ArrayList<Rocket> U1FleetPhase2= sim.loadU1(phase2ItemsList);
        int U1Phase2Budget = sim.runSimulation(U1FleetPhase2);
        System.out.println("Budget of U1 fleet for phase 2: $" + U1Phase2Budget + " million");
        System.out.println("Total budget for U1 fleet: $" + (U1Phase1Budget + U1Phase2Budget) + " million" );

        System.out.println("\nU2 fleet simulation:");
        U2 u2 = new U2();
        System.out.println("U2 rocket weight: " + u2.weight + " Tonnes and max weight: " + u2.maxWeight + " Tonnes");
        System.out.println("U2 rocket cost: $" + u2.cost + " million");
        System.out.println("Phase 1: ");
        ArrayList<Rocket> U2FleetPhase1= sim.loadU2(phase1ItemsList);
        int U2Phase1Budget = sim.runSimulation(U2FleetPhase1);
        System.out.println("Budget of U2 fleet for phase 1: $" + U2Phase1Budget + " million");
        System.out.println("Phase 2: ");
        ArrayList<Rocket> U2FleetPhase2= sim.loadU2(phase2ItemsList);
        int U2Phase2Budget = sim.runSimulation(U2FleetPhase2);
        System.out.println("Budget of U2 fleet for phase 2: $" + U2Phase2Budget + " million");
        System.out.println("Total budget for U2 fleet: $" + (U2Phase1Budget + U2Phase2Budget) + " million" );
    }
}
