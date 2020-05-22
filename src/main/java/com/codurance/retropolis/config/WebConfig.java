package com.codurance.retropolis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
//@Profile("!" + Environment.TEST)
public class WebConfig {

  @Configuration
  public class WebConfiguration implements WebMvcConfigurer {

//    @Autowired
//    private GoogleTokenAuthenticator googleTokenAuthenticator;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
      registry.addMapping("/**")
          .allowedOrigins("http://retropolis-fe.s3-website.eu-west-2.amazonaws.com");
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//      registry.addInterceptor(googleTokenAuthenticator);
//    }
  }
}