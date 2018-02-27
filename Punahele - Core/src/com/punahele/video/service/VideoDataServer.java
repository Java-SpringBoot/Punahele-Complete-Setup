package com.punahele.video.service;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.Future;

import javax.json.JsonObject;

public class VideoDataServer {
	//Try using Kafka here..From end requests will be queued together and a thread will be sending
	//that to Kafka. Some other thread, that will pick up data from kafka and will send them to the front
	//end Remember to Kafka anyhow
	/**
	 * With the start position and end position of the video, the method returns the portion 
	 * of the full video between the given positions
	 * @param startPositionFrame
	 * @param endPositionFrame
	 * @return
	 */
	/*public byte[] returnImageSequencesAsBytes(int startPositionFrame, int endPositionFrame) {
		try {
			String startFrameData = positionsMap.get(startPositionFrame);
			String temp[] = startFrameData.split(",");
			int startPos = Integer.parseInt(temp[0]);

			String endFrameData = positionsMap.get(endPositionFrame);
			temp = endFrameData.split(",");
			int endPos = Integer.parseInt(temp[0]) + Integer.parseInt(temp[1]);

			byte[] data = new byte[endPos - startPos];

			RandomAccessFile f = new RandomAccessFile(foldeName + "\\BigFinal.jpeg", "rw");
			f.seek(startPos);
			f.read(data, startPos, endPos);
			f.close();
			return data;
		} catch (IOException e) {
			return new byte[0];
		}
	}

	/**
	 * When a portion of the video is returned to the user as a sequence of images, this method
	 * returns the positions of the image frames within that portion of data being returned
	 * @param startFramePosition
	 * @param endFramePosition
	 * @return
	 */
	/*
	public int[] returnFramePositionsInImageSequence(int startFramePosition, int endFramePosition) {
        String temp[] =  positionsMap.get(startFramePosition).split(",");
        int subVal = Integer.parseInt(temp[0]); int[] framesPos = 
        		new int[endFramePosition-startFramePosition + 1];
		for(int cur=0; cur<=endFramePosition-startFramePosition; cur++) {
			String tempParts[] = positionsMap.get(cur+startFramePosition).split(",");
			framesPos[cur] = Integer.parseInt(tempParts[0]) - subVal;
       }
		return framesPos;
	}

	public byte[] returnAudioCorresToVideoDur() {
		return null;
	}
	*/
	public static Future<JsonObject> submitVideoRequest (JsonObject userRequest){
		//Queue video requests. Once request is read by threads, they read the video data and
		//put them to Kafka. From there, the returned Future will regularly check Kafka for any 
		//video data read. The websocket endpoint will then send data async to the client through a Future handle
		
		
		//Client sends a request through websocket. Server persists the request to Redis server.
		//If the server fails after the client has placed a request, the server can quickly recover from the failure
		//and serve the clients with the request which has been stored in Redis server.
		//In the client, we should just have a logic that will re establish the connection to 
		//the server. Also viewed history tracker should be done with Redis.
		return null;
	}
}
