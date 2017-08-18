# XHipster
An anti JHipster approach to Spring Framework

#### Does JHipster have too much stuff under it's hood ?

I believe so. JHipster is a great project, but during it's  7,797 (now) it has grown too much. Too much in order for a developer to be able to handle everything
what's inside it. Too much stuff you don't have expertise over to be used in production! Unless you're an expert javascript, java, front-end, database engineer all in one SUPER-STAR. I guess not.

Here's a MUCH simpler template for you to use.

# XHipster to the rescue

XHipster is a simple Spring Boot template that does pretty much what JHipster is doing, but in much less lines of code and with the idea of adding
as little as possible in order to give you (the developer) choices in your own tools.


## How to

Do you want to start "working" on your stuff or you want to play a little with it ?

If you want to get THIS example running with programming languages like in the picture make sure you setup MySQL first and configure with with a database named xhipster
See *application.yml* for the config settings (pay attention to the MySQL port).

Using docker ?
~~~~
docker run --detach --name=test-mysql --env="MYSQL_ROOT_PASSWORD=password" --publish 6603:3306 mysql
~~~~