package net.com.gopal.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

   EditText Username, Password;
   Button loginbtn;
    private TextView signup;
    DatabaseHelp databaseHelp;
    TextView forgetpass;
//    ProgressBar progressBar;
    FirebaseAuth mAuth;
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if(currentUser != null){
//            Intent intent = new Intent(MainActivity.this, home.class);
//            startActivity(intent);
//            finish();
//        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = findViewById(R.id.Username);
       Password = findViewById(R.id.password);
         loginbtn = findViewById(R.id.loginbtn);
        signup = findViewById(R.id.signup);
        forgetpass = findViewById(R.id.forgetpass);
//        progressBar = findViewById(R.id.progressBar);
        databaseHelp = new DatabaseHelp(this);
        mAuth = FirebaseAuth.getInstance();



        loginbtn.setOnClickListener(view -> {
            String Email = Username.getText().toString().trim();
            String password = Password.getText().toString().trim();

            if (TextUtils.isEmpty(Email) || TextUtils.isEmpty(password)) {
                Toast.makeText(MainActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.signInWithEmailAndPassword(Email, password)
                    .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            progressBar.setVisibility(View.GONE);
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(MainActivity.this, home.class);
                                        startActivity(intent);
                                        finish();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(MainActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
//                else
//                {
//                    Boolean checkUserPass = databaseHelp.checkUserPassword(userName,password);
//                    if (checkUserPass == true){
//                        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(this,home.class);
//                        startActivity(intent);
////                    }
//                    else{
//
//                        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
//                    }
//                }
        });

        signup.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, signup.class);
            startActivity(intent);


        });

        forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ForgetPassword.class);
                startActivity(intent);
            }
        });


    }



}