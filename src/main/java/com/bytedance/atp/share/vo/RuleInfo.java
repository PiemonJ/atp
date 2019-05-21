package com.bytedance.atp.share.vo;

import com.bytedance.atp.common.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RuleInfo {

    public String displayName;

    public Category category;

    public List<ScalarInfo> referenceScalars;
}
