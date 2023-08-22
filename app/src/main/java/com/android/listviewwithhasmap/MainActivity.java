package com.android.listviewwithhasmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    private ListView listView;
    private SearchView searchView;
    ArrayAdapter<String> adapter1;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    HashMap<String, String> hashMap;


    int[] flags = {R.drawable.afghanistan, R.drawable.albania, R.drawable.algeria, R.drawable.andorra,
            R.drawable.angola, R.drawable.antigua_and_barbuda, R.drawable.argentina, R.drawable.armenia, R.drawable.austria,
            R.drawable.azerbaijan, R.drawable.bangladesh};
    private String[] countryDescrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        searchView = findViewById(R.id.searchViewId);

        hashMap = new HashMap<>();
        hashMap.put("name", "Afganistan");
        hashMap.put("desc", "This is First country of Taleban");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "albania");
        hashMap.put("desc", "This is First country of Taleban");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "algeria");
        hashMap.put("desc", "Algeria is the Most beautifull country");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "andorra");
        hashMap.put("desc", "This is First country of Taleban");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "angola");
        hashMap.put("desc", "This is First country of Taleban");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "antigua_and_barbuda");
        hashMap.put("desc", "This is First country of Taleban");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "argentina");
        hashMap.put("desc", "This is First country of Taleban");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "armenia");
        hashMap.put("desc", "This is First country of Taleban");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "austria");
        hashMap.put("desc", "This is First country of Taleban");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "azerbaijan");
        hashMap.put("desc", "This is First country of Taleban");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "bangladesh");
        hashMap.put("desc", "This is First country of Taleban");
        arrayList.add(hashMap);


        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);
        adapter1 = new ArrayAdapter<String>(MainActivity.this, R.layout.sample_layout, R.id.tvName);
        listView.setAdapter(adapter1);
        listView.setOnItemClickListener((AdapterView.OnItemClickListener) this);
    }


    //String [] countryNames = getResources().getStringArray(R.array.country_names);
    //String [] countryDescrip = getResources().getStringArray(R.array.country_descrip);


    // For Search View


    ///-------------------------------------------------

    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {

            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView = layoutInflater.inflate(R.layout.sample_layout, viewGroup, false);

            ImageView imageView = myView.findViewById(R.id.imageViewId);
            TextView tvName = myView.findViewById(R.id.tvName);
            TextView tvDesc = myView.findViewById(R.id.tvDesc);


            HashMap<String, String> hashMap = arrayList.get(position);
            imageView.setImageResource(flags[position]);

            String name = hashMap.get("name");
            String desc = hashMap.get("desc");


            tvName.setText(name);
            tvDesc.setText(hashMap.get("desc"));


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    String value = adapter1.getItem(position);
                    Toast.makeText(MainActivity.this, "Hello\n" + name, Toast.LENGTH_SHORT).show();
                }
            });

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    adapter1.getFilter().filter(newText);
                    return false;
                }

            });
            return myView;


        }


        //listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        //@Override
        //  public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
        //     String value =myAdapter.getItem(position);

        //String value1 =countryDescrip[position];
        //    Toast.makeText(MainActivity.this,value,Toast.LENGTH_SHORT).show();


        ///  });


    }
}