package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.novedadconcepto_abm", "/web.novedadconcepto_abm"})
public final  class novedadconcepto_abm extends GXWebObjectStub
{
   public novedadconcepto_abm( )
   {
   }

   public novedadconcepto_abm( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( novedadconcepto_abm.class ));
   }

   public novedadconcepto_abm( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new novedadconcepto_abm_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new novedadconcepto_abm_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Novedad concepto";
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

