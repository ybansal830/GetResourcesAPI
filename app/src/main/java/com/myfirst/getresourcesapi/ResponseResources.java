package com.myfirst.getresourcesapi;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseResources implements Serializable {

	@SerializedName("data")
	private DataResources data;

	@SerializedName("support")
	private SupportResources support;

	public DataResources getData(){
		return data;
	}

	public SupportResources getSupport(){
		return support;
	}
}