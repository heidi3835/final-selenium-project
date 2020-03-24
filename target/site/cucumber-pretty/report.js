$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("hotelscom.feature");
formatter.feature({
  "line": 3,
  "name": "Verify hotels.com feature",
  "description": "",
  "id": "verify-hotels.com-feature",
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
      "name": "@hotels"
    }
  ]
});
formatter.before({
  "duration": 4361282145,
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
  "line": 12,
  "name": "List of all of hotel within 10 miles radius of airport or downtown",
  "description": "",
  "id": "verify-hotels.com-feature;list-of-all-of-hotel-within-10-miles-radius-of-airport-or-downtown",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 11,
      "name": "@hotels-2"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "I am on locations search result screen",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "I verify system displays all hotels within 10 miles radius of airport",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "I verify Hilton Hotel is within 10 miles radius",
  "keyword": "And "
});
formatter.match({
  "location": "hotelScenario2.IamOnthelandingpage()"
});
formatter.result({
  "duration": 17018396052,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 43
    }
  ],
  "location": "hotelScenario2.tenmilesaroundhotels(double)"
});
formatter.result({
  "duration": 156002200879,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "10 miles",
      "offset": 32
    }
  ],
  "location": "hotelScenario2.verifyHiltonHotelIsWithinRadious(double)"
});
formatter.result({
  "duration": 2142086445,
  "status": "passed"
});
formatter.after({
  "duration": 247679183,
  "status": "passed"
});
});