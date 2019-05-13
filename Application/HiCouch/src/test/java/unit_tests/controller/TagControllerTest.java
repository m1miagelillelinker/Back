package unit_tests.controller;

import com.hicouch.back.core.business.TagBusiness;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Tag;
import com.hicouch.back.core.service.TagService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TagControllerTest {

    @MockBean
    TagBusiness tagBusiness;

    @MockBean
    TagService tagService;

    Tag tag;

    List<Tag> tagList;

    @Before
    public void initAll() throws NoResultException {
        initDatas();
        initMocks();
    }

    private void initMocks() throws NoResultException {
        //Mockito.when(tagBusiness.setTagOnProduct(Mockito.anyString(),Mockito.anyString())).thenReturn(true);
        Mockito.when(tagService.createOrGetTag(Mockito.anyString())).thenReturn(tag);
        Mockito.when(tagService.setTagStatus(Mockito.anyInt(),Mockito.anyInt())).thenReturn(tag);
        Mockito.when(tagService.getTagById(Mockito.anyInt())).thenReturn(tag);
        Mockito.when(tagService.getTagByValue(Mockito.anyString())).thenReturn(tagList);
        Mockito.when(tagService.getTagsByIds(Mockito.anyList())).thenReturn(tagList);
    }

    private void initDatas() {
        tag = new Tag();
        tag.setId(1);
        tag.setStatus(1);
        tag.setValue("test");

        tagList.add(tag);
    }

    //TODO DELETE QUAND IL Y A UN AU MOINS UN TEST
    @Test
    public void testSample() {
        assertEquals(true, true);
    }
}
