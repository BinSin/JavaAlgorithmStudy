# Advanced
[Advanced](https://www.hackerrank.com/domains/java?filters%5Bsubdomains%5D%5B%5D=java-advanced&badge_type=java)

# import static
```java
import static java.lang.System.in

BufferedReader br = new BufferedReader(new InputStreamReader(in));
```

# Java Varargs
�� �� 5.0���� �Ұ��Ǵ� ���� �߿��� �����μ�(Varargs)���� ���� �ִ�. �����μ����� ���� �ʿ信 ���� �Ű�����(�μ�)�� ���������� ������ �� �ִ� �����̴�. �����μ��� ���� �������� �����μ� ���� �÷����̳� �迭�� �̿��ؼ� �����μ��� ��ü�ϰ� �־���.

��ó: https://gyrfalcon.tistory.com/entry/Java-Varargs [Minsub's Blog]

## ������
```
accessModifier methodName(datatype�� arg) {
    // method body
}
```


# Java Annotations

## 정의
어노테이션은 본질적인 목적은 소스 코드에 메타데이터를 표현하는 것입니다. 단순히 부가적인 표현뿐만 아니라 reflection을 이용하면 어노테이션 지정만으로도 원하는 클래스를 주입할 수 있습니다.

## Bulit-in Annotation
기본적으로 제공되는 어노테이션

- @Override : 메소드가 오버라이드 됐는지 검증합니다. 만약 부모 클래스 또는 구현해야할 인터페이스에서 해당 메소드를 찾을 수 없다면 컴파일 오류가 납니다.
- @Deprecated : 메소드를 사용하지 말도록 유도합니다. 만약 사용한다면 컴파일 경고를 일으킵니다.
- @SuppressWarnings : 컴파일 경고를 무시하도록 합니다.
- @SafeVarargs : 제너릭 같은 가변인자 매개변수를 사용할 때 경고를 무시합니다. (자바7 이상)
- @FunctionalInterface : 람다 함수등을 위한 인터페이스를 지정합니다. 메소드가 없거나 두개 이상 되면 컴파일 오류가 납니다. (자바 8이상)

## Meta Annotations
메타 어노테이션을 이용해 커스텀 어노테이션을 만들 수 있습니다.

- @Retention : 어노테이션의 범위(?)라고 할 수 있겠습니다. 어떤 시점까지 어노테이션이 영향을 미치는지 결정합니다.
- @Documented : 문서에도 어노테이션의 정보가 표현됩니다.
- @Target : 어노테이션이 적용할 위치를 결정합니다.
- @Inherited : 이 어노테이션을 선언하면 자식클래스가 어노테이션을 상속 받을 수 있습니다.
- @Repeatable : 반복적으로 어노테이션을 선언할 수 있게 합니다.


출처: https://jdm.kr/blog/216

# Java Lambda Expressions
�ĺ��� ���� ���� ������ �Լ� ǥ����

```
( parameters ) -> expression body
( parameters ) -> { expression body }
() -> { expression body }
() -> expression body
```


# BigInteger
������ �����ϸ� �Ҽ��� Ȯ���� �ƴ� ���쿡�� false�� return,

�Ҽ��� ���� Ȯ���� 1-(1/2)^certainty �̻��� ���� true�� return �Ѵ�.

```
BigInteger.valueof(n).isProbablePrime(int certainty);
```


# IntStream

## range, noneMatch
```
return n -> IntStream.range(2, (int) Math.sqrt(n+1)).noneMatch(i -> n%i == 0);
```


# StringBuilder
```
new StringBuilder(Integer.toString(n)).reverse().toString()
```


# ��Ŭ���� �ڵ� �ٸ���
ctrl + shift + f


# Java Reflection
Ŭ����, �������̽�, �ʵ� �� �޼ҵ��� ��Ÿ�� Ư���� �˻� �Ǵ�/�Ǵ� ������ �� �ִ�.

�츮�� ������ �ð��� �׵��� �̸��� ���� �� Ư�� �����ϴ�.

���� �츮�� reflection�� �̿��Ͽ� ���ο� ��ü�� �ν��Ͻ�ȭ�ϰ�, ������ ȣ���ϸ�, �ʵ� ���� ���ų� ������ �� �ִ�.

��ó: https://www.baeldung.com/java-reflection

## ������
```
Class student = Student.class; // Class�� public field ����

// public���� ������ �޼ҵ� ��������
Method[] methods = student.getDeclaredMethods();

ArrayList<String> methodList = new ArrayList<>();

for(Method method : methods){
    methodList.add(method.getName()); // �޼ҵ� �̸��� ����
}
```


# Private Class에 접근하기
클래스가 2개 이므로 연속해서 생성자 2개 생성

```java
o = new Inner().new Private();
System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");
```

# Private Method에 접근하기
private 매서드는  동일하거나 부모 클래스로 형 변환 시켜줘야 접근 가능!!

```java
System.out.println(num + " is " + ((Solution.Inner.Private)o).powerof2(num));
```


# �̱�ư ����(Singleton Pattern)

## ����
�� �ϳ��� ������ ��ü�� ������ ���� ������ ����

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
��Ƽ �������� ���� �� ������ ������.

## �ذ� ����

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


# 팩토리 메소드 패턴(Factory Method Pattern)

## 정의
객체를 만들어내는 부분을 서브 클래스에 위임하는 패턴.

## Summary

팩토리 메소드 패턴을 사용하는 이유는 클래스간의 결합도를 낮추기 위한것입니다.

결합도라는 것은 간단히 말해 클래스의 변경점이 생겼을 때 얼마나 다른 클래스에도 영향을 주는가입니다.

팩토리 메소드 패턴을 사용하는 경우 직접 객체를 생성해 사용하는 것을 방지하고 서브 클래스에 위임함으로써 보다 효율적인 코드 제어를 할 수 있고 의존성을 제거합니다.

결과적으로 결합도 또한 낮출 수 있습니다.


출처: https://jdm.kr/blog/180


# ������ ����(Visitor Pattern)
�˰������� ��ü �������� �и���Ű�� ������ �����̴�. �̷��� �и��� �ϸ� ������ �������� �ʰ��� ���������� ���ο� ������ ������ ��ü ������ �߰��� �� �ְ� �ȴ�. ����-���� ��Ģ�� �����ϴ� ������ �ϳ��̴�.

## ȿ��
- ó���� ������ �������� �и�
- �������� �������� ������
- Composite Pattern�� ����

��ó : https://blog.hansoolabs.com/564

# Set vs List
List is an ordered sequence of elements whereas Set is a distinct list of elements which is unordered



| | List | Set |
|:-----------------:|:-----------------:|:-----------------:|
| Duplicates | YES | NO |
| Order | ORDERED | DEPENDS ON IMPLEMENTATION |
| Positional Access | YES | NO |

��ó : http://net-informations.com/java/cjava/list.htm
