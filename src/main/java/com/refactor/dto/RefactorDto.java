package com.refactor.dto;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ToString
public class RefactorDto {

	int pageNumber;
	int pageOffSet;	
	

}