package com.am.portvisits.controller;

import com.am.portvisits.dto.*;
import com.am.portvisits.model.PortVisit;
import com.am.portvisits.service.PortVisitsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/vesseltracking")
public class PortVisitsRestController {

    public static Logger Log = Logger.getLogger (PortVisitsRestController.class);

    @Autowired
    private PortVisitsService portVisitsService;


    public PortVisitsRestController() {

    }

    /**
     * Task 1
     *
     * @param portId
     * @param date
     * @return
     */
    @PostMapping(value = "/vesselsatportadtime")
    public List<PortVisit> getVesselsAtPortByTime(
            @RequestParam(value = "portId") Integer portId,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {

        List<PortVisit> visits = new ArrayList<> ();
        try {
            visits = portVisitsService.getPortVisitsByTime_started (portId, date);
        } catch (Exception ex) {
           // ex.printStackTrace ();
            System.err.println (ex.getMessage ());
        }
        return visits;
    }

    /**
     * Task A
     *
     * @param portId
     * @param length
     * @return Json
     */
    @PostMapping(value = "/vesselsatportwithlengthgreaterthan", produces = "application/json")
    public String getVesselsatportwithlengthgreaterthan(
            @RequestParam(value = "portId") Integer portId,
            @RequestParam(value = "length") Double length) {

        String json = "";
        List<PortVisit> visits = new ArrayList<> ();
        try {
            visits = portVisitsService.getPortVisitsByLengthGreaterThan (portId, length);
            PortVisitSmall pvs;
            List<PortVisitSmall> portVisitSmalls = new ArrayList<> ();
            for (PortVisit pv : visits) {
                portVisitSmalls.add (new PortVisitSmall (pv));
            }
            ObjectMapper om = new ObjectMapper ();
            json = om.writeValueAsString (portVisitSmalls);
        } catch (Exception ex) {
            Log.trace ("Error", ex);
        }
        return json;
    }

    /**
     * Taks B
     * @param portId
     * @param imo
     * @param timeStartedStr
     * @param timeEndedStr
     * @return
     */
    @PostMapping(value = "/summarbyimoandportsanddates", produces = "application/json")
    public PortVisitSummaryForVessel GetSumaryForVessel(
            @RequestParam(value = "portId") Integer portId,
            @RequestParam(value = "imo") Integer imo,
            @RequestParam(value = "timeStarted") String timeStartedStr,
            @RequestParam(value = "timeEnded") String timeEndedStr) {

        SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd hh:mm");
        PortVisitSummaryRequest req = null;
        PortVisitSummaryForVessel summaryByPortAndImoAndDates = null;
        try {
            Date timeStarted = format.parse (timeStartedStr);
            Date timeEnded = format.parse (timeEndedStr);

            req = new PortVisitSummaryRequest (portId, imo, timeStarted, timeEnded);
            summaryByPortAndImoAndDates =
              portVisitsService.getSummaryByPortAndImoAndDates (req);
              Log.info (summaryByPortAndImoAndDates);
        } catch (Exception ex) {
            Log.error ("Error happened at SummaryForVessel: "+ex.getMessage ());
        }
        return summaryByPortAndImoAndDates;
    }

    /**
     * Task C
     * @param portId
     * @param month
     * @param year
     * @return
     */
    @PostMapping(value = "/monthysummarybyportandmonthandyear", produces = "application/json")
    public MonthlySummaryByPortYearAndMonth getMonthlySummaryByPortAndYearAndMont(
            @RequestParam(value = "portId") Integer portId,
            @RequestParam(value = "month") Integer month,
            @RequestParam(value = "year") Integer year) {

        Log.info ("Entering into the method");
        System.err.println ("Entering into the method");
        System.out.println ("Entering into the method");
        Log.warn ("Entering into the method");

        MonthlySummaryByPortYearAndMonth instanceOfTheOobject = new MonthlySummaryByPortYearAndMonth ();
        SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd hh:mm");
        try {
            String startDateStr = "" + year + "-" + month + "-01 00:00:00";
            Date startDate = format.parse (startDateStr);

            LocalDate convertedDate = LocalDate.parse (startDateStr, DateTimeFormatter.ofPattern ("yyyy-MM-dd hh:mm"));
            convertedDate = convertedDate.withDayOfMonth (
                    convertedDate.getMonth ().length (convertedDate.isLeapYear ()));
            Date endOfMonth = format.parse (convertedDate.toString ());
            Log.error ("Request parameters: "+portId+" | "+ startDate + " | " +endOfMonth);
            System.out.println ("Request parameters: "+portId+" | "+ startDate + " | " +endOfMonth);





            instanceOfTheOobject = portVisitsService.getMonthlySummaryByPortAndStartDateAndEndDate (portId, startDate, endOfMonth);
        } catch (Exception ex) {
            Log.error (ex.getMessage ());
        }
        return instanceOfTheOobject;
    }


}
