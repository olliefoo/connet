package main;


import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Owner on 11/12/2016.
 */
public class Database {
    private Database() throws IOException{
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setServiceAccount(new FileInputStream("..\\connet\\appathon-991ef-firebase-adminsdk-093ae-b1557a2ddf.json"))
                .setDatabaseUrl("https://appathon-991ef.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);
    }


}
