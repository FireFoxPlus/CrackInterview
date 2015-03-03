package edu.crackInterview;

import java.util.Arrays;
//1.6����N*N�ľ����ʾͼ������ÿ������4�ֽڣ���ͼ����ת90�ȣ���ռ�ö���洢�ռ�ɷ�������
//1.7��M*N������ĳ��Ԫ��Ϊ0��������������������
//1.8�ٶ��з���isSubstring���ɼ��һ�������Ƿ�Ϊ�����ַ������Ӵ������������ַ���s1��s2��
//��֤s2�Ƿ���s1��ת���ɣ�Ҫ��ֻ�ܵ���һ��isSubstring

public class chap8 {
	//1.1
    public boolean isUnique(String val){
    	int[] chars = new int[256];
    	for(int i = 0; i < 256; i++)
    		chars[i] = 0;
    	for(int i = 0; i < val.length(); i++)
    		chars[val.charAt(i)]++;
    		
    	for(int i = 0; i < 256; i++)
    		if(chars[i] > 1)
    			return false;
    	return true;
    } 
    
    //1.3
    public boolean isSame(String val1 , String val2){
    	if(val1.length() != val2.length())
    		return false;
    	char[] vals1 = val1.toCharArray();
    	char[] vals2 = val2.toCharArray();
    	Arrays.sort(vals1);
    	Arrays.sort(vals2);
    	for(int i = 0; i < val1.length(); i++)
    		if(vals1[i] != vals2[i])
    			return false;
    	return true;
    }
    
    //1.4
    public String reBlank(String val){
    	int blanks = 0;
    	String rs;
    	for(int i = 0; i < val.length(); i++)
    		if(val.charAt(i) == ' ')
    			blanks++;
    	int totalLen = val.length() + blanks * 2;
    	char[] rsChar = new char[totalLen];
    	totalLen--;
    	for(int i = val.length() - 1; i >=0; i--){
    		if(val.charAt(i) != ' '){
    			rsChar[totalLen] = val.charAt(i);
    			totalLen--;
    		}
    		else{
    			rsChar[totalLen--] = '0';
    			rsChar[totalLen--] = '2';
    			rsChar[totalLen--] = '%';
    		}
    	}
    	rs = new String(rsChar);
    	return rs;
    }
    
  //1.5ʵ���ַ�ѹ�������磬aabcccccaaa���Ϊa2b1c5a3����ѹ��֮���ַ���û�б�̣��򷵻�ԭ�ַ���
    public String compressStr(String val){
    	StringBuffer buf;
    	int count = 0;
    	boolean changed = false;
    	for(int i = 0; i < val.length(); i++){
    		if(i == 0){
    			buf.append(val.charAt(i));
    			continue;
    		}   		
    		if(val.charAt(i) != val.charAt(i - 1) && count != 0){
    			buf.append(count);
    			buf.append(charAt(i));
    			count = 0;
    		}
    		else if(val.charAt(i) == val.charAt(i - 1)){
    			count++;
    			changed = true;
    		}
    	}
    	if(!changed)
    		return val;
    	return buf.toString();
    }

}
