package Ch06IO;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

// =======================================
// REST API 호출
// HttpClient 로 요청하고 Jackson 으로 JSON 을 자바 객체로 변환
// =======================================

public class C11RestApi {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		// 요청 주소에 붙일 파라미터 지정 ------
		// https://www.daegufood.go.kr/kor/api/tasty.html?mode=json&addr=%EC%A4%91%EA%B5%AC
		// REST API : 주소와 파라미터로 요청하면 JSON 으로 응답하는 서비스. 대구 맛집 공공데이터를 사용함
		String url = "https://www.daegufood.go.kr/kor/api/tasty.html";
		String mode = "json";
		String addr = "중구";
		url += "?" + "mode=" + mode + "&addr=" + addr;
		
		// HTTP 요청 만들기 ------
		// HttpRequest : 요청 정보(주소, 방식 GET)를 담은 객체
		HttpRequest request = HttpRequest
							  .newBuilder()
							  .uri(URI.create(url))
							  .GET()
							  .build();
		
		// 요청을 보내고 응답 받기 ------
		// HttpClient.send : 요청을 보내고 응답(HttpResponse)을 받음
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpResponse<String> response = 
		httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		
//		System.out.println(response.body());
		
		
		// ObjectMapper : Jackson 의 JSON 변환기. readTree 는 JSON 구조를 그대로 읽고, readValue 는 자바 클래스로 변환함
		ObjectMapper mapper = new ObjectMapper();
//		
//		JsonNode jsonNode = mapper.readTree(response.body());
//		System.out.println("status: " + jsonNode.get("status"));
//		System.out.println("total: " + jsonNode.get("total"));
//		
//		JsonNode data = jsonNode.get("data");
//		for(int i=0; i<data.size(); i++) {
//			JsonNode item = data.get(i);
//			System.out.println(item.get("BZ_NM"));
//		}
		
		// JSON 구조에 맞는 클래스(Root, Datum)로 변환. @JsonProperty 는 JSON 키와 필드 이름이 다를 때 연결함
		Root responseObject = mapper.readValue(response.body(), Root.class);
		System.out.println("status: " + responseObject.status);
		System.out.println("total: " + responseObject.total);
		responseObject.data.forEach(System.out::println);

	}
	private static class Datum{
	    public String cnt;
	    @JsonProperty("OPENDATA_ID") 
	    public String oPENDATA_ID;
	    @JsonProperty("GNG_CS") 
	    public String gNG_CS;
	    @JsonProperty("FD_CS") 
	    public String fD_CS;
	    @JsonProperty("BZ_NM") 
	    public String bZ_NM;
	    @JsonProperty("TLNO") 
	    public String tLNO;
	    @JsonProperty("MBZ_HR") 
	    public String mBZ_HR;
	    @JsonProperty("SEAT_CNT") 
	    public String sEAT_CNT;
	    @JsonProperty("PKPL") 
	    public String pKPL;
	    @JsonProperty("HP") 
	    public String hP;
	    @JsonProperty("PSB_FRN") 
	    public String pSB_FRN;
	    @JsonProperty("BKN_YN") 
	    public String bKN_YN;
	    @JsonProperty("INFN_FCL") 
	    public String iNFN_FCL;
	    @JsonProperty("BRFT_YN") 
	    public String bRFT_YN;
	    @JsonProperty("DSSRT_YN") 
	    public String dSSRT_YN;
	    @JsonProperty("MNU") 
	    public String mNU;
	    @JsonProperty("SMPL_DESC") 
	    public String sMPL_DESC;
	    @JsonProperty("SBW") 
	    public String sBW;
	    @JsonProperty("BUS") 
	    public String bUS;
		@Override
		public String toString() {
			return "Datum [cnt=" + cnt + ", oPENDATA_ID=" + oPENDATA_ID + ", gNG_CS=" + gNG_CS + ", fD_CS=" + fD_CS
					+ ", bZ_NM=" + bZ_NM + ", tLNO=" + tLNO + ", mBZ_HR=" + mBZ_HR + ", sEAT_CNT=" + sEAT_CNT
					+ ", pKPL=" + pKPL + ", hP=" + hP + ", pSB_FRN=" + pSB_FRN + ", bKN_YN=" + bKN_YN + ", iNFN_FCL="
					+ iNFN_FCL + ", bRFT_YN=" + bRFT_YN + ", dSSRT_YN=" + dSSRT_YN + ", mNU=" + mNU + ", sMPL_DESC="
					+ sMPL_DESC + ", sBW=" + sBW + ", bUS=" + bUS + "]";
		}
	    
	    
	}

	private static class Root{
	    public String status;
	    public String total;
	    public ArrayList<Datum> data;
	}

	
	
	
}
