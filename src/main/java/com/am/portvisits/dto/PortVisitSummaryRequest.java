package com.am.portvisits.dto;

import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import java.util.Date;

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "calculateSumary",
                procedureName = "calculateSumary",
                resultClasses = { PortVisitSummaryForVessel.class },
                parameters = {
                        @StoredProcedureParameter(
                                name = "portId",
                                type = Long.class,
                                mode = ParameterMode.IN
                        ),
                        @StoredProcedureParameter (
                                name= "imo",
                                type = Integer.class,
                                mode = ParameterMode.IN
                        ),
                        @StoredProcedureParameter (
                                name= "timeStarted",
                                type = Date.class,
                                mode = ParameterMode.IN
                        ),
                        @StoredProcedureParameter (
                                name= "timeEnded",
                                type = Date.class,
                                mode = ParameterMode.IN
                        ),
                })
})
public class PortVisitSummaryRequest {



    private Integer port;
    private Integer imo;

    private Date timeStarted;
    private Date timeEnded;

    public PortVisitSummaryRequest() {
    }

    public PortVisitSummaryRequest(Integer port, Integer imo, Date timeStarted, Date timeEnded) {
        this.port = port;
        this.imo = imo;
        this.timeStarted = timeStarted;
        this.timeEnded = timeEnded;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getImo() {
        return imo;
    }

    public void setImo(Integer imo) {
        this.imo = imo;
    }

    public Date getTimeStarted() {
        return timeStarted;
    }

    public void setTimeStarted(Date timeStarted) {
        this.timeStarted = timeStarted;
    }

    public Date getTimeEnded() {
        return timeEnded;
    }

    public void setTimeEnded(Date timeEnded) {
        this.timeEnded = timeEnded;
    }
}
