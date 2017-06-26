package com.clouderwork.innoz.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.clouderwork.innoz.common.CommResult;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

@RestController
@Api(value = "file api", description = "文件上传接口")
public class FileController {
    private static Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private Environment env;

    @ApiOperation(value = "上传文件", response = CommResult.class)
    @PostMapping(value = "/api/file/upload")
    public CommResult uploadFile(@RequestParam("uploadFile") MultipartFile uploadFile) {
        try {
            String filename = uploadFile.getOriginalFilename();
            String directory = env.getProperty("innoz.path.upload");
            String filepath = Paths.get(directory, filename).toString();

            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
            stream.write(uploadFile.getBytes());
            stream.close();
        } catch (Exception e) {
            logger.error("file upload fail");
            return new CommResult(0, "upload fail");
        }

        return new CommResult(0, "upload ok");
    }
}
