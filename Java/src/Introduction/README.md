# 요일 구하기

```java
Calendar c = Calendar.getInstance();
c.set(year, month - 1, day);
return c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US);
```

# 나라별 화폐 포멧 바꾸기
locale에 변수가 없다면 new Locale로 만들면 된다

```java
NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
String us = nf.format(payment);
        
nf = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
String india = nf.format(payment);
```
