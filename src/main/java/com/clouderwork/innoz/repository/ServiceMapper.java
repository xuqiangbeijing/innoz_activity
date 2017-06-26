package com.clouderwork.innoz.repository;

import org.apache.ibatis.annotations.Mapper;

import com.clouderwork.innoz.domain.Service;

@Mapper
public interface ServiceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sv_service
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sv_service
     *
     * @mbggenerated
     */
    int insert(Service record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sv_service
     *
     * @mbggenerated
     */
    int insertSelective(Service record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sv_service
     *
     * @mbggenerated
     */
    Service selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sv_service
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Service record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sv_service
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Service record);
}