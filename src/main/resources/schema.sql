--Match Results Table
create table Match_Results
(
    id integer not null auto_increment,
    team_1_name varchar(255),
    team_1_score varchar(255),
    team_2_name varchar(255),
    team_2_score varchar(255),
    primary key (id)
);

--Team Points Table
create table Team_Points
(
    id integer not null auto_increment,
    team varchar(255),
    points varchar(255),
    primary key (id)
);