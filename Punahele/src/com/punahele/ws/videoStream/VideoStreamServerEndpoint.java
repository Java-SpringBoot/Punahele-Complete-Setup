package com.punahele.ws.videoStream;

import java.io.StringReader;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.punahele.utilities.json.CustomJsonBuilder;
import com.punahele.utilities.video.VideoContentManager;
import com.punahele.video.service.VideoDataServer;

@ServerEndpoint(value = "/requestVideoAsImages", encoders = {com.punahele.encoder.JsonEncoder.class})
public class VideoStreamServerEndpoint {

	@OnMessage
	public void serveVideoRequest(String userRequest, Session session) throws InterruptedException, ExecutionException{
		//Response should be a Json
		//containing 1. start position for each of the frame that is served
		//2. Should send the images as a single byte array
		//should play that range audio
		StringReader reequest = new StringReader(userRequest);
		JsonObject request = Json.createReader(reequest).readObject();
		
		/*
		int frameStartPos = Integer.parseInt(request.getString("frameStartPos")); --frameStartPos;
		int frameEndPos = Integer.parseInt(request.getString("frameEndPos")); --frameEndPos;
		String requestedVideo = request.getString("videoName");
		VideoContentManager manager = new VideoContentManager("C:\\Videos\\OneRepublic - Feel Again");
		byte[] imageSequences = manager.returnImageSequencesAsBytes(frameStartPos, frameEndPos); //Get the set of images frames requested from client
	    int[] startPositionsFrame = manager.returnFramePositionsInImageSequence(frameStartPos, frameEndPos);
	    byte[] audioDataForTimeRange = manager.returnAudioCorresToVideoDur();
        */
	    
	    /********************
	    for (int i = 0; i < startPositionsFrame.length; i++) {
	    	byte[] data = null;
	    	if(i == startPositionsFrame.length-1) {
	    		data = Arrays.copyOfRange(imageSequences, startPositionsFrame[i], imageSequences.length);	
	    	}
	    	else {
	    		data = Arrays.copyOfRange(imageSequences, startPositionsFrame[i], startPositionsFrame[i+1]);
	    	}
	    	try {
	    	FileOutputStream fos = new FileOutputStream("C:\\Videos\\OneRepublic - Feel Again\\Gen\\File"+i+".txt");
	    	fos.write(data); fos.close();
	    	}
	    	catch(Exception e) {}
		}
	    **/
	    /*
	    CustomJsonBuilder objBuilder = new CustomJsonBuilder();
	    objBuilder.createNewObject().setJsonProperty("image_sequences", imageSequences).
	    //setJsonProperty("audio_data_time_ranges", audioDataForTimeRange).
	    setJsonProperty("start_positions_frames", startPositionsFrame);
	    //return objBuilder.returnObject();
	     */
		Future<JsonObject> response = VideoDataServer.submitVideoRequest(request);
	    session.getAsyncRemote().sendObject(response.get());
	}
	
	public static void main(String[] args) {
       /*
		new VideoStreamServerEndpoint().serveVideoRequest("{\r\n" + 
		"			\"frameStartPos\" : \"1\",\r\n" + 
		"			\"frameEndPos\" : \"3\"\r\n" + 
		"		}");
		*/
	}
}
