package com.spartancoders.themesamples.patterns;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.spartancoders.themesamples.R;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Patterns extends ListActivity {
	private static final Map<String, Class> mSamples;
	static {
		Map<String, Class> map = new HashMap<String, Class>();
		map.put("Action Bar", Actionbar.class);
		mSamples = Collections.unmodifiableMap(map);
	}
	
	private static final String [] SAMPLES = mSamples.keySet().toArray(new String[1]);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, SAMPLES);
        setListAdapter(adapter);
	}
	
	@Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	CharSequence text = ((TextView)v).getText();
    	Intent intent = new Intent(this, mSamples.get(text));
    	startActivity(intent);
    }
}
