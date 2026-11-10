package Ch06IO;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

// =======================================
// REST API 호출 2
// 착한 가격 업소 공공데이터 JSON 변환
// =======================================

public class C11RestApi2 {

	public static void main(String[] args) throws IOException, InterruptedException  {
		// 요청 흐름 : 파라미터 지정 -> HttpRequest 만들기 -> HttpClient 로 보내 응답 받기 -> ObjectMapper 로 자바 객체 변환
		// 출처 : https://www.data.go.kr/data/15059414/openapi.do
		String url = "https://thegoodnight.daegu.go.kr/ajax/api/thegoodnight.html";
		String mode = "json";
		int item_count = 10;
		url += "?" + "mode=" + mode + "&item_count=" + item_count;
		
		HttpRequest request = HttpRequest
							  .newBuilder()
							  .uri(URI.create(url))
							  .GET()
							  .build();
		
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpResponse<String> response = 
		httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		// https://www.data.go.kr/data/15059414/openapi.do
		ObjectMapper mapper = new ObjectMapper();
		Root responseObject = mapper.readValue(response.body(), Root.class);
		System.out.println("status: " + responseObject.status);
		System.out.println("total: " + responseObject.total);
		responseObject.data.forEach(System.out::println);
	
	}
	// JSON 의 data 배열 한 항목에 해당하는 클래스
	private static class Datum{
	    public String num;
	    public String shop;
	    public String tel;
	    public String address;
	    public String offer;
	    public String facilities;
	    public String tag;
		@Override
		public String toString() {
			return "Datum [num=" + num + ", shop=" + shop + ", tel=" + tel + ", address=" + address + ", offer=" + offer
					+ ", facilities=" + facilities + ", tag=" + tag + "]";
		}
	}

	private static class Root{
	    public String status;
	    public String total;
	    public ArrayList<Datum> data;
	}

	
}
