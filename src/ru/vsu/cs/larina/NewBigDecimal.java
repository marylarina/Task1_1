package ru.vsu.cs.larina;

import java.util.Arrays;

public class NewBigDecimal {
    private String first;
    private String second;
    private int variable;

    public void setFirst (String first){
        this.first=first;
    }
    public String getFirst(){
        return first;
    }

    public void setSecond (String second){
        this.second=second;
    }
    public String getSecond(){
        return second;
    }

    public void setVariable (int variable){
        this.variable=variable;
    }
    public int getVariable(){
        return variable;
    }

    public static String Replacement (String number){
        return number=number.replace(".", "-1");
    }

    public static int [] StringToArray (String number){
        number=Replacement(number);
        String[] str = number.split(" ");
        int [] array = new int [str.length];
        for (int i=0; i< array.length; i++){
            array[i]= Integer.parseInt(str[i]);
        }
        return array;
    }

    public static int [] Sum (int [] first, int [] second){
        int plus=0;
        int count1=0;
        int count2=0;
        int k=0;
        int t=0;
        int temp=0;
        int flagF=0;
        int flagS=0;
        int minus =0;

        if (first.length> second.length){
            k= first.length;
        }else{
            k= second.length;
        }

        for (int i = 0; i < first.length; i++) {
            if (first[i] == -1) {
                flagF = i;
            }
        }
        for (int i = 0; i < second.length; i++) {
            if (second[i] == -1) {
                flagS = i;
            }
        }
        for (int i=flagF+1; i< first.length; i++){
            count1++;
        }
        for (int i=flagS+1; i< second.length; i++){
            count2++;
        }
        if (count1>count2){
            plus=count1-count2;
        }else{
            plus=count2-count1;
        }

        int [] newFirst = new int [k-1+plus];
        int [] newSecond = new int [k-1+plus];
        int [] array = new int [k-1+plus];
        int [] result = new int [k+plus];

        if (flagF>=flagS){
            for (int i = 0; i<flagF; i++){
                newFirst[i]=first[i];
            }
            for (int i=flagF+1; i< first.length; i++){
                newFirst[i-1]= first[i];
            }

            for (int i = flagF-flagS; i<flagF; i++){
                newSecond[i]=second[temp];
                temp++;
            }
            for (int i=flagS+1; i< second.length; i++){
                newSecond[flagF+t]= second[i];
                t++;
            }
            for (int i=0; i<newFirst.length; i++){
                array[i]=newFirst[i]+newSecond[i];

            }
            for (int i=array.length-1; i>0; i--){
                if (array[i]>9){
                    array[i]=array[i] % 10;
                    array[i-1]++;
                }
            }
            for (int i=0; i< flagF; i++){
                result[i]=array[i];
            }
            for (int i=flagF+1; i< array.length+1; i++){
                result[i]=array[i-1];
            }
            for (int i=flagF; i<=flagF; i++){
                result[i]=-1;
            }
        }

        if (flagF<flagS){
            for (int i = 0; i<flagS; i++){
                newSecond[i]=second[i];
            }
            for (int i=flagS+1; i< second.length; i++){
                newSecond[i-1]= second[i];
            }

            for (int i = flagS-flagF; i<flagS; i++){
                newFirst[i]=first[temp];
                temp++;
            }
            for (int i=flagF+1; i< first.length; i++){
                newFirst[flagS+t]= first[i];
                t++;
            }

            for (int i=0; i<newSecond.length; i++){
                array[i]=newFirst[i]+newSecond[i];

            }
            for (int i=array.length-1; i>0; i--){
                if (array[i]>9){
                    array[i]=array[i] % 10;
                    array[i-1]++;
                }
            }
            for (int i=0; i< flagS; i++){
                result[i]=array[i];
            }
            for (int i=flagS+1; i< array.length+1; i++){
                result[i]=array[i-1];
            }
            for (int i=flagS; i<=flagS; i++){
                result[i]=-1;
            }
        }
        return result;
        }

