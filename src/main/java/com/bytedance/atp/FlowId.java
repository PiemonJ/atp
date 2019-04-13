package com.bytedance.atp;

import lombok.AllArgsConstructor;
import lombok.Setter;

/**
 * Flow是一个Runtime概念
 * 顾名思义，我们设置了一个测试流程，那么测试流程就是一个静态概念，只有当其执行时，它才是一个Flow
 * 一个测试流程可以有多个Flow
 */
@Setter
@AllArgsConstructor
public class FlowId {

    String id;
}
