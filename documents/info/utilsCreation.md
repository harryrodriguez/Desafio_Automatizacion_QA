Creation  "utils" classes
=

Create Props class
-

- Under the folder src > test > java  create a package named "Utils"
- Under this package, create a java class named "Props"
- Create two variables


    private Properties properties;

    //this is necessary to create a path for the env.properties where you select which browser and url you need 
    private final String propertyFilePath = System.getProperty("user.dir") + "/documents/env.properties";

- Create constructor


    public Props() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }


- Create a method to obtain the browser


    public String getNavegador() {
        String driverPath = properties.getProperty("BROWSER");
        if (driverPath != null) return driverPath;
        else
            throw new RuntimeException("Driver Path not specified in the Configuration.properties file for the Key:driverPath");
    }


- Create a method to obtain the url


    public String getRuta(String URL) {
        String env = properties.getProperty("ENV_URL");
        String url = properties.getProperty(URL);

        if (url != null) return env+url;
        else
            throw new RuntimeException("Driver Path not specified in the Configuration.properties file for the Key:driverPath");
    }



Create ReadJson class
-

- Under "documents" folder, create a folder named "data"
- Inside the folder "data", create a file with  .json files

- Under the package "utils", create a java class named "ReadJson"
- (optional)Create a variable with de path of .json files

      static String projectPath = System.getProperty("user.dir");

- add following dependencies


        <dependency>
            <groupId>org.json</groupId>
            <artifactId>json</artifactId>
            <version>20180130</version>
            <type>jar</type>
        </dependency>      
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.8.9</version>
        </dependency>

- Create a method wich return an specific value of json



    public static String readJson(String file, String val) throws IOException, ParseException {
        String value= null;
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader( "./documents/data/" + file + ".json");
        Object obj = parser.parse(reader);
        JSONObject json = (JSONObject) obj;
        value = (String) json.get(val);
        return value;

    }


