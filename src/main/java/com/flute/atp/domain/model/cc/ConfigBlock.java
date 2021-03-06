package com.flute.atp.domain.model.cc;

import com.flute.atp.common.Category;
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
