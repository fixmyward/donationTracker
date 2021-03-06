package edu.gatech.cs2340.donationtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GithubAuthProvider;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;

/**
 * The login activity creates a login screen, verifies the user
 *  from the database, and connects to the Main Activity as well as the welcome activity
 */
public class LoginActivity extends AppCompatActivity {

    private EditText usernameInput;
    private EditText passwordInput;
    private FirebaseAuth mAuth;

    /**
     *  Login method that connects to firebase
     * @param user the string inputted as the username from the screen
     * @param pass the string inputted as the password from the screen
     */
    private void logIn(String user, String pass) {
        mAuth.signInWithEmailAndPassword(user, pass)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        FirebaseUser user1 = mAuth.getCurrentUser();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(LoginActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }

                    // [START_EXCLUDE]
                    if (!task.isSuccessful()) {
                        startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
                    }
                });
    }

    private void github(String email, String password) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        String token = "e3f31100b304f71a585cc2c20fe4f692b1d4c01a";
        AuthCredential credential = GithubAuthProvider.getCredential(token);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, task ->  {
                    if (!task.isSuccessful()) {
                        Toast.makeText(LoginActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private void reset(String email) {
        mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(this, task ->  {

                    if (task.isSuccessful()) {
                        Toast.makeText(LoginActivity.this, "Email sent!",
                                Toast.LENGTH_SHORT).show();
                        }

                });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button submit = findViewById(R.id.button_login2);
        Button reset = findViewById(R.id.button_reset);
        usernameInput = findViewById(R.id.username_input);
        passwordInput = findViewById(R.id.password_input);
        Button cancel = findViewById(R.id.button_cancel);
        mAuth = FirebaseAuth.getInstance();
        Button github = findViewById(R.id.button_github);



        submit.setOnClickListener(v -> {
            String userName = usernameInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();
            if (userName.length() == 0 || password.length() == 0) {
                Toast.makeText(LoginActivity.this, "Fill in credential.",
                        Toast.LENGTH_SHORT).show();
            } else {
                logIn(userName, password);
            }
        });

        github.setOnClickListener(v -> {
            String userName = usernameInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();
            if (userName.length() == 0 || password.length() == 0) {
                Toast.makeText(LoginActivity.this, "Fill in credential.",
                        Toast.LENGTH_SHORT).show();
            } else {
                github(userName, password);
            }
        });

        reset.setOnClickListener(v -> {
            String userName = usernameInput.getText().toString().trim();
            if (userName.length() == 0) {
                Toast.makeText(LoginActivity.this, "Please provide email.",
                        Toast.LENGTH_SHORT).show();
            } else {
                FirebaseAuth auth = FirebaseAuth.getInstance();
                String emailAddress = userName;
                reset(emailAddress);
            }
        });

        cancel.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this,
                WelcomeActivity.class)));
    }
}
