package notifications.controller;

import lombok.AllArgsConstructor;
import notifications.entity.NotificationTemplate;
import notifications.service.TemplateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/templates")
@AllArgsConstructor
public class TemplateController {

    private final TemplateService templateService;

    @PostMapping
    public NotificationTemplate createTemplate(@RequestBody NotificationTemplate template) {
        return templateService.saveTemplate(template);
    }


    @PutMapping("/{id}")
    public NotificationTemplate updateTemplate(@PathVariable Long id, @RequestBody NotificationTemplate updatedTemplate) {
        return templateService.updateTemplate(updatedTemplate.getName(), updatedTemplate.getContent());
    }

    @GetMapping("/{name}")
    public String getTemplate(@PathVariable String name) {
        return templateService.getTemplate(name);
    }

    @GetMapping
    public List<NotificationTemplate> getAllTemplates() {
        return templateService.getAllTemplates();
    }

}