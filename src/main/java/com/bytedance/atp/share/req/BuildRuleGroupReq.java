package com.bytedance.atp.share.req;

import com.bytedance.atp.common.Rule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildRuleGroupReq implements Serializable {

    public String creator;

    public String groupName;

    public String gitlab;

    List<Rule> rules;
}
