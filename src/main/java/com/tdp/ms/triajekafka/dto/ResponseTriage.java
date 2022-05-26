package com.tdp.ms.triajekafka.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseTriage {
	
	@JsonProperty("header")
    private Header header;
    @JsonProperty("content")
    private String content;
    
	public Header getHeader() {
		return header;
	}
	public void setHeader(Header header) {
		this.header = header;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
    
    
}
