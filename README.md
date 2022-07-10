# GRAPHQL TEST

query {
	findAllEquip{
		plant_code
		equip_id
	}
	findByIdEquip(plant_code:"P001", equip_id:"Q000-000000-000") {
		plant_code
		equip_id
		equip_nm,
	}
}


query {
	findByIdEquip(equip:{plant_code:"P001", equip_id:"Q000-000000-000"}) {
		plant_code
		equip_id
		equip_nm,
	}
}


mutation {
	saveEquip(equip:{plant_code:"P001", equip_id:"Q000-000000-002"}) {
		plant_code
		equip_id
		equip_nm,
	}
}

mutation {
	saveAllEquip(equip:[{plant_code:"P001", equip_id:"Q000-000000-003"}, {plant_code:"P001", equip_id:"Q000-000000-004"}]) {
		plant_code
		equip_id
		equip_nm,
	}
}
