package com.greek.main.populator;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.javafaker.Faker;

public class FakerDataPopulator implements Runnable {

	private static final Logger logger = LoggerFactory.getLogger(FakerDataPopulator.class);

	private static Properties prop = new Properties();
	private static BasicDataSource dataSource;

	public static void main(String[] args) throws IOException {
		logger.info("Populating with fake data");
		
		loadProperties();
		dataSource = loadDataSource();

		FakerDataPopulator fakeDataPopulator = new FakerDataPopulator();

		for (int x = 0; x < 8; ++x) {
			Thread thread = new Thread(fakeDataPopulator);
			thread.start();
		}
	}

	@Override
	public void run() {
		populate();
	}

	private void populate() {
		int prevPercentDone = 0;
		QueryRunner run = new QueryRunner(dataSource);
		Faker faker = new Faker(new Locale("es", "ES"));
//		Long idOrganizacion = 4L;

		for (int x = 0, total = 10000; x <= total; ++x) {
			try {
				run.update(
						"insert into persona (id,codigo_persona,cedula_persona,nombre_persona,apellido_persona,direccion_persona,"
								+ "fecha_nacimiento_persona,telefono_fijo_persona,e_mail_persona) "
								+ "values (nextval('persona_organizacion_id_seq'::regclass),?,?,?,?,?,?,?,?)",
						RandomStringUtils.randomAlphanumeric(16),
						RandomStringUtils.randomAlphanumeric(1) + "-" + RandomStringUtils.randomNumeric(14),
						faker.name().firstName(), faker.name().lastName() + " " + faker.name().lastName(),
						faker.address().fullAddress(), new Date(faker.date().birthday(18, 64).getTime()),
						faker.phoneNumber().cellPhone(),
						StringUtils.stripAccents(StringUtils.deleteWhitespace(faker.internet().emailAddress())));
			} catch (SQLException sqle) {
				logger.error("error", sqle);
			}

			prevPercentDone = printPercentDone(prevPercentDone, x, total);
		}
	}

	private int printPercentDone(int prevPercentDone, int x, int total) {
		int percentDone = (x * 100) / total;

		if (percentDone % 5 == 0 && percentDone != prevPercentDone) {
			logger.info("Done...{}%", percentDone);
		}

		return percentDone;
	}

	private static BasicDataSource loadDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(prop.getProperty("hibernate.connection.driver_class"));
		dataSource.setUrl(prop.getProperty("hibernate.connection.url"));
		dataSource.setUsername(prop.getProperty("hibernate.connection.username"));
		dataSource.setPassword(prop.getProperty("hibernate.connection.password"));

		return dataSource;
	}

	private static void loadProperties() throws IOException {
		try (InputStream input = FakerDataPopulator.class.getClassLoader().getResourceAsStream("domain.properties")) {
			if (input == null) {
				logger.debug("Sorry, unable to find config.properties");
				return;
			}

			// load a properties file from class path, inside static method
			prop.load(input);

			// get the property value and print it out
			logger.debug(prop.getProperty("hibernate.connection.driver_class"));
			logger.debug(prop.getProperty("hibernate.connection.url"));
			logger.debug(prop.getProperty("hibernate.connection.username"));
			logger.debug(prop.getProperty("hibernate.connection.password"));
		}
	}

}