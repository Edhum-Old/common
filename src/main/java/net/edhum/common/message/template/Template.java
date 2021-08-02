package net.edhum.common.message.template;

import net.edhum.common.i18n.Language;
import net.edhum.common.message.MessagePath;

public interface Template {

    String render(MessagePath context, Language language) throws Exception;
}
