package acer.ruwan.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {
    AdView adViewBanner;
    TextView editText;
    Button btnAdd, btnSub, btnMul, btnDiv , clearBtn , deleteBtn;
    Double x = 0.0;
    Double y = 1.0;
    Button getBtnValue;
    int clicked_btn = 0;
    int flag = 0;

    Button btnZero, btnOne , btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine , btnDote;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Addvetisement
        adViewBanner = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adViewBanner.loadAd(adRequest);
        adViewBanner.setAdListener(new AdListener(){


            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                Toast.makeText(MainActivity.this, "add failed load", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdClicked() {
                super.onAdClicked();
                Toast.makeText(MainActivity.this, "user clicked the add", Toast.LENGTH_SHORT).show();
            }
        });




        editText = (TextView) findViewById(R.id.editTxt);
        btnAdd = (Button) findViewById(R.id.add);
        btnSub = (Button) findViewById(R.id.sub);
        btnMul = (Button) findViewById(R.id.mul);
        btnDiv = (Button) findViewById(R.id.div);
        getBtnValue = (Button) findViewById(R.id.btnDone);
        clearBtn = (Button) findViewById(R.id.idclear);
        deleteBtn = (Button) findViewById(R.id.iddelete);

        //Equal button function

        getBtnValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clicked_btn == 1)
                {
                    if (!TextUtils.isEmpty(editText.getText().toString()))
                    {

                        Double value = Double.parseDouble(editText.getText().toString());
                        x += value;
                        editText.setText(String.valueOf(x));
                        x= 0.0;

                    }
                    else
                    {
                        editText.setText(String.valueOf(x));
                        x = 0.0;
                    }

                }
                else if (clicked_btn == 2)
                {
                    if (!TextUtils.isEmpty(editText.getText().toString()))
                    {

                        Double value = Double.parseDouble(editText.getText().toString());
                        x -= value;
                        editText.setText(String.valueOf(x));
                        x= 0.0;

                    }
                    else
                    {
                        editText.setText(String.valueOf(x));
                        x = 0.0;
                    }
                }
                else if (clicked_btn == 3)
                {
                    if (!TextUtils.isEmpty(editText.getText().toString()))
                    {
                        Double value = Double.parseDouble(editText.getText().toString());
                        y *= value;
                        editText.setText(String.valueOf(y));
                        y = 1.0;
                    }
                    else
                    {
                        editText.setText(String.valueOf(y));
                        y = 1.0;
                    }

                }
                else if (clicked_btn == 4)
                {
                    if (!TextUtils.isEmpty(editText.getText().toString()))
                    {
                        Double value = Double.parseDouble(editText.getText().toString());
                        y /= value;
                        editText.setText(String.valueOf(y));
                        y = 1.0;
                        flag = 0;

                    }
                    else
                    {
                        editText.setText(String.valueOf(y));
                        y = 1.0;
                        flag = 0;
                    }
                }



            }
        });

        // Addition , Subtraction , Multiplication , Division functions



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(editText.getText().toString()))
                {
                    cal("+", editText.getText().toString());
                }
                else
                {
                    Toast toast = Toast.makeText(MainActivity.this, "No empty number allowed",  Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM| Gravity.CENTER_HORIZONTAL,0,0);
                    toast.show();                }

            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(editText.getText().toString()))
                {
                    cal("-", editText.getText().toString());
                }
                else
                {

                    Toast toast = Toast.makeText(MainActivity.this, "No empty number allowed",  Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM| Gravity.CENTER_HORIZONTAL,0,0);
                    toast.show();
                }

            }
        });


        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(editText.getText().toString()))
                {
                    cal("*", editText.getText().toString() );
                }
                else
                {
                    Toast toast = Toast.makeText(MainActivity.this, "No empty number allowed",  Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM| Gravity.CENTER_HORIZONTAL,0,0);
                    toast.show();
                }
            }
        });

        btnDiv.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(editText.getText().toString()))
                {
                    cal("/", editText.getText().toString());
                }
                else
                {
                    Toast toast = Toast.makeText(MainActivity.this, "No empty number allowed",  Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM| Gravity.CENTER_HORIZONTAL,0,0);
                    toast.show();
                }
            }
        });


        // Clear button

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
                x = 0.0;
                y = 1.0;
                clicked_btn = 0;
            }
        });

        // Delete button

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(editText.getText().toString()))
                {
                    String txt = editText.getText().toString();
                    editText.setText(txt.substring(0 , txt.length() - 1));
                }
                else
                {
                    editText.setText("");
                }


            }
        });





        // Numbers functions

        btnDote = (Button) findViewById(R.id.dote);
        btnZero = (Button) findViewById(R.id.zero);
        btnOne = (Button) findViewById(R.id.one);
        btnTwo = (Button) findViewById(R.id.two);
        btnThree = (Button) findViewById(R.id.three);
        btnFour = (Button) findViewById(R.id.four);
        btnFive = (Button) findViewById(R.id.five);
        btnSix = (Button) findViewById(R.id.six);
        btnSeven = (Button) findViewById(R.id.seven);
        btnEight = (Button) findViewById(R.id.eight);
        btnNine = (Button) findViewById(R.id.nine);

        btnDote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + ".");
            }
        });

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "0");
            }
        });

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "1");
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "2");
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "3");
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "4");
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "5");
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "6");
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "7");
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "8");
            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "9");
            }
        });




    }

    // Addvetisement

    @Override
    protected void onPause() {
        if (adViewBanner != null)
        {
            adViewBanner.pause();
        }
        super.onPause();

    }

    @Override
    protected void onResume() {
        if (adViewBanner != null)
        {
            adViewBanner.resume();
        }
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        if (adViewBanner != null)
        {
            adViewBanner.destroy();
        }
        super.onDestroy();
    }

    // cal function

    void cal(String type, String number)
    {
         if (type.equals("+"))
         {
             clicked_btn = 1;
             Double addnumberDouble = Double.parseDouble(number);
             x = x + addnumberDouble;

             Toast toast = Toast.makeText(MainActivity.this, String.valueOf(x),  Toast.LENGTH_SHORT);
             toast.setGravity(Gravity.BOTTOM| Gravity.CENTER_HORIZONTAL,0,0);
             toast.show();

             editText.setText("");
             flag = 0;


         }
         else if (type.equals("-"))
         {
             clicked_btn = 2;
             Double subNumberDouble = Double.parseDouble(number);
             x =subNumberDouble - x;

             Toast toast = Toast.makeText(MainActivity.this, String.valueOf(x),  Toast.LENGTH_SHORT);
             toast.setGravity(Gravity.BOTTOM| Gravity.CENTER_HORIZONTAL,0,0);
             toast.show();

             editText.setText("");
             flag = 0;
         }
         else if (type.equals("*"))
         {
             clicked_btn = 3;
             Double mulnumberDouble  = Double.parseDouble(number);
             y *= mulnumberDouble;

             Toast toast = Toast.makeText(MainActivity.this, String.valueOf(y),  Toast.LENGTH_SHORT);
             toast.setGravity(Gravity.BOTTOM| Gravity.CENTER_HORIZONTAL,0,0);
             toast.show();

             editText.setText("");
             flag = 0;
         }
         else if (type.equals("/"))
         {
             clicked_btn = 4;
             Double divnumberDouble = Double.parseDouble(number);
             if (clicked_btn == 4 && flag == 0 )
             {
                 y = divnumberDouble / y ;


             }
             else if ( flag == 1)
             {

                     y = y / divnumberDouble;

             }
             flag = 1;

             Toast toast = Toast.makeText(MainActivity.this, String.valueOf(y),  Toast.LENGTH_SHORT);
             toast.setGravity(Gravity.BOTTOM| Gravity.CENTER_HORIZONTAL,0,0);
             toast.show();

             editText.setText("");


         }
    }
}
