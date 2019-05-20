# Java Reflection
클래스, 인터페이스, 필드 및 메소드의 런타임 특성을 검사 또는/또는 수정할 수 있다.

우리가 컴파일 시간에 그들의 이름을 모를 때 특히 유용하다.

또한 우리는 reflection을 이용하여 새로운 객체를 인스턴스화하고, 방법을 호출하며, 필드 값을 얻거나 설정할 수 있다.

출처: https://www.baeldung.com/java-reflection

## 사용법
```
Class student = Student.class; // Class의 public field 사용

// public으로 선언된 메소드 가져오기
Method[] methods = student.getDeclaredMethods(); 

ArrayList<String> methodList = new ArrayList<>();

for(Method method : methods){
    methodList.add(method.getName()); // 메소드 이름만 저장
}
```