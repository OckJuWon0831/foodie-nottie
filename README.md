# Foodie Nottie!

Android application constructed by Ock Ju Won


## References
- Retrofit: RESTful-api communication helping library
- Coroutine: 네트워크 통신이나, 로컬 딥에 저장하는 용도
- Android secret gradle plugin: A Gradle plugin for providing your secrets securely to your Android project.
- Lifecycle: Lifecycle-aware components perform actions in response to a change in the lifecycle status of another component, such as activities and fragments. These components help you produce better-organized, and often lighter-weight code, that is easier to maintain.
- Room: For the database and RDBMS functionality

### External APIs
- Google Map SDK
- Places API (which is subject to the Map SDK)

## Functionalities
1. 

## Entity와 DTO를 구분해서 사용하는 이유
1. Entity 구현과 그 자체를 안전하게 숨길 수 있다.(역할의 분리)
사실 Entity가 View를 그리는 정보를 전달할 수 ? 당연히 있다. 이미 데이터는 다 가지고 있기 때문이다. 다만 Entity는 DB 직접적으로 연결되어 핵심 로직들을 지니고 있는데, 이게 밖으로 노출될 경우 의도치 않은 상황에서 수정이 일어나버릴 수 있게 된다.

2. 데이터를 선별적으로 보내줄 수 있다.
서비스가 커지는 상황을 생각해보자. 하나의 Entity가 담는 정보도 증가하겠지만 무엇보다도 다양한 화면에서 여러 data들을 요구하게 될 것이다. 그렇다 보면 각 화면에서 필요로 하는 데이터가 다를텐데, Entity를 넘기다 보면 불필요한 데이터들을 매번 넘기게 되고 이는 자연스럽게 속도의 저하로도 이어진다. 이에 반해 DTO를 사용하면 필요한 데이터만 딱딱 넘길 수 있게 된다.

3. 순환참조를 예방할 수 있다.
내가 지금 공부하려고 하고 있는 JPA에서 쌍방향으로 참조를 하고 있으면 Entity를 불러오면 lazy loading이 되고, 되고, 되면서 순환참조 문제가 생기게 된다. 따라서 요청의 response를 DTO로 보내주게 되면 이런 문제를 해결할 수 있다.

4. validation 로직을 분리할 수 있다.
다른 내용들은 어느정도 알고 있었다면 이 내용은 미처 생각을 못했는데 유용할 것 같다. 결국 데이터가 들어오는 그 앞단에서 DTO를 통해 검증을 진행할 수 있게 된다는 장점이 있는 것이다.

## DAO를 DBRepository에서 한꺼번에 묶어서 사용함
