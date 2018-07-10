package in.karan.suman.foodka;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.rey.material.widget.CheckBox;

import in.karan.suman.foodka.Common.Common;
import in.karan.suman.foodka.Model.User;
import io.paperdb.Paper;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SignIn extends AppCompatActivity {

    MaterialEditText edtPhone,edtPassword;
    Button btnSignIn;
    CheckBox ckbRemember;
    TextView txtForgotPassword;
    FirebaseDatabase database;
    DatabaseReference table_user;@Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/cf.otf")
                .setFontAttrId(R.attr.fontPath)
                .build());
        setContentView(R.layout.activity_sign_in);

        edtPassword=findViewById(R.id.edtPassword);
        edtPhone=findViewById(R.id.edtPhone);
        btnSignIn=findViewById(R.id.btnSignIn);
        ckbRemember=findViewById(R.id.ckbRemember);
        txtForgotPassword=(TextView) findViewById(R.id.txtForgotPassword);

        Paper.init(this);

        database = FirebaseDatabase.getInstance();
        table_user=database.getReference("User");


        txtForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showForgotPwdDialog();
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {





            @Override
            public void onClick(View v) {

                if (Common.isConnetionToInternet(getBaseContext())) {


                    if(ckbRemember.isChecked())
                    {
                        Paper.book().write(Common.USER_KEY,edtPhone.getText().toString());
                        Paper.book().write(Common.PWD_KEY,edtPassword.getText().toString());
                    }




                    final ProgressDialog mDialog = new ProgressDialog(SignIn.this);
                    mDialog.setMessage("Please wait...");
                    mDialog.show();


                    table_user.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            //Check if user exist
                            if (dataSnapshot.child(edtPhone.getText().toString()).exists()) {

                                //Get User Info
                                mDialog.dismiss();

                                User user = dataSnapshot.child(edtPhone.getText().toString()).getValue(User.class);
                                user.setPhone(edtPhone.getText().toString());

                                if (user.getPassword().equals(edtPassword.getText().toString())) {

                                    Intent intent = new Intent(SignIn.this, Home.class);
                                    Common.currentUser = user;
                                    startActivity(intent);
                                    finish();
                                } else {

                                    Toast.makeText(SignIn.this, "Worng Password !!!", Toast.LENGTH_SHORT);
                                }

                            } else {
                                mDialog.dismiss();
                                Toast.makeText(SignIn.this, "User doesn't exist ", Toast.LENGTH_SHORT);
                            }

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else{
                    Toast.makeText(SignIn.this,"Please check your internet connection",Toast.LENGTH_SHORT).show();
                    return;
                }
            }

        });


        String user=Paper.book().read(Common.USER_KEY);
        String pwd=Paper.book().read(Common.PWD_KEY);

        if(user!=null && pwd!=null)
        {
            if(!user.isEmpty() && !pwd.isEmpty())
            {
                edtPhone.setText(user);
                edtPassword.setText(pwd);
            }

        }





    }

    private void showForgotPwdDialog()
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Forgot Password");
        builder.setMessage("Enter your secure code");


        LayoutInflater inflater=this.getLayoutInflater();
        View forgot_view=inflater.inflate(R.layout.forgot_password_layout,null);


        builder.setView(forgot_view);
        builder.setIcon(R.drawable.ic_security_black_24dp);

        final MaterialEditText edtPhone=forgot_view.findViewById(R.id.edtPhone);
        final MaterialEditText edtSecureCode=forgot_view.findViewById(R.id.edtSecureCode);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        User user=dataSnapshot.child(edtPhone.getText().toString()).getValue(User.class);

                        if(user.getSecureCode().equals(edtSecureCode.getText().toString()))
                        {
                            Toast.makeText(SignIn.this,"Your password : "+user.getPassword(),Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(SignIn.this,"Wrong secure code",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        builder.show();





    }
}
