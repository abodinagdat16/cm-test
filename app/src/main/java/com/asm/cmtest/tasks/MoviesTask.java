package com.asm.cmtest.tasks;

import java.util.concurrent.Callable;
import java.util.ArrayList;
import com.asm.cmtest.models.Movie;
import android.app.Activity;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import java.io.IOException;
import org.jsoup.select.Elements;

public class MoviesTask implements Callable<ArrayList<Movie>>
{

	private Activity activity;
    private String inputUrl;
	private OnTaskRun onTaskRun;

	public MoviesTask(Activity activity, String inputUrl, OnTaskRun onTaskRun)
	{
		this.activity = activity;
		this.inputUrl = inputUrl;
		this.onTaskRun = onTaskRun;
	}
	
	@Override
	public ArrayList<Movie> call() throws Exception
	{
		// TODO: Implement this method
		return doInBackground();
	}
	
	private ArrayList<Movie> doInBackground(){
		ArrayList<Movie> moviesList = new ArrayList<>();
		
		try
		{
			Document document = Jsoup.connect(inputUrl).get();
			Elements root = document.select("ul.enlaces li.elemento");
		}
		catch (IOException e)
		{
			onTaskRun.onTaskFailed(e.getMessage());
		}

		return moviesList;
	}
}
