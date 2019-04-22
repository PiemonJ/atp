package com.bytedance.atp.domain.model.group;

import com.bytedance.atp.domain.model.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupMetaData extends ValueObject<GroupMetaData> {

    public String ruleGroupName;

    public String creator;

    public Date createTime;

    @Override
    protected boolean equalsCore(GroupMetaData other) {

        return ruleGroupName.equals(other) && creator.equals(other.creator) && createTime.equals(other.createTime);

    }

    @Override
    protected int getHashCodeCore() {
        return 15687 * 13
                + ruleGroupName.hashCode()
                + creator.hashCode()
                + createTime.hashCode();
    }
}
