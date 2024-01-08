# hxjvm-Issue11054

https://github.com/HaxeFoundation/haxe/issues/11054

**Build instructions:**

1. Build the extern JAR: `cd ./project; ./build.bat`
2. Build the Haxe project: `haxe ./compile.hxml`
3. Run the extern JAR to preview the expected output: `cd ./project/out; java test.TestClass`
4. Run the Haxe output JAR to see the erroneous output: `cd ./bin/java; java -jar Main.jar`

**Expected Output**
```
src/Main.hx:18: #1 succeeds.
src/Main.hx:28: #2 succeeds.
```

**Erroneous Output**
```
src/Main.hx:18: #1 succeeds.
src/Main.hx:30: #2 fails.
src/Main.hx:31: java.lang.ClassCastException: class haxe.root.Main$Closure_main_1 cannot be cast to class test.FabricDataGenerator$Pack$Factory (haxe.root.Main$Closure_main_1 and test.FabricDataGenerator$Pack$Factory are in unnamed module of loader 'app')
```
