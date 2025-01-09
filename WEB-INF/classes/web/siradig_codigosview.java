package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.siradig_codigosview", "/web.siradig_codigosview"})
public final  class siradig_codigosview extends GXWebObjectStub
{
   public siradig_codigosview( )
   {
   }

   public siradig_codigosview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( siradig_codigosview.class ));
   }

   public siradig_codigosview( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new siradig_codigosview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new siradig_codigosview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "siradig_codigos View";
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

