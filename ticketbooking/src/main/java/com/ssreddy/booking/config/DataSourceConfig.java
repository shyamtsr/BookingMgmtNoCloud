/*
 * Copyright (c) 2018 SSR Technology & Services private limited. All rights
 * reserved. This software is the confidential and proprietary information of
 * SSR Technology & Services private limited. This file is part of Booking.
 */

package com.ssreddy.booking.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Author : Shyamsundar T <br>
 * Created on : 05th Aug, 2018 <br>
 * Version : 1.0. <br>
 * Description : Configuration class to hold Database configuration and Filter
 * Configuration <br>
 * JIRA: <br>
 */
@Configuration
public class DataSourceConfig {

	/**
	 *
	 * @return instance of DataSourceProperties.
	 */
	@Primary
	@Bean
	@ConfigurationProperties("spring.ticketdatasource")
	public DataSourceProperties ticketDataSourceProperties() {
		return new DataSourceProperties();
	}

	/**
	 *
	 * @return instance of DataSource.
	 */
	@Primary
	@Bean(name = "primaryDataSource")
	@ConfigurationProperties(prefix = "spring.ticketdatasource")
	public DataSource ticketDataSource() {
		return ticketDataSourceProperties().initializeDataSourceBuilder().build();
	}

	/**
	 *
	 * @param primaryDataSource
	 *            instance of DataSource.
	 * @return instance of JdbcTemplate.
	 */
	@Bean(name = "ticketJdbcTemplate")
	public JdbcTemplate ticketJdbcTemplate(@Qualifier("primaryDataSource") DataSource primaryDataSource) {
		return new JdbcTemplate(primaryDataSource);
	}

	/**
	 *
	 * @param primaryDataSource
	 * @return
	 */
	@Bean(name = "namedTicketJdbcTemplate")
	public NamedParameterJdbcTemplate namedTicketJdbcTemplate(
			@Qualifier("primaryDataSource") DataSource primaryDataSource) {
		return new NamedParameterJdbcTemplate(primaryDataSource);
	}


	/**
	 *
	 * @return instance of DataSourceProperties.
	 */
	/*@Bean
	@ConfigurationProperties("spring.admindatasource")
	public DataSourceProperties adminDataSourceProperties() {
		return new DataSourceProperties();
	}*/

	/**
	 *
	 * @return instance of DataSource.
	 */
	/*@Bean(name = "adminDataSource")
	@ConfigurationProperties(prefix = "spring.admindatasource")
	public DataSource adminDataSource() {
		return adminDataSourceProperties().initializeDataSourceBuilder().build();
	}*/

	/**
	 *
	 * @return instance of DataSourceProperties.
	 */
	/*@Bean
	@ConfigurationProperties("spring.masterdatasource")
	public DataSourceProperties masterDataSourceProperties() {
		return new DataSourceProperties();
	}*/

	/**
	 *
	 * @return instance of DataSource.
	 */
	/*@Bean(name = "masterDataSource")
	@ConfigurationProperties(prefix = "spring.masterdatasource")
	public DataSource masterDataSource() {
		return masterDataSourceProperties().initializeDataSourceBuilder().build();
	}*/

	/**
	 *
	 * @param adminDataSource
	 *            instance of DataSource.
	 * @return instance of JdbcTemplate.
	 */
	/*
	 * @Bean(name = "adminJdbcTemplate") public JdbcTemplate
	 * adminJdbcTemplate(@Qualifier("adminDataSource") DataSource adminDataSource) {
	 * return new JdbcTemplate(adminDataSource); }
	 */

	/**
	 *
	 * @param adminDataSource
	 *            instance of DataSource.
	 * @return instance of NamedPaarmeterJdbcTemplate.
	 */
	/*
	 * @Bean(name = "namedAdminJdbcTemplate") public NamedParameterJdbcTemplate
	 * namedAdminJdbcTemplate(@Qualifier("adminDataSource") DataSource
	 * adminDataSource) { return new NamedParameterJdbcTemplate(adminDataSource); }
	 */

	/**
	 *
	 * @param masterDataSource
	 *            instance of DataSource.
	 * @return
	 */
	/*
	 * @Bean(name = "masterJdbcTemplate") public JdbcTemplate
	 * masterJdbcTemplate(@Qualifier("masterDataSource") DataSource
	 * masterDataSource) { return new JdbcTemplate(masterDataSource); }
	 */

	/**
	 *
	 * @param masterDataSource
	 *            instance of DataSource.
	 * @return
	 */
	/*
	 * @Bean(name = "namedMasterJdbcTemplate") public NamedParameterJdbcTemplate
	 * namedMasterJdbcTemplate(
	 * 
	 * @Qualifier("masterDataSource") DataSource masterDataSource) { return new
	 * NamedParameterJdbcTemplate(masterDataSource); }
	 */

	/**
	 *
	 * @param primaryDataSource
	 *            DataSource.
	 * @return instance of DataSourceTransactionManager.
	 */
	/*
	 * @Bean(name = "transactionManager") public DataSourceTransactionManager
	 * transactionManager(
	 * 
	 * @Qualifier("primaryDataSource") DataSource primaryDataSource) { return new
	 * DataSourceTransactionManager(primaryDataSource); }
	 */


}
