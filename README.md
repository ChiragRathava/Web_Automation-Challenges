# Web Automation Challenges 🚀

A comprehensive Selenium WebDriver automation framework implementing 5 web automation challenges using Java, TestNG, and modern automation practices.

## 🎯 Overview

This project demonstrates Selenium WebDriver automation through real-world challenges. Development follows a two-phase approach:
1. **Phase 1**: Single-file solutions (Challenge_1.java, Challenge_2.java, etc.)
2. **Phase 2**: Refactored into structured framework with POM pattern

## 🛠 Technologies Used

- **Java 8+** | **Selenium WebDriver** | **TestNG** | **Maven**
- **AssertJ** | **Allure Reports** | **Page Object Model**
- **Thread Local** | **Apache POI** | **SonarLint**

## 📁 Project Structure

```
Web_Automation-Challenges/
├── src/test/java/com/ChiragRathava/
│   ├── base/          # Base test classes
│   ├── pages/         # Page Object Models
│   ├── tests/         # Test classes
│   └── utils/         # Utility classes
├── resources/         # Configuration files
├── Challenge_1.java   # Single-file solution for Challenge 1
├── Challenge_2.java   # Single-file solution for Challenge 2
├── Challenge_3.java   # Single-file solution for Challenge 3
└── Challenge_4.java   # Single-file solution for Challenge 4
```

## 🎪 Challenges Overview

| Challenge | Description | Target Site | Key Features |
|-----------|-------------|-------------|--------------|
| **Challenge 1** | Financial Calculation | [demo.applitools.com](https://demo.applitools.com) | Login automation, Table parsing, Amount calculation (verify 1996.22) |
| **Challenge 2** | Web Tables Verification | [demoqa.com/webtables](https://demoqa.com/webtables) | Edit table rows, Add new entries, Generic locators |
| **Challenge 3** | Modal Dialog Testing | [demoqa.com/modal-dialogs](https://demoqa.com/modal-dialogs) | Modal interactions, Content verification |
| **Challenge 4** | Parallel Browser Testing | [app.vwo.com](https://app.vwo.com/) | Multi-browser login, Dashboard verification, Parallel execution |
| **Challenge 5** | Advanced Interactions | [VWO Heatmap](https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1) | Iframe/Multi-window handling, Action class, Heatmap clicks |

> **Advanced Framework Implementation**: For Challenge 5 and advanced framework features, check out: [Selenium_AdvanceFramework](https://github.com/ChiragRathava/Selenium_AdvanceFramework)

## 🚀 Quick Start

### Prerequisites
- Java 8+ | Maven 3.6+ | Chrome/Firefox browsers

### Installation
```bash
git clone <your-repository-url>
cd Web_Automation-Challenges
mvn clean install
```

## 🏃‍♂️ Running Tests

### Single-File Solutions (Phase 1)
```bash
mvn compile exec:java -Dexec.mainClass="Challenge_1"
mvn compile exec:java -Dexec.mainClass="Challenge_2"
mvn compile exec:java -Dexec.mainClass="Challenge_3"
mvn compile exec:java -Dexec.mainClass="Challenge_4"
```

### Framework Tests (Phase 2)
```bash
mvn test -Dtest=TableColumnSumTest_Challenge1      # Challenge 1
mvn test -Dtest=WebTablesTest_Challenge2           # Challenge 2
mvn test -Dtest=content_of_theModel_Challenge3     # Challenge 3
mvn test -Dtest=ParallelExecute_Challenge4         # Challenge 4
```

### Run All Tests
```bash
mvn clean test                    # All framework tests
mvn test -DparallelMode=methods   # Parallel execution
```

## 📊 Reports

```bash
mvn allure:report    # Generate Allure report
mvn allure:serve     # Serve Allure report
```

## 🔄 Development Approach

### Why Two-Phase Implementation?
- ✅ **Rapid Prototyping**: Quick solution validation
- ✅ **Learning Focus**: Understand each challenge thoroughly
- ✅ **Iterative Enhancement**: Gradual improvement to framework
- ✅ **Best Practices**: Final implementation with proper architecture

### Framework Features
- **Thread Safety**: ThreadLocal WebDriver instances
- **Page Object Model**: Structured, maintainable code
- **Data-Driven**: Excel/Properties integration
- **Reporting**: Allure reports with screenshots
- **Parallel Execution**: Multi-browser support

## 🤝 Contributing

1. Fork repository
2. Create feature branch
3. Implement changes
4. Submit pull request

## 🔧 Troubleshooting

| Issue | Solution |
|-------|----------|
| WebDriver not found | Check WebDriverManager configuration |
| Element not found | Verify wait strategies and locators |
| Single-file execution | Ensure dependencies in classpath |
| Parallel execution | Check ThreadLocal implementation |

---

**Author**: Chirag Rathava | **Version**: 1.0 | **Last Updated**: August 2025

> 💡 **Tip**: Start with single-file solutions to understand the challenges, then explore the framework implementation for advanced features.