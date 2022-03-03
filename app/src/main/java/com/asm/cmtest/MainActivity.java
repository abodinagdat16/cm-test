package com.asm.cmtest;

import android.os.*;
import java.util.concurrent.*;

import android.app.Activity;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import java.io.IOException;
import org.jsoup.select.Elements;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.app.ProgressDialog;

public class MainActivity extends Activity 
{
	
	String result;
	String errorMsg = null;
	
	private EditText edt;
	private TextView tv;
	private Button btn;
	
	private ProgressDialog prog;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		edt = findViewById(R.id.mainEditText1);
		tv = findViewById(R.id.mainTextView1);
		btn = findViewById(R.id.mainButton1);
		
		prog = new ProgressDialog(this);
		prog.setCancelable(false);
		
		btn.setOnClickListener(new View.OnClickListener(){

				@Override
				public void onClick(View v)
				{
					tester(edt.getText().toString());
				}
			});
		
    }
	
	private void tester(final String link){
		prog.show();
		ExecutorService executor = Executors.newSingleThreadExecutor();
		final Handler handler = new Handler(Looper.getMainLooper());
		executor.execute(new Runnable() {
				@Override
				public void run() {
					
					try
					{
						Document document = Jsoup.connect(link).get();
						Elements root = document.select("ul.enlaces li.elemento");
						
						result = root.toString();
					}
					catch (IOException e)
					{
						errorMsg = e.getMessage();
					}

					handler.post(new Runnable() {
							@Override
							public void run() {
								prog.dismiss();
								if(errorMsg!=null){
									tv.setText(result);
								}else{
									tv.setText(errorMsg);
								}
								
							}
						});
				}
			});
	}
}
