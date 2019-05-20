# Java Reflection
Ŭ����, �������̽�, �ʵ� �� �޼ҵ��� ��Ÿ�� Ư���� �˻� �Ǵ�/�Ǵ� ������ �� �ִ�.

�츮�� ������ �ð��� �׵��� �̸��� �� �� Ư�� �����ϴ�.

���� �츮�� reflection�� �̿��Ͽ� ���ο� ��ü�� �ν��Ͻ�ȭ�ϰ�, ����� ȣ���ϸ�, �ʵ� ���� ��ų� ������ �� �ִ�.

��ó: https://www.baeldung.com/java-reflection

## ����
```
Class student = Student.class; // Class�� public field ���

// public���� ����� �޼ҵ� ��������
Method[] methods = student.getDeclaredMethods(); 

ArrayList<String> methodList = new ArrayList<>();

for(Method method : methods){
    methodList.add(method.getName()); // �޼ҵ� �̸��� ����
}
```