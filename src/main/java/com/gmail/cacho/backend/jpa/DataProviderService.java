package com.gmail.cacho.backend.jpa;

import java.util.List;

public interface DataProviderService<T, F> {

    List<T> fetch(int offset, int limit, List<SortOrder> sortBy, F filter);

    int count(F filter);
}
