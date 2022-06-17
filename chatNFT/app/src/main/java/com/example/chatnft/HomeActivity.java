package com.example.chatnft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class HomeActivity extends AppCompatActivity {

    GridView gridview;

    String[] names = {"Ninchat","Chat Magique","Astrochat","Charlock","Chat de bureau","Miaourin","Chapeauchat","Mr. Chat","Robochat","Chatutu"};
    int[] images = {R.drawable.image1, R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image6,R.drawable.image7,R.drawable.image8,R.drawable.image9,R.drawable.image10};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        gridview = findViewById(R.id.gridview);

        CustomAdapter customAdapter = new CustomAdapter(names, images, this);

        gridview.setAdapter(customAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                String selectedName = names[i];
                int selectedImage = images[i];


                    startActivity(new Intent(HomeActivity.this, ClickEditItemActivity.class).putExtra("name", selectedName).putExtra("image", selectedImage));
                }

        });
    }

        public class CustomAdapter extends BaseAdapter{
            private String[] imageNames;
            private int[] imagesPhoto;
            private Context context;
            private LayoutInflater layoutInflater;

            public CustomAdapter(String[] imageNames, int[] imagesPhoto, Context context) {
                this.imageNames = imageNames;
                this.imagesPhoto = imagesPhoto;
                this.context = context;
                this.layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
            }

            @Override
            public int getCount() {
                return imagesPhoto.length;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {

                if(view == null){
                    view = layoutInflater.inflate(R.layout.row_items, viewGroup, false);
                }

                TextView tvName = view.findViewById(R.id.tvName);
                ImageView imageView = view.findViewById(R.id.imageView);

                tvName.setText(imageNames[i]);
                imageView.setImageResource(imagesPhoto[i]);




                return view;
            }

        }
    }


