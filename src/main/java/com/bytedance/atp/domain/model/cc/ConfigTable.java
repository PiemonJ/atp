package com.bytedance.atp.domain.model.cc;

import com.bytedance.atp.common.Env;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfigTable {

    Env env;

    List<ConfigBlock> blocks;
}
