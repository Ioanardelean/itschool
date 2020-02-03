package fr.formation.itschool;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * The application class providing the Spring boot main method and
 * configuration.
 */
@SpringBootApplication
public class Application {

    /**
     * The main method running the application.
     *
     * @param args
     *            the optional method arguments
     * @see SpringApplication#run(Class, String...)
     */
    public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
    }

    /**
     * Default {@code ModelMapper} in order to ease mapping from DTO to
     * entities, and from entities to DTOs.
     *
     * @return an instance of {@code ModelMapper}
     */
    @Bean
    protected ModelMapper mapper() {
	ModelMapper mapper = new ModelMapper();
	mapper.getConfiguration().setFieldMatchingEnabled(true)
		.setFieldAccessLevel(AccessLevel.PRIVATE);
	return mapper;
    }

    /**
     * Default {@code ObjectMapper} in order to customize mapping from JSON
     * (request body) to DTOs.
     *
     * @return an instance of {@code ObjectMapper}
     */
    @Bean
    protected ObjectMapper objectMapper() {
	ObjectMapper mapper = new ObjectMapper();
	mapper.setVisibility(
		mapper.getSerializationConfig().getDefaultVisibilityChecker()
			.withFieldVisibility(JsonAutoDetect.Visibility.ANY)
			.withGetterVisibility(JsonAutoDetect.Visibility.NONE)
			.withIsGetterVisibility(JsonAutoDetect.Visibility.NONE)
			.withSetterVisibility(JsonAutoDetect.Visibility.NONE)
			.withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
	mapper.registerModule(new JavaTimeModule());
	mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
	return mapper;
    }
}
