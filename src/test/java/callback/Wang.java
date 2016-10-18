package callback;

public class Wang implements CallBack {

    private Li li;
    public Wang(Li li){  
        this.li = li;  
    }
    public void askQuestion(final String question){  
        //这里用一个线程就是异步，  
        new Thread(new Runnable() {  
            @Override  
            public void run() {  
                /** 
                 * 小王调用小李中的方法，在这里注册回调接口 
                 * 这就相当于A类调用B的方法C 
                 */  
                li.executeMessage(Wang.this, question);   
            }  
        }).start();
        //小网问完问题挂掉电话就去干其他的事情了，诳街去了
        play();  
    }
    public void play(){  
        System.out.println("我要逛街去了");  
    }
    /** 
     * 小李知道答案后调用此方法告诉小王，就是所谓的小王的回调方法 
     */  
    @Override  
    public void solve(String result) {  
        System.out.println("小李告诉小王的答案是--->" + result);  
    }
    public static void main(String[]args){
        Li li = new Li();
        Wang wang = new Wang(li);
        wang.askQuestion("1 + 1 = ?");
    }
}  