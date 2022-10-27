package com.naveendra.lotteryresults.service;

import com.naveendra.lotteryresults.entity.GovisethaResults;

import java.util.List;

public interface StoreResultsService {
    void saveLotteryResults(List<GovisethaResults> govisethaResultsList);
}
