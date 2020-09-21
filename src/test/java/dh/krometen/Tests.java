package dh.krometen;

import com.google.gson.Gson;
import dh.krometen.GET.DownloadFile;
import dh.krometen.POST.CreateTemplate;
import dh.krometen.POST.UploadFile;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Tests {
    @Test
    public void createTemplateTest(){
        Gson gson = new Gson();
        CreateTemplate createTemplate = new CreateTemplate();
        TemplateForm expectedTestTemplate = createTemplate.createTemplate("TestName",
                1, 1, 1, 1234, "HumanTestName");
        TemplateForm actualTestTemplate = new TemplateForm("TestName",
                1, 1, 1, 1234, "HumanTestName");
        Assert.assertEquals(gson.toJson(expectedTestTemplate),
                gson.toJson(actualTestTemplate));
    }

    @Test
    public void downloadFile() throws IOException {
        DownloadFile downloadTestFile = new DownloadFile();
        ResponseEntity<InputStreamResource> testFile = downloadTestFile.downloadFile("test");
        Assert.assertEquals(
                "<200 OK OK,InputStream resource [resource loaded through InputStream]," +
                        "[Content-Disposition:\"attachment;filename=test\", " +
                        "Content-Length:\"233782\"]>",
                testFile.toString());
    }

    @Test
    public void fileUploadTest() throws IOException {
        MultipartFile multipartFile = new MockMultipartFile("test.txt",
                new FileInputStream(new File("/home/path/test.txt")));
        UploadFile uploadFile = new UploadFile();
        uploadFile.fileUpload("test", multipartFile);
        String contents = Arrays.toString(Files.readAllBytes(Paths.get("/home/path/test.txt")));
        Assert.assertEquals("text", contents);
    }
}