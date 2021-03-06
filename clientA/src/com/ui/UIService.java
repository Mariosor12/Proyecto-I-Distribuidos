package com.ui;

import com.trace.*;
import java.util.*;

public class UIService {
  public void UIServices() {
  }

  public void print(String string) {
    System.out.println(string);
  }

  public void saveTrace(String library, String method, String lookUpValue) {
    Trace trace = new Trace(library, method, lookUpValue, new Date());
    trace.saveTrace();
  }

  public String getLookUpValue(String command) {
    String[] commandList = command.split(" ");
    int commandListLength = commandList.length;

    String[] lookUpValueList = Arrays.copyOfRange(commandList, 2, commandListLength);
    String lookUpValue = String.join(" ", lookUpValueList);

    return lookUpValue;
  }
}
