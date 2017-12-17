package dev.com.jongewaard.mylogin;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

/**
 * Created by german on 16-12-17.
 */

public class LoginActivity extends AppCompatActivity {

    /* Trabajar con las SharedPreferences*/
    private SharedPreferences prefs;

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Switch switchRemember;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //aquí pego el metodo con el codigo recogido
        bindUI();
        //así creo el SharedPreferences
        prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        //compruebo si se esta guardando o no el login!
        setCredentialsIfExist();


        //si pulso el boton login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                if(login(email, password)) {
                    //metodo goToMain
                    goToMain();
                    //metodo saveOnPreferences
                    saveOnPreferences(email,password);
                }
            }
        });
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

    private void setCredentialsIfExist(){

        String email = getUserMailPrefs(); //cojo el email y el password de la SharedPreferences
        String password = getUserPassPrefs();
        //si no estan vacios el email y el password
        if(!TextUtils.isEmpty(email) && (!TextUtils.isEmpty(password))) {

            editTextEmail.setText(email);
            editTextPassword.setText(password);



        }
    }

    private void saveOnPreferences(String email, String password){
        if(switchRemember.isChecked()){
            //Editor!
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("email", email);
            editor.putString("pass", password);
          //editor.commit();            aqui el codigo se para hasta que la info se guarde
            editor.apply();
        }
    }

    private boolean isValidEmail(String email) {
        //aqui nos dice si cumple con las reglas basicas de un correo electronico.
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private  boolean isValidPassword(String password) {
        //que el password sea mayor de 4 caracteres!
        return password.length() >= 4;
    }

    private void goToMain(){
                            //voy de LoginActivity hacia el MainActivity!!
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        /* Una vez que ingreso con el email y el password e ingreso a la app, estas Flags impiden
        que vuelva a la pantalla de Login a menos que cierre sesión */
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    //obtengo el email
    private String getUserMailPrefs(){

        return prefs.getString("email", "");

    }

    //obtengo el password
    private String getUserPassPrefs(){

        return prefs.getString("pass", "");

    }
}
