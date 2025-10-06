package com.example.bookstore.bdd;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.FEATURES_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.example.bookstore.bdd.steps")
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "classpath:features")
/*
  IMPORTANT: add junit plugin so Cucumber writes JUnit XML that Jenkins can read.
  This will create target/cucumber-junit.xml
*/
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,summary,junit:target/cucumber-junit.xml")
public class RunCucumberTest { }
