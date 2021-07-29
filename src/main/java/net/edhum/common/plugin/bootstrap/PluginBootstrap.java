package net.edhum.common.plugin.bootstrap;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import net.edhum.common.plugin.ModularPlugin;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PluginBootstrap {

    public Injector bootstrap(ModularPlugin plugin, Module environmentModule) {
        return Guice.createInjector(plugin.getStage(),
                Stream.concat(
                        Stream.of(new CommonModule(), environmentModule),
                        plugin.getModules().stream()
                ).collect(Collectors.toList()));
    }
}
