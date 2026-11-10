package Ch06IO;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.util.UUID;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

// =======================================
// Jsoup
// 웹 페이지의 이미지를 찾아 내려받기
// =======================================

public class C09Jsoup {

	public static void main(String[] args) throws IOException {
		
		// Jsoup : HTML 을 가져와 CSS 선택자로 요소를 뽑는 크롤링 라이브러리 (jsoup-1.22.2.jar 필요)
		// userAgent : 브라우저인 척 보내는 값. F12 - Network - 아무 요청 - Headers 의 Request Headers 에서 user-agent 를 복사해 사용함
		Connection conn = Jsoup
						.connect("https://g-sa.koreaisacademy.com/")
						// F12 - Network - 아무거나 name클릭 - Headers에서 Request Headers 내부 user-agent

						.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/147.0.0.0 Safari/537.36")
						.timeout(0)
						.ignoreHttpErrors(true)
						.followRedirects(true)
						;

		// get() : 페이지를 가져와 DOM 객체(Document)로 돌려줌
		Document document = conn.get();
		//System.out.println(document);
		
		// getElementsByTag("img") : img 태그 요소만 추출
		Elements elements = document.getElementsByTag("img");
		System.out.println("총 img size: " + elements.size());
		
		elements.forEach((el)->{
			
			try {
	//			System.out.println(el);
				// src 속성을 읽어 이미지 주소를 만들고, 상대 경로면 사이트 주소를 앞에 붙여 URL 로 열어 파일로 저장함
				String img_url = el.getElementsByAttribute("src").attr("src");
				String img_path = "https://g-sa.koreaisacademy.com";
				if(!img_url.startsWith("http")) {
					img_path += img_url; 
					System.out.println(img_path);
				}
				
				URL url = (new URI(img_path)).toURL();
				
				InputStream in = url.openStream();
				BufferedInputStream bin = new BufferedInputStream(in);
				
				// 주소에 포함된 확장자를 찾아 저장 파일의 확장자로 사용함 (UUID 로 파일명을 겹치지 않게 만듦)
				String exten = null;
				
				if(img_url.contains(".png")) {
					exten = ".png";
				}else if (img_url.contains(".svg")) {
					exten = ".svg";
				}else if (img_url.contains(".gif")) {
					exten = ".gif";
				}else if (img_url.contains(".web")) {
					exten = ".web";
				}else if (img_url.contains(".jpg")) {
					exten = ".jpg";
				}
				
				OutputStream out = null;
				
				out = new FileOutputStream("C:\\IOTEST\\" + UUID.randomUUID()+exten);
				
				while(true) {
					int data = bin.read();
					if(data == -1)
						break;
					out.write((byte)data);
					out.flush();
				}
				out.close();
				bin.close();
				in.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}	
		});
	}

}
