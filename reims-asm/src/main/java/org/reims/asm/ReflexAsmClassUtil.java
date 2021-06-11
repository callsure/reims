package org.reims.asm;

/**
 * 2021/6/10
 * Created by runshu.lin
 */
public class ReflexAsmClassUtil {

    private static final String REIMS_PACKAGE_NAME = "org.reims.";

    public static String rebuildClassName(String className) {
        if (!className.startsWith(REIMS_PACKAGE_NAME)) {
            className = REIMS_PACKAGE_NAME + className;
        }
        return className;
    }
}
