package net.edhum.common.command;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.name.Names;
import com.google.inject.throwingproviders.CheckedProvides;
import com.google.inject.throwingproviders.ThrowingProviderBinder;
import net.edhum.common.command.disabler.CommandDisabler;
import net.edhum.common.command.disabler.CommandDisablerImpl;
import net.edhum.common.command.disabler.list.DisabledCommandList;
import net.edhum.common.command.disabler.list.DisabledCommandListProvider;
import net.edhum.common.command.dispatcher.CommandDispatcher;
import net.edhum.common.command.dispatcher.CommandDispatcherImpl;
import net.edhum.common.command.execution.CommandExecutionHandler;
import net.edhum.common.command.execution.CommandExecutionHandlerImpl;
import net.edhum.common.command.execution.buffer.ArgumentBuffer;
import net.edhum.common.command.execution.buffer.ArgumentBufferFactory;
import net.edhum.common.command.execution.buffer.QueueArgumentBuffer;
import net.edhum.common.command.execution.result.CommandResultHandler;
import net.edhum.common.command.execution.result.LoggedCommandResultHandler;
import net.edhum.common.command.permission.CommandPermissionHandler;
import net.edhum.common.command.permission.CommandPermissionHandlerImpl;
import net.edhum.common.command.repository.CommandRepository;
import net.edhum.common.command.repository.PluginCachedCommandRepository;
import net.edhum.common.command.repository.filter.CommandNameFilter;
import net.edhum.common.command.repository.filter.CommandRepositoryFilterFactory;
import net.edhum.common.command.repository.filter.CommandSenderFilter;
import net.edhum.common.command.tab.CommandTabCompletionHandler;
import net.edhum.common.command.tab.CommandTabCompletionHandlerImpl;
import net.edhum.common.configuration.ObjectMapper;
import net.edhum.common.plugin.annotations.PluginDataFolder;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Predicate;

public class CommandModule extends AbstractModule {

    private static final String DISABLED_COMMANDS_FILE_NAME = "commands.yml";

    @Override
    protected void configure() {
        install(ThrowingProviderBinder.forModule(this));

        install(new FactoryModuleBuilder()
                .implement(new TypeLiteral<Predicate<CommandTree>>() {}, Names.named("sender"), CommandSenderFilter.class)
                .implement(new TypeLiteral<Predicate<CommandTree>>() {}, Names.named("name"), CommandNameFilter.class)
                .build(CommandRepositoryFilterFactory.class));

        install(new FactoryModuleBuilder()
                .implement(ArgumentBuffer.class, QueueArgumentBuffer.class)
                .build(ArgumentBufferFactory.class));

        bind(CommandDispatcher.class).to(CommandDispatcherImpl.class);

        bind(CommandExecutionHandler.class).to(CommandExecutionHandlerImpl.class);
        bind(CommandTabCompletionHandler.class).to(CommandTabCompletionHandlerImpl.class);

        bind(CommandPermissionHandler.class).to(CommandPermissionHandlerImpl.class);

        bind(CommandResultHandler.class).to(LoggedCommandResultHandler.class);

        bind(CommandDisabler.class).to(CommandDisablerImpl.class);

        bind(CommandRepository.class).to(PluginCachedCommandRepository.class).asEagerSingleton();

        Multibinder.newSetBinder(binder(), CommandTree.class); // Empty binder
    }

    @SuppressWarnings("BindingAnnotationWithoutInject")
    @CheckedProvides(DisabledCommandListProvider.class)
    public DisabledCommandList provideDisabledCommandSet(@PluginDataFolder Path dataFolder, ObjectMapper mapper) throws IOException {
        try (InputStream in = Files.newInputStream(dataFolder.resolve(DISABLED_COMMANDS_FILE_NAME))) {
            return mapper.load(DisabledCommandList.class, in);
        }
    }
}
