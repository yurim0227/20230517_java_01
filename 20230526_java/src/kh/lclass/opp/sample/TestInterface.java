package kh.lclass.opp.sample;

import java.awt.im.spi.InputMethod;
import java.io.Serializable;

public /* abstract class */ interface TestInterface extends /* InputMethod, */ Serializable {
	int MAXCNT = 10;
	public final int MAXCNT2 = 10; 
	public /* abstract */ void method1();	// 능력단위별 평가보기
	public /* abstract */ String method2();	// 평가안내
	public /* abstract */ int method3(int a, int b);	// 평가리뷰
//	public int method3();	// 평가리뷰
	
//	int insertBoard(Car vo);
//	int deleteBoard(Car vo);
//	int updateBoard(Car vo);
//	int selectOne(int boardNo);
//	Car[] selectList();
//	Car[] selectList(String searchWord);
//	List<Car> selectListList(String searchWord);
//	Car[] searchSelectBoard(String word);
}
