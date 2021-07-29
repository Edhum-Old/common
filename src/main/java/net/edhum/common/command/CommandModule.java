package net.edhum.common.command;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.throwingproviders.ThrowingProviderBinder;
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
import net.edhum.common.command.tab.CommandTabCompletionHandler;
import net.edhum.common.command.tab.CommandTabCompletionHandlerImpl;

public class CommandModule extends AbstractModule {

    @Override
    protected void configure() {
        install(ThrowingProviderBinder.forModule(this));

        install(new FactoryModuleBuilder()
                .implement(ArgumentBuffer.class, QueueArgumentBuffer.class)
                .build(ArgumentBufferFactory.class));

        bind(CommandDispatcher.class).to(CommandDispatcherImpl.class);

        bind(CommandExecutionHandler.class).to(CommandExecutionHandlerImpl.class);
        bind(CommandTabCompletionHandler.class).to(CommandTabCompletionHandlerImpl.class);

        bind(CommandPermissionHandler.class).to(CommandPermissionHandlerImpl.class);

        bind(CommandResultHandler.class).to(LoggedCommandResultHandler.class);

        bind(CommandRepository.class).to(PluginCachedCommandRepository.class).asEagerSingleton();
    }
}
