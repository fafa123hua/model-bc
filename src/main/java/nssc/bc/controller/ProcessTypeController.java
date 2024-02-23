package nssc.bc.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nssc.bc.entity.FileInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/processType")
@AllArgsConstructor
@CrossOrigin
public class ProcessTypeController {

    @Value("${myapp.ces}")
    private String myCes;

    @RequestMapping(value = "/files", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FileInfo> listFiles() throws IOException {
        String rootPath = myCes;
        File directory = new File(rootPath);
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("传入的路径不是目录或者目录不存在！");
        }
        List<FileInfo> fileInfos = new ArrayList<>();
        readFiles(directory, rootPath, fileInfos);
        return fileInfos;
    }

    private void readFiles(File file, String rootPath, List<FileInfo> fileInfos) throws IOException {
        String fileName = file.getName();
        if (file.isFile() && fileName.toLowerCase().endsWith(".json")) {
            // 读取文件内容
            JsonNode content = readJsonFile(file.getAbsolutePath());
            // 将文件信息封装到 FileInfo 对象中，并添加到集合中
            FileInfo fileInfo = new FileInfo();
            fileInfo.setName(fileName);
            fileInfo.setContent(content);
            fileInfo.setPath(file.getAbsolutePath().replace(rootPath, ""));
            fileInfos.add(fileInfo);
        } else if (file.isDirectory()) {
            File[] subFiles = file.listFiles();
            for (File subFile : subFiles) {
                readFiles(subFile, rootPath, fileInfos);
            }
        }
    }

    private JsonNode readJsonFile(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(filePath);
        return mapper.readTree(file);
    }

    @PostMapping(value = "/fileOut", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object createJsonFile(@RequestBody List<Object> dataList) throws IOException {
        // 这里调用保存文件的方法
        String rootPath = myCes;
        String fileName = "data2.json";
        String json = new ObjectMapper().writeValueAsString(dataList);
        saveJsonToFile(rootPath, fileName, json);
        return dataList;
    }
    private void saveJsonToFile(String rootPath, String fileName, String json) throws IOException {
        File directory = new File(rootPath);
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("传入的路径不是目录或者目录不存在！");
        }
        File file = new File(directory, fileName);
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(json);
        bw.close();
    }



    public ProcessTypeController() {}
}
