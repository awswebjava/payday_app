package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.licenciaswc", "/web.licenciaswc"})
public final  class licenciaswc extends GXWebObjectStub
{
   public licenciaswc( )
   {
   }

   public licenciaswc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( licenciaswc.class ));
   }

   public licenciaswc( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new licenciaswc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new licenciaswc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "licencias WC";
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

