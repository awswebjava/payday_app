package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.banda_salarial", "/web.banda_salarial"})
public final  class banda_salarial extends GXWebObjectStub
{
   public banda_salarial( )
   {
   }

   public banda_salarial( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( banda_salarial.class ));
   }

   public banda_salarial( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new banda_salarial_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new banda_salarial_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "banda_salarial";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

