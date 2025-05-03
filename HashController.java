package com.snhu.sslserver;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class HashController {

    @GetMapping("/hash")
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
}
