package test;

public class TestClass {
    public static void main(String[] args) {
        FabricDataGenerator generator = new FabricDataGenerator(true);

        FabricDataGenerator.Pack pack = generator.createPack();

        System.out.println(pack.shouldRun());
        System.out.println(pack.getName());

        DataProvider result = pack.addProvider((output) -> {
            return new MyDataProvider(output);
        });

        System.out.println(result);
    }
}
