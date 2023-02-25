package ch12.unit6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Ex006_Grop {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] aa = new String[] {
				"남01","남02","남03","남04","남05","남06","남07","남08","남09","남10","남11","남12","남13","남14"
		};
		
		String[] bb = new String[] {
				"여01","여02","여03","여04","여05","여06","여07","여08","여09","여10"
		};
		
		String[] cc;
		String[][] group;
		
		int total, groupCount;
		int ratio, groupNum;
		
		try {
			total = aa.length + bb.length; // 전체 인원수
			
			System.out.print("몇조로 할까요?");
			groupCount = Integer.parseInt(br.readLine());
			if(groupCount > total) {
				System.out.println("전체 인원수보다 클 수 없습니다.");
				return;
			}
			System.out.print("남성과 여성의 비율은 어떻게 할까요?(1.같은 비율, 2.무작위)"); //모든 조에 남자 3명 여자 3명 or 남자 1명 여자 4명 
			ratio = Integer.parseInt(br.readLine());
			if(ratio < 1 || ratio > 2) {
				System.out.println("비율은 1 또는 2만 가능합니다.");
				return;
			}
			
			// 그룹별 최대 인원수
			groupNum =total % groupCount == 0 ? total/groupCount : total/groupCount +1; //24명이면 5조로 나누면 나머지 4 . 최대 5명. 
			                                                                            //24명이 3조으로 잡으면 최대 8명
			
			group = new String[groupCount][groupNum];
			cc = new String[total];
			
			if(ratio == 1) {//같은 비율
				Collections.shuffle(Arrays.asList(aa));
				Collections.shuffle(Arrays.asList(bb));
				
				System.arraycopy(aa, 0, cc, 0, aa.length);
				System.arraycopy(bb, 0, cc, aa.length, bb.length);
				//앞에 남자, 뒤에 여자.
					
			}else { // 무작위
				System.arraycopy(aa, 0, cc, 0, aa.length);
				System.arraycopy(bb, 0, cc, aa.length, bb.length);
				
				Collections.shuffle(Arrays.asList(cc));
				//남자 여자 섞어서 Shuffle
			}
			
			int n =0;
			gogo:
			for(int col = 0; col < groupNum;col++)	{
				for( int row = 0; row<groupCount; row++) {
					group[row][col]= cc[n++];
					if (n > cc.length) {
						break gogo;
					}
				}
			}
			
			System.out.println("\n편성된 조원");
			for(int i =0; i<group.length;i++) {
				System.out.println((i+1)+"조 :");
				for(int j =0;j<group[i].length; j++) {
					if(group[i][j] != null) {
						System.out.print(group[i][j]+" ");
					}
				}
				System.out.println();
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
