package spring;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.format.DateTimeFormatter;

public class MemberPrinter {

	private DateTimeFormatter dateTimeFormatter ;

	public void print(Member member) {
		if (dateTimeFormatter == null ){
			System.out.printf("is null 인 경우 >>") ;
			System.out.printf(
					"회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n",
					member.getId(), member.getEmail(),member.getName(), member.getRegisterDateTime());
		} else {
			System.out.printf("not null 인 경우 >> ") ;
			System.out.printf(
					"회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%s\n",
					member.getId(), member.getEmail(),member.getName(), dateTimeFormatter.format(member.getRegisterDateTime()));
		}
	}

//	 5-1 ) 필수여부를 지정할 떄 	@Autowired(required = false)을 사용하는 방법
	@Autowired(required = false)
	public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter){
		this.dateTimeFormatter = dateTimeFormatter ;
	}

}

	/* 5-2 ) 필수여부를 지정할 떄  스프링 5 이상인 경우 자바 8의 옵셔널을 사용 하는 방법
	@Autowired
	public void setDateTimeFormatter(Optional<DateTimeFormatter> formatterOpt){
		if(formatterOpt.isPresent()){
			this.dateTimeFormatter = formatterOpt.get() ;
		}else{
			this.dateTimeFormatter = null ;
		}
	}
   */

	// 5-3 ) 필수여부를 지정할 떄 @Nullable 애노테이션을 사용 하는 방법
//	@Autowired
//	public void setDateTimeFormatter(@Nullable DateTimeFormatter dateTimeFormatter){
//		this.dateTimeFormatter = dateTimeFormatter ;
//
//	}


