import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class ComparationBal {

    static ComparationBal cb = new ComparationBal();
    private ComparationBal() {

    }

    public static void main(String[] args) throws IOException {
        InputStream inputStream = cb.getClass()
                .getClassLoader().getResourceAsStream("left_groups");
        System.out.println(inputStream.available());

        int count = 0;
        HashSet<Integer> left_profiles_set = new HashSet<>();
        try (Scanner redScanner = new Scanner(Objects.requireNonNull(cb.getClass().getClassLoader().getResourceAsStream("left_profiles")));
             Scanner polyScanner = new Scanner(Objects.requireNonNull(cb.getClass().getClassLoader().getResourceAsStream("bal_profiles.txt")))) {
            while (redScanner.hasNext())
                left_profiles_set.add(redScanner.nextInt());

            while (polyScanner.hasNext()) {
                int current = polyScanner.nextInt();
                if (left_profiles_set.contains(current)) {
                    System.out.println(current);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
