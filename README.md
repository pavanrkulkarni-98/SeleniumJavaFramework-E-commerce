# E-Commerce Hybrid + Data-Driven Automation Framework

A hybrid UI and API test automation framework built in **Java** with **Selenium 4**, **TestNG**, **Apache POI**, **Extent Reports**, and **REST Assured**. Designed with clear separation of responsibilities, `ThreadLocal` WebDriver isolation for parallel execution, Page Object Model (POM) abstractions, and Excel-driven test data.

---

## Core Architecture & Design Principles
* **Single Responsibility:** Each class owns one clear concern—configuration loading, browser creation, thread-safe driver storage, test lifecycle hooks, explicit waits, page interactions, Excel parsing, test listeners/retries, reporting/screenshots, and API utilities.
* **Parallel Execution Safety:** `DriverManager` stores `WebDriver` instances inside a `ThreadLocal<WebDriver>` and unloads (`quit()` + `remove()`) every thread in teardown so parallel TestNG runs do not collide or leak memory.
* **Fail-Fast Validation:** `DriverFactory` supports **Chrome**, **Firefox**, and **Edge** from `config.properties` and throws an `IllegalArgumentException` if a browser name is missing, blank, or unsupported.
* **Hybrid UI + API Coverage:** Combines browser-driven e-commerce journeys (search, product details, cart, checkout, login) with REST Assured API checks for setup, state verification, and backend contract/status validation.

---

## Project Structure

```text
ecommerce-automation-framework/
├── src/
│   ├── main/java/com/ecommerce/
│   │   ├── constants/
│   │   │   └── FrameworkConstants.java       # Central paths, timeouts, browser keys, report & Excel locations
│   │   ├── config/
│   │   │   └── ConfigLoader.java             # Reads and exposes values from config.properties
│   │   ├── driver/
│   │   │   ├── DriverFactory.java            # Instantiates Chrome, Firefox, or Edge; throws IllegalArgumentException on invalid values
│   │   │   └── DriverManager.java            # ThreadLocal<WebDriver> setDriver(), getDriver(), unload()
│   │   ├── pages/
│   │   │   ├── BasePage.java                 # Shared WebDriver & WaitUtils helpers for page objects
│   │   │   ├── HomePage.java                 # Search, navigation, and featured product actions
│   │   │   ├── ProductPage.java              # Variant selection and add-to-cart actions
│   │   │   ├── CartPage.java                 # Quantity updates, item removal, and checkout trigger
│   │   │   └── CheckoutPage.java             # Shipping, payment, and order confirmation flows
│   │   ├── utils/
│   │   │   ├── WaitUtils.java                # Explicit waits (visibility, clickability, presence, staleness)
│   │   │   ├── ExcelUtils.java               # Apache POI reader/writer for .xlsx test data sheets
│   │   │   ├── ScreenshotUtils.java          # Captures full/viewport screenshots on test failure
│   │   │   └── ExtentReportManager.java      # Initializes and manages Extent Reports instances & logs
│   │   └── api/
│   │       ├── ApiClient.java                # REST Assured request/response specifications & common HTTP helpers
│   │       └── Endpoints.java                # API endpoint paths and payload builders
│   └── test/
│       ├── java/com/ecommerce/
│       │   ├── base/
│       │   │   └── BaseTest.java             # TestNG @BeforeMethod / @AfterMethod setup & teardown
│       │   ├── listeners/
│       │   │   ├── TestListener.java         # TestNG ITestListener for logs, screenshots, and Extent status
│       │   │   └── RetryAnalyzer.java        # TestNG IRetryAnalyzer for flaky test retries
│       │   └── tests/
│       │       ├── ui/                       # UI test classes extending BaseTest
│       │       └── api/                      # REST Assured API test classes
│       └── resources/
│           ├── config/
│           │   └── config.properties         # Browser, base URL, timeouts, and environment settings
│           └── testdata/
│               └── TestData.xlsx             # Data-driven test cases for TestNG @DataProvider
├── reports/                                  # Generated Extent HTML reports & failure screenshots
├── testng.xml                                # TestNG suite & parallel execution configuration
├── pom.xml                                   # Maven dependencies (Selenium, TestNG, POI, Extent, REST Assured)
└── README.md




Key Design Decisions
Single Responsibility: DriverFactory handles browser instantiation (Chrome, Firefox, Edge), DriverManager isolates WebDriver instances per thread via ThreadLocal, and BaseTest manages TestNG setup/teardown.

Parallel Execution Ready: ThreadLocal<WebDriver> prevents thread collision during concurrent TestNG test runs.

Fail-Fast Configuration: Invalid or unsupported browser values in config.properties immediately throw an IllegalArgumentException.

Reports & Screenshots
Extent Reports: Generated automatically after each test run inside the /reports directory.

Failure Screenshots: Captured automatically on test failure via ScreenshotUtils and attached to the corresponding Extent Report entry.

Implementation Roadmap
[x] FrameworkConstants & ConfigLoader

[x] DriverFactory & DriverManager (ThreadLocal)

[ ] BaseTest (@BeforeMethod / @AfterMethod)

[ ] WaitUtils & Page Object classes (POM)

[ ] ExcelUtils (Apache POI) & TestNG @DataProvider

[ ] TestNG ITestListener & RetryAnalyzer

[ ] ScreenshotUtils & Extent Reports

[ ] REST Assured API utilities & tests
