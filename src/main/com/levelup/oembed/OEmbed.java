package com.levelup.oembed;

import com.google.gson.annotations.SerializedName;

import co.tophe.gson.GsonReflected;

public class OEmbed implements GsonReflected {
	@SerializedName("type") String type;
	@SerializedName("title") String title;
	@SerializedName("author_name") String author;
	@SerializedName("author_url") String authorUrl;
	@SerializedName("provider_name") String provider;
	@SerializedName("provider_url") String providerUrl;
	@SerializedName("thumbnail_url") String thumbnailUrl;
	@SerializedName("thumbnail_width") int thumbnailWidth;
	@SerializedName("thumbnail_height") int thumbnailHeight;
	@SerializedName("url") String photoUrl;
	@SerializedName("width") int photoWidth;
	@SerializedName("height") int photoHeight;
	
	/**
	 * Tell if the OEmbed object is a photo or a video
	 */
	public boolean isPhoto() {
		return "photo".equals(type);
	}
	
	public String getThumbnail() {
		return thumbnailUrl;
	}
	
	public int getThumbnailHeight() {
		return thumbnailHeight;
	}
	
	public int getThumbnailWidth() {
		return thumbnailWidth;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public int getPhotoWidth() {
		return photoWidth;
	}

	public int getPhotoHeight() {
		return photoHeight;
	}
}
