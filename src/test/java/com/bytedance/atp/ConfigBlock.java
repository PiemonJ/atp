package com.bytedance.atp;

import com.bytedance.atp.domain.model.common.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfigBlock {

    public Category category;

    public List<Configer> configers;
}
