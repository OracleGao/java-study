package org.pplm.jfp.base;

import java.util.stream.Stream;

public interface Performance {
    public String getName();

    public Stream<Artist> getMusicians();
}
