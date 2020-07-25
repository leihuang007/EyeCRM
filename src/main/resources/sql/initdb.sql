insert into M_ADMIN VALUES (0,'admin','admin','admin',1,'025');
INSERT INTO  MD_AREA  values  ('025','025','南京市',0);
INSERT INTO  MD_AREA  values  ('025001','025','秦淮区',0);
INSERT INTO  MD_AREA  values  ('025002','025','鼓楼区',0);
INSERT INTO  MD_AREA  values  ('025003','025','建邺区',0);
INSERT INTO  MD_AREA  values  ('025004','025','玄武区',0);
INSERT INTO  MD_AREA  values  ('025005','025','下关区',0);
INSERT INTO  MD_AREA  values  ('025006','025','浦口区',0);
INSERT INTO  MD_AREA  values  ('025007','025','六合区',0);
INSERT INTO  MD_AREA  values  ('025008','025','栖霞区',0);
INSERT INTO  MD_AREA  values  ('025009','025','雨花区',0);
INSERT INTO  MD_AREA  values  ('025010','025','江宁区',0);
INSERT INTO  MD_AREA  values  ('025011','025','溧水县',0);
INSERT INTO  MD_AREA  values  ('025012','025','高淳县',0);
INSERT INTO  MD_AREA  values  ('025013','025','白下区',0);


INSERT INTO MD_ASSURANCE_TYPE values (0,'城镇医保',0);
INSERT INTO MD_ASSURANCE_TYPE values (0,'农村医保',0);

INSERT INTO MD_DISEASE_TYPE values (0,'青光眼',0);
INSERT INTO MD_DISEASE_TYPE values (0,'白内障',0);
INSERT INTO MD_DISEASE_TYPE values (0,'眼底出血',0);

INSERT INTO MD_FIRST_ADVICE values (0,'留院观察',0);
INSERT INTO MD_FIRST_ADVICE values (0,'住院治疗',0);
INSERT INTO MD_FIRST_ADVICE values (0,'手术',0);

select * from eyecrm.m_admin;
