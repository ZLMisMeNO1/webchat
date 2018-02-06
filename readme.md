# webchat

## 初始化

1.添加一个用户admin 密码123

insert into t_user(userId,username,password,salt) values ('8a8a9c4160a0552b0160a05543a90000','admin','6bd359c51b87c1dc99ae67b6aafd467b','b6c4a53524d6715892459f1ef17c1c3a') ;

db.t_collection_user.save({userId:""})