package com.example.components;

import android.content.Context;
import android.support.annotation.ArrayRes;
import android.support.v7.widget.AppCompatSpinner;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomSpinner extends AppCompatSpinner {

    public CustomSpinner(Context context) {
        super(context);
    }

    public CustomSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void init(Context context, String item) {
        List<String> list = new ArrayList<>();
        list.add(item);
        init(context, list, item);
    }

    public void init(Context context, @ArrayRes int textArrayResId, String selectedValue) {
        List<String> list = Arrays.asList(getResources().getStringArray(textArrayResId));
        setCustomAdapter(context, list, selectedValue);
    }

    public void init(Context context, List<String> spinnerItems, String selectedValue) {
        setCustomAdapter(context, spinnerItems, selectedValue);
    }

    private void setCustomAdapter(Context context, List<String> spinnerItems, String selectedValue) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, spinnerItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.setAdapter(adapter);
        if (selectedValue != null) {
            int spinnerPosition = adapter.getPosition(selectedValue);
            this.setSelection(spinnerPosition);
        }
    }

    public String getSelectedValue() {
        return this.getSelectedItem().toString();
    }


}
