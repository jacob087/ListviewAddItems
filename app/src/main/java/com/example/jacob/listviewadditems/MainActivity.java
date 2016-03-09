package com.example.jacob.listviewadditems;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    ListView listV;
    Button btAdd;
    ArrayList<String> itemList;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText)findViewById(R.id.txtInput);
        btAdd=(Button)findViewById(R.id.btAdd);
        listV=(ListView)findViewById(R.id.list);

        final String[] items={"Apple","Banna","Dog"};
        itemList=new ArrayList<String>(Arrays.asList(items));
        adapter=new ArrayAdapter<String>(MainActivity.this,R.layout.list_item,R.id.txtview,itemList);
        listV.setAdapter(adapter);


        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = editText.getText().toString();
                itemList.add(newItem);
                adapter.notifyDataSetChanged();
            }
        });
      listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              String clickItem=items[position];
              Toast.makeText(getApplicationContext(),clickItem,Toast.LENGTH_LONG).show();
          }
      });
    }

}
