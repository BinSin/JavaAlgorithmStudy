# �̱�ư ����(Singleton Pattern)

## ����
�� �ϳ��� ������ ��ü�� ����� ���� ������ ����

## ����

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

## ������
��Ƽ ������� ���� �� ������ �����.

## �ذ� ���

- add synchronized

```
public static synchronized Singleton getInstance()
```
������ synchronized�� �����ս��� ������ ������ ��û�� ������ �ش�.

- eager initialization

��ü�� ���α׷� ���۰� ���ÿ� �ʱ�ȭ

```
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton(){}

    public static Singleton getInstance(){
        return instance;
    }
}
```

��ó: https://jdm.kr/blog/10