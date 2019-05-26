package com.am.portvisits.dao;


import com.am.portvisits.dto.MonthlySummaryByPortYearAndMonth;
import com.am.portvisits.dto.PortVisitSummaryForVessel;
import com.am.portvisits.model.PortVisit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PortVisitsRepository extends JpaRepository<PortVisit, Long> {

    List<PortVisit> findByPortAndTimeStartedGreaterThan(Integer portId, Date time_started);

    List<PortVisit> findPortVisitsByPortAndLengthGreaterThan(final Integer portId, final Double length);

  //  @Query(value = "{CALL `genscape`.`sp_calculateSummary`(?, ?, ?,? )}", nativeQuery = true)

    @Procedure(name = "sp_calculateSummary")
    PortVisitSummaryForVessel getSummaryByPortAndImoAndDates(
            @Param("portId") Integer portId,
            @Param ("imo") Integer imo,
            @Param("timeStarted") Date timeStarted,
            @Param("timeEnded") Date timeEnded);


    //@Query(value = "{ CALL `genscape`.`sp_calculateMonthlySummary`(?, ?, ? )}", nativeQuery = true)
    @Procedure(name = "sp_calculateMonthlySummary")
   /* @Query(value = "SELECT count(time_started) numberOfArrivalsInPort,  \n" +
            " (SELECT imo  FROM genscape.portvisits having count(*) =1) 'numberOfUniqueVesselsForArrival',\n" +
            "AVG((datediff(time_finished, time_started))) averageDurationOfPortVisits,  \n" +
            "SUM( length) sumOfLengthsOfTheShupsOfAllPortVisits\n" +
            "FROM portvisits \n" +
            "WHERE port_id =portId AND  time_started BETWEEN  startDate and endDate;", nativeQuery = true)*/
    MonthlySummaryByPortYearAndMonth getMonthlySummaryByPortAndStartDateAndEndDate(
            @Param("portId") Integer portId,
            @Param("startDate") Date startDate,
            @Param("endOfMonth") Date endOfMonth);

}
