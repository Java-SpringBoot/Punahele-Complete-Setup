package com.punahele.video.cache;

import java.util.Map;

import com.punahele.video.bean.VideoDetails;

public class VideoDetailsCache {
	private Map<String, VideoDetails> map;
    //Try using a Ehcache here
	public void setCache(Map<String, VideoDetails> cache) {
                          
	}
	public VideoDetails getVideoDetails(String videoName) {
		return map.get(videoName);
	}
}
