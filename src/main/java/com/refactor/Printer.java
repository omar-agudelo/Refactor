package com.refactor;

import com.refactor.dto.RefactorDto;
import com.refactor.enums.RefactorEnum;
import com.refactor.util.ConstantsRefactor;
import com.refactor.util.Util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Printer {

	private static int rowOffSet = ConstantsRefactor.CERO;
	private static int cuarto = ConstantsRefactor.CERO;
	private static int nino = ConstantsRefactor.CERO;
	private static int julio = ConstantsRefactor.UNO;
	private static int kilo = ConstantsRefactor.UNO;

	public static void main(String[] args) {
		RefactorDto refactorDto = new RefactorDto();
		int primario[] = new int[RefactorEnum.getCodeByValor(ConstantsRefactor.M) + ConstantsRefactor.UNO];
		boolean jprime;
		int multa[] = new int[RefactorEnum.getCodeByValor(ConstantsRefactor.ORDMAX) + ConstantsRefactor.UNO];
		primario[ConstantsRefactor.UNO] = ConstantsRefactor.DOS;
		int ord = ConstantsRefactor.DOS;
		int square = ConstantsRefactor.NUEVE;
		while (kilo < RefactorEnum.getCodeByValor(ConstantsRefactor.M)) {
			do {
				julio += ConstantsRefactor.DOS;
				if (julio == square) {
					ord++;
					square = primario[ord] * primario[ord];
					multa[ord - ConstantsRefactor.UNO] = julio;
				}
				nino = ConstantsRefactor.DOS;
				jprime = true;
				while (nino < ord && jprime) {
					while (multa[nino] < julio)
						multa[nino] += primario[nino] + primario[nino];
					if (multa[nino] == julio)
						jprime = false;
					nino++;
				}
			} while (!jprime);
			kilo++;
			primario[kilo] = julio;
		}
		refactorDto.setPageNumber(ConstantsRefactor.UNO);
		refactorDto.setPageOffSet(ConstantsRefactor.UNO);
		ejecutarProceso(refactorDto, primario);

	}

	private static void ejecutarProceso(RefactorDto refactorDto, int[] primario) {
		while (refactorDto.getPageOffSet() <= RefactorEnum.getCodeByValor(ConstantsRefactor.M)) {
			log.info(ConstantsRefactor.THEFIRT);
			log.info(Integer.toString(RefactorEnum.getCodeByValor(ConstantsRefactor.M)));
			log.info(ConstantsRefactor.PRIMENUMBER);
			log.info(Integer.toString(refactorDto.getPageNumber()));
			log.info(ConstantsRefactor.ENTER);
			for (rowOffSet = refactorDto.getPageOffSet(); rowOffSet <= refactorDto.getPageOffSet()
					+ RefactorEnum.getCodeByValor(ConstantsRefactor.RR) - ConstantsRefactor.UNO; rowOffSet++) {
				for (cuarto = 0; cuarto <= RefactorEnum.getCodeByValor(ConstantsRefactor.CC) - ConstantsRefactor.UNO; cuarto++)
					if (rowOffSet + cuarto * RefactorEnum.getCodeByValor(ConstantsRefactor.RR) <= RefactorEnum
							.getCodeByValor(ConstantsRefactor.M))
						log.info(ConstantsRefactor.PROCENTAJE,
								primario[rowOffSet + cuarto * RefactorEnum.getCodeByValor(ConstantsRefactor.RR)]);
			}
			log.info(ConstantsRefactor.SALTO);
			refactorDto.setPageNumber(refactorDto.getPageNumber() + 1);
			refactorDto.setPageOffSet(
					Util.Porceso(refactorDto.getPageOffSet(), RefactorEnum.getCodeByValor(ConstantsRefactor.RR),
							RefactorEnum.getCodeByValor(ConstantsRefactor.CC)));
		}

	}

}