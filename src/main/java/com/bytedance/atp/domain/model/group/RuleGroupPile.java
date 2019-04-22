package com.bytedance.atp.domain.model.group;

import com.bytedance.atp.common.Category;
import com.bytedance.atp.common.Rule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RuleGroupPile {

    public String gitlab;

    public Category category;

    public List<Rule> rules;
}
