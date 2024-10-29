//package com.example.dumplingscloud.core;
//
//import com.datastax.oss.driver.api.core.CqlSession;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CassandraConnectionChecker {
//
//    @Autowired
//    private CqlSession cqlSession;
//
//    @PostConstruct
//    public void init() {
//        checkCassandraConnection();
//    }
//
//    private void checkCassandraConnection() {
//        boolean connected = false;
//        int retryCount = 0;
//        final int maxRetries = 5;
//        final int waitTime = 5000; // 5 секунд
//
//        while (!connected && retryCount < maxRetries) {
//            try {
//                // Попробуйте выполнить запрос для проверки подключения
//                cqlSession.execute("select id from ingredients limit 1;");
//                connected = true;
//                System.out.println("Connected to Cassandra");
//            } catch (Exception e) {
//                System.out.println("Failed to connect to Cassandra, retrying...");
//                retryCount++;
//                try {
//                    Thread.sleep(waitTime);
//                } catch (InterruptedException interruptedException) {
//                    Thread.currentThread().interrupt();
//                }
//            }
//        }
//
//        if (!connected) {
//            throw new RuntimeException("Could not connect to Cassandra after " + maxRetries + " attempts");
//        }
//    }
//}
