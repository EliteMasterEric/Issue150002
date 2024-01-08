package test;

import java.util.concurrent.CompletableFuture;

public final class FabricDataGenerator /* extends DataGenerator */ {
    // private final ModContainer modContainer;
    private final boolean strictValidation;
    // private final FabricDataOutput fabricOutput;
    // private final CompletableFuture<RegistryWrapper.WrapperLookup>
    // registriesFuture;

    // @ApiStatus.Internal
    public FabricDataGenerator(boolean strictValidation) {
        // super(modContainer, "fabric", "fabric");
        this.strictValidation = strictValidation;
    }

    /**
     * Create a default {@link Pack} instance for generating a mod's data.
     */
    public Pack createPack() {
        return new Pack(strictValidation, "testModId");
    }

    /**
     * Represents a pack of generated data (i.e. data pack or resource pack).
     * Providers are added to a pack.
     */
    public final class Pack /* extends DataGenerator.Pack */ {
        private final boolean shouldRun;
        private final String name;

        private Pack(boolean shouldRun, String name) { // , FabricDataOutput output
            this.shouldRun = shouldRun;
            this.name = name;
        }

        public boolean shouldRun() {
            return shouldRun;
        }

        public String getName() {
            return name;
        }

        /**
         * Registers a constructor of {@link DataProvider} which takes a
         * {@link FabricDataOutput}.
         *
         * @return the {@link DataProvider}
         */
        public <T extends DataProvider> T addProvider(Factory<T> factory) {
            // super.addProvider(output -> factory.create((FabricDataOutput) output));
            return factory.create(new FabricDataOutput());
        }

        /**
         * Registers a constructor of {@link DataProvider} which takes a
         * {@link FabricDataOutput} and the registries.
         * This is used, for example, with
         * {@link net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider}.
         *
         * @return the {@link DataProvider}
         */
        public <T extends DataProvider> T addProvider(RegistryDependentFactory<T> factory) {
            // super.addProvider(output -> factory.create((FabricDataOutput) output, registriesFuture));
            return factory.create(new FabricDataOutput(), new CompletableFuture<String>());
        }

        /**
         * A factory of a data provider. This is usually the constructor.
         */
        @FunctionalInterface
        public interface Factory<T extends DataProvider> {
            T create(FabricDataOutput output);
        }

        /**
         * A factory of a data provider. This is usually the constructor.
         * The provider has access to the registries.
         */
        @FunctionalInterface
        public interface RegistryDependentFactory<T extends DataProvider> {
            T create(FabricDataOutput output, CompletableFuture<String> registriesFuture);
        }
    }
}