package com.am.portvisits.dto;

import com.am.portvisits.model.PortVisit;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PortVisitSmall {

private String name;

    private int imo;

    private double length;


    private int port;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date timeStarted;

    public PortVisitSmall(PortVisit pv) {
        setName (pv.getName ());
        setPort (pv.getPort ());
        setImo ( pv.getImo ());
        setLength (pv.getLength ());
        setTimeStarted (pv.getTimeStarted ());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImo() {
        return imo;
    }

    public void setImo(int imo) {
        this.imo = imo;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Date getTimeStarted() {
        return timeStarted;
    }

    public void setTimeStarted(Date timeStarted) {
        this.timeStarted = timeStarted;
    }


}