        public static int [] Subtraction (int[] first, int [] second){
            int plus=0;
            int count=0;
            int count1=0;
            int count2=0;
            int k=0;
            int t=0;
            int temp=0;
            int flagF=0;
            int flagS=0;
            if (first.length> second.length){
                k= first.length;
            }else{
                k= second.length;
            }

            for (int i = 0; i < first.length; i++) {
                if (first[i] == -1) {
                    flagF = i;
                }
            }
            for (int i = 0; i < second.length; i++) {
                if (second[i] == -1) {
                    flagS = i;
                }
            }
            for (int i=flagF+1; i< first.length; i++){
                count1++;
            }
            for (int i=flagS+1; i< second.length; i++){
                count2++;
            }
            if (count1>count2){
                plus=count1-count2;
            }else{
                plus=count2-count1;
            }

            int [] newFirst = new int [k-1+plus];
            int [] newSecond = new int [k-1+plus];
            int [] array = new int [k-1+plus];
            int [] result = new int [k+plus];

            if (flagF>=flagS){
                for (int i = 0; i<flagF; i++){
                    newFirst[i]=first[i];
                }
                for (int i=flagF+1; i< first.length; i++){
                    newFirst[i-1]= first[i];
                }

                for (int i = flagF-flagS; i<flagF; i++){
                    newSecond[i]=second[temp];
                    temp++;
                }
                for (int i=flagS+1; i< second.length; i++){
                    newSecond[flagF+t]= second[i];
                    t++;
                }
                for (int i = k-1+plus-1; i >= 0; i--) {
                    array[i] = newFirst[i] - newSecond[i] - count;
                    if (array[i] >= 0) {
                        count = 0;
                    } else {
                        array[i] = array[i] + 10;
                        count = 1;
                    }
                }

                for (int i=0; i< flagF; i++){
                    result[i]=array[i];
                }
                for (int i=flagF+1; i< array.length+1; i++){
                    result[i]=array[i-1];
                }
                for (int i=flagF; i<=flagF; i++){
                    result[i]=-1;
                }
            }

            if (flagF<flagS) {
                for (int i = 0; i<flagS; i++){
                    newSecond[i]=second[i];
                }
                for (int i=flagS+1; i< second.length; i++){
                    newSecond[i-1]= second[i];
                }

                for (int i = flagS-flagF; i<flagS; i++){
                    newFirst[i]=first[temp];
                    temp++;
                }
                for (int i=flagF+1; i< first.length; i++){
                    newFirst[flagS+t]= first[i];
                    t++;
                }
                for (int i = k-1+plus-1; i >= 0; i--) {
                    array[i] = newSecond[i] - newFirst[i] - count;
                    if (array[i] >= 0) {
                        count = 0;
                    } else {
                        array[i] = array[i] + 10;
                        count = 1;
                    }
                }

                for (int i=0; i< flagS; i++){
                    result[i]=array[i];
                }
                for (int i=flagS+1; i< array.length+1; i++){
                    result[i]=array[i-1];
                }
                for (int i=flagS; i<=flagS; i++){
                    result[i]=-1;
                }
                result[0]=-result[0];
            }
            return result;
        }

        public static int [] Multiplication(int [] first, int [] second) {
        int count=0;
        int m=0;
        int flagF=0;
        int flagS=0;

             for (int i = 0; i < first.length; i++) {
                if (first[i] == -1) {
                    flagF = i;
                }
            }
            for (int i = 0; i < second.length; i++) {
                if (second[i] == -1) {
                    flagS = i;
                }
            }
            int [] newFirst = new int [first.length-1];
            int [] newSecond = new int [second.length-1];
            int [] array = new int [newFirst.length + newSecond.length];
            int[] result = new int[array.length+1];

            for (int i = 0; i<flagF; i++){
                newFirst[i]=first[i];
            }
            for (int i=flagF+1; i< first.length; i++){
                newFirst[i-1]= first[i];
            }

            for (int i = 0; i<flagS; i++){
                newSecond[i]=second[i];
            }
            for (int i=flagS+1; i< second.length; i++){
                newSecond[i-1]= second[i];
            }

            int t = array.length - 1;
            for (int i = newFirst.length - 1; i >= 0; i--) {
                if(i!= newFirst.length-1){
                    t-=count;
                }
                for (int j = newSecond.length - 1; j >= 0; j--) {
                    array[t] += newSecond[j] * newFirst[i];
                    t--;
                }
                t= array.length-1;
                count++;
            }
            for (int i = array.length -1; i > 0; i--) {
                m = array[i];
                array[i] = m % 10;
                array[i - 1] += m / 10;
            }

            for (int i=0; i< flagS+flagF; i++){
                result[i]=array[i];
            }
            for (int i=flagS+flagF+1; i< array.length+1; i++){
                result[i]=array[i-1];
            }
            for (int i=flagS+flagF; i<=flagS+flagF; i++){
                result[i]=-1;
            }
            return result;
        }

