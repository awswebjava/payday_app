package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.abmnovedadconcepto", "/web.abmnovedadconcepto"})
public final  class abmnovedadconcepto extends GXWebObjectStub
{
   public abmnovedadconcepto( )
   {
   }

   public abmnovedadconcepto( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( abmnovedadconcepto.class ));
   }

   public abmnovedadconcepto( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new abmnovedadconcepto_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new abmnovedadconcepto_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Horas trabajadas / adicionales";
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

