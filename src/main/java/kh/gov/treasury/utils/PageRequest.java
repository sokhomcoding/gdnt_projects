package kh.gov.treasury.utils;

import lombok.Builder;

@Builder
public record PageRequest(
		int page, int size
		) {
}
