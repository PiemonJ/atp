package com.bytedance.atp.domain.model.group;

import com.bytedance.atp.domain.model.ValueObject;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GroupIdentifier extends ValueObject<GroupIdentifier> {

    public String groupName;

    public String creator;


    public GroupIdentifier copyCreator(String groupName){
        if (groupName.equals(groupName)){
            return this;
        }
        return new GroupIdentifier(groupName,creator);
    }


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
