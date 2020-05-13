package org.jiage.srpc.server.apple;

import java.io.Serializable;
import java.util.List;

public class AppleKeys implements Serializable {

    private List<AppleKey> keys;

    public List<AppleKey> getKeys() {
        return keys;
    }

    public void setKeys(List<AppleKey> keys) {
        this.keys = keys;
    }
}
