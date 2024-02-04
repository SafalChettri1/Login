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

public class signup extends AppCompatActivity {
 TextView backbutton;
 EditText name, phone, email,password,repassword,username;
 Button register;
 DatabaseHelp databaseHelp;
 FirebaseAuth mAuth;
 ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        backbutton = findViewById(R.id.backbutton);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        register = findViewById(R.id.registerbtn);
        username = findViewById(R.id.username);
//        progressBar = findViewById(R.id.progressBar);
        databaseHelp = new DatabaseHelp(this);
        mAuth= FirebaseAuth.getInstance();



        register.setOnClickListener(view -> {
//              String  Name = name.getText().toString();
          String user = username.getText().toString();
          String Email = email.getText().toString();
          String Phone = phone.getText().toString();
          String  Password = password.getText().toString();
          String Repassword = repassword.getText().toString();
//          progressBar.setVisibility(view.VISIBLE);

          if (TextUtils.isEmpty(user) || TextUtils.isEmpty(Email) ||
                  TextUtils.isEmpty(Phone) || TextUtils.isEmpty(Password)
                  || TextUtils.isEmpty(Repassword)){
                Toast.makeText(signup.this, "All field are required", Toast.LENGTH_SHORT).show();
            }
            mAuth.createUserWithEmailAndPassword(Email, Password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
//                                progressBar.setVisibility(view.GONE);
                                // Sign in success, update UI with the signed-in user's information
//                                Log.d(TAG, "createUserWithEmail:success");
//                                FirebaseUser user = mAuth.getCurrentUser();
//                                updateUI(user);
                                Toast.makeText(signup.this, "Account Created", Toast.LENGTH_SHORT).show();
                            } else {
                                // If sign in fails, display a message to the user.
//                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(signup.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
//            else{
//              if (Password.equals(Repassword)){
//
//                    Boolean checkUser = databaseHelp.checkUsername(user);
//                    if (!checkUser){
////                            Boolean insert = databaseHelp.insertData(Name,user,Email,Phone,Password);
//                        Boolean insert = databaseHelp.insertData(user,Email, Phone,Password);
//
//                        if (insert){
//                          Toast.makeText(signup.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(signup.this,MainActivity.class);
//                          startActivity(intent);
//                      }
//                      else{
//                          Toast.makeText(signup.this, "Registration Failed", Toast.LENGTH_SHORT).show();
//
//                      }
//                    }else{
//                        Toast.makeText(signup.this, "Username already exist", Toast.LENGTH_SHORT).show();
//                    }
//
//                }
//
//              else{
//                  Toast.makeText(signup.this, "Password not matching", Toast.LENGTH_SHORT).show();
//              }
//            }

        });



        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(signup.this,MainActivity.class);

                startActivity(intent);
            }
        });
         //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}


//                if(name.getText().toString().isEmpty() ||
//                        phone.getText().toString().isEmpty() || email.getText().toString().isEmpty()||
//                password.getText().toString().isEmpty() || repassword.getText().toString().isEmpty()){
//                    Toast.makeText(signup.this, "All field should be filled", Toast.LENGTH_SHORT).show();
//                }
//                else if (name.getText().toString().length()<3){
//                    Toast.makeText(signup.this, "First name  should be longer than 3 letter", Toast.LENGTH_SHORT).show();
//                }
//                else if(username.getText().toString().length()<5&&username.getText().toString().length()>15){
//                    Toast.makeText(signup.this, "Username should be greater than 5 character and less than 15 character", Toast.LENGTH_SHORT).show();
//                }
////                else if (username)
//                else if (!email.getText().toString().matches("[A-Za-z0-9]+@gmail.com")) {
//                    Toast.makeText(signup.this, "Email is not valid", Toast.LENGTH_SHORT).show();
//                }
//
//                else if (!phone.getText().toString().matches("\\d{10}")) {
//                    Toast.makeText(signup.this, "Phone number is not valid", Toast.LENGTH_SHORT).show();
//                }
//
//                else if (!password.getText().toString().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,20}$")) {
//                    Toast.makeText(signup.this, "Password must contain uppercase, lowercase, a digit, and a special character", Toast.LENGTH_SHORT).show();
//                }
//
//                else if (!password.getText().toString().equals(repassword.getText().toString())){
//                    Toast.makeText(signup.this, "Password and Re-Password must be same", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Toast.makeText(signup.this, "Registration Successful ", Toast.LENGTH_SHORT).show();
//                    Intent intent  = new Intent(signup.this, MainActivity.class);
//                    startActivity(intent);
//
//                }