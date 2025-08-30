-- ment 테이블 생성
CREATE TABLE ment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    content TEXT NOT NULL
);

-- 샘플 데이터 삽입
INSERT INTO ment (content) VALUES 
('오늘도 화이팅! 당신의 노력은 빛날 거예요.'),
('작은 발걸음도 목표를 향한 소중한 진전입니다.'),
('포기하지 마세요. 성공은 한 걸음 더 앞에 있어요.'),
('오늘의 노력이 내일의 성과를 만듭니다.'),
('당신은 생각보다 훨씬 강한 사람입니다.'),
('매일 조금씩 성장하는 것이 성공의 비결입니다.'),
('어제보다 나은 오늘을 만들어 가세요.'),
('도전하는 자만이 진정한 승리를 얻을 수 있습니다.'),
('실패는 성공으로 가는 징검다리일 뿐입니다.'),
('꿈을 포기하지 않으면 언젠가는 이루어집니다.');

-- 랜덤 조회 쿼리 테스트
SELECT content FROM ment ORDER BY RAND() LIMIT 1;
