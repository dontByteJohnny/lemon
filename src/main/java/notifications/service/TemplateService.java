package notifications.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import notifications.entity.NotificationTemplate;
import notifications.repository.TemplateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class TemplateService {
    private final TemplateRepository templateRepository;

    public NotificationTemplate saveTemplate(NotificationTemplate template) {
        NotificationTemplate existingTemplate = templateRepository.findById(template.getId())
                .orElseThrow(() -> new RuntimeException("not found " + template.getId()));
        if (existingTemplate != null) {
            throw new RuntimeException("already exists" + template.getName());
        }
        return templateRepository.save(template);
    }

    public String getTemplate(String templateName) {
        NotificationTemplate template = templateRepository.findByName(templateName);

        return template.getContent();
    }

    public List<NotificationTemplate> getAllTemplates() {
        return templateRepository.findAll();
    }

    public NotificationTemplate updateTemplate(String templateName, String newContent) {
        NotificationTemplate template = templateRepository.findByName(templateName);

        template.setContent(newContent);
        templateRepository.save(template);

        log.info("success {}", templateName);
        return template;
    }
}