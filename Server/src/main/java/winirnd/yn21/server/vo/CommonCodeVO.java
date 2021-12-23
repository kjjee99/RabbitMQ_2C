package winirnd.yn21.server.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CommonCodeVO {
	String codeID;
	String codeName;
	String upperID;
	String regDate;
	
	@Builder
	public CommonCodeVO(String codeID, String codeName,String upperID) {
		this.codeID = codeID;
		this.codeName = codeName;
		this.upperID = upperID;
	}
}
