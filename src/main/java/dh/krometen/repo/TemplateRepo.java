package dh.krometen.repo;

import dh.krometen.TemplateForm;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//Repository for templates
public interface TemplateRepo extends CrudRepository<TemplateForm, Long> {
    List<TemplateForm> findAllByOrderByIdDesc();
}