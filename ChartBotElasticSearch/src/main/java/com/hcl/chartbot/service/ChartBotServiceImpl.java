package com.hcl.chartbot.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.chartbot.common.ConvertingObjectToJson;
import com.hcl.chartbot.entity.ChartBotEntity;
import com.hcl.chartbot.repository.ChartBotRepository;

@Service
public class ChartBotServiceImpl implements ChartBotService {

	private final Logger LOGGER = LoggerFactory.getLogger(ChartBotServiceImpl.class);

	private ChartBotRepository chatBotRepository;

	@Autowired
	public void setChatBotRepository(ChartBotRepository chatBotRepository) {
		this.chatBotRepository = chatBotRepository;
	}

	@Override
	public ChartBotEntity createChartBot(ChartBotEntity chatBotEntity) {
		LOGGER.info("Start ChartBotServiceImpl.createChartBot() method" + new Date().getDate());
		ChartBotEntity chartBotRes = chatBotRepository.save(chatBotEntity);

		LOGGER.info(" ChatBot Created " + new Date().getDate() + "Response Object :"
				+ ConvertingObjectToJson.getJsonObjectMapper(chartBotRes));
		return chartBotRes;
	}

	@Override
	public ChartBotEntity getChartBotById(String chartBotId) {
		LOGGER.info("Start ChartBotServiceImpl.getChartBotById() method" + new Date().getDate());
		ChartBotEntity chartBotRes = chatBotRepository.findById(chartBotId).get();

		LOGGER.info(" ChartBot Response Object :" + ConvertingObjectToJson.getJsonObjectMapper(chartBotRes));

		return chartBotRes;
	}

	@Override
	public List<ChartBotEntity> getChartBots() {
		LOGGER.info("Start ChartBotServiceImpl.getChartBots() method" + new Date().getDate());
		Iterable<ChartBotEntity> findAll = chatBotRepository.findAll();

		List<ChartBotEntity> chartBots = StreamSupport.stream(findAll.spliterator(), false).filter(obj -> null != obj)
				.collect(Collectors.toList());

		LOGGER.info(" List of ChartBot Response Object :" + ConvertingObjectToJson.getJsonObjectMapper(chartBots));
		return chartBots;
	}

	@Override
	public List<ChartBotEntity> findByProjectName(String projectName) {
		LOGGER.info("Start ChartBotServiceImpl.findByProjectName() method" + new Date().getDate());
		ChartBotEntity chartBotRes = chatBotRepository.findById(projectName).get();

		LOGGER.info(" ChartBot Response Object :" + ConvertingObjectToJson.getJsonObjectMapper(chartBotRes));
		return null;
	}

	@Override
	public List<ChartBotEntity> findByLanguageName(String language) {
		LOGGER.info("Start ChatBotServiceImpl.findByLanguageName() method" + new Date().getDate());
		ChartBotEntity chartBotRes = chatBotRepository.findById(language).get();

		LOGGER.info(" ChartBot Response Object :" + ConvertingObjectToJson.getJsonObjectMapper(chartBotRes));
		return null;
	}

}
