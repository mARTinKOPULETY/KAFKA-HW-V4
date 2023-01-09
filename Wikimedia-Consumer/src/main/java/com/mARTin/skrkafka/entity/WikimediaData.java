package com.mARTin.skrkafka.entity;


public class WikimediaData {
    private Long originalId;
    private String wikiEventData;

    public WikimediaData(Long  originalId, String wikiEventData) {
        this.originalId = originalId;
        this.wikiEventData = wikiEventData;
    }

    public Long getOriginalId() {
        return originalId;
    }

    public void setOriginalId(Long originalId) {
        this.originalId = originalId;
    }

    public String getWikiEventData() {
        return wikiEventData;
    }

    public void setWikiEventData(String wikiEventData) {
        this.wikiEventData = wikiEventData;
    }

    @Override
    public String toString() {
        return "WikimediaData{" + "id=" + originalId
                + ", wikiEventData='" + wikiEventData + '\'' + '}';
    }
}
