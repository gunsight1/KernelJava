INSERT INTO kernel360.DEPT (dept_no,dept_nm) VALUES
                                                 (1,'국어국문학과'),
                                                 (2,'컴퓨터공학과');



INSERT INTO kernel360.STUDENT (stu_no,stu_name,dept_no) VALUES
                                                            (201290,'김현지',2),
                                                            (201518,'정지용',1),
                                                            (202360,'이윤선',1),
                                                            (211213,'김영롱',1),
                                                            (212330,'우무룡',2);


INSERT INTO kernel360.SUBJECT (subject_no,subject_nm,dept_no,major) VALUES
                                                                        (1,'국어',1,1),
                                                                        (2,'수학',1,0),
                                                                        (3,'국어',2,0),
                                                                        (4,'수학',2,1);


INSERT INTO kernel360.SCORE (score_no,stu_no,subject_no,score) VALUES
                                                                   (1,211213,1,95),
                                                                   (2,211213,2,56),
                                                                   (3,212330,3,95),
                                                                   (4,212330,4,98),
                                                                   (5,201518,1,100),
                                                                   (6,201518,2,88),
                                                                   (7,202360,1,89),
                                                                   (8,202360,2,95),
                                                                   (9,201290,3,83),
                                                                   (10,201290,4,56);
