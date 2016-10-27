package mapper;

import entity.HisAddress;

public interface HisAddressMapper {

	HisAddress getAddressById(long id);
	
	void insert(HisAddress hisAddress);
}
