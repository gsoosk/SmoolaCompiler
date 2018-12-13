package main.Tools;

import java.util.ArrayList;

/**
 * TypeChecker
 */
public class TypeChecker {

  public static boolean isSubtypeOf(String type, String parent) {
    ArrayList<String> children = HashMaker.getClassesTree().get(parent);
    if (children.contains(type)) {
      return true;
    } else {
      boolean contain = false;
      for (String child : children) {
        if (isSubtypeOf(type, child)) {
          contain = true;
          break;
        }
      }
      return contain;
    }
  }

  static boolean checkWriteArgument() {

  }
}