package test;

public class MyDataProvider implements DataProvider {
    private final FabricDataOutput output;

    public MyDataProvider(FabricDataOutput output) {
        this.output = output;
    }

    public String toString() {
        return "MyDataProvider(output=" + this.output + ")";
    }
}
