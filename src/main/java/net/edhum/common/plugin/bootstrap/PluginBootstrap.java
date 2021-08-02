package net.edhum.common.plugin.bootstrap;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import net.edhum.common.plugin.ModularPlugin;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class PluginBootstrap {

    public Injector bootstrap(ModularPlugin plugin, Module... modules) {
        return Guice.createInjector(plugin.getStage(), Stream.of(
                        Stream.of((Module) new CommonModule()),
                        Arrays.stream(modules),
                        plugin.getModules().stream())
                .flatMap(Function.identity())
                .toList());
    }
}
