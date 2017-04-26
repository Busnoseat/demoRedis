# redis window版本启动命令
cmd到redis安装目录下 <br>
redis-server redis.window.conf <br>
redis-server redis.window.conf --maxheap 200m (内存限制启动受阻时指定内存启动) <br>

# redis主从复制
http://blog.csdn.net/ajun_studio/article/details/6714130 <br>
http://blog.csdn.net/ajun_studio/article/details/7667746 <br>

|主redis.windows.conf修改                 | 副reids.windows.conf修改             |
|---------------------------------------- |-------------------------------------|
|port 6379                                | port 6380                           |
|bind 127.0.0.1   (主redis所在环境ip)      |bind 127.0.0.1 (副redis所在环境的ip)  |
|                                         |slaveof 127.0.0.1 6379 (主redis所在环境的ip和端口)

 
