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