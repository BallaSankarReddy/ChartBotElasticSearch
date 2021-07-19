package com.hcl.chartbot.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.chartbot.common.ConvertingObjectToJson;
import com.hcl.chartbot.entity.ChartBotEntity;
import com.hcl.chartbot.service.ChartBotService;

@RestController
public class ChartBotController {

	private final Logger LOGGER = LoggerFactory.getLogger(ChartBotController.class);

	@Autowired
	private ChartBotService chatBotService;

	@PostMapping("/createproject")
	public ChartBotEntity saveChatBot(@RequestBody ChartBotEntity chatBot) {

		ChartBotEntity createChartBot = chatBotService.createChartBot(chatBot);
		LOGGER.trace(ConvertingObjectToJson.getJsonObjectMapper(createChartBot));
		return createChartBot;
	}

	@GetMapping("/chart_bot/{chartBotId}")
	public ChartBotEntity getChartBotById(@PathVariable("chartBotId") String chartBotId) {
		LOGGER.trace("Calling ChartBotController.getChartBotById() ::" + chartBotId);
		return chatBotService.getChartBotById(chartBotId);

	}

	public List<ChartBotEntity> getChartBots() {
		LOGGER.trace("Calling ChartBotController.getChartBots() ::");
		return chatBotService.getChartBots();
	}

	@GetMapping("/chart_bot/projectName/{projectName}")
	public List<ChartBotEntity> findByProjectName(@PathVariable("projectName") String projectName) {
		LOGGER.trace("Calling ChartBotController.findByProjectName() ::" + projectName);
		return chatBotService.findByProjectName(projectName);
	}

	@GetMapping("/chart_bot/language/{language}")
	public List<ChartBotEntity> findByLanguageName(@PathVariable("language") String language) {
		LOGGER.trace("Calling ChartBotController.findByLanguageName() ::" + language);
		return chatBotService.findByLanguageName(language);
	}

}
