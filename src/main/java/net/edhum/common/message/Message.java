package net.edhum.common.message;

import java.util.Map;

public interface Message {

    String getPath();

    Map<String, Object> getContext();
}