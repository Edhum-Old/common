package net.edhum.common.plugin;

import com.google.inject.Module;
import com.google.inject.Stage;

import java.util.Collection;
import java.util.Collections;

public interface ModularPlugin {

    default Collection<Module> getModules() {
        return Collections.emptyList();
    }

    Stage getStage();
}
