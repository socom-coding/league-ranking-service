--Match Results Table
create table fixtures
(
    id integer not null auto_increment,
    team_1_name varchar(255),
    team_1_score varchar(255),
    team_2_name varchar(255),
    team_2_score varchar(255),
    primary key (id)
);

--Team Points Table
create table points
(
    id integer not null auto_increment,
    team_1_name varchar(255),
    team_1_points varchar(255),
    team_2_name varchar(255),
    team_2_points varchar(255),
    primary key (id)
);

--Team Points Table
create table ranking
(
    id integer not null auto_increment,
    team varchar(255),
    points varchar(255),
    primary key (id)
);