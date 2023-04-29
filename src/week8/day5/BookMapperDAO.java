package com.example.springedu.dao;

import com.example.springedu.domain.BookDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookMapperDAO {

    @Select("select id,title,price,kind from book")
    List<BookDTO> getList();

    @Select("select id,title,price,kind from book order by price desc")
    List<BookDTO> getListOrderByPrice();

    @Select("select id,title,price,kind from book where price>=20000")
    List<BookDTO> getListPriceOver20000();

    @Select("select id,title,price,kind from book where kind=\"b02\"")
    List<BookDTO> getListWebProgramming();

    @Select("select id,title,price,kind from book where kind=\"b04\"or\"b05\"")
    List<BookDTO> getListDataBaseOrInfra();

    @Select("    select id,title,price,kind from book where title like concat('%',#{key},'%')")
    List<BookDTO> getListByWithinName(String name);

    @Select("select round(avg(price))as avgprice from book GROUP BY kind")
    List<Double> averagePriceByKind();

    @Select("INSERT INTO book(title,price,kind)VALUES(#{title}, #{price}, #{kind})")
    boolean insertBook(BookDTO bookDTO);
}
