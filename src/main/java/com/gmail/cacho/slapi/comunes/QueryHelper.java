package com.gmail.cacho.slapi.comunes;

import com.vaadin.flow.data.provider.QuerySortOrder;
import com.vaadin.flow.data.provider.SortDirection;
import org.apache.deltaspike.data.api.QueryResult;

import java.util.List;

public class QueryHelper {
    public static <T> QueryResult<T> applyLimitsAndSortOrder(QueryResult<T> result, int offset, int limit,
                                                             List<QuerySortOrder> sortOrders) {
        QueryResult<T> queryResult = applyLimits(result, offset, limit);
        return applySortOrder(queryResult, sortOrders);
    }

    public static <T> QueryResult<T> applyLimits(QueryResult<T> result, int offset, int limit) {
        return result.firstResult(offset).maxResults(limit);
    }

    public static <T> QueryResult<T> applySortOrder(QueryResult<T> result, List<QuerySortOrder> sortOrders) {
        QueryResult<T> queryResult = result;
        for (QuerySortOrder sortOrder : sortOrders) {
            if (sortOrder.getDirection() == SortDirection.ASCENDING) {
                queryResult = queryResult.orderAsc(sortOrder.getSorted());
            } else {
                queryResult = queryResult.orderDesc(sortOrder.getSorted());
            }
        }

        return queryResult;
    }
}
