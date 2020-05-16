package nada.doktorski.doktorski.service;

import nada.doktorski.doktorski.model.Experiment;
import nada.doktorski.doktorski.model.StatisticsDto;
import nada.doktorski.doktorski.model.StatisticsListDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private final JavaMailSender javaMailSender;

    @Value( "${info.destination}" )
    private String infoDestiantion;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendStatisticsInMail(StatisticsListDto statisticsListDto) throws Exception {

        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            String mailtToSend = infoDestiantion;

            sortData(statisticsListDto);

            messageHelper.setTo(mailtToSend.split(","));
            messageHelper.setSubject("Statistics collected");
            messageHelper.setText(createEmailBody(statisticsListDto), true);
        };
        try {
            javaMailSender.send(messagePreparator);
        } catch (MailException e) {
            // runtime exception; compiler will not force you to handle it
        }
    }

    private void sortData(StatisticsListDto statisticsListDto) {
        statisticsListDto.getStatisticsPerPage().sort((statisticsDto, t1) -> {
            if (t1.getName().equals("K")) {
                return -1;
            }
            if (statisticsDto.getName().equals("K")) {
                return 1;
            }
            return statisticsDto.getName().compareTo(t1.getName());
        });

    }

    private String createEmailBody(StatisticsListDto statisticsListDto) {
        String emailBody = "<html> <head>\n" +
                "<style>\n" +
                "table {\n" +
                "  font-family: arial, sans-serif;\n" +
                "  border-collapse: collapse;\n" +
                "  width: 100%;\n" +
                "}\n" +
                "\n" +
                "td, th {\n" +
                "  border: 1px solid #dddddd;\n" +
                "  text-align: left;\n" +
                "  padding: 8px;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "</style>\n" +
                "</head>"; //TODO just fucking lazy, all of this needs to be reworked BRUH like WTF

        if ( statisticsListDto.getExperiment() == Experiment.EXPERIMENT1 ) {
            emailBody += "<h2>Eksperiment 1 (da se pronađe 8 parnih)</h2> </br> </br>";
        } else {
            emailBody += "<h2>Eksperiment 2 (da se pronađe 1 broj sa zadatom pozadinom)</h2> </br> </br>";
        }


        emailBody += "<table>";
        emailBody += createTableHeader(statisticsListDto);
        for(StatisticsDto statisticsDto: statisticsListDto.getStatisticsPerPage()) {
            emailBody += createTableRow(statisticsDto, statisticsListDto.getExperiment());
        }

        emailBody += "</table> </html>";

        return emailBody;
    }

    private String createTableRow(StatisticsDto statisticsDto, Experiment experiment) {
        String row = "";
        if ( experiment == Experiment.EXPERIMENT1 ) {
            row += "<tr>";
            row += "<td>" + statisticsDto.getName()  + "</td>";
            row += "<td>" + statisticsDto.getNumberOfMistakesMade()  + "</td>";
            row += "<td>" + statisticsDto.getTimeSpentOnPage()  + "</td>";
            row += "<td>" + statisticsDto.getFirstCorrectButtonClikcedAt()  + "</td>";
            row += "</tr>";
        } else {
            row += "<tr>";
            row += "<td>" + statisticsDto.getName()  + "</td>";
            row += "<td>" + statisticsDto.getNumberOfMistakesMade()  + "</td>";
            row += "<td>" + statisticsDto.getFirstCorrectButtonClikcedAt()  + "</td>";
            row += "</tr>";
        }

        return row;
    }

    private String createTableHeader(StatisticsListDto statisticsListDto) {
        String header = "";
        if ( statisticsListDto.getExperiment() == Experiment.EXPERIMENT1 ) {
            header += "<tr>";
            header += "<th>Ekrani</th><th>Netačni</th><th>Vreme po stranici</th><th>Vreme do prvog pronađenog broja</th>";
            header += "</tr>";
        } else {
            header += "<tr>";
            header += "<th>Ekrani</th><th>Netačni</th><th>Vreme do prvog pronađenog broja</th>";
            header += "</tr>";
        }

        return header;
    }
}
