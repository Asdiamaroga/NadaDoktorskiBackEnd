package nada.doktorski.doktorski.controller;

import nada.doktorski.doktorski.model.StatisticsListDto;
import nada.doktorski.doktorski.service.MailService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MailController {

    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @CrossOrigin // TODO this sucks but leave it for now
    @PostMapping("/sendStatistics")
    public void sendStatisticsInMail(@RequestBody StatisticsListDto statisticsListDto,  HttpServletRequest request) throws Exception {
        mailService.sendStatisticsInMail(statisticsListDto, request.getRemoteAddr());
    }
}
