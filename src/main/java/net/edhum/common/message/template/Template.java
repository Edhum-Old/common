package net.edhum.common.message.template;

import net.edhum.common.i18n.Language;
import net.edhum.common.message.Message;

public interface Template {

    String render(Message context, Language language) throws Exception;
}
