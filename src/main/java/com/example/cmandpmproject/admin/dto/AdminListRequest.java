package com.example.cmandpmproject.admin.dto;

import com.example.cmandpmproject.admin.entity.AdminRole;
import com.example.cmandpmproject.admin.entity.AdminStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AdminListRequest {
    private String keyword;
    private int page = 1;
    private int limit = 10;
    private SortAdmin sortOrder = SortAdmin.ASC;
    private SortBy sortBy = SortBy.NAME;
    private AdminRole role;
    private AdminStatus status;

}
