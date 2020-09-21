package dh.krometen.POST;

import com.google.gson.Gson;
import dh.krometen.TemplateForm;
import dh.krometen.repo.RepoFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@EnableAutoConfiguration
@Controller
public class CreateTemplate extends RepoFactory {

    @RequestMapping("/CreateTemplate")
    public @ResponseBody
    TemplateForm createTemplate(
            @RequestParam("name") String name,
            @RequestParam("x") int x,
            @RequestParam("y") int y,
            @RequestParam("id") int id,
            @RequestParam("hash") double hash,
            @RequestParam("humanName") String humanName) {
        //Creates a template bean
        TemplateForm template = new TemplateForm(name, x, y, id, hash, humanName);
        //Save to database
        try {
            templateRepo.save(template);
        }catch(NullPointerException npe){
            System.out.println("No repository: " + npe + "\n " + template);
        }
        return template;
    }
}