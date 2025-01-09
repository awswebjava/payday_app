package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.religion", "/web.religion"})
public final  class religion extends GXWebObjectStub
{
   public religion( )
   {
   }

   public religion( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( religion.class ));
   }

   public religion( int remoteHandle ,
                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new religion_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new religion_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Religion";
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

