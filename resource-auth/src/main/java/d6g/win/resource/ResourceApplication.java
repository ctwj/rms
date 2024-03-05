package d6g.win.resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
@SpringBootApplication
@MapperScan("d6g.win.resource.mapper")
@EnableCaching
public class ResourceApplication {

    public static void main(String[] args) {

        SpringApplication.run(ResourceApplication.class, args);
    }
}