/**
 * 
 * APDPlat - Application Product Development Platform
 * Copyright (c) 2013, 杨尚川, yang-shangchuan@qq.com
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package org.apdplat.word.web.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 资源变化实时通知
 * @author 杨尚川
 */
public class ResourceChangeNotifier {
    private static JedisPool jedisPool;
    public static void setJedisPool(JedisPool jedisPool){
        ResourceChangeNotifier.jedisPool = jedisPool;
    }
    /**
     * 分词词典 - 增加一个词
     * @param item 词
     */
    public static void addDic(String item){
        Jedis jedis = jedisPool.getResource();
        jedis.publish("dic.txt.add", item);
        jedisPool.returnResource(jedis);
    }
    /**
     * 分词词典 - 移除一个词
     * @param item 词
     */
    public static void removeDic(String item){
        Jedis jedis = jedisPool.getResource();
        jedis.publish("dic.txt.remove", item);
        jedisPool.returnResource(jedis);
    }
    /**
     * 停用词 - 增加一个停用词
     * @param item 停用词
     */
    public static void addStopword(String item){
        Jedis jedis = jedisPool.getResource();
        jedis.publish("stopwords.txt.add", item);
        jedisPool.returnResource(jedis);
    }
    /**
     * 停用词 - 移除一个停用词
     * @param item 停用词
     */
    public static void removeStopword(String item){
        Jedis jedis = jedisPool.getResource();
        jedis.publish("stopwords.txt.remove", item);
        jedisPool.returnResource(jedis);
    }
    /**
     * 数量词 - 增加一个数量词
     * @param item 数量词
     */
    public static void addQuantifier(String item){
        Jedis jedis = jedisPool.getResource();
        jedis.publish("quantifier.txt.add", item);
        jedisPool.returnResource(jedis);
    }
    /**
     * 数量词 - 移除一个数量词
     * @param item 数量词
     */
    public static void removeQuantifier(String item){
        Jedis jedis = jedisPool.getResource();
        jedis.publish("quantifier.txt.remove", item);
        jedisPool.returnResource(jedis);
    }
    /**
     * 标点符号 - 增加一个标点符号
     * @param item 标点符号
     */
    public static void addPunctuation(String item){
        Jedis jedis = jedisPool.getResource();
        jedis.publish("punctuation.txt.add", item);
        jedisPool.returnResource(jedis);
    }
    /**
     * 标点符号 - 移除一个标点符号
     * @param item 标点符号
     */
    public static void removePunctuation(String item){
        Jedis jedis = jedisPool.getResource();
        jedis.publish("punctuation.txt.remove", item);
        jedisPool.returnResource(jedis);
    }
    /**
     * 百家姓 - 增加一个百家姓
     * @param item 百家姓
     */
    public static void addSurname(String item){
        Jedis jedis = jedisPool.getResource();
        jedis.publish("surname.txt.add", item);
        jedisPool.returnResource(jedis);
    }
    /**
     * 百家姓 - 移除一个百家姓
     * @param item 百家姓
     */
    public static void removeSurname(String item){
        Jedis jedis = jedisPool.getResource();
        jedis.publish("surname.txt.remove", item);
        jedisPool.returnResource(jedis);
    }
    /**
     * 二元模型 - 增加一个二元模型
     * @param item 二元模型
     */
    public static void addBigram(String item){
        Jedis jedis = jedisPool.getResource();
        jedis.publish("bigram.txt.add", item);
        jedisPool.returnResource(jedis);
    }    
    /**
     * 二元模型 - 移除一个二元模型
     * @param item 二元模型
     */
    public static void removeBigram(String item){
        Jedis jedis = jedisPool.getResource();
        jedis.publish("bigram.txt.remove", item);
        jedisPool.returnResource(jedis);
    }
    /**
     * 三元模型 - 增加一个三元模型
     * @param item 三元模型
     */
    public static void addTrigram(String item){
        Jedis jedis = jedisPool.getResource();
        jedis.publish("trigram.txt.add", item);
        jedisPool.returnResource(jedis);
    }    
    /**
     * 三元模型 - 移除一个三元模型
     * @param item 三元模型
     */
    public static void removeTrigram(String item){
        Jedis jedis = jedisPool.getResource();
        jedis.publish("trigram.txt.remove", item);
        jedisPool.returnResource(jedis);
    }
    public static void main(String[] args){
        ResourceChangeNotifier.setJedisPool(new JedisPool(new JedisPoolConfig(), "203.195.135.142", 6379));
        ResourceChangeNotifier.addDic("杨尚川");
    }
}
