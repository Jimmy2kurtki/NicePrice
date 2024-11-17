package com.lessons.niceprice;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView btnClear, tvResult, btnCalculate;
    private ListView listView;
    private EditText etPrice, etWeight;
    private ArrayList<String> stringsForRv;
    private MyConst myConst = new MyConst();
    ArrayAdapter<String> adapter;

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
        stringsForRv = new ArrayList();
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
            @Override
            public void onClick(View view) {
                if (etPrice.getText().toString().isEmpty() || etWeight.getText().toString().isEmpty()) {

                } else {
                    Product product = new Product(Double.parseDouble(etPrice.getText().toString()),
                            Double.parseDouble(etWeight.getText().toString()));
                    double result = product.getResult();
                    tvResult.setText(String.format("%.2f", result) + myConst.UNIT_OF_MEASUREMENT);
                    etPrice.setText("");
                    etWeight.setText("");
                    String string = "p: " + String.format("%.2f", product.getPrice()) +
                            "   w: " + (int) product.getWeight() +
                            "   p/w: " + String.format("%.2f", result);
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

}