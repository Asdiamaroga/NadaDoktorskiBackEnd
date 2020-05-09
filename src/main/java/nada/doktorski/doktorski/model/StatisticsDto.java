package nada.doktorski.doktorski.model;

public class StatisticsDto {

    private String name;
    private String[] colors;
    private String pattern;
    private int evenNumbersClicked;
    private int numberOfMistakesMade;
    private double firstCorrectButtonClikcedAt;
    private double timeSpentOnPage;

    public StatisticsDto() {
    }

    public StatisticsDto(String name, String[] colors, String pattern, int evenNumbersClicked, int numberOfMistakesMade, double firstCorrectButtonClikcedAt, double timeSpentOnPage) {
        this.name = name;
        this.colors = colors;
        this.pattern = pattern;
        this.evenNumbersClicked = evenNumbersClicked;
        this.numberOfMistakesMade = numberOfMistakesMade;
        this.firstCorrectButtonClikcedAt = firstCorrectButtonClikcedAt;
        this.timeSpentOnPage = timeSpentOnPage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getColors() {
        return colors;
    }

    public void setColors(String[] colors) {
        this.colors = colors;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public int getEvenNumbersClicked() {
        return evenNumbersClicked;
    }

    public void setEvenNumbersClicked(int evenNumbersClicked) {
        this.evenNumbersClicked = evenNumbersClicked;
    }

    public int getNumberOfMistakesMade() {
        return numberOfMistakesMade;
    }

    public void setNumberOfMistakesMade(int numberOfMistakesMade) {
        this.numberOfMistakesMade = numberOfMistakesMade;
    }

    public double getFirstCorrectButtonClikcedAt() {
        return firstCorrectButtonClikcedAt;
    }

    public void setFirstCorrectButtonClikcedAt(double firstCorrectButtonClikcedAt) {
        this.firstCorrectButtonClikcedAt = firstCorrectButtonClikcedAt;
    }

    public double getTimeSpentOnPage() {
        return timeSpentOnPage;
    }

    public void setTimeSpentOnPage(double timeSpentOnPage) {
        this.timeSpentOnPage = timeSpentOnPage;
    }
}
