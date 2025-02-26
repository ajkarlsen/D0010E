import java.io.*;
import java.util.Scanner;

public class GraphIO {
    public static void readFile(Graph g, String filename) throws IOException {
        try {
            Scanner scanner = new Scanner(new FileReader(filename));
            int nodes = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < nodes; i++) {
                String[] parts = scanner.nextLine().split(" ");
                int id = Integer.parseInt(parts[0]);
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);
                g.addNode(id, x, y);
            }

            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(" ");
                int id1 = Integer.parseInt(parts[0]);
                int id2 = Integer.parseInt(parts[1]);
                int weight = Integer.parseInt(parts[2]);
                g.addEdge(id1, id2, weight);

            }
            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Ingen fil :(");
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Fel Filformat typ :(");
        }
        catch (Exception e) {
            System.out.println("Något annat fel :(");
        }
    }
}