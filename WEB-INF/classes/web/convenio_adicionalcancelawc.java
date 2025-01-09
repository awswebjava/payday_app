package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.convenio_adicionalcancelawc", "/web.convenio_adicionalcancelawc"})
public final  class convenio_adicionalcancelawc extends GXWebObjectStub
{
   public convenio_adicionalcancelawc( )
   {
   }

   public convenio_adicionalcancelawc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( convenio_adicionalcancelawc.class ));
   }

   public convenio_adicionalcancelawc( int remoteHandle ,
                                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new convenio_adicionalcancelawc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new convenio_adicionalcancelawc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "convenio_adicional Cancela WC";
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

