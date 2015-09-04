package mbanje.kurt.todo;

import ckm.simple.sql_provider.UpgradeScript;
import ckm.simple.sql_provider.annotation.ProviderConfig;
import ckm.simple.sql_provider.annotation.SimpleSQLConfig;

/**
 * Created by kurt on 2015/09/04.
 */
@SimpleSQLConfig(
        name = TodoProviderConfig.PROVIDER_CLASS,
        authority = "mbanje.kurt.todo.debug",
        database = "test.db",
        version = 1)
public class TodoProviderConfig implements ProviderConfig {
    public static final String PROVIDER_CLASS = "TodoProvider";

    @Override
    public UpgradeScript[] getUpdateScripts() {
        return new UpgradeScript[0];
    }
}
