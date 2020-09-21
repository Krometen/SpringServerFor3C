package dh.krometen.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Repository for templates
@Component
public class RepoFactory {
    public TemplateRepo templateRepo;

    @Autowired
    public void setTemplateRepo(TemplateRepo templateRepo){
        this.templateRepo = templateRepo;
    }
}