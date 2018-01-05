자동 영단어 학습 프로그램 remember me

개요
카메라를 이용한 단어 검색, 자동 오탈자 방지 기능을 적용하여 단어 검색의 불편함을 해소하고, 에빙하우스의 망각곡선을 적용하여 암기 주기 관리를 효율적으로 해주는 영어 단어장 어플리케이션

주요기능

	1. 카메라 촬영을 통한 단어 검색

	1. 챗봇을 이용한 자기주도 학습

	1. 암기 주기 관리


참고 영상:
참고 PPT:

해당 서버의 기능
해당 서버는 페이지를 제공하지 않고 데이터 정보만 제공하도록 Rest API 형태로 설계하였다. 주 기능은 다음과 같다

	1. 각 회원에 해당하는 단어장, 영어 단어 리스트 정보를 제공
	2. 각 회원에 해당하는 학습데이터 제공 및 회원의 학습 결과 데이터를 DB에 기록
	3. 각 회원에 해당하는 학습 현황데이터 제공


각 Controller에 대한 설명

WordController: 각 회원에 해당하는 영어단어 정보를 Json의 형태로 제공하는 Controller이다.

VocaController: 각 회원에 해당하는 단어장 정보를 Json의 형태로 제공하는 Controller이다.

ReviewController: 각 회원에게 할당된 복습데이터 정보를 Json의 형태로 제공하고 회원이 복습을 진행하고 나온 복습 결과 데이터를 DB에 기록하는 기능을 제공하는 Controller이다.

ResultController: 각 회원의 학습 현황 정보 및 main화면에 표시되는 명언 문장을 제공해주는 Controller이다.

LearnController: 각 회원에게 할당된 학습데이터 정보를 Json의 형태로 제공하고 회원이 학습을 진행하고 나온 복습 결과 데이터를 DB에 기록하는 기능을 제공하는 Controller이다.

ExamController: 각 회원에게 할당된 주기관리 학습 데이터 정보를 Json의 형태로 제공하고 회원이 학습을 진행하고 나온 주기관리 학습 결과 데이터를 DB에 기록하는 기능을 제공하는 Controller이다.

FileController: 해당 서버에 저장되어있는 각 단어에 해당하는 이미지 파일을 제공해주는 Controller이다.
