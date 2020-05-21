package com.products.app.repository;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.products.app.modal.Data;
import com.products.app.modal.Request;
import com.products.app.response.MessagesResponse;

@Repository
public class NewsDaoImpl implements NewsDao {

	@Value("${static-api}")
	private String url;

	@Value("${static-api-key}")
	private String apiKey;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Data getData(Request request) throws MessagesResponse {

		String country = request.getCountry();
		String category = request.getCategory();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Data> entity = new HttpEntity<Data>(headers);

		Data data = new Data();
		String uri = url + "?";

		if (country != null && category != null) {
			uri += "apiKey=" + apiKey + "&country=" + country + "&category=" + category + "";
		} else if (category == null && country != null) {
			uri += "country=" + country + "&apiKey=" + apiKey + "";
		}
		System.out.println(uri);
		try {
			Data jsondata = restTemplate.exchange(uri, HttpMethod.GET, entity, Data.class).getBody();

			if (jsondata.getStatus().equals("ok")
					&& (jsondata.getTotalResults() != 0 && jsondata.getTotalResults() != null)) {
				jsondata.setStatus("200");
				data = jsondata;
			}
		} catch (Exception e) {
			throw new MessagesResponse("Somthing went wrong");
		}
		return data;
	}
}
