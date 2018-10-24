package ru.schepin.restService.servlet.autorization;

import org.junit.Test;
import ru.schepin.restService.util.Urls;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class UserLoginServletTest {
    @Test
    public void whenCallDoGetThenServletReturnIndexPage() throws ServletException, IOException {

        final UserLoginServlet servlet = new UserLoginServlet();

        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        final RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(request.getRequestDispatcher(Urls.userLogin)).thenReturn(dispatcher); //var... args => OngoingStubbing<T> thenReturn(T value, T... values);

        servlet.doGet(request, response);

        verify(request, times(1)).getRequestDispatcher(Urls.userLogin);
        verify(request, never()).getSession();
        verify(dispatcher).forward(request, response);
    }
}
