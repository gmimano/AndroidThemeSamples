package com.spartancoders.themesamples;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.spartancoders.themesamples.light.LightThemes;
import com.spartancoders.themesamples.patterns.Patterns;

public class Main extends ListActivity {
	private static final Map<String, Class> mSections;
	static {
		Map<String, Class> map = new HashMap<String, Class>();
		map.put("Buttons", null);
		map.put("Dark Themes", null);
		map.put("Light Themes", LightThemes.class);
		map.put("UI Patterns", Patterns.class);
		mSections = Collections.unmodifiableMap(map);
	}
	
    private static final String [] SECTIONS = mSections.keySet().toArray(new String[3]);
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, SECTIONS);
        setListAdapter(adapter);
    }
        
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	CharSequence text = ((TextView)v).getText();
    	Class c = mSections.get(text);
    	if (c != null) {
        	Intent intent = new Intent(this, c);
        	startActivity(intent);    		
    	} else Toast.makeText(this, "Nothing there yet..", Toast.LENGTH_SHORT).show();
    }
}