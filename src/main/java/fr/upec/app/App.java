package fr.upec.app;

/**
 * @author Abdoul Mouctar DIALLO
 */
public class App {
    public static void main(String[] args) {
        HashLinearProbing hasher = new HashLinearProbing();

        hasher.put("A", "A");
        hasher.put("A", "B");
        hasher.remove("A");

        System.out.println(hasher);

    }
}
