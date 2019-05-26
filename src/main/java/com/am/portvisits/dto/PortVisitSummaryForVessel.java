package com.am.portvisits.dto;


import java.util.Date;

public class PortVisitSummaryForVessel {


    private Integer numberOfPortVisits;
    private Double averageTimeInThePort;
    private Integer minimumTimeInThePort;
    private Integer maximumTimeInThePort;
    private Date earliestVisit;
    private Date latestVisit;


    public PortVisitSummaryForVessel() {
    }

    public PortVisitSummaryForVessel(Integer numberOfPortVisits, Double averageTimeInThePort,
                                     Integer minimumTimeInThePort, Integer maximumTimeInThePort,
                                     Date earliestVisit, Date latestVisit) {
        this.numberOfPortVisits = numberOfPortVisits;
        this.averageTimeInThePort = averageTimeInThePort;
        this.minimumTimeInThePort = minimumTimeInThePort;
        this.maximumTimeInThePort = maximumTimeInThePort;
        this.earliestVisit = earliestVisit;
        this.latestVisit = latestVisit;
    }

    public Integer getNumberOfPortVisits() {
        return numberOfPortVisits;
    }

    public void setNumberOfPortVisits(Integer numberOfPortVisits) {
        this.numberOfPortVisits = numberOfPortVisits;
    }

    public Double getAverageTimeInThePort() {
        return averageTimeInThePort;
    }

    public void setAverageTimeInThePort(Double averageTimeInThePort) {
        this.averageTimeInThePort = averageTimeInThePort;
    }

    public Integer getMinimumTimeInThePort() {
        return minimumTimeInThePort;
    }

    public void setMinimumTimeInThePort(Integer minimumTimeInThePort) {
        this.minimumTimeInThePort = minimumTimeInThePort;
    }

    public Integer getMaximumTimeInThePort() {
        return maximumTimeInThePort;
    }

    public void setMaximumTimeInThePort(Integer maximumTimeInThePort) {
        this.maximumTimeInThePort = maximumTimeInThePort;
    }

    public Date getEarliestVisit() {
        return earliestVisit;
    }

    public void setEarliestVisit(Date earliestVisit) {
        this.earliestVisit = earliestVisit;
    }

    public Date getLatestVisit() {
        return latestVisit;
    }

    public void setLatestVisit(Date latestVisit) {
        this.latestVisit = latestVisit;
    }


    @Override
    public String toString() {
        return "PortVisitSummaryForVessel{" +
                "numberOfPortVisits=" + numberOfPortVisits +
                ", averageTimeInThePort=" + averageTimeInThePort +
                ", minimumTimeInThePort=" + minimumTimeInThePort +
                ", maximumTimeInThePort=" + maximumTimeInThePort +
                ", earliestVisit=" + earliestVisit +
                ", latestVisit=" + latestVisit +
                '}';
    }
}
