package Model;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Database implements Serializable {
    private static ArrayList<User> users;
    private static ArrayList<String> usernameList;
    private static ArrayList<String> emailList;

    public Database() {
        users = new ArrayList<>(5);
        usernameList = new ArrayList<>(10);
        emailList = new ArrayList<>(10);
    }

    /**
     * Adds the user to the corresponding list in the database depending on
     * the user type.
     *
     * @param u the user to add
     */
    public static void add(User u) {
        users.add(u);
    }

    /**
     * saves all of the users that have registered an account
     */
    public static void saveAll() {
        try {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("all.bin"))) {
                out.writeObject(users);
                out.writeObject(usernameList);
                out.writeObject(emailList);
            }
        } catch (IOException ex) {
            ex.getStackTrace();
        }
    }

    /**
     * loads all of the users that have registered an account
     */
    public static void loadAll() {
        try {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("all.bin"))) {
                ArrayList<User> uL = (ArrayList<User>) in.readObject();
                ArrayList<String> usL = (ArrayList<String>) in.readObject();
                ArrayList<String> eL = (ArrayList<String>) in.readObject();
                users = uL;
                usernameList = usL;
                emailList = eL;
            }
        } catch (IOException ex) {
            ex.getStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.getStackTrace();
        }
    }

    /**
     * Adds the username to the username list
     *
     * @param name the username to be added
     */
    public static void addUsername(String name) {
        usernameList.add(name);
    }

    /**
     * Adds the email to the email list
     *
     * @param email the email to be added
     */
    public static void addEmail(String email) {
        emailList.add(email);
    }

    /**
     * Checks whether the database contains the specified username
     *
     * @param name username of a user
     * @return whether or no the database contains the specified user
     */
    public static boolean containsUsername(String name) {
        return usernameList.contains(name);
    }

    /**
     * Checks whether the database contains the specified email
     *
     * @param email an email to check
     * @return whether the database contains the specified email
     */
    public static boolean containsEmail(String email) {
        return emailList.contains(email);
    }

    /**
     * Gets the user with the specified username
     *
     * @param name the username of a user
     * @return the user with the specified username. NULL if user is not in the database
     */
    public static User getUser(String name) {
        for (User u : users) {
            if (name.equals(u.getUsername())) {
                return u;
            }
        }
        return null;

    }
}