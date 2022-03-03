package com.asm.cmtest.models;

public class Movie
{
	public String server,size,quality,link;

	public Movie(String server, String size, String quality, String link)
	{
		this.server = server;
		this.size = size;
		this.quality = quality;
		this.link = link;
	}

	public void setServer(String server)
	{
		this.server = server;
	}

	public String getServer()
	{
		return server;
	}

	public void setSize(String size)
	{
		this.size = size;
	}

	public String getSize()
	{
		return size;
	}

	public void setQuality(String quality)
	{
		this.quality = quality;
	}

	public String getQuality()
	{
		return quality;
	}

	public void setLink(String link)
	{
		this.link = link;
	}

	public String getLink()
	{
		return link;
	}
}
