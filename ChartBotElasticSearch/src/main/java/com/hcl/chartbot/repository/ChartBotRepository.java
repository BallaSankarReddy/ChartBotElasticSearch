package com.hcl.chartbot.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.hcl.chartbot.entity.ChartBotEntity;

@Repository
public interface ChartBotRepository extends ElasticsearchRepository<ChartBotEntity, String> {

}
