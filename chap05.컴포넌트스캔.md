Chapter5. 컴포넌트 스캔
1.@Component 애노테이션으로 스캔 대상 지정
2.@ComponentScan 애노테이션으로 스캔 설정
3.예제 실행 
4.스캔 대상에서 제외하거나 포함하기
4.1기본 스캔 대상
5.컴포넌트 스캔에 따른 충돌 처리
5.1 빈 이름 충돌
5.2 수동 등록한 빈과 충돌


2024.11.27 00:51
실습용 프로젝트 chap5 생성 후 프로젝트 기동 확인
git repogitory 생성 후 git 연결 


2024.11.27 21:54
MainForSpring에서 sample data sout 입력해둠

Chapter5. 컴포넌트 스캔

1.@Component 애노테이션으로 스캔 대상 지정
@Component 붙이기 완료 [리스트 5.1]   - 값을 주지 않는 경우 클래스 이름의 첫 글자를 소문자로 바꾸어 빈 이름으로 사용 
@Component("infoPrinter") 붙이기 완료 [리스트 5.2]  - 값을 주는 경우 해당 값을 빈 이름으로 사용 

2.@ComponentScan 애노테이션으로 스캔 설정
@Component 애노테이션을 붙인 클래스를 스캔해서 스프링 빈으로 등록하려면 설정 클래스에 @ComponentScan 애노테이션을 적용해야 한다.
@ComponentScan(basePackages = {"spring"})는 spring 패키지와 그 하위 패키지에 있는 스프링 컴포넌트들을 자동으로 검색하여 빈으로 등록한다.
 자동화: XML 파일에 빈을 수동으로 등록할 필요 없이, 어노테이션을 사용해 쉽게 빈을 등록할 수 있습니다.
 관리 간소화: 패키지 단위로 검색 경로를 지정할 수 있어 대규모 프로젝트에서도 설정이 간결해집니다. 
 유연성: basePackages뿐만 아니라 다른 속성(예: basePackageClasses, includeFilters, excludeFilters)을 사용해 세부적으로 조정할 수 있습니다

3.예제 실행
 설정클래스 AppCtx에서 @ComponentScan 애노테이션이 붙은 Bean 설정 부분을 모두 삭제하고 프로그램 기동 
 정상 작동 되는 부분을 확인함.

4.스캔 대상에서 제외하거나 포함하기
excludeFilters 속성을 사용하면 스캔할 때 특정 대상을 자동 등록 대상에서 제외할 수 있다.
> ```
> FilteType에 REGEX 정규표현식을 사용 (FilteType.REGEX) 
> @ComponentScan(basePackages = {"spring" },
> excludeFilters = @Filter(type = FilteType.REGEX, pattern = "spring\\\\..*Dao"))
>  spring. 으로 시작하고 Dao로 끝나는 클래스를 스캔대상에서 제외한다.
> ```

> ```
>> FilteType 에 ASPECTJ 를 사용  (FilterType.ASPECTJ) 
> >@ComponentScan(basePackages = {"spring" },
>excludeFilters = @Filter(type = FilterType.ASPECTJ, pattern = "spring.*Dao"))
> spring 패키지 에서 이름이 Dao로 끝나는 타입을 스캔대상에서 제외한다.
> ASPECTJ 를 사용할 때에는  의존 대상에 aspectjweaver 을 추가하여야 한다. (pom.xml) 
> ```


>```
> FilterType 특정 애노테이션을 사용  ( FilterType.ANNOTATION) 
>@Retention(RUNTIME)
>@Target(TYPE)
>public @interface NoProduct {}
>
>@Retention (RUNTIME)
>@Target(TYPE)
>public @interface ManualBean {}
>
>@ComponentScan(basePackages = {"spring", "spring2"}
>               ,excludeFilters = @Filter(type = FilterType.ANNOTATION
>               ,classes = {NoProduct.class, ManualBean.class } ))
> @NoProduct, @ManualBean 애노테이션이 붙은 클래스를 컴포넌트 스캔 대상에서 제외한다.
> ```

> ```
> 특정 타입이나 그 하위 타입을 제외하는 경우  ( FilterType.ASSIGNABLE_TYPE)  ) 
> @ComponentScan(basePackages = { 11spring11 }
>                ,excludeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE
>                , classes = MemberDao.class ))
> classes 속성에 제외할 타입 목록을 지정한다 
> ```

> ```
> 설정할 필터가 두개 이상인 경우 
> @ComponentScan(basePackages = {"spring"}
>       , excludeFilters = {
>                 @Filter(type = FilterType.ANNOTATION, classes = ManualBean.class )
>                 ,@Filter(type = FilterType.REGEX, pattern = "spring2\\\\ ..*")
>                })
> excludeFilters에 배열로 필터 목록을 지정할 수 있다.
> ```

4.1기본 스캔 대상
5.컴포넌트 스캔에 따른 충돌 처리


