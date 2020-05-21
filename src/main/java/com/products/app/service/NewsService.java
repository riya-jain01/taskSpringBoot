package com.products.app.service;

import com.products.app.modal.Data;
import com.products.app.modal.Request;
import com.products.app.response.MessagesResponse;

public interface NewsService {
	Data getData(Request request) throws MessagesResponse;
}
