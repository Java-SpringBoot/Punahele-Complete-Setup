# Punahele-Complete-Setup
Video Streaming Service written in Java 8, HTML5, Websockets, ElasticSearch, Redis, Kafka (Complete Setup).
Project's main aim is to implement features provided by Youtube. 
Currently, Multiple users can request for video content from the application. The video content is streamed frame by frame to the user's browser through websockets. A Batch job runs periodically, converting newly added videos to a particular format. And from this file, users requests are served. Users can jump to a particular time, pause/play playback. Also planned to implement a profile for users, so that users can start from the point where they have paused earlier (Pending - Planned to use Redis).
Currently, the UI is simple (Using Bootstrap). Have plans to make it big using Angular 5. 
All the external frameworks . Kafka, ElasticSearch, Redis are triggered through custom written Java adapters.

Technologies used
1. Java 8, JEE8
2. HTML5 - Websockets, HTML storage, webworkers, Bootstrap
3. Spring Data, Spring Boot as well
4. Elastic Search
5. Maven
6. Redis
7. Kafka
8. OpenCV

Achievements
•	For 19 users, 3 seconds of Video can be buffered every 1 sec.
•	Benchmarking done on Intel core i5 7300u with 8 GB RAM
•	Please check Statistics file for more detailed benchmarking.
