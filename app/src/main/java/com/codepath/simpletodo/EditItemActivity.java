package com.codepath.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EditItemActivity extends AppCompatActivity {
    int itemPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String item = getIntent().getStringExtra(MainActivity.ITEM_VALUE);
        itemPosition = getIntent().getIntExtra(MainActivity.ITEM_POSITION, 0);
        EditText etNewItem = (EditText) findViewById(R.id.etEditItem);
        etNewItem.setText(item, TextView.BufferType.EDITABLE);
        etNewItem.setSelection(item.length());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onSaveItem(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.etEditItem);
        String itemText = etNewItem.getText().toString();
        Intent data = new Intent();
        data.putExtra(MainActivity.ITEM_VALUE, itemText);
        data.putExtra(MainActivity.ITEM_POSITION, itemPosition);
        setResult(MainActivity.ITEM_REQUEST, data);
        this.finish();
    }

}
