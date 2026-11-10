package Ch20StarCraft.building;

// =======================================
// 비행 인터페이스
// 날 수 있는 건물이 구현할 동작
// =======================================

// 날 수 있는 능력을 인터페이스로 분리함. 건물 상속과 함께 여러 개를 구현할 수 있음
public interface ICanFly {
	public void Move();
	public void Land();
	public void Fly();
}
