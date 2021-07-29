package net.edhum.common.message;

public interface MessageFactory {

    Message createMessage(MessagePath context);
}
