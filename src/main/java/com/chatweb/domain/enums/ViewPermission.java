package com.chatweb.domain.enums;

public enum ViewPermission
{
    // 因为已经定义了带参数的构造器，所以在列出枚举值时必须传入对应的参数 public login private
    PUBLIC(0L), LOGIN(1L), PRIVATE(2L);

    // 定义一个 private 修饰的实例变量
    private Long value;

    // 定义一个带参数的构造器，枚举类的构造器只能使用 private
    ViewPermission(Long value) {
        this.value = value;
    }

    // 定义 get  方法
    public Long getValue() {
        return value;
    }

}
