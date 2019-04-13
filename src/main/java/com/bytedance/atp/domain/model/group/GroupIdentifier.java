package com.bytedance.atp.domain.model.group;

import com.bytedance.atp.domain.model.ValueObject;

public class GroupIdentifier extends ValueObject<GroupIdentifier> {

    public String groupName;

    public String creator;


    @Override
    protected boolean equalsCore(GroupIdentifier other) {
        return this.creator.equals(other.creator) && this.groupName.equals(other.groupName)
            ? true
            : false;
    }

    @Override
    protected int getHashCodeCore() {
        return 0;
    }
}
