package com.xeonwell.JerseyDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * Created by xeonwell on 2017-04-25.
 */
@Resource(name="redisService")
public class RedisService {
    //操作redis客户端
    @Autowired
    @Qualifier("connectionFactory")
    private JedisConnectionFactory jedisConnectionFactory;
    @Autowired
    @Qualifier("jedisPool")
    private JedisPool jedisPool;
    /**
     * 通过key删除（字节）
     * @param key
     */
    public void del(byte [] key){
        Jedis jedis = null;
        try{
            jedis = this.getJedis();
            jedis.del(key);
        }finally{
            returnResource(jedis);
        }
    }
    /**
     * 通过key删除
     * @param key
     */
    public void del(String key){
        Jedis jedis = null;
        try{
            jedis = this.getJedis();
            jedis.del(key);
        }finally{
            returnResource(jedis);
        }
    }
    /**
     * 添加key value 并且设置存活时间(byte)只能顶级key有效
     * @param key
     * @param value
     * @param liveTime
     */
    public void set(byte [] key,byte [] value,int liveTime){
        Jedis jedis = null;
        try{
            jedis = this.getJedis();
            jedis.set(key, value);
            jedis.expire(key, liveTime);
        }finally{
            returnResource(jedis);
        }
    }
    /**
     * 添加key value 并且设置存活时间
     * @param key
     * @param value
     * @param liveTime
     */
    public void set(String key,String value,int liveTime){
        Jedis jedis = null;
        try{
            jedis = this.getJedis();
            jedis.set(key, value);
            jedis.expire(key, liveTime);
        }finally{
            returnResource(jedis);
        }
    }
    /**
     * 添加key value
     * @param key
     * @param value
     */
    public void set(String key,String value){
        Jedis jedis = null;
        try{
            jedis = this.getJedis();
            jedis.set(key, value);
        }finally{
            returnResource(jedis);
        }
    }
    /**添加key value (字节)(序列化)
     * @param key
     * @param value
     */
    public void set(byte [] key,byte [] value){
        Jedis jedis = null;
        try{
            jedis = this.getJedis();
            jedis.set(key, value);
        }finally{
            returnResource(jedis);
        }
    }
    /**
     * 获取redis value (String)
     * @param key
     * @return
     */
    public String get(String key){
        Jedis jedis = null;
        try{
            jedis = this.getJedis();
            if(jedis.exists(key)){
                return jedis.get(key);
            }else{
                return null;
            }
        }finally{
            returnResource(jedis);
        }
    }
    /*key递减*/
    public Long decr(String key){
        Jedis jedis = null;
        try{
            jedis = this.getJedis();
            if(jedis.exists(key)){
                return jedis.decr(key);
            }else{
                jedis.set(key, "0");
                return 1L;
            }
        }finally{
            returnResource(jedis);
        }
    }
    /*key递增*/
    public Long incr(String key){
        Jedis jedis = null;
        try{
            jedis = this.getJedis();
            if(jedis.exists(key)){
                return jedis.incr(key);
            }else{
                jedis.set(key, "1");
                return 1L;
            }
        }finally{
            returnResource(jedis);
        }
    }
    /**
     * 获取redis value (byte [] )(反序列化)
     * @param key
     * @return
     */
    public byte[] get(byte [] key){
        Jedis jedis = null;
        try{
            jedis = this.getJedis();
            return jedis.get(key);
        }finally{
            returnResource(jedis);
        }
    }
    /**
     * 通过正则匹配keys
     * @param pattern
     * @return
     */
    public Set<String> keys(String pattern){
        Jedis jedis = null;
        try{
            jedis = this.getJedis();
            return jedis.keys(pattern);
        }finally{
            returnResource(jedis);
        }
    }
    /**
     * 查找key是否已经存在
     * @param key
     * @return
     */
    public boolean exists(String key){
        Jedis jedis = null;
        try{
            jedis = this.getJedis();
            return jedis.exists(key);
        }finally{
            returnResource(jedis);
        }
    }
    public void hset(String key,String field,String value){
        Jedis jedis = null;
        try{
            jedis = this.getJedis();
            jedis.hset(key, field, value);
        }finally{
            returnResource(jedis);
        }
    }
    public String hget(String key,String field){
        Jedis jedis = null;
        try{
            jedis = this.getJedis();
            return jedis.hget(key, field);
        }finally{
            returnResource(jedis);
        }
    }
    public List<String> hget(String key, String...fields){
        Jedis jedis = null;
        try{
            jedis = this.getJedis();
            return jedis.hmget(key, fields);
        }finally{
            returnResource(jedis);
        }
    }
    public Long hdel(String key,String...field){
        Jedis jedis = null;
        try{
            jedis = this.getJedis();
            return jedis.hdel(key, field);
        }finally{
            returnResource(jedis);
        }
    }
    public Boolean hexists(String key,String field){
        Jedis jedis = null;
        try{
            jedis = this.getJedis();
            return jedis.hexists(key, field);
        }finally{
            returnResource(jedis);
        }
    }
    public Long hincr(String key,String field){
        Jedis jedis = null;
        try{
            jedis = this.getJedis();
            return jedis.hincrBy(key, field, 1);
        }finally{
            returnResource(jedis);
        }
    }
    public Long hdesc(String key,String field){
        Jedis jedis = null;
        try{
            jedis = this.getJedis();
            return jedis.hincrBy(key, field, -1);
        }finally{
            returnResource(jedis);
        }
    }
    /**
     * 清空redis全部数据
     * @return
     */
    public String flushDB(){
        Jedis jedis = null;
        try{
            jedis = this.getJedis();
            return jedis.flushDB();
        }finally{
            returnResource(jedis);
        }
    }
    /**
     * 查看redis里有多少数据
     */
    public long dbSize(){
        Jedis jedis = null;
        try{
            jedis = this.getJedis();
            return jedis.dbSize();
        }finally{
            returnResource(jedis);
        }
    }
    /**
     * 测试是否连接成功
     * @return
     */
    public String ping(){
        Jedis jedis = null;
        try{
            jedis = this.getJedis();
            return jedis.ping();
        }finally{
            returnResource(jedis);
        }
    }
    public boolean conn(){
        if(ping().equals("PONG")){
            return true;
        }else{
            return false;
        }
    }
    /**
     * 存储REDIS队列 顺序存储
     * @param  key reids键名
     * @param  value 键值
     */
    public void lpush(byte[] key, byte[] value) {
        Jedis jedis = null;
        try{
            jedis = this.getJedis();
            jedis.lpush(key, value);
        }finally{
            returnResource(jedis);
        }
    }
    public void lpush(String key, String value) {
        Jedis jedis = null;
        try{
            jedis = this.getJedis();
            jedis.lpush(key, value);
        }finally{
            returnResource(jedis);
        }
    }
    public String lpop(String key) {
        Jedis jedis = null;
        try{
            jedis = this.getJedis();
            return jedis.lpop(key);
        }finally{
            returnResource(jedis);
        }
    }
    /**
     * @author 伤心鱼
     * @date 2016年4月13日下午5:14:20
     * @Description 取出散列中start到end位置的数据
     * @param key
     * @param start
     * @param end
     * @return List<String>
     */
    public List<String> lrange(String key,Integer start,Integer end) {
        Jedis jedis = null;
        try{
            jedis = this.getJedis();
            return jedis.lrange(key, start, end);
        }finally{
            returnResource(jedis);
        }
    }
    public String lnew(String key,Integer start,Integer end) {
        Jedis jedis = null;
        try{
            jedis = this.getJedis();
            if(jedis.exists(key)){
                Long length = jedis.llen(key);
                List<String> list = jedis.lrange(key, length-2, length-1);
                if(list!=null&&list.size()>0){
                    return list.get(0);
                }
                return null;
            }else{
                return null;
            }
        }finally{
            returnResource(jedis);
        }
    }
    /**
     * @author 伤心鱼
     * @date 2016年4月13日下午5:14:56
     * @Description 散列的长度
     * @param key
     * @return Long
     */
    public Long llen(String key) {
        Jedis jedis = null;
        try{
            jedis = this.getJedis();
            return jedis.llen(key);
        }finally{
            returnResource(jedis);
        }
    }
    public String rpop(String key) {
        Jedis jedis = null;
        try{
            jedis = this.getJedis();
            return jedis.rpop(key);
        }finally{
            returnResource(jedis);
        }
    }
    /**
     * 获取jedis 客户端
     * @return
     */
    public Jedis getJedis() {
        return jedisPool.getResource();
    }
    public void returnResource(Jedis jedis){
        if(jedis != null) {
            jedisPool.returnResource(jedis);
        }
    }
    private RedisService (){

    }
}
