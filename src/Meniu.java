import java.util.*;

public class Meniu {
    private List<String> optiuni;

    public Meniu(List<String> optiuni) {
        this.optiuni = optiuni;
    }

    public String show() {
        System.out.println();
        for (int i = 0; i < this.optiuni.size(); ++i) {
            System.out.println((i + 1) + ") " + this.optiuni.get(i));
        }
        int index = -1;
        Scanner scanner = new Scanner(System.in);

        while (index == -1) {
            try {
                System.out.print("Introdu alegere: ");
                index = scanner.nextInt();
                if (index < 1 || index > this.optiuni.size()) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Index invalid");
                scanner.nextLine();
                index = -1;
            }

        }
        return this.optiuni.get(index - 1).toLowerCase().replace(' ', '_');
    }
}
