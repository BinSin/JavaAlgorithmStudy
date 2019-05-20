# Java Varargs
자 바 5.0에서 소개되는 기법 중에서 가변인수(Varargs)라는 것이 있다. 가변인수라는 것은 필요에 따라 매개변수(인수)를 가변적으로 조정할 수 있는 기술이다. 가변인수가 없던 시절에는 가변인수 대신 컬렉션이나 배열을 이용해서 가변인수를 대체하고 있었다.

출처: https://gyrfalcon.tistory.com/entry/Java-Varargs [Minsub's Blog]

## 사용법
```
void add(int ... args)
	~~~
	for(int n : args)
```