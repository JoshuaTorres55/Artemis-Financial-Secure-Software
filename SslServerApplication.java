package com.snhu.sslserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SslServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SslServerApplication.class, args);
    }

    @RestController
    public class SslController {

        @GetMapping("/checksum")
        public String getChecksum() {
            String uniqueData = "hello world";
            String name = "Joshua Torres";

            try {
                String checksum = ChecksumUtility.generateChecksum(uniqueData);
                return String.format("Name: %s<br>Unique Data: %s<br>Checksum: %s", name, uniqueData, checksum);
            } catch (Exception e) {
                return String.format("Error generating checksum: %s", e.getMessage());
            }
        }

        @GetMapping("/secure")
        public String secureCommunication() {
            return "Secure communication is working!";
        }
    }
}
