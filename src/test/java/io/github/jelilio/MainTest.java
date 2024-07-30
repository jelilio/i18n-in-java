package io.github.jelilio;

import io.github.jelilio.i18nresourcebundle.support.ReloadableResourceBundleMessageSource;
import io.github.jelilio.i18nresourcebundle.support.ResourceBundleMessageSource;
import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

  @Test
  public void testResourceBundle() {
    ResourceBundle resources =
        ResourceBundle.getBundle("messages", Locale.FRANCE);
    String greeting = resources.getString("greeting.hello");
    assertEquals("Bonjour le monde", greeting);

    String greetingUsername =
        MessageFormat.format(resources.getString("greeting.username"), "Ayo");
    assertEquals("Bonjour Ayo", greetingUsername);
  }

  @Test
  public void testResourceBundleMessageSource() {
    ResourceBundleMessageSource messageSource =
        new ResourceBundleMessageSource();
    messageSource.setBasenames("messages");

    String greeting = messageSource
        .getMessage("greeting.hello", null, Locale.FRANCE);
    assertEquals("Bonjour le monde", greeting);

    String greetingUsername = messageSource
        .getMessage("greeting.username", new String[]{"Ayo"}, Locale.FRANCE);
    assertEquals("Bonjour Ayo", greetingUsername);
  }

  @Test
  public void testReloadableResourceBundleMessageSource() {
    ReloadableResourceBundleMessageSource messageSource =
        new ReloadableResourceBundleMessageSource();
    messageSource.setBasenames("messages");

    String greeting = messageSource
        .getMessage("greeting.hello", null, Locale.FRANCE);
    assertEquals("Bonjour le monde", greeting);

    String greetingUsername = messageSource
        .getMessage("greeting.username", new String[]{"Ayo"}, Locale.FRANCE);
    assertEquals("Bonjour Ayo", greetingUsername);
  }
}
