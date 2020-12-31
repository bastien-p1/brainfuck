import java.util.*;
class brainfuck {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        for(int loops = 0; loops <100; loops++){
            System.out.print("$/");
            char[] Instructions;
            Instructions = input.nextLine().toCharArray();
            byte val = (byte)1;
            int size = 30000;//size of the table
            int p = 0;//pointer
            int i = 0;//iteration variable
            byte[] t = new byte[size];//8 bits table
            while(i < Instructions.length){
                char cmd = Instructions[i];
                switch(cmd){
                    case '>':
                        if(p < size){p++;}
                    break;
                    case '<':
                        if(p > 0){p--;}
                    break;
                    case '+':
                            t[p]+=val;
                    break;
                    case '-':
                        t[p]-=val;
                    break;
                    case '[':
                        if(t[p] == 0){
                            int level = 1;
                            while(level > 0){
                                i++;
                                if(Instructions[i] == ']'){level--;}
                                if(Instructions[i] == '['){level++;}
                            }
                        }
                    break;
                    case ']':
                        if(t[p] != 0){
                            int level = 1;
                            while(level > 0){
                                i--;
                                if(Instructions[i] == ']'){level++;}
                                if(Instructions[i] == '['){level--;}
                            }
                        }
                    break;
                    case '.':
                        char ascii = (char) Byte.toUnsignedInt(t[p]);
                        //char ascii = (char)t[p];
                        System.out.print(ascii);
                    break;
                    case ',':
                        char in = input.next().charAt(0);
                        t[p] = (byte)in;
                    break;
                }
                i++;
            }
            System.out.print("\n");
        }
        input.close();
    }
}