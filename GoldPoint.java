import java.util.ArrayList;

import java.util.HashMap;

import java.util.Iterator;

import java.util.List;

import java.util.Map;

import java.util.Scanner;

 

public class GoldPoint {

public static void main(String[] args){

    GoldPoint gd=new GoldPoint();

    gd.goldPoint();

}

public void goldPoint(){

    HashMap<String,Double> inputMap=new HashMap<String,Double>();//�����������

    HashMap<String,Double> scoreMap=new HashMap<String,Double>();//�������

    String name="";

    Double inputScore;

    int peopleNum;//�μӵ�����

    int time;//��������

    Double sum=0.0;

    Double aver=0.0;

    Scanner scan=new Scanner(System.in); //����������ϵͳ��������

    System.out.println("����μӵ�������");

    peopleNum=scan.nextInt();

    System.out.println("������Ҫ���м��֣�");

    time=scan.nextInt();

    for(int i=0;i<peopleNum;i++){

        System.out.println("�������"+(i+1)+"���μ��ߵ�������");

        name=scan.next();

        System.out.println("�������һ�ֵķ�����");

        inputScore=scan.nextDouble();

         inputMap.put(name, inputScore);

         scoreMap.put(name,(double) 0);//��ʼ��scoreMap

         sum+=inputScore;

    }

    aver=sum/peopleNum*0.618;

    System.out.println("aver="+aver);

    this.findWinner(inputMap, scoreMap, aver);

    this.show(scoreMap);

    System.out.println("��һ�ֽ���");

    for(int i=0;i<time-1;i++){

            sum=0.0;

            System.out.println("�������"+(i+2)+"�ֵķ�����");

            Iterator iter = inputMap.entrySet().iterator();

            while (iter.hasNext()) {

                Map.Entry entry0 = (Map.Entry) iter.next();

                String key = (String) entry0.getKey();

                System.out.println(key+"�����"+(i+2)+"�ַ�����");

                Double score =scan.nextDouble();

                inputMap.put(key, score);//�滻����ǰ�ķ���

                sum+=score;

        }

            aver=sum/peopleNum*0.618;

            System.out.println("aver="+aver);

            this.findWinner(inputMap, scoreMap, aver);

            this.show(scoreMap);

        System.out.println("��"+(i+2)+"�ֽ���");

    } ��������System.out.println("��Ϸ����");

}

//�ҳ�ÿ�η�����ӽ��ƽ��� ����Զ�� ��ӽ��ļ�һ�� ��Զ�ļ�һ�� �������֣���������ͬ�ģ�

public void findWinner(HashMap<String,Double> inputMap,HashMap<String,Double> scoreMap,Double aver){    

    Double temp;

    Double temp0;

    List<String> latest=new ArrayList<String>();

    List<String> farthest=new ArrayList<String>();

     

    Iterator iter = inputMap.entrySet().iterator();

    Map.Entry entry = (Map.Entry) iter.next();

    Double input = (Double) entry.getValue();

    String key0 = (String) entry.getKey();

    latest.add(key0);

    farthest.add(key0);

    //iter.hasNext();

    temp0=temp=Math.abs(aver-input);

    //����map

    while (iter.hasNext()) {    

        entry = (Map.Entry) iter.next();

        String key = (String) entry.getKey();

        input = (Double) entry.getValue();

        Double temp1=Math.abs(aver-input);

        if(temp>temp1){//Ѱ�����

            temp=temp1;

             latest.clear();

             latest.add(key);

        }else if(temp==temp1){

            latest.add(key);

        }

        if(temp0<temp1){//Ѱ����Զ

            temp0=temp1;

            farthest.clear();

            farthest.add(key);}

        else if(temp0==temp1){

            farthest.add(key);

        }

    }

    //ʵ�ּӷ�

    iter = scoreMap.entrySet().iterator();

    while (iter.hasNext()) {

        Map.Entry entry0 = (Map.Entry) iter.next();

        String key = (String) entry0.getKey();

        Double score =(Double) entry0.getValue();

        if(this.containList(key, latest)){

            score=score+1;

            scoreMap.put(key, score);

            }

        if(this.containList(key, farthest)){

            score=score-1;

            scoreMap.put(key, score);

        }

        }

}

public boolean containList(String str,List<String> list){

    for(int i=0;i<list.size();i++){

        if(str.equals(list.get(i))){

            return true;

        }

    }

    return false;

}

public void show(HashMap<String,Double> scoreMap){

    System.out.println("�÷������");

    Iterator iter = scoreMap.entrySet().iterator();

    while (iter.hasNext()) {

        Map.Entry entry0 = (Map.Entry) iter.next();

        String key = (String) entry0.getKey();

        Double score =(Double) entry0.getValue();

        System.out.println(key+"��"+score);

    }

}

 

}