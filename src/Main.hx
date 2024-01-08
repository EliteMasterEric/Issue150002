package;

import test.FabricDataGenerator;
import test.FabricDataGenerator.FabricDataGenerator_Pack;
import test.DataProvider;
import test.FabricDataOutput;

class Main {
	public static function main():Void {
        var generator:FabricDataGenerator = new FabricDataGenerator(true);

        var pack:FabricDataGenerator_Pack = generator.createPack();

		try {
			pack.addProvider(function (output):DataProvider {
				return new CustomDataProvider(output);
			});
			trace('#1 succeeds.');
		} catch (e:Dynamic) {
			trace('#1 fails.');
			trace(e);
		}

		try {
			pack.addProvider(function (output) {
				return new CustomDataProvider(output);
			});
			trace('#2 succeeds.');
		} catch (e:Dynamic) {
			trace('#2 fails.');
			trace(e);
		}
	}
}

class CustomDataProvider implements DataProvider {
	var output:FabricDataOutput;
	public function new(output:FabricDataOutput) {
		this.output = output;
	}
}