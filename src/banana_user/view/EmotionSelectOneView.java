package banana_user.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import banana_user.controller.Controllers;
import banana_user.domain.Emotion;

public class EmotionSelectOneView {
	
	private Scanner keyboard;
	
	public EmotionSelectOneView() {
		
		keyboard = new Scanner(System.in);
		
	}
	
	public void emotionSelectOne(ArrayList<Emotion> emotions) {
		
		System.out.println("지금 기분이 어떠신가요?? ");
		
		for(int i=0; i<emotions.size(); i++) {
			
			System.out.print((i+1)+"."+emotions.get(i).getEmotionName()+"\t");
			
		}
		
		int selectedEmotion = keyboard.nextInt();
		
		while(true){
			try {

				selectedEmotion = keyboard.nextInt();
				break;

			} catch (InputMismatchException e) {

				keyboard = new Scanner(System.in);
				System.out.print("잘못입력하셨습니다. 다시 입력해주세요 : ");

			} 
		}
		
		Controllers.getMusicController().requestEmotionMusic(selectedEmotion);
		
	}

}