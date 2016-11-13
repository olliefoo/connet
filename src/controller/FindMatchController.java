package controller;

import javafx.fxml.FXML;
import main.Database;
import main.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Owner on 11/12/2016.
 */
public class FindMatchController {

    User user;

    public void setUser(User user) {
        this.user = user;
    }

    @FXML
    private void findMatch() {
        // loop through all the users and check if they are in the same convention
        List<User> sameConvention = new ArrayList<>(10);
        for(User u : Database.getUsers()) {
            if(user.getConvention() == u.getConvention()) {
                sameConvention.add(u);
            }
        }
        // now have to check each user's preference to see if match
        Set userPreferences = user.getPreferences();
        Set temp = userPreferences;
        int max = 0;
        User matchedUser = null;
        for(User u : sameConvention) {
            temp.removeAll(u.getPreferences());
            if(temp.size() > max) {
                max = temp.size();
                matchedUser = u;
            }
            temp = userPreferences;
        }
    }

}
