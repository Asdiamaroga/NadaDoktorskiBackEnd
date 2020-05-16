package nada.doktorski.doktorski.controller;

import nada.doktorski.doktorski.model.StatisticsListDto;
import nada.doktorski.doktorski.service.MailService;
import org.springframework.web.bind.annotation.*;

@RestController
public class MailController {

    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @CrossOrigin // TODO this sucks but leave it for now
    @PostMapping("/sendStatistics")
    public void sendStatisticsInMail(@RequestBody StatisticsListDto statisticsListDto) throws Exception {
        mailService.sendStatisticsInMail(statisticsListDto);
    }
}
