# �̱�ư ����(Singleton Pattern)
- ����

�� �ϳ��� ������ ��ü�� ����� ���� ������ ����

- ����

```
public class Singleton {
    private static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance(){
        if( instance == null ){ // (1)
            instance = new Singleton(); // (2)
        }
        return instance;
    }
}
```

- ������

��Ƽ ������� ���� �� ������ �����.

- �ذ� ���

1. add synchronized

```
public class Singleton {
    private static Singleton instance;

    private Singleton(){}

    public static synchronized Singleton getInstance(){
        if( instance == null ){
            instance = new Singleton();
        }
        return instance;
    }
}
```
������ synchronized�� �����ս��� ������ ������ ��û�� ������ �ش�.

2.


��ó: https://jdm.kr/blog/10