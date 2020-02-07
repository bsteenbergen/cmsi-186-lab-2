import java.util.Arrays;
import java.util.HashSet;

public class SharedBirthday {

    public static void main(String[] args) {
        try {
            if (args.length != 3) {
                throw new IllegalArgumentException("Exactly three arguments required");
            }

            int people = Integer.parseInt(args[0]);
            int days = Integer.parseInt(args[1]);
            int trials = Integer.parseInt(args[2]);
            System.out.println(probabilityEstimate(people, days, trials));

        } 
        
        catch (NumberFormatException e) {
            System.err.println("Arguments must all be integers");
        } 

        catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public static double probabilityEstimate(int people, int days, int trials) {
            if (people < 2) {
                throw new IllegalArgumentException("At least two people required");
            }

            if (days < 1) {
                throw new IllegalArgumentException("At least one day required");
            }

            if (trials < 1) {
                throw new IllegalArgumentException("At least one trial required");
            }

            double shareBday = 0;

            for (var i = 0; i < trials; i++) {
                if (randomTrialHasSharedBirthday(people, days)) {
                    shareBday++;
                }
            }
    
        return (double)shareBday / trials;
    }
        
static boolean randomTrialHasSharedBirthday(int people, int days) {

        Integer[] peopleArray = new Integer[people];

        for (var i = 0; i < people; i++) {
            peopleArray[i] = (int)(Math.random() * days);
        }

        return new HashSet<Integer>(Arrays.asList(peopleArray)).size() != peopleArray.length;
    }

}
