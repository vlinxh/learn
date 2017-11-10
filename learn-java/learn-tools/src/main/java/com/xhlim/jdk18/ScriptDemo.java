package com.xhlim.jdk18;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author xhlim@outlook.com
 * @create 2017-09-17 13:56
 */
public class ScriptDemo {


    public static void script() throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        System.out.println(engine.getClass().getName());
        System.out.println("Result:" + engine.eval("function f() { return 10; }; f() + 1;"));

    }

    public static void main(String[] args) throws ScriptException {
        script();
    }
}
