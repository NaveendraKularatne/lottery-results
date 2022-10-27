package com.naveendra.lotteryresults.service.impl;

import com.naveendra.lotteryresults.entity.GovisethaResults;
import com.naveendra.lotteryresults.entity.StoreResults;
import com.naveendra.lotteryresults.repository.StoreResultsRepository;
import com.naveendra.lotteryresults.service.StoreResultsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreResultsServiceImpl implements StoreResultsService {

    @Autowired
    private StoreResultsRepository storeResultsRepository;

    public void saveLotteryResults(List<GovisethaResults> govisethaResultsList) {
        if (govisethaResultsList.size() > 0) {

            List<StoreResults> storeResultsList = new ArrayList<>();
            for (GovisethaResults results : govisethaResultsList) {
                StoreResults storeResults = new StoreResults();
                BeanUtils.copyProperties(results, storeResults);
                storeResultsList.add(storeResults);
            }
            this.storeResultsRepository.saveAll(storeResultsList);
        }
    }
}
