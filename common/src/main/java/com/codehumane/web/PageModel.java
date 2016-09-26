package com.codehumane.web;

import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;

import lombok.Getter;
import lombok.Setter;

/**
 * API에서 반환하는 페이징 형태의 데이터<br/>
 * Created by chogh on 9/25/16.
 */
@Setter
@Getter
public class PageModel<T> {

    private List<T> elements;
    private int elementsCount;
    private long totalElementsCount;
    private int totalPageCount;
    private boolean last;

    public <S> PageModel(Page<S> page, Converter<S, T> converter) {
        this(page.map(converter));
    }

    public PageModel(Page<T> page) {
        this.elements = page.getContent();
        this.elementsCount = page.getNumberOfElements();
        this.totalElementsCount = page.getTotalElements();
        this.totalPageCount = page.getTotalPages();
        this.last = page.isLast();
    }
}
