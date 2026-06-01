package Runner;

import io.cucumber.junit.Cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)


@CucumberOptions (features="src/test/resources/features",
glue= {"StepDefinition","Hooks"},
tags="@Smoke",
plugin= {"pretty","html:target/htmlreports/report1.html","json:target/jsonreport/report","junit:target/junitreport/report"}
)

public class RunCucumberTest {

}
