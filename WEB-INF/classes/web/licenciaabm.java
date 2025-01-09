package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.licenciaabm", "/web.licenciaabm"})
public final  class licenciaabm extends GXWebObjectStub
{
   public licenciaabm( )
   {
   }

   public licenciaabm( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( licenciaabm.class ));
   }

   public licenciaabm( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new licenciaabm_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new licenciaabm_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Licencia";
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

