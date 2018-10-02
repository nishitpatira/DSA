package com.nishit.zalando.codility;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MostWordsSentence {

	public static void main(String[] args) {
		//String text = "We test coders. Give us a try?";
		//final String text = "Forget  CVs! .Save time . x x";
		//String text = "";
		//String text = ".....????.....";
		//String text = null;
		String text = " ";
		System.out.println(new MostWordsSentence().solution(text));
		
	}
	
	public final int solution(String text){
		if(text == null) return 0;
		if(text.length() == 0) return 0;
		
		int maxWords = 0;
		
		//Finding all sentences in the text
		final List<String> sentences = Stream.of(text.split("[?!.]")).collect(Collectors.toList());
		//final String[] sentences = text.split("[?!.]");
		
		for(final String sentence : sentences){
			int sentenceWordCount = 0;
			//Finding words in each sentence
			final String[] words = sentence.split("\\s");
			for(final String word : words){
				if(word.trim().length() != 0){
					sentenceWordCount++;
				}
			}
			if(sentenceWordCount > maxWords){
				maxWords = sentenceWordCount;
			}
		}
		return maxWords;
	}
	
}
