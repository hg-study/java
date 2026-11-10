package Ch04Collection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// =======================================
// Properties
// 설정 파일(application.properties) 읽기
// =======================================

// Properties ------
// Properties : 키=값 형태의 설정 파일을 읽고 쓰는 Map 계열 클래스
// load(스트림) : 파일 내용을 읽어 저장하고, getProperty(키) 로 값을 꺼냄
// DB 접속 정보처럼 코드에 직접 쓰기 어려운 값을 파일로 분리할 때 사용함

public class C08Properties {

	public static void main(String[] args) throws IOException {

		// 경로 구하기 ------
		// java.class.path : 컴파일된 클래스가 있는 경로, user.dir : 프로젝트 경로
		String classPath = System.getProperty("java.class.path");
		System.out.println("classPath: " + classPath);
		String dirPath = System.getProperty("user.dir");
		System.out.println("dirPath: " + dirPath);
		String packagePath = C08Properties.class.getPackageName();
		System.out.println("packagePath: " + packagePath);     // 패키지(폴더)명

		// File.separator : 운영체제별 경로 구분자(윈도우는 \)
		String filePath = dirPath + File.separator + "src" + File.separator +
						  packagePath + File.separator + "application.properties";
		System.out.println("filePath: " + filePath);

		FileInputStream fin = new FileInputStream(filePath);

		Properties properties = new Properties();
		properties.load(fin);

		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");

		System.out.println();
		System.out.printf("url: %s \nusername: %s \npassword: %s \n", url, username, password);
	}

}
