package com.apptics.library.controller;

import com.apptics.library.model.Publisher;
import com.apptics.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/publishers")
    public String findAllPublishers(Model model) {
        model.addAttribute("publishers", publisherService.getAllPublishers());
        return "publisher/publishers";
    }

    @GetMapping("/add-publisher")
    public String addPublisher(Publisher publisher) {
            return "publisher/add-publisher";
    }

    @PostMapping("/save-publisher")
    public String savePublisher(Publisher publisher, Model model) {
        publisherService.savePublisher(publisher);
        model.addAttribute("publishers", publisherService.getAllPublishers());
        return "publisher/publishers";
    }

    @GetMapping("/update-publisher/{id}")
    public String editPublisher(@PathVariable Long id, Model model) {
        publisherService.getPublisherById(id);
        model.addAttribute("publisher", publisherService.getPublisherById(id));
        return "publisher/update-publisher";
    }

    @PostMapping("/save-update-publisher/{id}")
    public String updatePublisher(@PathVariable Long id, Publisher publisher, Model model) {
        if (publisherService.getPublisherById(id) != null) {
            publisherService.updatePublisher(publisher);
        } else {
            return "publisher/update-publisher";
        }
        model.addAttribute("publishers", publisherService.getAllPublishers());
        return "publisher/publishers";
    }

    @GetMapping("/delete-publisher/{id}")
    public String deletePublisher(@PathVariable Long id, Model model) {
        publisherService.deletePublisher(id);
        model.addAttribute("publishers", publisherService.getAllPublishers());
        return "publisher/publishers";
    }
}
