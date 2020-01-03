package nikhil.guptan404.com.menusanddialogues;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login {

    EditText u,p;
    Button l,s;

    public void showDialog(final Activity activity) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.login_dial);

        u=dialog.findViewById(R.id.u);
        p=dialog.findViewById(R.id.p);
        l=dialog.findViewById(R.id.l);
        s=dialog.findViewById(R.id.s);


        final String pass = p.getText().toString();

        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String user = u.getText().toString();
                Toast.makeText(activity,user+" ",Toast.LENGTH_LONG).show();
            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass = p.getText().toString();
                Toast.makeText(activity,pass+" ",Toast.LENGTH_LONG).show();
            }
        });

        dialog.show();

        Window window = dialog.getWindow();
        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);


    }
}
