import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class TripPlanner {
    private List<Destination> destinations;

    public TripPlanner(List<Destination> destinations) {
        this.destinations = destinations;
    }

    // Method to ask for input and plan the weekly trip
    public void askForInputAndPlanWeek() {
        Scanner scanner = new Scanner(System.in);

        // Get user input for number of days driven and total distance
        System.out.print("Enter total number of days driven (1-6): ");
        int daysDriven = scanner.nextInt();

        System.out.print("Enter total distance covered in the week (in km): ");
        double totalDistance = scanner.nextDouble();

        // Plan the weekly trip
        planWeekTrip(daysDriven, totalDistance);

        scanner.close();
    }

    // Method to plan the weekly trip with return to Zivinice after each destination
    public void planWeekTrip(int daysDriven, double totalDistance) {
        List<String> tripPlan = new ArrayList<>();
        String startLocation = "Zivinice";
        tripPlan.add("Start at Zivinice");

        double remainingDistance = totalDistance;

        for (int day = 1; day <= daysDriven; day++) {
            tripPlan.add("Day " + day + ":");
            double dailyDistance = 0;

            // Set a flexible limit for the current day based on remaining distance
            double dailyLimit = (remainingDistance / (daysDriven - day + 1)) + 10; // Adjusted daily limit

            while (dailyDistance < dailyLimit && remainingDistance > 0) {
                Destination chosenDestination = getRandomDestination(Math.min(remainingDistance / 2, dailyLimit - dailyDistance));

                if (chosenDestination != null) {
                    double roundTripDistance = chosenDestination.getDistance() * 2; // Round trip distance

                    // Check if there's enough distance left for the round trip
                    if (remainingDistance >= roundTripDistance && (dailyDistance + roundTripDistance) <= dailyLimit) {
                        remainingDistance -= roundTripDistance; // Deduct the round trip distance from remaining distance
                        dailyDistance += roundTripDistance; // Add to the daily distance

                        // Add the trip to the plan in the requested format
                        tripPlan.add("  Zivinice -> " + chosenDestination.getDestination() +
                                " (" + chosenDestination.getDistance() + " km one way, " +
                                chosenDestination.getMinutes() + " min) ");
                        tripPlan.add("  " + chosenDestination.getDestination() + " -> Zivinice" +
                                " (" + chosenDestination.getDistance() + " km one way, " +
                                chosenDestination.getMinutes() + " min) ");
                    } else {
                        break; // Stop if there's not enough distance left for this destination
                    }
                } else {
                    break; // Stop if no valid destination is found
                }
            }

            // If no trips were made for the day, try again to fill the day
            if (dailyDistance == 0 && remainingDistance > 0) {
                Destination chosenDestination = getRandomDestination(Math.min(remainingDistance / 2, dailyLimit));
                if (chosenDestination != null) {
                    double roundTripDistance = chosenDestination.getDistance() * 2;

                    if (remainingDistance >= roundTripDistance) {
                        remainingDistance -= roundTripDistance;
                        dailyDistance += roundTripDistance;

                        tripPlan.add("  Zivinice -> " + chosenDestination.getDestination() +
                                " (" + chosenDestination.getDistance() + " km one way, " +
                                chosenDestination.getMinutes() + " min) ");
                        tripPlan.add("  " + chosenDestination.getDestination() + " -> Zivinice" +
                                " (" + chosenDestination.getDistance() + " km one way, " +
                                chosenDestination.getMinutes() + " min) ");
                    }
                }
            }
        }

        // Allow for minimal tolerance on the remaining distance
        if (remainingDistance > 0) {
            tripPlan.add("Warning: Remaining distance not utilized! Remaining distance: " + remainingDistance + " km");
        }

        tripPlan.add("End at Zivinice");

        // Output the planned trip
        System.out.println("\nWeekly Trip Plan:");
        for (String trip : tripPlan) {
            System.out.println(trip);
        }
    }

    // Method to get a random destination that fits within the remaining distance
    private Destination getRandomDestination(double maxDistance) {
        Random random = new Random();
        List<Destination> validDestinations = new ArrayList<>();

        // Filter destinations based on the maximum allowed one-way distance
        for (Destination destination : destinations) {
            if (destination.getDistance() <= maxDistance) {
                validDestinations.add(destination);
            }
        }

        // Randomly select a valid destination, if any exist
        if (!validDestinations.isEmpty()) {
            return validDestinations.get(random.nextInt(validDestinations.size()));
        }

        return null;  // No valid destination found
    }
}
