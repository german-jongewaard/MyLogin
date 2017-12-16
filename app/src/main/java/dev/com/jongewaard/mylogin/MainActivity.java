package dev.com.jongewaard.mylogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Switch switchRemember;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //aquí pego el metodo con el codigo recogido
        bindUI();

    }

    private boolean login(String email, String password){

        if(!isValidEmail(email)){
            //si el email falla, mensaje y falso.
            Toast.makeText(this, "Email is not valid, please try again", Toast.LENGTH_LONG).show();
            return false;
        }else if(!isValidPassword(password)){
            //si el password falla, mensaje y falso.
            Toast.makeText(this, "Password is not valid, 4 characters or more, please try again", Toast.LENGTH_LONG).show();
            return false;
        }else {
            //si ninguno fallo es verdadero!
            return true;
        }

    }



    /* Método para recojer el codigo*/
    private void bindUI() {
        /* Aquí los enlazo, recojo las referencias */
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        switchRemember = (Switch) findViewById(R.id.switchRemember);
        btnLogin = (Button) findViewById(R.id.buttonLogin);
    }

    private boolean isValidEmail(String email) {
        //aqui nos dice si cumple con las reglas basicas de un correo electronico.
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private  boolean isValidPassword(String password) {
        //que el password sea mayor de 4 caracteres!
        return password.length() > 4;
    }



}
