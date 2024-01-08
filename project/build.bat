REM Build all the Java files in the src/ folder into the out/ folder
javac -d out src/test/TestClass.java src/test/DataProvider.java src/test/MyDataProvider.java src/test/FabricDataOutput.java src/test/FabricDataGenerator.java
REM Create a JAR file from the compiled classes
cd out/
jar cf project.jar test/TestClass.class test/DataProvider.class test/MyDataProvider.class test/FabricDataOutput.class test/FabricDataGenerator.class test/FabricDataGenerator$Pack.class test/FabricDataGenerator$Pack$Factory.class test/FabricDataGenerator$Pack$RegistryDependentFactory.class
