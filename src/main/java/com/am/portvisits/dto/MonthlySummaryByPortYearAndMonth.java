package com.am.portvisits.dto;

public class MonthlySummaryByPortYearAndMonth {

    private Integer totalArrivalsInThePort;
    private Integer numberOfUniqueVesselsForArrival;
    private Double averageDurationOfPortVisits;
    private Integer sumOfLengthsOfTheShupsOfAllPortVisits;

    public MonthlySummaryByPortYearAndMonth() {
        totalArrivalsInThePort = 0;
        numberOfUniqueVesselsForArrival = 0;
        averageDurationOfPortVisits = 0.0d;
        sumOfLengthsOfTheShupsOfAllPortVisits = 0;
    }

    public MonthlySummaryByPortYearAndMonth(Integer totalArrivalsInThePort, Integer numberOfUniqueVesselsForArrival,
                                            Double averageDurationOfPortVisits,
                                            Integer sumOfLengthsOfTheShupsOfAllPortVisits) {
        this.totalArrivalsInThePort = totalArrivalsInThePort;
        this.numberOfUniqueVesselsForArrival = numberOfUniqueVesselsForArrival;
        this.averageDurationOfPortVisits = averageDurationOfPortVisits;
        this.sumOfLengthsOfTheShupsOfAllPortVisits = sumOfLengthsOfTheShupsOfAllPortVisits;
    }

    public Integer getTotalArrivalsInThePort() {
        return totalArrivalsInThePort;
    }

    public void setTotalArrivalsInThePort(Integer totalArrivalsInThePort) {
        this.totalArrivalsInThePort = totalArrivalsInThePort;
    }

    public Integer getNumberOfUniqueVesselsForArrival() {
        return numberOfUniqueVesselsForArrival;
    }

    public void setNumberOfUniqueVesselsForArrival(Integer numberOfUniqueVesselsForArrival) {
        this.numberOfUniqueVesselsForArrival = numberOfUniqueVesselsForArrival;
    }

    public Double getAverageDurationOfPortVisits() {
        return averageDurationOfPortVisits;
    }

    public void setAverageDurationOfPortVisits(Double averageDurationOfPortVisits) {
        this.averageDurationOfPortVisits = averageDurationOfPortVisits;
    }

    public Integer getSumOfLengthsOfTheShupsOfAllPortVisits() {
        return sumOfLengthsOfTheShupsOfAllPortVisits;
    }

    public void setSumOfLengthsOfTheShupsOfAllPortVisits(Integer sumOfLengthsOfTheShupsOfAllPortVisits) {
        this.sumOfLengthsOfTheShupsOfAllPortVisits = sumOfLengthsOfTheShupsOfAllPortVisits;
    }
}
