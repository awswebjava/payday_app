package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.convenio_adicionalalicuotaswc", "/web.convenio_adicionalalicuotaswc"})
public final  class convenio_adicionalalicuotaswc extends GXWebObjectStub
{
   public convenio_adicionalalicuotaswc( )
   {
   }

   public convenio_adicionalalicuotaswc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( convenio_adicionalalicuotaswc.class ));
   }

   public convenio_adicionalalicuotaswc( int remoteHandle ,
                                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new convenio_adicionalalicuotaswc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new convenio_adicionalalicuotaswc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "convenio_adicionalalicuotas WC";
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

