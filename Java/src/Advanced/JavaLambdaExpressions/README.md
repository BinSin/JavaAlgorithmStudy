# Java Lambda Expressions
식별자 없이 실행 가능한 함수 표현식

```
( parameters ) -> expression body
( parameters ) -> { expression body }
() -> { expression body }
() -> expression body
```

# BigInteger
간단히 설명하면 소수가 확실히 아닌 경우에는 false를 return,

소수가 맞을 확률이 1-(1/2)^certainty 이상인 경우 true를 return 한다.

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

# 이클립스 자동 줄맞춤
ctrl + shift + f

