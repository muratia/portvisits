package com.am.portvisits.dto;

import java.util.Date;

public class MonthlySummaryByPortRequest {

   private Integer portId;
    private Date startDate;
    private Date endOfMonth;

    public MonthlySummaryByPortRequest() {
    }

    public MonthlySummaryByPortRequest(Integer portId, Date startDate, Date endOfMonth) {
        this.portId = portId;
        this.startDate = startDate;
        this.endOfMonth = endOfMonth;
    }

    public Integer getPortId() {
        return portId;
    }

    public void setPortId(Integer portId) {
        this.portId = portId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndOfMonth() {
        return endOfMonth;
    }

    public void setEndOfMonth(Date endOfMonth) {
        this.endOfMonth = endOfMonth;
    }
}
