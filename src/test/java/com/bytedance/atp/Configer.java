package com.bytedance.atp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 配置
 *
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Configer {

    ConfigItem item;

    ConfigValue value;

}
