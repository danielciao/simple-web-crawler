package com.danielc.web.crawler.collector;

import com.google.common.collect.Lists;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class NonEmptyCollectorTest {

  private NonEmptyCollector candidate = new NonEmptyCollector();

  @Test
  public void shouldHandleInvalidInputs() {
    assertThat(candidate.collect(null), is(nullValue()));
    assertThat(candidate.collect(Lists.newArrayList()), is(Lists.newArrayList()));
  }

  @Test
  public void shouldCollectNonEmptyStrings() {
    assertThat(candidate.collect(
      Lists.newArrayList(
        "",
        "  ",
        "test",
        "test this",
        "what-about-this",
        "what-about-line-break\n"
      )),

      is(Lists.newArrayList(
        "test",
        "test this",
        "what-about-this",
        "what-about-line-break\n"
      ))
    );
  }

}
