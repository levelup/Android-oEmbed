package com.levelup.oembed;

import com.google.gson.annotations.SerializedName;

public class OEmbed {
	@SerializedName("type") String type;
	@SerializedName("title") String title;
	@SerializedName("author_name") String author;
	@SerializedName("author_url") String authorUrl;
	@SerializedName("provider_name") String provider;
	@SerializedName("provider_url") String providerUrl;
	@SerializedName("thumbnail_url") String thumbnailUrl;
	
	/**
	 * Tell if the OEmbed object is a photo or a video
	 */
	public boolean isPhoto() {
		return "photo".equals(type);
	}
	
	public String getThumbnail() {
		return thumbnailUrl;
	}
}
