# 싱글튼 패턴(Singleton Pattern)

## 정의
단 하나의 유일한 객체를 만들기 위한 디자인 패턴

## 구현

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

## 문제점
멀티 스레드로 돌릴 시 문제가 생긴다.

## 해결 방법

- add synchronized

```
public static synchronized Singleton getInstance()
```
하지만 synchronized는 퍼포먼스엥 안좋은 쪽으로 엄청난 영향을 준다.

- eager initialization

객체를 프로그램 시작과 동시에 초기화

```
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton(){}

    public static Singleton getInstance(){
        return instance;
    }
}
```

출처: https://jdm.kr/blog/10