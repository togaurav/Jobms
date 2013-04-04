package com.ganshar.search;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;

public class Test {
	public static void mainsss(String[] args) throws Exception {
        int[][] r = { { 1, 5 }, { 3, 5 }, { 4, 5 }, { 1, 4 }, { 5, 6 },
                { 8, 1 }, { 9, 20 }, { 98, 11 }, { 13, 76 }, { 98, 77 },
                { 2, 1 } };
        List tmplist=Arrays.asList(r[0]);
        List tmplist2=Arrays.asList(r[1]);

        for(int[] a:r){
        	List tmplist3=Arrays.asList(a);
        	
        }
        
        Set<FriendSquare> squareSet = calculateFriendSquare(r);
        for(FriendSquare square : squareSet){
            System.out.println(square.toString());
        }
    }
	public static void main(String[] args){
		File root = new File("E://workspace/logs/test");
		File[] files=root.listFiles();
		 for(File file:files){     
			 if(file.isDirectory()){
				 System.out.println(file.getAbsolutePath());
			 }else{
				 FileInputStream fis = null; 
				 try{
					  fis = new FileInputStream(file.getAbsoluteFile());
					  byte[] data = new byte[1024];
					  int i=fis.read(data);
					  String s=new String(data,0,i);
					  System.out.println(s);
				 }catch(Exception e){
					 e.printStackTrace();
				 }finally{
                     try{
                              //关闭流，释放资源
                              fis.close();
                     }catch(Exception e){}

				 }
				// System.out.println(file.);
			 }
		 }
		
	}
	public static void mainaa(String[] args){
		//转化json
		List<Map<String,Object>> _list=new ArrayList<Map<String,Object>>();
		Map<String,Object> _map=new HashMap<String,Object>();
		_map.put("a", "1");
		_map.put("b", "2");
		Map<String,Object> _map2=new HashMap<String,Object>();
		_map2.put("c", "11");
		_map2.put("d", "22");
		_map2.put("e", "3");
		_list.add(_map);
		_list.add(_map2);

		JSONArray _json=JSONArray.fromObject(_list);
		System.out.println(_json.toString());
		}
    private static Set<FriendSquare> calculateFriendSquare(int[][] array){
        //每个人对应的朋友圈
        Map<Integer, FriendSquare> squareMap = new HashMap<Integer, FriendSquare>();
        for(int[] arr : array){
            //此次分析所关联的朋友圈
            List<FriendSquare> squareList = new ArrayList<FriendSquare>();
            for(int id : arr){
                FriendSquare square = squareMap.get(id);
                //如果当前没有已经存在的朋友圈，新建一个
                if(square == null){
                    square =new Test().new FriendSquare();
                    square.addFriend(id);
                    squareMap.put(id, square);
                }
                squareList.add(square);
            }
            //合并此次相关的朋友圈，并刷新map
            FriendSquare square = squareList.get(0);
            for(int i = 1 ; i < squareList.size(); i ++){
                if(square != squareList.get(i)){
                    square.merge(squareList.get(i));
                    for(int id : squareList.get(i).getFriendIds())
                        squareMap.put(id, square);
                }
            }
        }
        Iterator<FriendSquare> iterator = squareMap.values().iterator();
        Set<FriendSquare> resultSet = new HashSet<FriendSquare>();
        while(iterator.hasNext()){
            FriendSquare square = iterator.next();
            if(!resultSet.contains(square))
                resultSet.add(square);
        }
        return resultSet;
    }
    
    class FriendSquare {
        private Set<Integer> friendSet = new HashSet<Integer>();
     
        public FriendSquare(){
        	
        }
        
        public boolean isContains(int id) {
            return friendSet.contains(id);
        }
         
        public Integer[] getFriendIds(){
            return friendSet.toArray(new Integer[friendSet.size()]);
        }
     
        public void merge(FriendSquare square) {
            Iterator<Integer> iterator = square.friendSet.iterator();
            while(iterator.hasNext())
                addFriend(iterator.next());
        }
         
        public void addFriend(int id){
            friendSet.add(id);
        }
         
        public String toString(){
            StringBuffer sb = new StringBuffer();
            for(Integer id : friendSet)
                sb.append(id + ",");
            return sb.toString();
        }
    }
}
