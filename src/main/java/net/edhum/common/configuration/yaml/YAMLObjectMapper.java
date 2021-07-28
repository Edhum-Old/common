package net.edhum.common.configuration.yaml;

import net.edhum.common.configuration.ObjectMapper;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.CustomClassLoaderConstructor;

import java.io.InputStream;

public class YAMLObjectMapper implements ObjectMapper {

    @Override
    public <T> T load(Class<T> type, InputStream in) {
        Yaml yaml = new Yaml(new CustomClassLoaderConstructor(getClass().getClassLoader())); // https://stackoverflow.com/a/57730194

        return yaml.loadAs(in, type);
    }
}
