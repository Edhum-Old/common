package net.edhum.common.command.execution.buffer;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueArgumentBuffer implements ArgumentBuffer {

    private final LinkedBlockingQueue<Object> arguments;

    @AssistedInject
    public QueueArgumentBuffer(@Assisted List<Object> arguments) {
        this.arguments = new LinkedBlockingQueue<>();

        for (Object argument : arguments) {
            this.addArgument(argument);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T readArgument() {
        if (this.arguments.isEmpty()) {
            throw new NoSuchElementException();
        }

        return (T) this.arguments.poll();
    }

    @Override
    public <T> Optional<T> readOptionalArgument() {
        Optional<T> optionalArg = Optional.empty();

        if (!this.arguments.isEmpty()) {
            optionalArg = Optional.of(this.readArgument());
        }

        return optionalArg;
    }

    private void addArgument(Object argument) {
        this.arguments.offer(argument);
    }
}
