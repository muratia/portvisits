package com.am.portvisits.service.impl;

import com.am.portvisits.dao.PortVisitsRepository;
import com.am.portvisits.dto.MonthlySummaryByPortYearAndMonth;
import com.am.portvisits.dto.PortVisitSummaryForVessel;
import com.am.portvisits.dto.PortVisitSummaryRequest;
import com.am.portvisits.model.PortVisit;
import com.am.portvisits.service.PortVisitsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Service
public class PortVisitsServiceImpl implements PortVisitsService {

    public static Logger Log = Logger.getLogger (PortVisitsServiceImpl.class);
    private final PortVisitsRepository repository;

@PersistenceContext
private EntityManager em;

    @Autowired
    public PortVisitsServiceImpl(PortVisitsRepository repo) {

        repository = repo;
    }

    @Override
    public List<PortVisit> getPortVisitsByTime_started(Integer portId, Date time_started) throws Exception {
        if(repository == null){
            throw new Exception ("Repository is not instantiated Null ");
        }
       // System.err.println (String.format ("PortId = %1s %2d ",portId, time_started));
        return repository.findByPortAndTimeStartedGreaterThan (portId, time_started);
    }



    @Override
    public List<PortVisit> getPortVisitsByLengthGreaterThan(Integer portId, Double length) {

        return repository.findPortVisitsByPortAndLengthGreaterThan (portId, length);
    }




    @Override
    public PortVisitSummaryForVessel getSummaryByPortAndImoAndDates(PortVisitSummaryRequest req) throws Exception {
        PortVisitSummaryForVessel pvsfv = new PortVisitSummaryForVessel ();


        Query q = em.createNativeQuery("SELECT count(imo) numberOfPortVisits,  \n" +
                "AVG((datediff(time_finished, time_started))) averageTimeInThePort,  \n" +
                "MIN(datediff(time_finished, time_started)) minimumTimeInThePort,\n" +
                "MAX(datediff(time_finished, time_started)) maximumTimeInThePort,\n" +
                "MIN(time_started) earliestVisit, \n" +
                "MAX(time_started) latestVisit \n" +
                " \n" +
                "FROM portvisits \n" +
                "WHERE port_id = ?portId AND imo = ?imo AND time_started BETWEEN ?timeStarted and ?endOfMonth\n" +
                "GROUP BY imo;");

          q.executeUpdate ();
          pvsfv = (PortVisitSummaryForVessel) q.getSingleResult ();


            if(pvsfv==null){
                throw new Exception ( "P is null");
            }

        return pvsfv;
    }

    /***
     * Task D: Implementation of the Service
     * @param portId ID of the port
     * @param startDate  Start of the selected month converted into object java.util.Date for convenience
     * @param endOfMonth Calculated end of the month based on the given month and year
     * @return MonthlySummaryByPortYearAndMonth
     * @throws Exception
     */
     @Override
    public MonthlySummaryByPortYearAndMonth getMonthlySummaryByPortAndStartDateAndEndDate(Integer portId,
                                                                                          Date startDate,
                                                                                          Date endOfMonth)
             throws Exception {

        MonthlySummaryByPortYearAndMonth m = new MonthlySummaryByPortYearAndMonth ();
       System.out.println( "Request parameters: "+portId+" | "+ startDate + " | " +endOfMonth);
        StoredProcedureQuery storedProcedure =
                em.createStoredProcedureQuery ("`sp_calculateMonthlySummary`",
                        MonthlySummaryByPortYearAndMonth.class);


        storedProcedure.registerStoredProcedureParameter("portId", Long.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter ("startDate", Date.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter ("endOfMonth", Date.class, ParameterMode.IN);
        storedProcedure.setParameter ("portId", portId);
        storedProcedure.setParameter("startDate", startDate);
        storedProcedure.setParameter ("endOfMonth", endOfMonth );

        // execute stored procedure
        Log.info ("Trying to execute");
        boolean execute = storedProcedure.execute ();
        if(execute) {
          m = (MonthlySummaryByPortYearAndMonth) storedProcedure.getSingleResult ();
          System.out.println("Executed");
        }else{
            m = new MonthlySummaryByPortYearAndMonth ();
           System.err.println ("Not loaded");
        }
       /* m = repository.getMonthlySummaryByPortAndStartDateAndEndDate(req.getPortId (),
                req.getStartDate (), req.getEndOfMonth ());*/

        return m;
    }


}
