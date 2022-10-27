package com.naveendra.lotteryresults.service.impl;

import com.naveendra.lotteryresults.entity.GovisethaResults;
import com.naveendra.lotteryresults.repository.GovisethaResultsRepository;
import com.naveendra.lotteryresults.repository.StoreResultsRepository;
import com.naveendra.lotteryresults.service.GovisethaResultsService;
import com.naveendra.lotteryresults.service.StoreResultsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GovisethaResultsServiceImpl implements GovisethaResultsService {
    private GovisethaResultsRepository govisethaResultsRepository;
    @Autowired
    private StoreResultsService storeResultsService;

    public GovisethaResultsServiceImpl(GovisethaResultsRepository govisethaResultsRepository) {
        this.govisethaResultsRepository = govisethaResultsRepository;
    }

    @Override
    public void printLotteryResults() {
        List<GovisethaResults> govisethaResultsList = govisethaResultsRepository.findAll();

        log.info("Printing the lottery results with HTML tags");

        System.out.println("<h1> Govisetha Results </h1>");
        System.out.println("<table>");
        System.out.println("<thead>");
        System.out.println("<tr>");
        System.out.println("<th> Letter </th>");
        System.out.println("<th> Number 01 </th>");
        System.out.println("<th> Number 02 </th>");
        System.out.println("<th> Number 03 </th>");
        System.out.println("<th> Number 04 </th>");
        System.out.println("</tr>");
        System.out.println("<tbody>");

        if (govisethaResultsList.size() > 0) {
            for (GovisethaResults results : govisethaResultsList) {
                System.out.println("<tr>");
                System.out.println("<td>" + results.getLetter() + "</td>");
                System.out.println("<td>" + results.getNumber01() + "</td>");
                System.out.println("<td>" + results.getNumber02() + "</td>");
                System.out.println("<td>" + results.getNumber03() + "</td>");
                System.out.println("<td>" + results.getNumber04() + "</td>");
                System.out.println("</tr>");
            }
        } else {
            System.out.println("<tr>");
            System.out.println("<td> - </td>");
            System.out.println("<td> - </td>");
            System.out.println("<td> - </td>");
            System.out.println("<td> - </td>");
            System.out.println("<td> - </td>");
            System.out.println("</tr>");
        }
        System.out.println("</tbody>");
        System.out.println("</table>");

        this.storeResultsService.saveLotteryResults(govisethaResultsList);
    }

    @Override
    public void run(String... args) throws Exception {
        this.printLotteryResults();
    }
}
