package com.bytedance.atp.domain.model.group;

import com.bytedance.atp.domain.model.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupIdentifier extends ValueObject<GroupIdentifier> {

    public String gitlab;


    @Override
    protected boolean equalsCore(GroupIdentifier other) {
        return this.gitlab.equals(other.gitlab) ? true : false;
    }

    @Override
    protected int getHashCodeCore() {
        return 15681 * 13 + gitlab.hashCode();
    }
}
