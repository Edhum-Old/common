package net.edhum.common.command.execution.buffer;

import java.util.List;

public interface ArgumentBufferFactory {

    ArgumentBuffer createArgumentBuffer(List<Object> arguments);
}
