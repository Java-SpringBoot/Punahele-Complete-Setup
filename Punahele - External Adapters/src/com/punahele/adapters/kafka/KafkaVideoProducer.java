package com.punahele.adapters.kafka;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaVideoProducer {


    private final static String TOPIC = "300_Film";
    private final static String BOOTSTRAP_SERVERS =
            "localhost:9090";
    
    private static Producer<Long, String> createProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                                            BOOTSTRAP_SERVERS);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "KafkaVideoProducer");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                                        LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                                    StringSerializer.class.getName());
        props.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, "15728640");
        return new KafkaProducer<>(props);
    }
    
    public static void main(String... args) throws Exception {
        if (args.length == 0) {
            //runProducer(200);
        } else {
        	//runProducer(Integer.parseInt(args[0]));
        }
        producerVideoData("C:\\Videos\\OneRepublic - Feel Again.mp4");
    }
    
    static void producerVideoData(String filelocation) throws InterruptedException, ExecutionException {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", BOOTSTRAP_SERVERS);
        properties.put("acks", "all");
        properties.put("retries", 0);
        //properties.put("batch.size", 26214400);
        properties.put("linger.ms", 1);
        //properties.put("buffer.memory", 2*26214400);
        //properties.put("max.request.size", 26214400);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
        //KafkaProducer<String,byte[]> producer = new KafkaProducer<String, byte[]>(properties);
        final Producer<Long, String> producer = createProducer();
        try {
            byte[] filedata =Files.readAllBytes(Paths.get(filelocation));
            long start=0;
            for(long end=1000000; end<filedata.length; end=end+1000000) {
            	byte[] piece = new byte[1000000];
            	for(long cur=start; cur<end; cur++) {
            		long index = cur>1000000?cur-1000000:cur;
            		piece[(int)(index)] = filedata[(int)(cur)];
            	}
            	start = end+1;
            	//producer.send(new ProducerRecord<String,byte[]>(TOPIC, "test-key","dasdsd".getBytes() ));
            	final ProducerRecord<Long, String> record =
                        new ProducerRecord<>(TOPIC, 0l,
                        		"Metallica Rocks" + " " + Base64.getEncoder().encodeToString(piece));

                RecordMetadata metadata = producer.send(record).get();
                long elapsedTime = System.currentTimeMillis() - end;
                System.out.printf("sent record(key=%s value=%s) " +
                                "meta(partition=%d, offset=%d) time=%d\n",
                        record.key(), record.value(), metadata.partition(),
                        metadata.offset(), elapsedTime);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        producer.close();
        System.out.println("program completed");
    }
    
    static void runProducer(final int sendMessageCount) throws Exception {
        final Producer<Long, String> producer = createProducer();
        long time = System.currentTimeMillis();

        try {
            for (long index = time; index < time + sendMessageCount; index++) {
                final ProducerRecord<Long, String> record =
                        new ProducerRecord<>(TOPIC, index,
                        		"Metallica Rocks" + " " + UUID.randomUUID().toString());

                RecordMetadata metadata = producer.send(record).get();

                long elapsedTime = System.currentTimeMillis() - time;
                System.out.printf("sent record(key=%s value=%s) " +
                                "meta(partition=%d, offset=%d) time=%d\n",
                        record.key(), record.value(), metadata.partition(),
                        metadata.offset(), elapsedTime);

            }
        } finally {
            producer.flush();
            producer.close();
        }
    }

}
