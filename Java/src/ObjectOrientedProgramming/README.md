# Object Oriented Programming
[Object Oriented Programming](https://www.hackerrank.com/domains/java?filters%5Bsubdomains%5D%5B%5D=oop&badge_type=java)


# 추상 클래스 (Abstract Class)
추상 클래스(abstract class)란 하나 이상의 추상 메소드(abstract method)를 포함하는 클래스이다. 추상 메소드는 선언만 있고 본체는 없는 함수이며 선언부에 ‘abstract’ 라는 키워드를 붙인다. 추상 메소드가 포함되었다면 클래스도 추상 클래스이므로 클래스명 앞에도 ‘abstract’키워드를 붙여야 한다.

## 주의점
1. 자식 클래스에서 재정의되어야 함으로 추상 메소드의 접근 지정자로 private을 사용할 수 없다.
2. 어떤 추상클래스를 상속 받은 자식 클래스에서 추상 메소드를 구현하지 않았다면 자식 클래스도 추상 클래스가 되어야 한다

출처: https://studymake.tistory.com/423


# Interface
자바 프로그래밍 언어에서 클래스들이 구현해야 하는 동작을 지정하는데 사용되는 추상형이다

## 인터페이스가 필요한 이유
계산기 예제에 인터페이스를 도입해보자. 계산기 기능이 필요한 프로젝트를 진행하는데 시간이 촉박하다. 그래서 계산기 클래스는 개발자 A가 만들고, 개발자 B는 그 클래스를 사용하는 로직을 만들다고 해보자. 이런 경우 개발자 B는 개발자 A가 계산기를 잘 만들어서 나중에 제출할 것이라고 기대하고 개발을 진행할 것이다. 그리고 아래와 같이 가짜 로직을 만들어서 코드를 작성했다.

출처: https://opentutorials.org/module/2495/14142

# git commit message change
```
git commit --amend
```


출처: https://opentutorials.org/module/2495/14142
