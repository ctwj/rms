package d6g.win.resource;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collection;
import java.util.Collections;

public class GenerateUtil {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://192.168.2.6:3306/abc", "abc", "123456")
                .globalConfig(builder -> {
                    builder.author("ctwj")
                            .enableSwagger()
//                            .fileOverride()
                            .outputDir("/Users/kerwin/Program/java/resource/resource-auth/src/main/java");
                })
                .packageConfig(builder -> {
                    builder.parent("d6g.win.resource")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "/Users/kerwin/Program/java/resource/resource-auth/src/main/resources/mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("posts", "postmeta");
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
