# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

### step 1 - 자바8 스트림, 람다, Optional
#### 람다 실습 1 - 익명 클래스를 람다로 전환
- MoveStrategy 에 대한 익명 클래스로 구현하고 있는 부분을 람다를 적용해 구현한다.

#### 람다 실습 2 - 람다를 활용해 중복 제거
- List 에 담긴 값 중 3보다 큰 수만을 더해야 한다.
- 이 기능을 구현하려고 보니 앞의 요구사항 1, 2와 많은 중복이 발생한다. 람다를 활용해 중복을 제거해보자.
- nextstep.fp.Lambda 의 sumAll, sumAllEven, sumAllOverThree method 소스 코드를 확인하고 중복 제거

#### 다양한 stream method 실습
- map, reduce, filter 실습

#### Optional