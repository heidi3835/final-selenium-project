$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("darksky.feature");
formatter.feature({
  "line": 3,
  "name": "Verify dark sky feature",
  "description": "",
  "id": "verify-dark-sky-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@web"
    },
    {
      "line": 1,
      "name": "@regression"
    },
    {
      "line": 1,
      "name": "@control"
    }
  ]
});
formatter.before({
  "duration": 3782954610,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.scenario({
  "line": 25,
  "name": "Verify Current Temperature should not be greater or less than the Temperature from Daily Timeline",
  "description": "",
  "id": "verify-dark-sky-feature;verify-current-temperature-should-not-be-greater-or-less-than-the-temperature-from-daily-timeline",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 24,
      "name": "@control-1"
    }
  ]
});
formatter.step({
  "line": 26,
  "name": "I am Darksky Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "I verify current temp is not greater or less then temps from daily timeline",
  "keyword": "Then "
});
formatter.match({
  "location": "Scenario1SD.IAmOnDarkSkyHomePage()"
});
formatter.result({
  "duration": 4586769306,
  "status": "passed"
});
formatter.match({
  "location": "Scenario1SD.verifyLowAndHighTemDisplayCorectly()"
});
formatter.result({
  "duration": 98562685,
  "status": "passed"
});
formatter.after({
  "duration": 99259235,
  "status": "passed"
});
});