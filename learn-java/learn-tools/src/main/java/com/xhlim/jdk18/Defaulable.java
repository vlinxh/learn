package com.xhlim.jdk18;

import java.util.function.Supplier;

/**
 * 接口允许默认方法，实现类可以覆盖，也可以不覆盖
 *
 * @author xhlim@outlook.com
 * @create 2017-09-13 14:31
 */
public interface Defaulable {

    default String noRequirep() {
        return "Default implementation";
    }

    public static class DefaultableImpl implements Defaulable {

    }

    public static class OverridableImpl implements Defaulable {

        @Override
        public String noRequirep() {
            return "OverridableImpl implementation";
        }
    }

    public interface DefaulableFactory {

        static Defaulable create(Supplier<Defaulable> supplier) {
            return supplier.get();
        }
    }

}
