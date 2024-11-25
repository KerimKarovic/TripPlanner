import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Manually add destinations instead of reading from an Excel file
        List<Destination> destinations = new ArrayList<>();
        destinations.add(new Destination("Zivinice Loko", 8, 35));
        destinations.add(new Destination("Priluk", 10, 15));
        destinations.add(new Destination("Djurdjevik", 10, 15));
        destinations.add(new Destination("Tuzla", 12, 15));
        destinations.add(new Destination("Lukavac", 15, 20));
        destinations.add(new Destination("Banovici", 18, 20));
        destinations.add(new Destination("Puracic", 18, 20));
        destinations.add(new Destination("Kalesija", 26, 30));
        destinations.add(new Destination("Srebrenik", 34, 40));
        destinations.add(new Destination("Lopare", 37, 40));
        destinations.add(new Destination("Kladanj", 37, 40));
        destinations.add(new Destination("Gracanica", 42, 45));
        destinations.add(new Destination("Sapna", 45, 50));
        destinations.add(new Destination("Cerik", 48, 55));
        destinations.add(new Destination("Klokotnica", 52, 50));
        destinations.add(new Destination("Zvornik", 54, 60));
        destinations.add(new Destination("Olovo", 55, 60));
        destinations.add(new Destination("Doboj", 61, 60));
        destinations.add(new Destination("Zavidovici", 65, 70));
        destinations.add(new Destination("Zepce", 77, 80));
        destinations.add(new Destination("Tesanj", 79, 90));
        destinations.add(new Destination("Maglaj", 83, 90));
        destinations.add(new Destination("Sarajevo", 110, 120));
        destinations.add(new Destination("Zenica", 116, 120));
        destinations.add(new Destination("Banja Luka", 163, 140));
        destinations.add(new Destination("Bugojno", 176, 190));
        destinations.add(new Destination("Mostar", 218, 210));

        // Create an instance of TripPlanner
        TripPlanner tripPlanner = new TripPlanner(destinations);
        
        // Call the method to prompt the user and plan the trip for the week
        tripPlanner.askForInputAndPlanWeek(); // This will handle user input and trip planning.
    }
}
