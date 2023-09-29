package com.example.springstarter.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.validation.constraints.NotNull;

public final class CompanyWriteUpdateDto {
    @NotNull
    private final
    String companyName;
@JsonCreator
    public CompanyWriteUpdateDto(@NotNull String companyName) {
        this.companyName = companyName;
    }

    public @NotNull String getCompanyName() {
        return this.companyName;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CompanyWriteUpdateDto)) return false;
        final CompanyWriteUpdateDto other = (CompanyWriteUpdateDto) o;
        final Object this$companyName = this.getCompanyName();
        final Object other$companyName = other.getCompanyName();
        if (this$companyName == null ? other$companyName != null : !this$companyName.equals(other$companyName))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $companyName = this.getCompanyName();
        result = result * PRIME + ($companyName == null ? 43 : $companyName.hashCode());
        return result;
    }

    public String toString() {
        return "CompanyWriteUpdateDto(companyName=" + this.getCompanyName() + ")";
    }
}
