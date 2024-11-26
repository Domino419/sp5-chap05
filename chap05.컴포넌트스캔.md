 chap 04.의존 자동 주입
 
1. 예제 프로젝트 준비 ( commit ) 
 3장에서 실습한 chap03 프로젝트에서 가져온 소스 파일 목록 
 - spring 패키지의 모든 자바 파일(.java) 
 - config 패키지의 AppCts.java
 - main 패키지의 MainForSpring

 패키지 명 일부 수정하고 나서 정상적으로 프로그램 실행 ok 


2.@Autowired 애노테이션을 이용한 의존 자동 주입 
 @Autowired 를 붙이면 자동주입기능을 사용하면 설정에 의존 객체를 명시하지 않아도 스프링이 필요한 의존 빈 객체를 찾아서 주입해준다.
 2-1.ChangePasswordService의 private MemberDao memberDao 에 애노테이션을 추가.
 2-2.AppCtx의 Bean 설정 부분에서 세터 메서드 ( setMemberDao()메서드 ) 를 이용해서 의존 객체를 주입하는 걸 주석 처리함.
>> @Autowired 애노태이션을 필드나 세터 메서드에 붙이면 스프링은 타입이 일치하는 빈 객체를 찾아서 주입한다.

2.1 일치하는 빈이 없는 경우 
@Autowired 애노태이션을 적용한 대상에 일치하는 빈이 없는 경우 익셉션 발생하면서 실행이 불가능함.
@Autowired 애노태이션을 붙인 주입 대상에 일치하는 빈이 두개 이상이면 ~~expected single matching bean but found 2' 
이라는 메시지가 발생하면서 에러 발생

3.@Qualifier 애노태이션을 이용한 의존 객체 선택 
자동 주입 가능한 빈이 두개 이상이면 @Qualifier을 이용해서 자동 주입 대상 빈을 한정할 수 있다.
@Qualifier은 @Bean 애노태이션을 붙인 빈 설정 메서드에서 사용이 가능하다. 
 ex) 
@Bean
@Qualifier("printer")   << 이런 식으로 ..


> 24.11.21 23:23
> 책따라서 실습을 하긴 하는데 뭔가 매끄럽게 안되는 느낌..
> 무슨 말인지 제대로 이해 안됨
> 맨 정신으로 chap 프로젝트 파일 싹 지우고 새로 실습해보자 
> 
> 
24.11.24 23:40
chap04 프로젝트 예제 소스로 덮어쓰기. 
프로젝트 실행 여부 확인 완료 
git에 현재 시점 프로젝트 내용 push 

24.11.25 00:12
상위하위 타입 관계와 자동주입하기.  (실습은 했는데.. 나중에 다시 찾아보기. 작동하는 게 아직 눈에 안 들어옴. ..
5.@autowired 애노테이션의 필수 여부.
@Autowired 애노테이션을 붙인 타입에 해당하는 빈이 존재하지 않으면 익셉션이 발생한다.
5-1) 자동 주입할 대상이 필수가 아닌 경우에는 	@Autowired 애노테이션의 required 속성을 false로 지정하는 방법 
에러 메시지 : No qualifying bean of type 'java.time.format.DateTimeFormatter' available: expected at least 1 bean which qualifies as autowire candidate. Dependency 
5-2) 스프링5 이상에서부터는 @Autowired(required = false) 를 하지 않고 자바 8의 Optional을 사용하는 방법 
자동 주입대상이 옵셔널인 경우 값이 없는 옵셔널을 인자로 전달하고(NPE 발생 X) 옵셔널을 사용하는 코드는
값 존재 여부에 따라 알맞게 의존 객체를 사용하면 된다.
5-3) @Nullable 애노테이션을 사용하는 방법 


에러 Exception in thread "main" java.util.UnknownFormatConversionException: Conversion = '/'
System.out.printf에서 회원정보 : 이메일 = %/s, 이름=%/s \n로 형식 지정자 잘못 넣어서 에러 

24.11.26 17:00
5-1.생성자 초기화와 필수 여부 지정 방식 동작 이해
@Autowired  ( required ="false") 이면 일치하지 않는 빈이 존재하지 않을 때 필드나 메서드에 null을 전달하지 않는다.
@@Nullable 을 사용하면 스프링 컨테이너가 의존 주입 대상이 존재하지 않을 때 null을 값으로 전달한다. 
일치하는 빈이 없을 때 값 할당 자체를 하지 않는 방법 = @Autowired  ( required ="false") 
일치하는 빈이 없을 때 값을 null로 할당하는 방법 = @@Nullable
매칭되는 빈이 없으면 값이 없는 Optional을 할당하는 방법 = 예시 setDateTimeFormatter(Optional<DateTimeFormatter> formatterOpt) 
 >> 기본 생성자에서 자동 주입 대상이 되는 필드를 초기화할 때 3가지 방법 중에 어느것을 해야 할지 주의해야 한다.


6
자동 주입과 명시적 의존 주입 간의 관계 



