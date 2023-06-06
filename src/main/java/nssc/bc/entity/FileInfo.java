package nssc.bc.entity;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

import java.io.Serializable;

@Data
public class FileInfo implements Serializable {

    private String name;

    private JsonNode content; // 文件内容封装为 JSONObject 对象

    private String path;

}