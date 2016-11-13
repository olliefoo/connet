package main;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by cbbjs on 11/12/2016.
 */
public class User implements Serializable{
        private String username;
        private String password;
        private int convention;
        private Profile profile;
        private String email;
        private Set preferences;

        public User(String username, String password, String email) {
            this.username = username;
            this.password = password;
            profile = new Profile();
            this.convention = convention;
            this.email = email;
            profile.setEmail(email);
            preferences = new TreeSet<>();
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public Profile getProfile() { return profile; }

        public Set getPreferences() {
            return preferences;
        }

        public int getConvention() {
            return convention;
        }

        public String getEmail() {
            return email;
        }
}
