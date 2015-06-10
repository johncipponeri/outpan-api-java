package io.github.johncipponeri.outpanapi;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class OutpanObject {

	public String
		gtin,
		outpan_url,
		name;
	
	public HashMap<String, String>
		attributes;
	
	public ArrayList<String>
		images,
		videos;
	
	public OutpanObject() {
		this.gtin = "";
		this.outpan_url = "";
		this.name = "";
		
		this.attributes = new HashMap<String, String>();
		this.images = new ArrayList<String>();
		this.videos = new ArrayList<String>();
	}
	
	public OutpanObject(JSONObject json) {
		this();
		
		this.gtin = json.getString("gtin");
		this.outpan_url = json.getString("outpan_url");
		
		if (!json.isNull("name"))
			this.name = json.getString("name");
		
		if (!json.isNull("attributes")) {
			JSONObject attrObject = json.getJSONObject("attributes");
			String[] attrs = JSONObject.getNames(attrObject);
			
			for (int a = 0; a < attrs.length; a++)
				this.attributes.put(attrs[a], attrObject.getString(attrs[a]));
		}
		
		if (!json.isNull("images")) {
			JSONArray imgs = json.getJSONArray("images");
			for (int i = 0; i < imgs.length(); i++)
				this.images.add(imgs.getString(i));
		}
		
		if (!json.isNull("videos")) {
			JSONArray vids = json.getJSONArray("videos");
			for (int i = 0; i < vids.length(); i++)
				this.videos.add(vids.getString(i));
		}
	}
}