package com.twitter.common.checkstyle;

import com.puppycrawl.tools.checkstyle.api.Check;

/**
 * Utilities needed by custom checkstyle rules
 *
 * @author Utkarsh Srivastava
 */
public final class CheckStyleUtils {

  /**
   * Hide constructor
   */
  private CheckStyleUtils() {
  }

  /**
   * Returns the message bundle to use for a custom rule. All built-in rules in checkstyle have
   * a message bundle in the same package as that rule. This method returns the path to that
   * bundle.
   *
   * @param parentBuiltInCheckClass The class of the built-in checkstyle rule that the custom rule
   *                                ultimately derives from
   * @return Path to message bundle
   */
  public static String getMessageBundle(final Class<? extends Check> parentBuiltInCheckClass) {
    String parentBuiltInCheckClassName = parentBuiltInCheckClass.getName();
    // This code is copied from com.puppycrawl.tools.checkstyle.api.
    // AbstractViolationReporter.java::getMessageBundle(String s)
    // If that method were protected (and not package private) we could
    // just invoke it
    final int endIndex = parentBuiltInCheckClassName.lastIndexOf('.');
    final String messages = "messages";
    if (endIndex < 0) {
      return messages;
    }
    final String packageName = parentBuiltInCheckClassName.substring(0, endIndex);
    return packageName + "." + messages;
  }
}