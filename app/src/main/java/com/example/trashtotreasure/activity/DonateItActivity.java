package com.example.trashtotreasure.activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.trashtotreasure.R;

public class DonateItActivity extends AppCompatActivity {
    ListView listView;

    String [] fillist1;
    String [] fillist2;
    private static int RESULT_LOAD_IMAGE = 1;


    protected void onCreate(@Nullable Bundle x) {
        super.onCreate(x);
        setContentView(R.layout.activity_donateit);

        fillist1 = getResources().getStringArray(R.array.itemcat);
        Button buttonLoadImage = (Button) findViewById(R.id.buttonLoadPicture);

       //get the spinner from the xml.
        Spinner dropdown = findViewById(R.id.spinner1);
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, fillist1);
        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);

        fillist2 = getResources().getStringArray(R.array.itemcondition);
        Spinner dropdown2 = findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, fillist2);
        dropdown2.setAdapter(adapter2);
    }

    // load image of the item

    public void loadpic(View arg0) {
        Intent i = new Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            ImageView imageView = (ImageView) findViewById(R.id.imgView);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }
    }

    public void homeClick(View view) {
        Intent intent = new Intent(this, LaunchActivity.class);
        startActivity(intent);
    }

        public void addmyitem(View view) {
            Toast.makeText(DonateItActivity.this, "New Listing Item Added", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, LaunchActivity.class);
        startActivity(intent);
    }


}
