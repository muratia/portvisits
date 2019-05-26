package com.am.portvisits.service;

import com.am.portvisits.dto.MonthlySummaryByPortRequest;
import com.am.portvisits.dto.MonthlySummaryByPortYearAndMonth;
import com.am.portvisits.dto.PortVisitSummaryForVessel;
import com.am.portvisits.dto.PortVisitSummaryRequest;
import com.am.portvisits.model.PortVisit;

import java.util.Date;
import java.util.List;


public interface PortVisitsService {

    List<PortVisit> getPortVisitsByTime_started(Integer portId, Date time_started) throws Exception;

    List<PortVisit> getPortVisitsByLengthGreaterThan(Integer portId, Double length);

    PortVisitSummaryForVessel getSummaryByPortAndImoAndDates(PortVisitSummaryRequest request) throws Exception;

    MonthlySummaryByPortYearAndMonth getMonthlySummaryByPortAndStartDateAndEndDate(Integer portId, Date startDate,Date endOfMonth) throws Exception;
}
