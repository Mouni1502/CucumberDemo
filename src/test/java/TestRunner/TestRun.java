package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {".//features/loginnop.feature"},glue={"Stepdefinition"}
                ,plugin={"pretty","html:reports/myreports.html",
                		"junit:target/junitReports/xmlreports",
                		"json:target/jsonReports/json reports"
                        },
                		dryRun=false,//checks mapping between scenarios and step definitions methods
                		monochrome=true,
                		publish=true) 

public class TestRun {

}
