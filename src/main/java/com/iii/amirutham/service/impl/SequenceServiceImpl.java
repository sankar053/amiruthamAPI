/**
 * 
 */
package com.iii.amirutham.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iii.amirutham.dto.model.SequnceDto;
import com.iii.amirutham.model.SequnceTable;
import com.iii.amirutham.repo.SequnceRepository;
import com.iii.amirutham.service.SequenceService;

/**
 * @author sanka
 *
 */
@Service
public class SequenceServiceImpl implements SequenceService {

	@Autowired
	private SequnceRepository sequnceRepo;

	@Override
	public SequnceDto findMySeQuence(String name) {
		// TODO Auto-generated method stub
		Optional<SequnceTable> sequenceOpt = sequnceRepo.findBySeqName(name);
		if (sequenceOpt.isPresent()) {
			SequnceTable sequence = sequenceOpt.get();
			SequnceDto sequenceDto = new SequnceDto(sequence.getId(), sequence.getSeqName(), sequence.getSeqChar(),
					sequence.getSeqCurVal(), sequence.getSeqNxtVal(), sequence.getSeqLimVal());
			return (sequenceDto);
		} else {
			return null;
		}

	}


	@Override
	public void updateMySeQuence(SequnceDto sequence) {
		// TODO Auto-generated method stub

		SequnceTable mySeqence = new SequnceTable(sequence.getId(), sequence.getSeqName(), sequence.getSeqChar(),
				sequence.getSeqNxtVal(), (sequence.getSeqNxtVal() + 1), sequence.getSeqLimVal());

		sequnceRepo.saveAndFlush(mySeqence);

	}

}
