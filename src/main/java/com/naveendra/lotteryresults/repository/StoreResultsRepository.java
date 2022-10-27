package com.naveendra.lotteryresults.repository;

import com.naveendra.lotteryresults.entity.StoreResults;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreResultsRepository extends JpaRepository<StoreResults, Integer> {
}
