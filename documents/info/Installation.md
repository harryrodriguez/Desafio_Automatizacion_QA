PRE-REQUISITOS
=
- <a href="https://java.com/en/download/manual.jsp" target="_blank">JAVA</a>
- <a href="https://www.jetbrains.com/es-es/idea/download/#section=windows" target="_blank">IntelliJ</a>


First Steps and Configurations
-
- Install Java and create the environment variables
- Install IntelliJ and create a Maven project
- Go to File-> Settings-> Plugins and Install "Cucumber for java"
- Go to pom.xml and add dependencies

-- Cucumber dependencies

            <dependency>
                    <groupId>info.cukes</groupId>
                    <artifactId>cucumber-java</artifactId>
                    <version>1.2.5</version>
            </dependency>
            <dependency>
                <groupId>info.cukes</groupId>
                <artifactId>cucumber-java</artifactId>
                <version>1.2.5</version>
                <scope>test</scope>
            </dependency>
            <dependency>
                <groupId>com.aventstack</groupId>
                <artifactId>extentreports</artifactId>
                <version>4.0.9</version>
            </dependency>


-- Cucumber-junit dependencies

		<dependency>
			<groupId>info.cukes</groupId>
			<artifactId>cucumber-junit</artifactId>
			<version>1.2.5</version>
		</dependency>

-- Junit dependencies

            <dependency>
                <groupId>junit</groupId>
                <artifactId>junit</artifactId>
                <version>4.13.1</version>
            </dependency>

-- Selenium-webdriver dependencies

        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.1.2</version>
        </dependency>


