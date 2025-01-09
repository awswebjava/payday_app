package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.convenio_adicionalimporteswc", "/web.convenio_adicionalimporteswc"})
public final  class convenio_adicionalimporteswc extends GXWebObjectStub
{
   public convenio_adicionalimporteswc( )
   {
   }

   public convenio_adicionalimporteswc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( convenio_adicionalimporteswc.class ));
   }

   public convenio_adicionalimporteswc( int remoteHandle ,
                                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new convenio_adicionalimporteswc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new convenio_adicionalimporteswc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "convenio_adicionalimportes WC";
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

