--insert into qacomponent(qa_component_id,requirement_complexity,test_data_complexity,validation_component,validation_points) values(1L,'Simple','Simple','Simple',0.5);
--insert into qacomponent(qa_component_id,requirement_complexity,test_data_complexity,validation_component,validation_points) values(2L,'Simple','Medium','Complex',4.5);

insert into project_details(project_id,project_name) values(1L,'Test Project - 1');
insert into project_details(project_id,project_name) values(2L,'Test Project - 2');

-- insert into features_component(feature_id,feature_name,project_id,qa_component_id)  values(1L,'Java Service',1L,1L);
-- insert into features_component(feature_id,feature_name,project_id,qa_component_id)  values(2L,'Java Service',1L,2L);

insert into features_component(feature_id,feature_name,project_id)  values(1L,'Java Service',1L);
insert into features_component(feature_id,feature_name,project_id)  values(2L,'Java Service',1L);

--insert into items(item_id,component_complexity_for_item,degree_of_changes_for_item,item_name,new_or_modify,technology_for_item,item_type,feature_id) values(1L,'Simple','Simple','TestService','New','Java','Service Factors',1L);
--insert into items(item_id,component_complexity_for_item,degree_of_changes_for_item,item_name,new_or_modify,technology_for_item,item_type,feature_id) values(2L,'Simple','Medium','TestService','New','Java','Service Factors',1L);


insert into component_feature_point values(1L,'Service Factors','Component Complexity','Simple',2);
insert into component_feature_point values(2L,'Service Factors','Component Complexity','Medium',4);
insert into component_feature_point values(3L,'Service Factors','Component Complexity','Complex',8);
insert into component_feature_point values(4L,'Service Factors','Component Complexity','Very Complex',12);

insert into component_feature_point values(5L,'Service Factors','Degree of Change','Simple',1);
insert into component_feature_point values(6L,'Service Factors','Degree of Change','Medium',2);
insert into component_feature_point values(7L,'Service Factors','Degree of Change','Complex',4);
insert into component_feature_point values(8L,'Service Factors','Degree of Change','Very Complex',6);


insert into component_feature_point values(9L,'Service Factors','Technology','Tuxedo',1.2);
insert into component_feature_point values(10L,'Service Factors','Technology','Java',1);
insert into component_feature_point values(11L,'Service Factors','Technology','Centura',1);
insert into component_feature_point values(12L,'Service Factors','Technology','Data Power',0.7);
insert into component_feature_point values(13L,'Service Factors','Technology','IIB',0.9);
insert into component_feature_point values(14L,'Service Factors','Technology','ODM',1.1);
insert into component_feature_point values(15L,'Service Factors','Technology','BPM',1.1);
insert into component_feature_point values(16L,'Service Factors','Technology','Mainframe',1);
insert into component_feature_point values(17L,'Service Factors','Technology','Abinitio',1);


insert into component_feature_point values(18L,'Batch Factors','Component Complexity','Simple',2);
insert into component_feature_point values(19L,'Batch Factors','Component Complexity','Medium',4);
insert into component_feature_point values(20L,'Batch Factors','Component Complexity','Complex',8);
insert into component_feature_point values(21L,'Batch Factors','Component Complexity','Very Complex',12);

insert into component_feature_point values(22L,'Batch Factors','Degree of Change','Simple',1);
insert into component_feature_point values(23L,'Batch Factors','Degree of Change','Medium',2);
insert into component_feature_point values(24L,'Batch Factors','Degree of Change','Complex',4);
insert into component_feature_point values(25L,'Batch Factors','Degree of Change','Very Complex',6);

insert into component_feature_point values(26L,'Batch Factors','Technology','Tuxedo',1.1);
insert into component_feature_point values(27L,'Batch Factors','Technology','Java',1);
insert into component_feature_point values(28L,'Batch Factors','Technology','Mainframe',1);
insert into component_feature_point values(29L,'Batch Factors','Technology','ETL',1);
insert into component_feature_point values(30L,'Batch Factors','Technology','Abinitio',1);

insert into component_feature_point values(31L,'UI Factors','Component Complexity','Simple',2);
insert into component_feature_point values(32L,'UI Factors','Component Complexity','Medium',4);
insert into component_feature_point values(33L,'UI Factors','Component Complexity','Complex',8);
insert into component_feature_point values(34L,'UI Factors','Component Complexity','Very Complex',12);

insert into component_feature_point values(35L,'UI Factors','Degree of Change','Simple',1);
insert into component_feature_point values(36L,'UI Factors','Degree of Change','Medium',2);
insert into component_feature_point values(37L,'UI Factors','Degree of Change','Complex',4);
insert into component_feature_point values(38L,'UI Factors','Degree of Change','Very Complex',6);

insert into component_feature_point values(39L,'UI Factors','Technology','Centura',1.1);
insert into component_feature_point values(40L,'UI Factors','Technology','Java',1);

insert into qacomponent_feature_point(id,complexity_name,complexity_type,score) values(1L,'Test Data','Simple',0.5);
insert into qacomponent_feature_point(id,complexity_name,complexity_type,score) values(2L,'Test Data','Medium',1.0);
insert into qacomponent_feature_point(id,complexity_name,complexity_type,score) values(3L,'Test Data','Complex',1.5);
insert into qacomponent_feature_point(id,complexity_name,complexity_type,score) values(4L,'Test Data','Very Complex',2.0);


insert into qacomponent_feature_point(id,complexity_name,complexity_type,score) values(5L,'Validation','Simple',2.0);
insert into qacomponent_feature_point(id,complexity_name,complexity_type,score) values(6L,'Validation','Medium',4.0);
insert into qacomponent_feature_point(id,complexity_name,complexity_type,score) values(7L,'Validation','Complex',8.0);
insert into qacomponent_feature_point(id,complexity_name,complexity_type,score) values(8L,'Validation','Very Complex',12.0);

insert into qacomponent_feature_point(id,complexity_name,complexity_type,score) values(9L,'Requirement','Simple',0.5);
insert into qacomponent_feature_point(id,complexity_name,complexity_type,score) values(10L,'Requirement','Medium',1.0);
insert into qacomponent_feature_point(id,complexity_name,complexity_type,score) values(11L,'Requirement','Complex',1.5);
insert into qacomponent_feature_point(id,complexity_name,complexity_type,score) values(12L,'Requirement','Very Complex',2.0);


insert into qacomponent_feature_point(id,complexity_name,complexity_type,score) values(13L,'Validation Point','1',1.0);
insert into qacomponent_feature_point(id,complexity_name,complexity_type,score) values(14L,'Validation Point','2',1.5);
insert into qacomponent_feature_point(id,complexity_name,complexity_type,score) values(15L,'Validation Point','3',2.0);
insert into qacomponent_feature_point(id,complexity_name,complexity_type,score) values(16L,'Validation Point','4',2.5);

