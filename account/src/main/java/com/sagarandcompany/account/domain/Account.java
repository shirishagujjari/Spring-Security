package com.sagarandcompany.account.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Account {
    private Long id;
    private Long balance;
}
