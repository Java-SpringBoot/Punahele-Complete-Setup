package com.punahele.video.cache;

import java.util.HashMap;

import com.punahele.video.bean.VideoDetails;

public enum VideoDetailsCache1 {
	INSTANCE;
	private HashMap<String, VideoDetails> videoCache = new HashMap<>();
	private VideoDetailsCache1() {
	}

	public static VideoDetailsCache1 newInstance() {
		return INSTANCE;
	}
}
