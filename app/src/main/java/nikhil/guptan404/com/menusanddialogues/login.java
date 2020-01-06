package nikhil.guptan404.com.menusanddialogues;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login {

    EditText u,p;
    Button l,s;
    private FirebaseAuth mAuth;
    FirebaseUser currentUser;

    public void showDialog(final Activity activity) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.login_dial);

        u=dialog.findViewById(R.id.u);
        p=dialog.findViewById(R.id.p);
        l=dialog.findViewById(R.id.l);
        s=dialog.findViewById(R.id.s);

        mAuth=FirebaseAuth.getInstance();
        currentUser=mAuth.getCurrentUser();


        final String pass = p.getText().toString();

        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = u.getText().toString();
                String pass = p.getText().toString();
                mAuth.signInWithEmailAndPassword(user,pass).addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(activity,"Log In succesfull!",Toast.LENGTH_LONG).show();
                            currentUser = mAuth.getCurrentUser();
                            currentUser.sendEmailVerification();
                        }
                        else {
                            Toast.makeText(activity,task.getException().toString()+" ",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = u.getText().toString();
                String pass = p.getText().toString();
                mAuth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(activity,"Sign Up succesfull!",Toast.LENGTH_LONG).show();
                            currentUser = mAuth.getCurrentUser();
                            currentUser.sendEmailVerification();
                        }
                        else {
                            Toast.makeText(activity,task.getException().toString()+" ",Toast.LENGTH_LONG).show();
                        }

                    }
                });
            }
        });

        dialog.show();

        Window window = dialog.getWindow();
        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);


    }
}
