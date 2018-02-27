package com.punahele.video.cache;

public class VideoDataCacheLoader {
   //Read video files and load their details into VideoDetailsCache
	VideoDataCacheLoader(){}
	public void loadVideoCache() {
		//Read the video dir. And then load VideoDetailsCache with filename and 
		//video file handle details 
	}
	
	public void setVideoDir(String videoDir) {
		//This class will be called when the applciation starts. Reading files and caching them
		//Note the resulting cache should contain filename, video detail object loaded, and also if
		//possible first 100 frames from the resulting video
	}
	
}
