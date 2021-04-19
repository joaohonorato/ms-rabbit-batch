package br.com.portobello.digital.partnerspurchaseorderbatch.domain.vos.leroy;

import java.time.LocalDateTime;

public class FilterVo {
    private LocalDateTime begin;
    private LocalDateTime end;
    private Integer offset;

    public FilterVo(LocalDateTime begin) {
        this.begin = begin;
    }

    public FilterVo(LocalDateTime begin, LocalDateTime end, Integer offset) {
        this.begin = begin;
        this.end = end;
        this.offset = offset;
    }

    public LocalDateTime getBegin() {
        return begin;
    }

    public void setBegin(LocalDateTime begin) {
        this.begin = begin;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "FilterVo{" +
                "begin=" + begin +
                ", end=" + end +
                ", offset=" + offset +
                '}';
    }
}
