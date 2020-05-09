package nada.doktorski.doktorski.model;

import java.util.List;

public class StatisticsListDto {
    private Experiment experiment;
    private List<StatisticsDto> statisticsPerPage;

    public StatisticsListDto() {
    }

    public StatisticsListDto(Experiment experiment, List<StatisticsDto> statisticsPerPage) {
        this.experiment = experiment;
        this.statisticsPerPage = statisticsPerPage;
    }

    public List<StatisticsDto> getStatisticsPerPage() {
        return statisticsPerPage;
    }

    public void setStatisticsPerPage(List<StatisticsDto> statisticsPerPage) {
        this.statisticsPerPage = statisticsPerPage;
    }

    public Experiment getExperiment() {
        return experiment;
    }

    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }
}
