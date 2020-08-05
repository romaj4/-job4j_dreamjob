package ru.job4j.dream.servlet;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ru.job4j.dream.store.PsqlStore;
import ru.job4j.dream.store.Store;
import ru.job4j.dream.store.StoreStub;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PsqlStore.class)
public class CandidateServletTest extends TestCase {

    @Test
    public void whenAddCandidateThenStoreIt() throws ServletException, IOException {
        Store storeStub = StoreStub.instOf();
        PowerMockito.mockStatic(PsqlStore.class);
        when(PsqlStore.instOf()).thenReturn(storeStub);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("name")).thenReturn("Roman Korolchuk");
        when(req.getParameter("id")).thenReturn("0");
        when(req.getParameter("cityId")).thenReturn("1");
        new CandidateServlet().doPost(req, resp);
        assertEquals(storeStub.findAllCandidates().iterator().next().getName(), "Roman Korolchuk");
    }
}