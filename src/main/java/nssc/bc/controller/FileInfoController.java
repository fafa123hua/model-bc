package nssc.bc.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nssc.bc.entity.FileInfo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/file")
@AllArgsConstructor
@CrossOrigin
public class FileInfoController {

    @RequestMapping(value = "/files", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FileInfo> listFiles() throws IOException {
        String rootPath = "D:\\汇总\\WJDQCS";
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
}
