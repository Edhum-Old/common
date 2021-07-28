package net.edhum.common.plugin;

import com.google.inject.Module;
import com.google.inject.Stage;

import java.util.Collection;

public interface ModularPlugin {

    Collection<Module> getModules();

    Stage getStage();
}
