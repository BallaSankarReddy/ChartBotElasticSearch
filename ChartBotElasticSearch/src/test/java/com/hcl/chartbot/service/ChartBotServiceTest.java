package com.hcl.chartbot.service;

import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.chartbot.entity.ChartBotEntity;
import com.hcl.chartbot.repository.ChartBotRepository;

@RunWith(SpringRunner.class)
/*
 * @SpringBootTest
 * 
 * @ContextConfiguration(locations = "classpath:application.properties")
 */
public class ChartBotServiceTest {
	
	
	@InjectMocks
	private  ChartBotService botService;
	@Mock
	private ChartBotRepository botRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void savechartBot() {
		Mockito.when(botRepository.save(getChartBotEntity())).thenReturn(getChartBotEntity());
		botService.createChartBot(getChartBotEntity());
	}

	@Test
	public void getChartBotById() {
		Mockito.when(botRepository.findById("1")).thenReturn(Optional.of(getChartBotEntity()));
		botService.getChartBotById("1");
	}
	
	public ChartBotEntity getChartBotEntity() {
		
		ChartBotEntity chart =new ChartBotEntity();
		chart.setId("1");
		chart.setLanguage("eng");
		chart.setProject("Test123");
		
		return chart;
	}
	
}
