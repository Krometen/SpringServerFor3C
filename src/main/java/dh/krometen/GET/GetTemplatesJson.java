package dh.krometen.GET;

import dh.krometen.TemplateForm;
import dh.krometen.repo.RepoFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GetTemplatesJson extends RepoFactory {
    @RequestMapping(value="/GetTemplatesJson", method= RequestMethod.GET)
    public @ResponseBody
    List<TemplateForm> getTemplatesJson() {
        return templateRepo.findAllByOrderByIdDesc();
    }
}