        public static int[] Division(int [] first, int variable){
        int k=0;
        int t=0;
        int count=0;
        int flag=0;
        int flagF=0;
        int count1=0;

        for (int i = 0; i < first.length; i++) {
            if (first[i] == -1) {
                flagF = i;
            }
        }
        for (int i=flagF+1; i< first.length; i++){
            count1++;
        }

        int [] newFirst = new int [first.length-1];
        int [] notFinal = new int [newFirst.length];

        for (int i = 0; i<flagF; i++){
            newFirst[i]=first[i];
        }
        for (int i=flagF+1; i< first.length; i++){
            newFirst[i-1]= first[i];
        }
        variable= (int) (variable*Math.pow(10, count1));
        for (int i=0; i< newFirst.length; i++){
            t = newFirst[i] + k;
            notFinal[i] = t/variable;
            k = (t%variable)*10;
        }
        for (int i=0; i< notFinal.length; i++){
            if ((notFinal[i]==0)&&(flag==0)){
                count++;
            }else{
                flag++;
            }
        }
            int [] result = new int [notFinal.length - count];
            for (int i=0; i< result.length; i++){
                result[i]=notFinal[i+count];
            }
        return result;
        }

        public static int [] Remainder (int [] first, int variable){
            int k=0;
            int flagF=0;
            int count1=0;
            int count=0;
            int flag=0;
            int m=0;
            int r=0;
            int temp=0;
            int c=0;
            for (int i = 0; i < first.length; i++) {
                if (first[i] == -1) {
                    flagF = i;
                }
            }
            for (int i=flagF+1; i< first.length; i++){
                count1++;
            }

            int [] newFirst = new int [first.length-1];
            int [] notFinal = new int [newFirst.length];

            for (int i = 0; i<flagF; i++){
                newFirst[i]=first[i];
            }
            for (int i=flagF+1; i< first.length; i++){
                newFirst[i-1]= first[i];
            }
            int secondVariable = variable;
            variable= (int) (variable*Math.pow(10, count1));
            for (int i=0; i< newFirst.length; i++){
                temp = newFirst[i] + k;
                notFinal[i] = temp/variable;
                k = (temp%variable)*10;
            }
            for (int i=0; i< notFinal.length; i++){
                if ((notFinal[i]==0)&&(flag==0)){
                    count++;
                }else{
                    flag++;
                }
            }
            int [] result = new int [notFinal.length - count];
            for (int i=0; i< result.length; i++){
                result[i]=notFinal[i+count];
            }

            count=0;
            flag=0;

            String s = Integer.toString(secondVariable);
            int[] newSecond = new int[s.length()];
            for (int i = newSecond.length - 1; i >= 0; i--) {
                newSecond[i] = secondVariable % 10;
                secondVariable /= 10;
            }
            int [] array = new int [result.length + newSecond.length];
            int t = array.length - 1;
            for (int i = result.length - 1; i >= 0; i--) {
                if(i!= result.length-1){
                    t-=c;
                }
                for (int j = newSecond.length - 1; j >= 0; j--) {
                    array[t] += newSecond[j] * result[i];
                    t--;
                }
                t= array.length-1;
                c++;
            }
            for (int i = array.length -1; i > 0; i--) {
                m = array[i];
                array[i] = m % 10;
                array[i - 1] += m / 10;
            }

            for (int i=0; i< array.length; i++){
                if (array[i]!=0){
                    flag=i;
                    break;
                }
            }
            int [] multiple = new int [newFirst.length];
            for (int i=flag; i< array.length; i++){
                multiple[count]=array[i];
                count++;
            }
            int [] arr = new int [newFirst.length];
            for (int i = arr.length-1; i >= 0; i--) {
                arr[i] = newFirst[i] - multiple[i] - r;
                if (arr[i] >= 0) {
                    r = 0;
                } else {
                    arr[i] = arr[i] + 10;
                    r = 1;
                }
            }
            count=0;
            flag=0;

            for (int i = 0; i< arr.length; i++){
                if ((arr[i]==0)&&(flag==0)){
                    count++;
                }else{
                    flag++;
                }
            }
            int [] theLastOne = new int [arr.length - count];
            for (int i=0; i< theLastOne.length; i++){
                theLastOne[i]=arr[i+count];
            }
            int [] finalOne = new int [theLastOne.length+1];
            for (int i=0; i<theLastOne.length-count1+1; i++){
                finalOne[i]=theLastOne[i];
            }
            for(int i= theLastOne.length - count1; i<theLastOne.length; i++){
                finalOne[i+1]=theLastOne[i];
            }
            finalOne[theLastOne.length-count1]=-1;
            return finalOne;
        }

    public static String ArrayToString(int [] array){
        StringBuilder str = new StringBuilder();
        for (int element : array) {
            str.append(element);
        }
        String number = str.toString();
        number = number.replace("-1", ".");
        return number;
    }
}
