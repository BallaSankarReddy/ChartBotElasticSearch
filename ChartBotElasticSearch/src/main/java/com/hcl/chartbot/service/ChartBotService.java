package com.hcl.chartbot.service;

import java.util.List;

import com.hcl.chartbot.entity.ChartBotEntity;

public interface ChartBotService {

	public ChartBotEntity createChartBot(ChartBotEntity chatBotEntity);

	public ChartBotEntity getChartBotById(String chartBotId);

	public List<ChartBotEntity> getChartBots();

	public List<ChartBotEntity> findByProjectName(String projectName);

	public List<ChartBotEntity> findByLanguageName(String language);

}
