package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mainList;
    private ArrayList<Painter> painter1;
    private ArrayList<Painter> painters2;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        painter1 = new ArrayList<>();
        painters2 = new ArrayList<>();
        painter1.add(new Painter("Jan","Matejko",R.drawable.matejko));
        painter1.add(new Painter("Wincent","Van Gogh",R.drawable.gogh));
        painter1.add(new Painter("Zdzisław","Beksiński",R.drawable.szkielet));
        button = findViewById(R.id.button);
        mainList = findViewById(R.id.mainList);
        PainterAdapter adapter = new PainterAdapter(this,painter1);
        PainterAdapter adapter1 = new PainterAdapter(this,painters2);
        mainList.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Painter painter: painter1){
                    if (painter.isToDelete() ==false){
                        painters2.add(painter);
                    }
                }
                mainList.setAdapter(adapter1);
            }
        });
    }
}