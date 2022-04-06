import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Akinator {

    public static /* varargs */ void main(String... args) {
        boolean y = true;
        boolean n = false;

        // JUEGO BASE PARTIES

        HashMap c1 = new HashMap();
        c1.put((Object) "name", (Object) "Personaje 1");
        c1.put((Object) "tag1", (Object) n);
        c1.put((Object) "tag2", (Object) y);
        c1.put((Object) "tag3", (Object) y);

        HashMap c2 = new HashMap();
        c2.put((Object) "name", (Object) "Personaje 2");
        c2.put((Object) "tag1", (Object) n);
        c2.put((Object) "tag2", (Object) n);
        c2.put((Object) "tag3", (Object) y);

        HashMap c3 = new HashMap();
        c3.put((Object) "name", (Object) "Personaje 3");
        c3.put((Object) "tag1", (Object) n);
        c3.put((Object) "tag2", (Object) n);
        c3.put((Object) "tag3", (Object) n);



        ArrayList database = new ArrayList();
        database.add((Object) c1);
        database.add((Object) c2);
        database.add((Object) c3);

        Scanner sc = new Scanner(System.in);

        ArrayList a1 = new ArrayList<>(Arrays.asList("Tu personaje es?", "tag1"));
        ArrayList a2 = new ArrayList<>(Arrays.asList("Tu personaje es?", "tag2"));
        ArrayList a3 = new ArrayList<>(Arrays.asList("Tu personaje es?", "tag3"));

        ArrayList<ArrayList<String>> arrays = new ArrayList(Arrays.asList(a1, a2, a3));

        for (int i = 0; i < arrays.size(); i++) {

            int numero = numerorandom(arrays.size());
            String pregunta = arrays.get(numero).get(0);
            String valor = arrays.get(numero).get(1);

            System.out.println(pregunta);
            Akinator.take_input(sc.nextInt(), valor, database);

            arrays.remove(numero);
        }
    }

    public static int numerorandom(int tamaño) {
        int numeror = (int) ((Math.random() * tamaño));
        return numeror;
    }

    public static void take_input(int answer, String property, ArrayList database) {
        boolean ans = answer == 1;
        ArrayList to_remove = new ArrayList();
        for (Object d : database) {
            HashMap character = (HashMap) d;
            boolean prop = (Boolean) character.get((Object) property);
            if (prop == ans) continue;
            to_remove.add((Object) character);
        }
        for (Object ch : to_remove) {
            database.remove(ch);
        }
        if (database.size() == 1) {
            HashMap character = (HashMap) database.get(0);
            String name = (String) character.get((Object) "name");
            System.out.println("tu personaje es " + name);
            System.exit(0);
        }
    }
}

