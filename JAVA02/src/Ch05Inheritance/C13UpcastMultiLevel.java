package Ch05Inheritance;

// =======================================
// 업캐스팅 연습 3
// 여러 단계 상속에서의 다운캐스팅
// =======================================

class Shape {
    void draw() {
        System.out.println("도형을 그립니다");
    }
}

class Circle extends Shape {
    void draw() {
        System.out.println("원을 그립니다");
    }

    void calculateArea() {
        System.out.println("원의 넓이를 계산합니다");
    }
}

class ColoredCircle extends Circle {
    void draw() {
        System.out.println("색칠된 원을 그립니다");
    }

    void applyColor() {
        System.out.println("원에 색을 칠합니다");
    }
}

public class C13UpcastMultiLevel {
    public static void main(String[] args) {
        System.out.println("=== 연습문제 3: 다중 레벨 ===");

        // 문제 ------
        // 1. ColoredCircle 인스턴스를 만들어 Shape 타입으로 업캐스팅함
        // 2. 업캐스팅된 참조로 draw() 를 호출함
        // 3. Shape -> Circle 로 다운캐스팅하고 calculateArea() 를 호출함
        // 4. Circle -> ColoredCircle 로 다운캐스팅하고 applyColor() 를 호출함
        // 5. 각 단계에서 접근 가능한 메서드를 확인함
        // 실행 결과 : 색칠된 원을 그립니다 / 원의 넓이를 계산합니다 / 원에 색을 칠합니다

        // 업캐스팅 : Shape 타입이라 draw() 만 접근 가능(실행은 가장 하위 ColoredCircle 의 draw)
        Shape up1 = new ColoredCircle();
        up1.draw();

        // 다운캐스팅 1 : Circle 타입이면 calculateArea() 까지 접근 가능
        Circle down1 = (Circle) up1;
        down1.calculateArea();

        // 다운캐스팅 2 : ColoredCircle 타입이면 applyColor() 까지 접근 가능
        ColoredCircle down2 = (ColoredCircle) down1;
        down2.applyColor();

    }
}
