package abc.wuyan.service.impl;

import abc.wuyan.mapper.PriMapper;
import abc.wuyan.model.Pri;
import abc.wuyan.service.PriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriServiceImpl implements PriService {
    @Autowired
    private  PriMapper priMapper;
    @Override
    public Pri findById(int priId) {
        return priMapper.findById(priId);
    }
}
