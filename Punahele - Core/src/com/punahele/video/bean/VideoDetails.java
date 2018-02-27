package com.punahele.video.bean;

import java.io.RandomAccessFile;
import java.util.Map;

public class VideoDetails {
	public VideoDetails(RandomAccessFile videoHandle, Map<Integer, String> positionsMap) {
		this.videoHandle = videoHandle;
		this.positionsMap = positionsMap;
	}

	private RandomAccessFile videoHandle;
	private Map<Integer, String> positionsMap;

	public RandomAccessFile getVideoHandle() {
		return videoHandle;
	}

	public void setVideoHandle(RandomAccessFile videoHandle) {
		this.videoHandle = videoHandle;
	}

	public Map<Integer, String> getPositionsMap() {
		return positionsMap;
	}

	public void setPositionsMap(Map<Integer, String> positionsMap) {
		this.positionsMap = positionsMap;
	}
}
