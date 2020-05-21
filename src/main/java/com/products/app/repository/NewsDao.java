package com.products.app.repository;

import com.products.app.modal.Data;
import com.products.app.modal.Request;
import com.products.app.response.MessagesResponse;

public interface NewsDao {
	public Data getData(Request request) throws MessagesResponse;
}
