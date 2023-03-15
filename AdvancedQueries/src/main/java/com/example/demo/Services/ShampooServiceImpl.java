package com.example.demo.Services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Shampoo;
import com.example.demo.entities.Size;
import com.example.demo.repositories.ShampooRepository;

@Service
public class ShampooServiceImpl implements ShampooService {
	private ShampooRepository shampooRepository;

	public ShampooServiceImpl(ShampooRepository shampooRepository) {
		this.shampooRepository = shampooRepository;
	}

	@Override
	public List<Shampoo> findByIngredient(List<String> ingrediants) {
		return shampooRepository.findByIngredients(ingrediants);
	}

	@Override
	public List<Shampoo> findBySizeOrLabelId(String size, long labelId) {
		Size parsed = Size.valueOf(size.toUpperCase());

		return this.shampooRepository.findBySizeOrLabelId(parsed, labelId);
	}

	@Override
	public List<Shampoo> findWithPriceGreaterThan(BigDecimal price) {
		return this.shampooRepository.findByPriceGreaterThanOrderByPriceDesc(price);
	}

	@Override
	public long countWithPriceLowerThan(String price) {

		return this.shampooRepository.countByPriceLessThan(new BigDecimal(price));
	}

//	@Override
//	public List<Shampoo> findWithIngredientCountLessThan(int count) {
//		return this.shampooRepository.findByIngredientCountLessThan(count);
//	}

}
