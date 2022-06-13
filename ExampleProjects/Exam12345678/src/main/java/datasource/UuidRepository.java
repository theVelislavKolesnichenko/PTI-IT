package datasource;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class UuidRepository {
    private Set<UUID> uuids;
    private static UuidRepository instance;

    private UuidRepository() {
        this.uuids = new HashSet<>();
    }

    public static UuidRepository getInstance() {
        if (instance == null) {
            instance = new UuidRepository();
        }
        return instance;
    }

    public String crate() {
        UUID uuid = UUID.randomUUID();
        uuids.add(uuid);
        return uuid.toString();
    }

    public void remove(String value) {
        if (exist(value)) {
            uuids.remove(UUID.fromString(value));
        }

    }


    public boolean exist(String value) {
        return uuids.contains(UUID.fromString(value));
    }
}
