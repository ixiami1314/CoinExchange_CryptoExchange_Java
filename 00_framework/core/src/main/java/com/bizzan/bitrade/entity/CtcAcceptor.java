package com.bizzan.bitrade.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * 承兑商名单列表
 * @author shaox
 *
 */
@Entity
@Data
@Table
public class CtcAcceptor {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
	
	@ManyToOne
    @JoinColumn(name = "member_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private Member member;
	
	@Column(columnDefinition = "decimal(18,2) default 0.00 comment '售出USDT'")
	private BigDecimal usdtOut = BigDecimal.ZERO;
	
	@Column(columnDefinition = "decimal(18,2) default 0.00 comment '买入USDT'")
	private BigDecimal usdtIn = BigDecimal.ZERO;
	
	@Column(columnDefinition = "decimal(18,2) default 0.00 comment '售出CNY'")
	private BigDecimal cnyOut = BigDecimal.ZERO;
	
	@Column(columnDefinition = "decimal(18,2) default 0.00 comment '买入CNY'")
	private BigDecimal cnyIn = BigDecimal.ZERO;
	
	/**
	 * 状态（0：无效，1：有效）
	 */
	private int status = 1;
}
