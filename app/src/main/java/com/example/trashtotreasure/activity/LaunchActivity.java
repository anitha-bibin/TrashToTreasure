package com.example.trashtotreasure.activity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.trashtotreasure.R;

public class LaunchActivity extends AppCompatActivity {

    private TextView mDialog;
    GridView grid;
    String ItemNamesList[] = {
            "Einsteen Saucer",
            "Booster Seat", "Double Stroller",
            "Euro Tub", "Large Trike",
            "Sit to stand",
            "Baby Crib",
            "Baby swing", "Play Yard",
            "Baby Monitor", "Baby Tub",
            "Indoor Play Set",
            "High Chair"
    };
    int ItemImages[] = {
            R.drawable.baby_einstein_saucer,
            R.drawable.booster_seat_rental,
            R.drawable.double_stroller,
            R.drawable.primo_eurotub_rental,
            R.drawable.large_trike,
            R.drawable.sit_to_stand,
            R.drawable.baby_crib,
            R.drawable.baby_swing,
            R.drawable.play_yard,
            R.drawable.baby_monitor,
            R.drawable.baby_tub,
            R.drawable.indoor_play,
    };

    protected void onCreate(@Nullable Bundle x) {
        super.onCreate(x);
        setContentView(R.layout.activity_launch);

        // GRID VIEW
        CustomGrid adapter = new CustomGrid(LaunchActivity.this, ItemNamesList, ItemImages);
        grid =  findViewById(R.id.gridlist);
        grid.setAdapter(adapter);


    }

    public void donateLinkClick(View view) {
        Intent intent = new Intent(this, DonateItActivity.class);
        startActivity(intent);

    }

    public void signInLinkClick(View view) {

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


    public void onItemClick(View view) {
        /*Toast.makeText(LaunchActivity.this, "Toast displayed. You selected " , Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, PreviewItemActivity.class);
        startActivity(intent);*/

        Intent i = new Intent(this, PreviewItemActivity.class);
        mDialog = findViewById(R.id.grid_text);
        int imgid = mDialog.getId();
        String getrec=mDialog.getText().toString();

//Create the bundle
        Bundle bundle = new Bundle();
//Add your data to bundle
        bundle.putString("imageid", getrec);

//Add the bundle to the intent
        Toast.makeText(LaunchActivity.this, "Toast displayed. You selected " + bundle +getrec, Toast.LENGTH_SHORT).show();
       i.putExtras(bundle);
       // i.putExtra("ImageDetails", getImage);
//go to the next activity
        startActivity(i);
    }
}