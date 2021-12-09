package com.ui;

import com.Trace.*;
import java.util.*;

public class UIService {
  public void UIServices() {
  }

  public void print(String string) {
    System.out.println(string);
  }

  public void saveTrace(String library, String method, String lookUpValue) {
    Trace trace = new Trace(library, method, lookUpValue, new Date());
    trace.guardarTraza();
  }
}
