package com.lessons.niceprice;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView btnClear, tvResult, btnCalculate;
    private ListView listView;
    private EditText etPrice, etWeight;
    private ArrayList<String> stringsForRv;
    private final MyConst myConst = new MyConst();
    private ArrayAdapter<String> adapter;
    private Toast emptyToast;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();
        initClick();
        initListView();

    }

    private void initVariables(){
        btnClear = findViewById(R.id.btnClear);
        tvResult = findViewById(R.id.tvResult);
        btnCalculate = findViewById(R.id.btnCalculate);
        listView = findViewById(R.id.listView);
        etPrice = findViewById(R.id.etPrice);
        etWeight = findViewById(R.id.etWeight);
        stringsForRv = new ArrayList<>();
    }

    private void initClick(){
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringsForRv.clear();
                adapter.notifyDataSetChanged();
            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                String stringEtPrice = etPrice.getText().toString();
                String stringEtWeight = etWeight.getText().toString();

                if (stringEtPrice.isEmpty() || stringEtWeight.isEmpty()) {

                    emptyToast = Toast.makeText(getBaseContext(), "Заполни все поля", Toast.LENGTH_SHORT);
                    emptyToast.show();

                } else {

                    Product product = new Product(Double.parseDouble(stringEtPrice),
                                                  Double.parseDouble(stringEtWeight));

                    @SuppressLint("DefaultLocale") String stringResult = String.format("%.2f", product.getResult());
                    @SuppressLint("DefaultLocale") String stringPrice = String.format("%.2f", product.getPrice());

                    tvResult.setText(stringResult + myConst.UNIT_OF_MEASUREMENT);
                    etPrice.setText("");
                    etWeight.setText("");

                    String string = "p: " + stringPrice +
                                    "   w: " + (int) product.getWeight() +
                                    "   p/w: " + stringResult;

                    stringsForRv.add(string);
                    adapter.notifyDataSetChanged();

                }
            }
        });
    }

    private void initListView(){

        adapter = new ArrayAdapter<>(this, R.layout.design_list, R.id.tvProduct, stringsForRv);
        listView.setAdapter(adapter);

    }

    public void onBackPressed() {

        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Нажмите еще раз, что бы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }

        backPressedTime = System.currentTimeMillis();

    }
}