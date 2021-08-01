package net.edhum.common.command.disabler.list;

import com.google.inject.throwingproviders.CheckedProvider;

import java.io.IOException;

public interface DisabledCommandListProvider extends CheckedProvider<DisabledCommandList> {

    @Override
    DisabledCommandList get() throws IOException;
}
