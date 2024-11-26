package spring;


/**
 * class         : MemberSummaryPrinter
 * date          : 2024-11-21 20:45
 * description   : 회원 정보를 요약하여 출력하는 기능을 제공하는 클래스.
 *                 MemberPrinter를 상속하여 특정 출력 형식을 재정의.
 */
public class MemberSummaryPrinter extends MemberPrinter {

    /**
     * method        : print
     * date          : 2024-11-21 20:45
     * param         : Member member - 출력할 회원 객체
     * return        : void
     * description   : 주어진 회원 객체의 이메일과 이름만 요약하여 출력.
     */
    @Override
    public void print(Member member){
        System.out.printf("회원정보 : 이메일 = %s, 이름=%s \n", member.getEmail() , member.getName());
    }
}


// [리스트 4.9] 118page