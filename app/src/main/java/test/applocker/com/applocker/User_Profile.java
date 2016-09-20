package test.applocker.com.applocker;

/**
 * Created by samreen on 9/18/2016.
 */



        import android.app.Activity;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.text.Editable;
        import android.text.TextWatcher;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class User_Profile extends Activity {


    private EditText etEmailAddrss;
    private EditText etPhoneNumber;
    private Button btnSubmit;
//SharedPreferences pref;
//    public static final String mypreference = "mypref";
//    public static final String Number = "numberKey";
    //   public static final String Email = "emailKey";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        registerViews();

        ///////////////////////////////////////////////////////
     /*   pref = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        if (pref.contains(Number)) {
            etPhoneNumber.setText(spref.getString(Number, ""));
        }
        if (pref.contains(Email)) {
            etEmailAddrss.setText(spref.getString(Email, ""));

        }*/
        ////////////////////////////////////////////////////////////
    }
    private void registerViews() {

        etEmailAddrss = (EditText) findViewById(R.id.editText2);
        etEmailAddrss.addTextChangedListener(new TextWatcher() {
            // after every change has been made to this editText, we would like to check validity
            public void afterTextChanged(Editable s) {
                Validate_Profile.isEmailAddress(etEmailAddrss, true);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

        etPhoneNumber = (EditText) findViewById(R.id.editText);
        etPhoneNumber.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                Validate_Profile.isPhoneNumber(etPhoneNumber, false);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

        btnSubmit = (Button) findViewById(R.id.button);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Validation class will check the error and display the error on respective fields
                but it won't resist the form submission, so we need to check again before submit
                 */

                if ( checkValidation () )
                {
                    ////////////////////////////////////////////////////////
                  /*  String n = etPhoneNumber.getText().toString();
                    String e = etEmailAddrss.getText().toString();
                    SharedPreferences.Editor editor = spref.edit();
                    editor.putString(Number, n);
                    editor.putString(Email, e);
                    editor.commit();*/
                    //////////////////////////////////////
                    submitForm();
                }
                else
                    Toast.makeText(User_Profile.this, "Please fill the fields properly!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void submitForm() {
        // Submit your form here. your form is valid
        Toast.makeText(this, "Profile Created!", Toast.LENGTH_LONG).show();
    }

    private boolean checkValidation() {
        boolean ret = true;

        if (!Validate_Profile.isEmailAddress(etEmailAddrss, true)) ret = false;
        if (!Validate_Profile.isPhoneNumber(etPhoneNumber, true)) ret = false;

        return ret;
    }
}
